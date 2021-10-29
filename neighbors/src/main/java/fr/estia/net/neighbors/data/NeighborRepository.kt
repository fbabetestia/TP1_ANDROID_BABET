package fr.estia.net.neighbors.data

import fr.estia.net.neighbors.data.service.DummyNeighborApiService
import fr.estia.net.neighbors.data.service.NeighborApiService
import fr.estia.net.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun removeNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
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
