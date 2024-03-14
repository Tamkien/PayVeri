package com.kienct.payveri

import android.app.Application
import com.kienct.payveri.db.ProjectRepository
import com.kienct.payveri.db.ProjectRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PayveriApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ProjectRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ProjectRepository(database.projectDao()) }

}