package com.example.newapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.example.newapp.R
import com.example.newapp.core.Result
import com.example.newapp.data.model.Soccer
import com.example.newapp.data.remote.SoccerDataSource
import com.example.newapp.databinding.FragmentSoccerBinding
import com.example.newapp.presentation.SoccerViewModel
import com.example.newapp.presentation.SoccerViewModelFactory
import com.example.newapp.repository.SoccerRepoImpl
import com.example.newapp.ui.soccer.adapters.SoccerAdapter




class SoccerFragment : Fragment(R.layout.fragment_soccer), SoccerAdapter.OnSoccerListener {
    override fun OnMovieClick(soccer: Soccer) {
        Log.d("Movie", "onMovieClick : $soccer")
    }

    private lateinit var binding: FragmentSoccerBinding
    private val viewModel by viewModels<SoccerViewModel> {
        SoccerViewModelFactory(
            SoccerRepoImpl(
                SoccerDataSource()
            )
        )
    }
    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        concatAdapter = ConcatAdapter()


            viewModel.fetchLatestCourt().observe(viewLifecycleOwner, androidx.lifecycle.Observer { result ->
                when (result) {
                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Result.Success -> {
                        binding.rvSoccer.visibility = View.GONE


                    }
                }
            })
                }
            }
