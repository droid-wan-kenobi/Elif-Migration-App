package com.example.elifmigrationapp.data

import com.example.elifmigrationapp.R
import com.example.elifmigrationapp.Song

class Datasource {
    fun loadDataFromDatabase(): List<Song> {
        return listOf(
            Song(1, "Song Name1", 1, 1, 1),
            Song(2, "Song Name2", 2, 2, 2)
        )
    }
}