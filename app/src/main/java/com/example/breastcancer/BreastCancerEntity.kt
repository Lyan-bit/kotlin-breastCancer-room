package com.example.breastcancer

import androidx.room.Entity 
import androidx.room.PrimaryKey

@Entity(tableName = "breastCancerTable")
data class BreastCancerEntity (
    @PrimaryKey
    val id: String, 
    val age: Int, 
    val bmi: Float, 
    val glucose: Float, 
    val insulin: Float, 
    val homa: Float, 
    val leptin: Float, 
    val adiponectin: Float, 
    val resistin: Float, 
    val mcp: Float, 
    val outcome: String
)
