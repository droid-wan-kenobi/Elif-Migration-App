package com.example.elifmigrationapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

data class ArtistAndNumOfSongs(val name: String, val numOfSongs: Int)

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

    @Insert
    abstract fun insertAllArtists(
            list: List<Artist>
    )

    @Query("SELECT * FROM Song")
    abstract fun getAllSongs(
    ): List<Song>

    @Query("SELECT * FROM Artist")
    abstract fun getAllArtists(
    ): List<Artist>

    @Query("SELECT Artist.name, count(*) as numOfSongs FROM Song JOIN Artist ON (Song.artistId = " +
            "Artist.id) GROUP BY Artist.name")
    abstract fun getArtistAndSongCount(
    ): List<ArtistAndNumOfSongs>
}
