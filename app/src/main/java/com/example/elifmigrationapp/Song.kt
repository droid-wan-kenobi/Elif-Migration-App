package com.example.elifmigrationapp

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey




@Entity(
    foreignKeys = [
        ForeignKey (entity = Artist::class, parentColumns = ["id"], childColumns = ["artistId"]),
        ForeignKey (entity = Album::class, parentColumns = ["id"], childColumns = ["albumId"])
    ]
)
data class Song (
    @field:PrimaryKey val id: Int, val title: String, val length: Int, val artistId: Int,
    val albumId: Int) {
    companion object {
        const val TABLE_NAME = "Song"
    }
}
