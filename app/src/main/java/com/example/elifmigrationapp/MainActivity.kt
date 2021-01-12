package com.example.elifmigrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}