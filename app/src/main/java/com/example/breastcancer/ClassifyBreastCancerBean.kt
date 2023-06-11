package com.example.breastcancer

import android.content.Context
import java.util.*

class ClassifyBreastCancerBean(c: Context) {
    private var model: ModelFacade = ModelFacade.getInstance(c)

    private var breastcancer = ""
	private var instanceBreastCancer: BreastCancer? = null
	

    private var errors = ArrayList<String>()
    private var checkEmpty = " cannot be empty"

    fun setBreastCancer(breastcancerx: String) {
        breastcancer = breastcancerx
    }
    

    fun resetData() {
        breastcancer = ""
    }

suspend fun isClassifyBreastCancerError(): Boolean {
	    errors.clear()
        instanceBreastCancer = model.getBreastCancerByPK2(breastcancer)
        if (instanceBreastCancer == null) {
            errors.add("breastCancer must be a valid BreastCancer id")
        }
        

	    return errors.isNotEmpty()
	}

    fun errors(): String {
        return errors.toString()
    }

    suspend fun classifyBreastCancer (): String {
        return model.classifyBreastCancer(instanceBreastCancer!!)
    }

}
