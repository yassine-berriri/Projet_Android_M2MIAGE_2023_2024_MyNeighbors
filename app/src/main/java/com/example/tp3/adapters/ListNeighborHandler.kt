package com.example.tp3.adapters

import com.example.tp3.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeighbor(neighbor: Neighbor)
}