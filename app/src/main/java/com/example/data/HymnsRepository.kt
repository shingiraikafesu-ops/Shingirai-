package com.example.data

import kotlinx.coroutines.flow.Flow

class HymnsRepository(private val favoriteDao: FavoriteDao) {
    val allFavorites: Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()

    fun getHymns(): List<Hymn> {
        return HymnsProvider.getHymns()
    }

    suspend fun addFavorite(hymnNumber: Int) {
        favoriteDao.insertFavorite(FavoriteEntity(hymnNumber, true))
    }

    suspend fun removeFavorite(hymnNumber: Int) {
        favoriteDao.deleteFavorite(hymnNumber)
    }
}
