package com.example.breastcancer

import androidx.room.Database
import androidx.room.RoomDatabase 

@Database(entities = [(BreastCancerEntity::class)], version = 1, exportSchema = false)
abstract class BreastCancerDatabase : RoomDatabase() {
    abstract fun breastCancerDao(): BreastCancerEntityDao
}
