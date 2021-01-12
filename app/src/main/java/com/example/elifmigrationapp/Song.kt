package com.example.elifmigrationapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = Song.TABLE_NAME)
data class Song internal constructor(
    @field:PrimaryKey val id: Int, val title: String, val length: Int
) {
    companion object {
        const val TABLE_NAME = "Song"
    }
}