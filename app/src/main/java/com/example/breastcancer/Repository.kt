package com.example.breastcancer

import kotlinx.coroutines.flow.Flow 

class Repository : BreastCancerRepository  {

    private val breastCancerDao: BreastCancerEntityDao by lazy { BreastCancerApplication.database.breastCancerDao() }

    val allBreastCancers: Flow<List<BreastCancerEntity>> = breastCancerDao.listBreastCancers()

    val allBreastCancerids: Flow<List<String>> = breastCancerDao.listBreastCancerids()
    val allBreastCancerages: Flow<List<Int>> = breastCancerDao.listBreastCancerages()
    val allBreastCancerbmis: Flow<List<Float>> = breastCancerDao.listBreastCancerbmis()
    val allBreastCancerglucoses: Flow<List<Float>> = breastCancerDao.listBreastCancerglucoses()
    val allBreastCancerinsulins: Flow<List<Float>> = breastCancerDao.listBreastCancerinsulins()
    val allBreastCancerhomas: Flow<List<Float>> = breastCancerDao.listBreastCancerhomas()
    val allBreastCancerleptins: Flow<List<Float>> = breastCancerDao.listBreastCancerleptins()
    val allBreastCanceradiponectins: Flow<List<Float>> = breastCancerDao.listBreastCanceradiponectins()
    val allBreastCancerresistins: Flow<List<Float>> = breastCancerDao.listBreastCancerresistins()
    val allBreastCancermcps: Flow<List<Float>> = breastCancerDao.listBreastCancermcps()
    val allBreastCanceroutcomes: Flow<List<String>> = breastCancerDao.listBreastCanceroutcomes()

    //Create
    override suspend fun createBreastCancer(breastCancer: BreastCancerEntity) {
        breastCancerDao.createBreastCancer(breastCancer)
    }

    //Read
    override suspend fun listBreastCancer(): List<BreastCancerEntity> {
        return breastCancerDao.listBreastCancer()
    }

    //Update
    override suspend fun updateBreastCancer(breastCancer: BreastCancerEntity) {
        breastCancerDao.updateBreastCancer(breastCancer)
    }

    //Delete all BreastCancers
    override suspend fun deleteBreastCancers() {
       breastCancerDao.deleteBreastCancers()
    }

    //Delete a BreastCancer
	override suspend fun deleteBreastCancer(id: String) {
	   breastCancerDao.deleteBreastCancer(id)
    }
    
     //Search with live data
     override fun searchByBreastCancerid (searchQuery: String): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerid(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerage (searchQuery: Int): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerage(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerbmi (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerbmi(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerglucose (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerglucose(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerinsulin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerinsulin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerhoma (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerhoma(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerleptin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerleptin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCanceradiponectin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCanceradiponectin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancerresistin (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancerresistin(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCancermcp (searchQuery: Float): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCancermcp(searchQuery)
     }
     
     //Search with live data
     override fun searchByBreastCanceroutcome (searchQuery: String): Flow<List<BreastCancerEntity>>  {
         return breastCancerDao.searchByBreastCanceroutcome(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchByBreastCancerid2 (id: String): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerid2(id)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerage2 (age: Int): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerage2(age)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerbmi2 (bmi: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerbmi2(bmi)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerglucose2 (glucose: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerglucose2(glucose)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerinsulin2 (insulin: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerinsulin2(insulin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerhoma2 (homa: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerhoma2(homa)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerleptin2 (leptin: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerleptin2(leptin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCanceradiponectin2 (adiponectin: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCanceradiponectin2(adiponectin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancerresistin2 (resistin: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancerresistin2(resistin)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCancermcp2 (mcp: Float): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCancermcp2(mcp)
     }
	     
    //Search with suspend
     override suspend fun searchByBreastCanceroutcome2 (outcome: String): List<BreastCancerEntity> {
          return breastCancerDao.searchByBreastCanceroutcome2(outcome)
     }
	     


}
