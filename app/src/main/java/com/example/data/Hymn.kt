package com.example.data

data class Hymn(
    val number: Int,
    val title: String,
    val key: String,
    val lyrics: List<String>,
    val category: String, // "SHONA", "CHEWA", "NDEBELE"
    val englishTitle: String? = null
)
