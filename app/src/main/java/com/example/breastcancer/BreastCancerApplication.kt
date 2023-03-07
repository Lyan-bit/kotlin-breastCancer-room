package com.example.breastcancer

import android.app.Application
import androidx.room.Room

class BreastCancerApplication : Application() {

    companion object {
        lateinit var database: BreastCancerDatabase
            private set
    }
    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(
                this,
                BreastCancerDatabase::class.java,
                "breastCancerDatabase"
            )
            .build() }
}
