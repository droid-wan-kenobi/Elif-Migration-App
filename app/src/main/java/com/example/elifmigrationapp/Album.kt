package com.example.elifmigrationapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Album internal constructor(
    @field:PrimaryKey val id: Int, val name: String
) {
    companion object {
        const val TABLE_NAME = "Album"
    }
}