package com.kienct.payveri.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_table")

data class Project (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "bank_text")
    val bankText: String,
    @ColumnInfo(name = "prefix")
    val prefix: String,
    @ColumnInfo(name = "token")
    val token: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "is_active")
    val isActive: Boolean
    )
