package com.example.tp3.data

import com.example.tp3.data.service.DummyNeighborApiService
import com.example.tp3.data.service.NeighborApiService
import com.example.tp3.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun deleteNeighbors(neighbor: Neighbor): Boolean{
        return apiService.deleteNeighbour(neighbor)
    }

    fun addNeighbor(neighbor: Neighbor): Boolean{
       return apiService.createNeighbour(neighbor)
    }

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}