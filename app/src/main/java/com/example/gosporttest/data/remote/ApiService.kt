package com.example.gosporttest.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponseDto
//  https://themealdb.com/api/json/v1/1/categories.php

    @GET("search.php?s")
    suspend fun getMeals(): MealsResponseDto
//  https://themealdb.com/api/json/v1/1/search.php?s
}