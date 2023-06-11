package com.example.breastcancer

import androidx.room.*
import kotlinx.coroutines.flow.Flow 

@Dao
interface BreastCancerEntityDao {
    //LiveData
    //Read (list entity)
    @Query("SELECT * FROM breastCancerTable")
    fun listBreastCancers(): Flow<List<BreastCancerEntity>>

    //Read (list id)
	@Query("SELECT id FROM breastCancerTable")
	fun listBreastCancerids (): Flow<List<String>>
    //Read (list age)
	@Query("SELECT age FROM breastCancerTable")
	fun listBreastCancerages (): Flow<List<Int>>
    //Read (list bmi)
	@Query("SELECT bmi FROM breastCancerTable")
	fun listBreastCancerbmis (): Flow<List<Float>>
    //Read (list glucose)
	@Query("SELECT glucose FROM breastCancerTable")
	fun listBreastCancerglucoses (): Flow<List<Float>>
    //Read (list insulin)
	@Query("SELECT insulin FROM breastCancerTable")
	fun listBreastCancerinsulins (): Flow<List<Float>>
    //Read (list homa)
	@Query("SELECT homa FROM breastCancerTable")
	fun listBreastCancerhomas (): Flow<List<Float>>
    //Read (list leptin)
	@Query("SELECT leptin FROM breastCancerTable")
	fun listBreastCancerleptins (): Flow<List<Float>>
    //Read (list adiponectin)
	@Query("SELECT adiponectin FROM breastCancerTable")
	fun listBreastCanceradiponectins (): Flow<List<Float>>
    //Read (list resistin)
	@Query("SELECT resistin FROM breastCancerTable")
	fun listBreastCancerresistins (): Flow<List<Float>>
    //Read (list mcp)
	@Query("SELECT mcp FROM breastCancerTable")
	fun listBreastCancermcps (): Flow<List<Float>>
    //Read (list outcome)
	@Query("SELECT outcome FROM breastCancerTable")
	fun listBreastCanceroutcomes (): Flow<List<String>>

	//Suspend
    //Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createBreastCancer (breastCancer: BreastCancerEntity)

    //Read (list entity with suspend)
    @Query("SELECT * FROM breastCancerTable")
    suspend fun listBreastCancer(): List<BreastCancerEntity>

    //Update
    @Update
    suspend fun updateBreastCancer (breastCancer: BreastCancerEntity)

    //Delete all records
    @Query("DELETE FROM breastCancerTable")
    suspend fun deleteBreastCancers ()

    //Delete a single record by PK
    @Query("DELETE FROM breastCancerTable WHERE id = :id")
    suspend fun deleteBreastCancer (id: String)
    
    //Search with live data
	@Query("SELECT * FROM  breastCancerTable WHERE id LIKE :searchQuery ")
	fun searchByBreastCancerid(searchQuery: String): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE age LIKE :searchQuery ")
	fun searchByBreastCancerage(searchQuery: Int): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE bmi LIKE :searchQuery ")
	fun searchByBreastCancerbmi(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE glucose LIKE :searchQuery ")
	fun searchByBreastCancerglucose(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE insulin LIKE :searchQuery ")
	fun searchByBreastCancerinsulin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE homa LIKE :searchQuery ")
	fun searchByBreastCancerhoma(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE leptin LIKE :searchQuery ")
	fun searchByBreastCancerleptin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE adiponectin LIKE :searchQuery ")
	fun searchByBreastCanceradiponectin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE resistin LIKE :searchQuery ")
	fun searchByBreastCancerresistin(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE mcp LIKE :searchQuery ")
	fun searchByBreastCancermcp(searchQuery: Float): Flow<List<BreastCancerEntity>>
	@Query("SELECT * FROM  breastCancerTable WHERE outcome LIKE :searchQuery ")
	fun searchByBreastCanceroutcome(searchQuery: String): Flow<List<BreastCancerEntity>>

    //Search with suspend
    @Query("SELECT * FROM  breastCancerTable WHERE id LIKE :searchQuery")
	suspend fun searchByBreastCancerid2(searchQuery: String): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE age LIKE :searchQuery")
	suspend fun searchByBreastCancerage2(searchQuery: Int): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE bmi LIKE :searchQuery")
	suspend fun searchByBreastCancerbmi2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE glucose LIKE :searchQuery")
	suspend fun searchByBreastCancerglucose2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE insulin LIKE :searchQuery")
	suspend fun searchByBreastCancerinsulin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE homa LIKE :searchQuery")
	suspend fun searchByBreastCancerhoma2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE leptin LIKE :searchQuery")
	suspend fun searchByBreastCancerleptin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE adiponectin LIKE :searchQuery")
	suspend fun searchByBreastCanceradiponectin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE resistin LIKE :searchQuery")
	suspend fun searchByBreastCancerresistin2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE mcp LIKE :searchQuery")
	suspend fun searchByBreastCancermcp2(searchQuery: Float): List<BreastCancerEntity>
    @Query("SELECT * FROM  breastCancerTable WHERE outcome LIKE :searchQuery")
	suspend fun searchByBreastCanceroutcome2(searchQuery: String): List<BreastCancerEntity>

}
