package com.example.breastcancer

import java.util.HashMap

class BreastCancer {

    init {
        breastCancerAllInstances.add(this)
    }

    companion object {
        var breastCancerAllInstances = ArrayList<BreastCancer>()
        fun createBreastCancer(): BreastCancer {
            return BreastCancer()
        }
        
        var breastCancerIndex: HashMap<String, BreastCancer> = HashMap<String, BreastCancer>()
        
        fun createByPKBreastCancer(idx: String): BreastCancer {
            var result: BreastCancer? = breastCancerIndex[idx]
            if (result != null) { return result }
                  result = BreastCancer()
                  breastCancerIndex.put(idx,result)
                  result.id = idx
                  return result
        }
        
		fun killBreastCancer(idx: String?) {
            val rem = breastCancerIndex[idx] ?: return
            val remd = ArrayList<BreastCancer>()
            remd.add(rem)
            breastCancerIndex.remove(idx)
            breastCancerAllInstances.removeAll(remd)
        }        
    }

    var id = ""  /* identity */
    var age = 0 
    var bmi = 0.0F 
    var glucose = 0.0F 
    var insulin = 0.0F 
    var homa = 0.0F 
    var leptin = 0.0F 
    var adiponectin = 0.0F 
    var resistin = 0.0F 
    var mcp = 0.0F 
    var outcome = ""  /* derived */

}
