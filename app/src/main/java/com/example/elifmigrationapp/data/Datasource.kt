package com.example.elifmigrationapp.data

import android.content.Context
import androidx.room.Room
import com.example.elifmigrationapp.MusicDatabase
import com.example.elifmigrationapp.Song

class Datasource {
    fun loadDataFromDatabase(db: MusicDatabase): List<Song> {
        val dao = db.musicDao()

        // Adding the last column as we finish part 2
//        val songs = listOf(
//            Song(1, "Tell Me Baby", 3, 3, 3),
//            Song(2, "Hysteria", 2, 2, 2),
//            Song(3, "White Shadows", 3, 1, 1)
//        )
//        dao.insertAllSongs(songs)

        return dao.getAllSongs()
    }
}