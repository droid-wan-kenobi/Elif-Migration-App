package com.example.elifmigrationapp

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {
    val migration1To2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE artist (id INTEGER NOT NULL, name TEXT NOT NULL, PRIMARY KEY(id))")
            database.execSQL("ALTER TABLE song ADD COLUMN artistId INTEGER NOT NULL DEFAULT 0")
        }
    }

    val migration2To3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE album (id INTEGER NOT NULL, name TEXT NOT NULL, PRIMARY KEY(id))")
            database.execSQL("ALTER TABLE song ADD COLUMN albumId INTEGER NOT NULL DEFAULT 0")
        }
    }
}