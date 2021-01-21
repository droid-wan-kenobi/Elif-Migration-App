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

    val migration3To4 = object : Migration(3, 4) {
        // This is a complex database scheme change. Hence we will create a new table, with the
        // foreign key definitions we want to add, move data into it, drop the old table, and
        // rename the temporary new table we created to the name of the old table.
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Temp` " +
                    "(`title` TEXT NOT NULL, " +
                    "`length` INTEGER NOT NULL, " +
                    "`artistId` INTEGER NOT NULL, " +
                    "`albumId` INTEGER NOT NULL, " +
                    "`id` INTEGER PRIMARY KEY NOT NULL, " +
                    "FOREIGN KEY (artistId) REFERENCES Artist(id), " +
                    "FOREIGN KEY (albumId) REFERENCES Album(id))")
            database.execSQL("INSERT INTO `Temp` (title, length, artistId, albumId, id) " +
                    "SELECT title, length, artistId, albumId, id " +
                    "FROM Song")
            database.execSQL("DROP TABLE `Song`")
            database.execSQL("ALTER TABLE `Temp` RENAME TO `Song`")
        }
    }
}