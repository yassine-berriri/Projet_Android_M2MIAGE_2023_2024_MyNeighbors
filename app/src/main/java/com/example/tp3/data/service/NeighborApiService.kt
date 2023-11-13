package com.example.tp3.data.service

import com.example.tp3.models.Neighbor

interface NeighborApiService {
    /**
     * Get all my Neighbors
     * @return [List]
     */
    val neighbours: List<Neighbor>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbour(neighbor: Neighbor):Boolean

    /**
     * Create a neighbour
     * @param neighbor: Neighbor
     */
    fun createNeighbour(neighbor: Neighbor):Boolean

    /**
     * Update "Favorite status" of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateDataNeighbour(neighbor: Neighbor)
}