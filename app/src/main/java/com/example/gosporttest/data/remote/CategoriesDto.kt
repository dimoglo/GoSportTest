package com.example.gosporttest.data.remote

data class CategoriesResponseDto(
    val categories: List<CategoryDto>
)

data class CategoryDto(
    val idCategory: String? = null,
    val strCategory: String? = null,
    val strCategoryThumb: String? = null,
    val strCategoryDescription: String? = null
)