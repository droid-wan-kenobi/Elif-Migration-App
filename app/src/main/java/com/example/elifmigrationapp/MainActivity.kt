package com.example.elifmigrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.elifmigrationapp.adapter.ItemAdapter
import com.example.elifmigrationapp.data.Datasource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val db = Room.inMemoryDatabaseBuilder(
            applicationContext,
            MusicDatabase::class.java
        ).allowMainThreadQueries().build()

        val myDataset = Datasource().loadDataFromDatabase(db)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)
    }
}