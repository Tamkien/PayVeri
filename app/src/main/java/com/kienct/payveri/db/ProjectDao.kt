package com.kienct.payveri.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(project: Project)
    @Query("SELECT * FROM project_table ORDER BY id ASC")
    fun getAllProjects(): Flow<List<Project>>
}