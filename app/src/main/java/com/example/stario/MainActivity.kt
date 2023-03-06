package com.example.stario

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stario.adapter.ItemAdapter
import com.example.stario.databinding.ActivityMainBinding
import com.example.stario.network.Planet
import com.example.stario.overview.OverviewViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity(), IMainActivity {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: OverviewViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        itemAdapter = ItemAdapter(
            this,
            arrayListOf()
        )
        recyclerView.adapter = itemAdapter

        viewModel = OverviewViewModel(this)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getPlanets()
    }

    override fun updateList(planets: List<Planet>) {
        itemAdapter.updateData(planets)
    }
}

interface IMainActivity {
    fun updateList(planets: List<Planet>)
}