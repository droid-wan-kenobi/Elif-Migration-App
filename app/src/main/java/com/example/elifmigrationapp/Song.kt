package com.example.elifmigrationapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Song internal constructor(
    @field:PrimaryKey val id: Int, val title: String, val length: Int, val artistId: Int,
    val albumId: Int
) {
    companion object {
        const val TABLE_NAME = "Song"
    }
}