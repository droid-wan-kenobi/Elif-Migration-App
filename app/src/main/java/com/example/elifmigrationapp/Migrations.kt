package com.example.elifmigrationapp

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {
    val migration1To2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE artist (id INTEGER, name TEXT, PRIMARY KEY(id))")
            database.execSQL("ALTER TABLE song ADD COLUMN artistId INTEGER")
        }
    }
}