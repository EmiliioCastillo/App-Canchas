package com.example.newapp.repository

import com.example.newapp.data.model.Soccer
import com.example.newapp.data.remote.SoccerDataSource

class SoccerRepoImpl(private val dataSource: SoccerDataSource) : SoccerRepo {
    override suspend fun getLatestCourt(): Result<List<Soccer>> = dataSource.getLatestCourt()
    override suspend fun getLatestCourt1(): Result<List<Soccer>> = dataSource.getLatestCourt()

    override suspend fun getLatestCourt2(): Result<List<Soccer>> = dataSource.getLatestCourt()
}