package com.example.gosporttest.domain

import kotlinx.coroutines.flow.Flow

interface MealsRepository {
    suspend fun getMeals(): Flow<Result<List<MealModel>>>

    suspend fun getCategories(): Flow<Result<List<CategoryModel>>>
}