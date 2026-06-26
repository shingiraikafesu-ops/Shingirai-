package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.Hymn
import com.example.data.HymnsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HymnsViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppDatabase.getDatabase(application)
    private val repository = HymnsRepository(database.favoriteDao())

    // Search query state
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    // Language/Category state: "ALL", "SHONA", "CHEWA", "NDEBELE"
    private val _selectedCategory = MutableStateFlow("ALL")
    val selectedCategory = _selectedCategory.asStateFlow()

    // Show only favorites flag
    private val _onlyShowFavorites = MutableStateFlow(false)
    val onlyShowFavorites = _onlyShowFavorites.asStateFlow()

    // Currently selected hymn (if not null, details are displayed)
    private val _selectedHymn = MutableStateFlow<Hymn?>(null)
    val selectedHymn = _selectedHymn.asStateFlow()

    // Text scaling / font size for hymn lyrics
    private val _fontSize = MutableStateFlow(18f)
    val fontSize = _fontSize.asStateFlow()

    // Keep screen on while reading hymn
    private val _keepScreenOn = MutableStateFlow(false)
    val keepScreenOn = _keepScreenOn.asStateFlow()

    // Favorites from database
    val favoriteHymnNumbers: StateFlow<Set<Int>> = repository.allFavorites
        .combine(MutableStateFlow(emptySet<Int>())) { favList, _ ->
            favList.map { it.hymnNumber }.toSet()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptySet()
        )

    // Filtered list of hymns based on search, category and favorites filter
    val filteredHymns: StateFlow<List<Hymn>> = combine(
        _searchQuery,
        _selectedCategory,
        _onlyShowFavorites,
        favoriteHymnNumbers
    ) { query, category, onlyFav, favNumbers ->
        val allHymns = repository.getHymns()
        allHymns.filter { hymn ->
            val matchesCategory = category == "ALL" || hymn.category.equals(category, ignoreCase = true)
            val matchesSearch = query.isEmpty() || 
                hymn.number.toString() == query ||
                hymn.title.contains(query, ignoreCase = true) ||
                hymn.englishTitle?.contains(query, ignoreCase = true) == true ||
                hymn.lyrics.any { it.contains(query, ignoreCase = true) }
            val matchesFavorites = !onlyFav || favNumbers.contains(hymn.number)

            matchesCategory && matchesSearch && matchesFavorites
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setSelectedCategory(category: String) {
        _selectedCategory.value = category
    }

    fun setOnlyShowFavorites(show: Boolean) {
        _onlyShowFavorites.value = show
    }

    fun selectHymn(hymn: Hymn?) {
        _selectedHymn.value = hymn
    }

    fun setFontSize(size: Float) {
        _fontSize.value = size.coerceIn(12f, 36f)
    }

    fun toggleKeepScreenOn() {
        _keepScreenOn.value = !_keepScreenOn.value
    }

    fun toggleFavorite(hymnNumber: Int) {
        viewModelScope.launch {
            val currentFavs = favoriteHymnNumbers.value
            if (currentFavs.contains(hymnNumber)) {
                repository.removeFavorite(hymnNumber)
            } else {
                repository.addFavorite(hymnNumber)
            }
        }
    }
}
