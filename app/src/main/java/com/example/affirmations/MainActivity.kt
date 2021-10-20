package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create an instance of [Datasource] and call [loadAffirmations] on it
        val myDataset = Datasource().loadAffirmations()

        // find a reference to the recycler view using [findViewById]
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // Remember [ItemAdapter] which displays [Affirmation] data object?
        // Set the adapter property of [recyclerView] to an instance of [ItemAdapter]
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Improve performance
        recyclerView.setHasFixedSize(true)
    }
}