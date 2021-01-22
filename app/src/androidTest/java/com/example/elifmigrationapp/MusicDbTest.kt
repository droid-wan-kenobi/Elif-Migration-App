package com.example.elifmigrationapp

import androidx.room.Room
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteQuery
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicDbTest {
    private val migrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        MusicDatabase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )
    @Test
    fun initializeDb() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.elifmigrationapp", appContext.packageName)
        val db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            MusicDatabase::class.java
        ).build()
    }

//    @Test
//    fun testP1() {
//        val db = Room.inMemoryDatabaseBuilder(
//            InstrumentationRegistry.getInstrumentation().context,
//            MusicDatabase::class.java
//        ).build()
//        val dao = db.musicDao()
//
//        val songs = listOf(
//            Song(1, "Tell Me Baby", 3),
//            Song(2, "Hysteria", 2),
//            Song(3, "White Shadows", 3)
//        )
//        dao.insertAllSongs(songs)
//        val result = dao.getAllSongs()
//        assertThat(result).isEqualTo(songs)
//        db.close()
//    }
//
//    @Test
//    fun testMultiTableChangeInP2() {
//        val db = Room.inMemoryDatabaseBuilder(
//                InstrumentationRegistry.getInstrumentation().context,
//                MusicDatabase::class.java
//        )
//                .addMigrations(Migrations.migration1To2)
//                .build()
//        val dao = db.musicDao()
//
//        val artists = listOf(
//                Artist(1, "Coldplay"),
//                Artist(2, "Muse"),
//                Artist(3, "Red Hot Chili Peppers"),
//        )
//        dao.insertAllArtists(artists)
//
//        val songs = listOf(
//                Song(1, "White Shadows", 3, 1),
//                Song(2, "Yellow", 3, 1),
//                Song(3, "Hysteria", 2, 2),
//                Song(4, "Tell Me Baby", 3, 3),
//                Song(5, "Snow", 3, 3),
//                Song(6, "Californication", 3, 3),
//                )
//        dao.insertAllSongs(songs)
//
//        val actualResult = dao.getArtistAndSongCount()
//        val expectedResult = listOf(
//                ArtistAndNumOfSongs("Coldplay", 2),
//                ArtistAndNumOfSongs("Muse", 1),
//                ArtistAndNumOfSongs("Red Hot Chili Peppers", 3),
//        )
//        assertThat(actualResult).isEqualTo(expectedResult)
//    }
//
//
//    @Test
//    fun firstToSecondMigrationInP2() {
//        migrationTestHelper.createDatabase("test_db", 1)
//        migrationTestHelper.runMigrationsAndValidate(
//            "test_db",
//            2,
//            false,
//            Migrations.migration1To2
//        )
//    }
//
//    @Test
//    fun firstToSecondMigrationInP3() {
//        migrationTestHelper.createDatabase("test_db", 2)
//        migrationTestHelper.runMigrationsAndValidate(
//            "test_db",
//            3,
//            false,
//            Migrations.migration1To2, Migrations.migration2To3
//        )
//    }
//
//    @Test
//    fun testMultiTableChangeInP3() {
//        migrationTestHelper.createDatabase("test_db", 2).use { db ->
//            // I ended up making all album and artist ids not null should i switch this back
//            //db.execSQL("INSERT INTO Song VALUES (1, 'Ni Bien Ni Mal', 240, NULL)")
//            db.execSQL("INSERT INTO Song VALUES (1, 'Ni Bien Ni Mal', 240, 1)")
//        }
//        migrationTestHelper.runMigrationsAndValidate(
//            "test_db",
//            3,
//            false,
//            Migrations.migration1To2, Migrations.migration2To3
//        )
//        val db = Room.databaseBuilder(
//            InstrumentationRegistry.getInstrumentation().targetContext,
//            MusicDatabase::class.java,
//            "test_db"
//        ).build()
//        val dao = db.musicDao()
//        assertThat(dao.getAllSongs().size).isEqualTo(1)
//    }
//
    // Adapting this test to only migrate from 3 to 4 as we know the previous parts do work.
    @Test
    fun thirdToFourthMigration() {
        migrationTestHelper.createDatabase("test_db", 3).use { db ->
            db.execSQL("INSERT INTO Artist VALUES (1, 'Bad Bunny')")
            db.execSQL("INSERT INTO Album VALUES (1, 'YHLQMDLG')")
            db.execSQL("INSERT INTO Song VALUES (1, 'Ni Bien Ni Mal', 1, 1, 1)")
        }
        migrationTestHelper.runMigrationsAndValidate(
            "test_db",
            4,
            false,
            Migrations.migration1To2, Migrations.migration2To3,
            Migrations.migration3To4
        )
//        val db = Room.databaseBuilder(
//            InstrumentationRegistry.getInstrumentation().context,
//            MusicDatabase::class.java,
//            "test_db"
//        ).build()
//        val dao = db.musicDao()
//        assertThat(dao.getAllSongs().size).isEqualTo(1)
//        db.close()
    }
}
