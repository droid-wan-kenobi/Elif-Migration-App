package com.example.elifmigrationapp

import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteQuery
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicDbTest {
    @Test
    fun initializeDb() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.elifmigrationapp", appContext.packageName)
    }

    @Test
    fun insertAndGetSongs() {
        val db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            MusicDatabase::class.java
        ).build()
        val dao = db.musicDao()

        val songs = listOf(
                Song(3, "White Shadows", 3),
                Song(1, "Tell Me Baby", 3),
                Song(2, "Hysteria", 2),
        )
        dao.insertAllSongs(songs)
        val result = dao.getAllSongs()
        assertThat(result).isEqualTo(songs)
        db.close()
    }

    @Test
    fun afterMigration1To2() {
        val db = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().context,
                MusicDatabase::class.java
        )
                .addMigrations(Migrations.migration1To2)
                .build()
        val dao = db.musicDao()

//        val artists = listOf(
//                Artist(3, "Red Hot Chili Peppers"),
//                Artist(2, "Muse"),
//                Artist(1, "Coldplay")
//        )
//        dao.insertAllArtists(artists)
//
//        val songs = listOf(
//                Song(1, "White Shadows", 3, 1),
//                Song(2, "Yellow", 3, 1),
//                Song(4, "Hysteria", 2, 2),
//                Song(3, "Tell Me Baby", 3, 1),
//                Song(3, "Snow", 3, 1),
//                Song(3, "Californication", 3, 1),
//
//                )
//        dao.insertAllSongs(songs)
//        val result = dao.getAllSongs()
    }
}
