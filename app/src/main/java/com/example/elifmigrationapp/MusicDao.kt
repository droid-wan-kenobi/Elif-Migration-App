package com.example.elifmigrationapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class MusicDao {
    @Insert
    abstract fun insert(
        entity: Song?
    )
    @Insert
    abstract fun insertAllSongs(
        list: List<Song>
    )

    @Query("SELECT * FROM Song")
    abstract fun getAllSongs(
    ): List<Song>
}
