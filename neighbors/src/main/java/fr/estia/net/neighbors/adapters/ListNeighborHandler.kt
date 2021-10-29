package fr.estia.net.neighbors.adapters

import fr.estia.net.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
}
