package com.example.elifmigrationapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class, Artist::class], version = 2, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}