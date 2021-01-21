package com.example.elifmigrationapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class, Artist::class, Album::class], version = 4, exportSchema = true)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}