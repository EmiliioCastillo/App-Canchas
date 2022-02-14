package com.example.newapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.newapp.core.Result
import com.example.newapp.repository.SoccerRepo
import com.example.newapp.ui.soccer.concat.MostVotedConcatAdapter
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class SoccerViewModel(private val repo : SoccerRepo) : ViewModel(){
     fun fetchLatestCourt() = liveData(Dispatchers.IO) {
         emit(Result.Loading())
         try {
             emit(Result.Success(Triple(repo.getLatestCourt(), repo.getLatestCourt1(), repo.getLatestCourt2()))
         }catch (e : Exception){
             emit(Result.Failure(e))
         }
     }
     }
class SoccerViewModelFactory(private val repo : SoccerRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SoccerRepo::class.java).newInstance(repo)
    }
}