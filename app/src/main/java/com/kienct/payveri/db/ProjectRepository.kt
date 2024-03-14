package com.kienct.payveri.db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ProjectRepository(private val projectDao: ProjectDao) {
    val allProjects: Flow<List<Project>> = projectDao.getAllProjects()
    @WorkerThread
    suspend fun insert(project: Project) {
        projectDao.insert(project)
    }
}