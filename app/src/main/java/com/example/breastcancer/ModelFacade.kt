package com.example.breastcancer

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.ArrayList
import android.content.res.AssetManager
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel
import java.util.*

class ModelFacade private constructor(context: Context) {

    private val assetManager: AssetManager = context.assets
    private var fileSystem: FileAccessor



    init {
    	//init
        fileSystem = FileAccessor(context)
    }

    companion object {
    	private val repository by lazy { Repository() }
        private var instance: ModelFacade? = null
        fun getInstance(context: Context): ModelFacade {
            return instance ?: ModelFacade(context)
        }
    }
    

    val allBreastCancers: LiveData<List<BreastCancerEntity>> = repository.allBreastCancers.asLiveData()

    val allBreastCancerIds: LiveData<List<String>> = repository.allBreastCancerids.asLiveData()
    val allBreastCancerAges: LiveData<List<Int>> = repository.allBreastCancerages.asLiveData()
    val allBreastCancerBmis: LiveData<List<Float>> = repository.allBreastCancerbmis.asLiveData()
    val allBreastCancerGlucoses: LiveData<List<Float>> = repository.allBreastCancerglucoses.asLiveData()
    val allBreastCancerInsulins: LiveData<List<Float>> = repository.allBreastCancerinsulins.asLiveData()
    val allBreastCancerHomas: LiveData<List<Float>> = repository.allBreastCancerhomas.asLiveData()
    val allBreastCancerLeptins: LiveData<List<Float>> = repository.allBreastCancerleptins.asLiveData()
    val allBreastCancerAdiponectins: LiveData<List<Float>> = repository.allBreastCanceradiponectins.asLiveData()
    val allBreastCancerResistins: LiveData<List<Float>> = repository.allBreastCancerresistins.asLiveData()
    val allBreastCancerMcps: LiveData<List<Float>> = repository.allBreastCancermcps.asLiveData()
    val allBreastCancerOutcomes: LiveData<List<String>> = repository.allBreastCanceroutcomes.asLiveData()
    private var currentBreastCancer: BreastCancerEntity? = null
    private var currentBreastCancers: List<BreastCancerEntity> = ArrayList()
	    
    fun searchByBreastCancerid(searchQuery: String): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerid(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerage(searchQuery: Int): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerage(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerbmi(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerbmi(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerglucose(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerglucose(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerinsulin(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerinsulin(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerhoma(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerhoma(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerleptin(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerleptin(searchQuery).asLiveData()
    }
    
    fun searchByBreastCanceradiponectin(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCanceradiponectin(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancerresistin(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancerresistin(searchQuery).asLiveData()
    }
    
    fun searchByBreastCancermcp(searchQuery: Float): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCancermcp(searchQuery).asLiveData()
    }
    
    fun searchByBreastCanceroutcome(searchQuery: String): LiveData<List<BreastCancerEntity>>  {
        return repository.searchByBreastCanceroutcome(searchQuery).asLiveData()
    }
    

	fun getBreastCancerByPK(value: String): Flow<BreastCancer> {
        val res: Flow<List<BreastCancerEntity>> = repository.searchByBreastCancerid(value)
        return res.map { breastCancer ->
            val itemx = BreastCancer.createByPKBreastCancer(value)
            if (breastCancer.isNotEmpty()) {
            itemx.id = breastCancer[0].id
            itemx.age = breastCancer[0].age
            itemx.bmi = breastCancer[0].bmi
            itemx.glucose = breastCancer[0].glucose
            itemx.insulin = breastCancer[0].insulin
            itemx.homa = breastCancer[0].homa
            itemx.leptin = breastCancer[0].leptin
            itemx.adiponectin = breastCancer[0].adiponectin
            itemx.resistin = breastCancer[0].resistin
            itemx.mcp = breastCancer[0].mcp
            itemx.outcome = breastCancer[0].outcome
            }
            itemx
        }
    }
    
    suspend fun createBreastCancer(x: BreastCancerEntity) {
        repository.createBreastCancer(x)
        currentBreastCancer = x
    }
    
    suspend fun editBreastCancer(x: BreastCancerEntity) {
    	        repository.updateBreastCancer(x)
    	        currentBreastCancer = x
    }	    
    
   fun setSelectedBreastCancer(x: BreastCancerEntity) {
	     currentBreastCancer = x
	}
	    
    suspend fun classifyBreastCancer(breastCancer: BreastCancer) : String {
        var result : String
	    lateinit var tflite : Interpreter
	    lateinit var tflitemodel : ByteBuffer
	
	    try{
	        tflitemodel = loadModelFile(assetManager, "cancer.tflite")
	        tflite = Interpreter(tflitemodel) 
	       } catch(ex: Exception){
	            ex.printStackTrace()
	    }
	        
	    val inputVal: FloatArray = floatArrayOf(
	            ((breastCancer.age - 24) / (89 - 24)).toFloat(),
	            ((breastCancer.bmi - 18.37) / (38.5787585 - 18.37)).toFloat(),
	            ((breastCancer.glucose - 60) / (201 - 60)).toFloat(),
	            ((breastCancer.insulin - 2.432) / (58.46 - 2.432)).toFloat(),
	            ((breastCancer.homa - 4.311) / (90.28 - 4.311)).toFloat(),
	            ((breastCancer.leptin - 1.6502) / (38.4 - 1.6502)).toFloat(),
	            ((breastCancer.adiponectin - 3.21) / (82.1 - 3.21)).toFloat(),
	            ((breastCancer.resistin - 45.843) / (1698.44 - 45.843)).toFloat(),
	            ((breastCancer.mcp - 45.843) / (1698.44 - 45.843)).toFloat()
	        )
	    val outputVal: ByteBuffer = ByteBuffer.allocateDirect(8)
	    outputVal.order(ByteOrder.nativeOrder())
	    tflite.run(inputVal, outputVal)
	    outputVal.rewind()
	        
	  	val labelsList : List<String> = listOf ("positive","negative")
	    val output = FloatArray(2)
	        for (i in 0..1) {
	            output[i] = outputVal.float
	        }
	        
	     result = getSortedResult(output, labelsList)[0].toString()
	        
	        breastCancer.outcome = result
	        persistBreastCancer(breastCancer)
	        
	     return result
	    }
	    
	    data class Recognition(
	            var id: String = "",
	            var title: String = "",
	            var confidence: Float = 0F
	        )  {
	            override fun toString(): String {
	                return "$title ($confidence%)"
	            }
	        }
	    
	private fun getSortedResult(labelProbArray: FloatArray, labelList: List<String>): List<Recognition> {
	    
	    val pq = PriorityQueue(
	        labelList.size,
	        Comparator<Recognition> {
	              (_, _, confidence1), (_, _, confidence2)
	              -> confidence1.compareTo(confidence2) * -1
	        })
	    
	    for (i in labelList.indices) {
	        val confidence = labelProbArray[i]
	        pq.add(
	        Recognition("" + i,
	         	if (labelList.size > i) labelList[i] else "Unknown", confidence*100))
	    }
	    val recognitions = ArrayList<Recognition>()
	    val recognitionsSize = Math.min(pq.size, labelList.size)
	    
	    if (pq.size != 0) {
	       for (i in 0 until recognitionsSize) {
	           recognitions.add(pq.poll())
	       }
	    }
	    else {
	           recognitions.add(Recognition("0", "Unknown",100F))
	         }
	    return recognitions
	}
	        
	private fun loadModelFile(assetManager: AssetManager, modelPath: String): ByteBuffer {
	        val fileDescriptor = assetManager.openFd(modelPath)
	        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
	        val fileChannel = inputStream.channel
	        val startOffset = fileDescriptor.startOffset
	        val declaredLength = fileDescriptor.declaredLength
	        return fileChannel.map(
	            FileChannel.MapMode.READ_ONLY,
	            startOffset, declaredLength)
	}

    suspend fun listBreastCancer(): List<BreastCancerEntity> {
	        currentBreastCancers = repository.listBreastCancer()
	        return currentBreastCancers
	    }	
	  
	suspend fun listAllBreastCancer(): ArrayList<BreastCancer> {	
		currentBreastCancers = repository.listBreastCancer()
		var res = ArrayList<BreastCancer>()
			for (x in currentBreastCancers.indices) {
					val vo: BreastCancerEntity = currentBreastCancers[x]
				    val itemx = BreastCancer.createByPKBreastCancer(vo.id)
	            itemx.id = vo.id
            itemx.age = vo.age
            itemx.bmi = vo.bmi
            itemx.glucose = vo.glucose
            itemx.insulin = vo.insulin
            itemx.homa = vo.homa
            itemx.leptin = vo.leptin
            itemx.adiponectin = vo.adiponectin
            itemx.resistin = vo.resistin
            itemx.mcp = vo.mcp
            itemx.outcome = vo.outcome
			res.add(itemx)
		}
		return res
	}

    suspend fun stringListBreastCancer(): List<String> {
        currentBreastCancers = repository.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
        for (x in currentBreastCancers.indices) {
            res.add(currentBreastCancers[x].toString())
        }
        return res
    }

    suspend fun getBreastCancerByPK2(value: String): BreastCancer? {
        val res: List<BreastCancerEntity> = repository.searchByBreastCancerid2(value)
	        return if (res.isEmpty()) {
	            null
	        } else {
	            val vo: BreastCancerEntity = res[0]
	            val itemx = BreastCancer.createByPKBreastCancer(value)
	            itemx.id = vo.id
            itemx.age = vo.age
            itemx.bmi = vo.bmi
            itemx.glucose = vo.glucose
            itemx.insulin = vo.insulin
            itemx.homa = vo.homa
            itemx.leptin = vo.leptin
            itemx.adiponectin = vo.adiponectin
            itemx.resistin = vo.resistin
            itemx.mcp = vo.mcp
            itemx.outcome = vo.outcome
	            itemx
	        }
    }
    
    suspend fun retrieveBreastCancer(value: String): BreastCancer? {
            return getBreastCancerByPK2(value)
    }

    suspend fun allBreastCancerIds(): ArrayList<String> {
        currentBreastCancers = repository.listBreastCancer()
        val res: ArrayList<String> = ArrayList()
            for (breastcancer in currentBreastCancers.indices) {
                res.add(currentBreastCancers[breastcancer].id)
            }
        return res
    }

    fun setSelectedBreastCancer(i: Int) {
        if (i < currentBreastCancers.size) {
            currentBreastCancer = currentBreastCancers[i]
        }
    }

    fun getSelectedBreastCancer(): BreastCancerEntity? {
        return currentBreastCancer
    }

    suspend fun persistBreastCancer(x: BreastCancer) {
        val vo = BreastCancerEntity(x.id, x.age, x.bmi, x.glucose, x.insulin, x.homa, x.leptin, x.adiponectin, x.resistin, x.mcp, x.outcome)
        repository.updateBreastCancer(vo)
        currentBreastCancer = vo
    }
	

	
}
