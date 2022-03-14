package com.example.edvora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.edvora.MyAdapter.RideAdapter
import com.example.edvora.Repository.Repository
import com.example.edvora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val rideAdapter by lazy { RideAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getRides()
        viewModel.getUser()

        setupRecyclerView()

        viewModel.responseRides.observe(this) { response ->

            if (response.isSuccessful) {
                response.body()?.let {
                    rideAdapter.setData(it)
                }

            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }

        }

        viewModel.responseUser.observe(this) { response ->
            if (response.isSuccessful) {
                response.body()?.let {

                    Glide.with(this)
                        .load(it.url)
                        .centerCrop()
                        .into(binding.circularImg)

                    binding.name.text = it.name
                }

            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = rideAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}