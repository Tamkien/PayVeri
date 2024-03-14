package com.kienct.payveri.db

import androidx.room.Database

@Database(entities = [Project::class], version = 1, exportSchema = false)

public abstract class ProjectRoomDatabase : androidx.room.RoomDatabase(){
    abstract fun projectDao(): ProjectDao
    companion object {
        @Volatile
        public final var INSTANCE: ProjectRoomDatabase? = null
        public final fun getDatabase(context: android.content.Context, scope: kotlinx.coroutines.CoroutineScope): ProjectRoomDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = androidx.room.Room.databaseBuilder(context.applicationContext, ProjectRoomDatabase::class.java, "project_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}