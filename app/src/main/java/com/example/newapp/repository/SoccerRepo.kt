package com.example.newapp.repository

import com.example.newapp.data.model.Soccer

interface SoccerRepo {
    suspend fun getLatestCourt(): Result<List<Soccer>>
    suspend fun getLatestCourt1(): Result<List<Soccer>>
    suspend fun getLatestCourt2(): Result<List<Soccer>>
}