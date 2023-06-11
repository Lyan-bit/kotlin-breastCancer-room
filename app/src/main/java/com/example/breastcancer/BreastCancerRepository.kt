package com.example.breastcancer

import kotlinx.coroutines.flow.Flow 

interface BreastCancerRepository {
    //Read
    suspend fun listBreastCancer(): List<BreastCancerEntity>

    //Create
    suspend fun createBreastCancer(breastCancer: BreastCancerEntity)

    //Update
    suspend fun updateBreastCancer(breastCancer: BreastCancerEntity)

    //Delete All BreastCancers
    suspend fun deleteBreastCancers()


    //Delete a BreastCancer by PK
	suspend fun deleteBreastCancer(id: String)
	    
    //Search with live data
    fun searchByBreastCancerid(searchQuery: String): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerage(searchQuery: Int): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerbmi(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerglucose(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerinsulin(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerhoma(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerleptin(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCanceradiponectin(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancerresistin(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCancermcp(searchQuery: Float): Flow<List<BreastCancerEntity>>
    //Search with live data
    fun searchByBreastCanceroutcome(searchQuery: String): Flow<List<BreastCancerEntity>>

    //Search with suspend
    suspend fun searchByBreastCancerid2(searchQuery: String): List<BreastCancerEntity>
    suspend fun searchByBreastCancerage2(searchQuery: Int): List<BreastCancerEntity>
    suspend fun searchByBreastCancerbmi2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCancerglucose2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCancerinsulin2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCancerhoma2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCancerleptin2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCanceradiponectin2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCancerresistin2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCancermcp2(searchQuery: Float): List<BreastCancerEntity>
    suspend fun searchByBreastCanceroutcome2(searchQuery: String): List<BreastCancerEntity>

}
