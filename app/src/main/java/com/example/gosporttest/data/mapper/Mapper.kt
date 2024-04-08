package com.example.gosporttest.data.mapper

import com.example.gosporttest.data.local.CategoryEntity
import com.example.gosporttest.data.local.MealEntity
import com.example.gosporttest.data.remote.CategoryDto
import com.example.gosporttest.data.remote.MealDto
import com.example.gosporttest.domain.CategoryModel
import com.example.gosporttest.domain.MealModel

fun CategoryDto.toEntity(): CategoryEntity? {
    if (this.idCategory == null)
        return null
    return CategoryEntity().apply {
        idCategory = this@toEntity.idCategory
        strCategory = this@toEntity.strCategory
        strCategoryThumb = this@toEntity.strCategoryThumb
        strCategoryDescription = this@toEntity.strCategoryDescription
    }
}

fun MealDto.toEntity(): MealEntity? {
    if (this.idMeal == null)
        return null
    return MealEntity().apply {
        idMeal = this@toEntity.idMeal
        strMeal = this@toEntity.strMeal
        strDrinkAlternate = this@toEntity.strDrinkAlternate
        strCategory = this@toEntity.strCategory
        strArea = this@toEntity.strArea
        strInstructions = this@toEntity.strInstructions
        strMealThumb = this@toEntity.strMealThumb
        strTags = this@toEntity.strTags
        strYoutube = this@toEntity.strYoutube
        strIngredient1 = this@toEntity.strIngredient1
        strIngredient2 = this@toEntity.strIngredient2
        strIngredient3 = this@toEntity.strIngredient3
        strIngredient4 = this@toEntity.strIngredient4
        strIngredient5 = this@toEntity.strIngredient5
        strIngredient6 = this@toEntity.strIngredient6
        strIngredient7 = this@toEntity.strIngredient7
        strIngredient8 = this@toEntity.strIngredient8
        strIngredient9 = this@toEntity.strIngredient9
        strIngredient10 = this@toEntity.strIngredient10
        strIngredient11 = this@toEntity.strIngredient11
        strIngredient12 = this@toEntity.strIngredient12
        strIngredient13 = this@toEntity.strIngredient13
        strIngredient14 = this@toEntity.strIngredient14
        strIngredient15 = this@toEntity.strIngredient15
        strIngredient16 = this@toEntity.strIngredient16
        strIngredient17 = this@toEntity.strIngredient17
        strIngredient18 = this@toEntity.strIngredient18
        strIngredient19 = this@toEntity.strIngredient19
        strIngredient20 = this@toEntity.strIngredient20
        strMeasure1 = this@toEntity.strMeasure1
        strMeasure2 = this@toEntity.strMeasure2
        strMeasure3 = this@toEntity.strMeasure3
        strMeasure4 = this@toEntity.strMeasure4
        strMeasure5 = this@toEntity.strMeasure5
        strMeasure6 = this@toEntity.strMeasure6
        strMeasure7 = this@toEntity.strMeasure7
        strMeasure8 = this@toEntity.strMeasure8
        strMeasure9 = this@toEntity.strMeasure9
        strMeasure10 = this@toEntity.strMeasure10
        strMeasure11 = this@toEntity.strMeasure11
        strMeasure12 = this@toEntity.strMeasure12
        strMeasure13 = this@toEntity.strMeasure13
        strMeasure14 = this@toEntity.strMeasure14
        strMeasure15 = this@toEntity.strMeasure15
        strMeasure16 = this@toEntity.strMeasure16
        strMeasure17 = this@toEntity.strMeasure17
        strMeasure18 = this@toEntity.strMeasure18
        strMeasure19 = this@toEntity.strMeasure19
        strMeasure20 = this@toEntity.strMeasure20
        strSource= this@toEntity.strSource
        strImageSource= this@toEntity.strImageSource
        strCreativeCommonsConfirmed= this@toEntity.strCreativeCommonsConfirmed
        dateModified= this@toEntity.dateModified
    }
}

fun CategoryEntity.toModel(): CategoryModel {
    return CategoryModel(
        idCategory = this.idCategory,
        strCategory = this.strCategory,
        strCategoryThumb = this.strCategoryThumb,
        strCategoryDescription = this.strCategoryDescription

    )
}

fun MealEntity.toModel(): MealModel {
    return MealModel(
        idMeal = this.idMeal,
        strMeal = this.strMeal,
        strDrinkAlternate = this.strDrinkAlternate,
        strCategory = this.strCategory,
        strArea = this.strArea,
        strInstructions = this.strInstructions,
        strMealThumb = this.strMealThumb,
        strTags = this.strTags,
        strYoutube = this.strYoutube,
        strIngredient1 = this.strIngredient1,
        strIngredient2 = this.strIngredient2,
        strIngredient3 = this.strIngredient3,
        strIngredient4 = this.strIngredient4,
        strIngredient5 = this.strIngredient5,
        strIngredient6 = this.strIngredient6,
        strIngredient7 = this.strIngredient7,
        strIngredient8 = this.strIngredient8,
        strIngredient9 = this.strIngredient9,
        strIngredient10 = this.strIngredient10,
        strIngredient11 = this.strIngredient11,
        strIngredient12 = this.strIngredient12,
        strIngredient13 = this.strIngredient13,
        strIngredient14 = this.strIngredient14,
        strIngredient15 = this.strIngredient15,
        strIngredient16 = this.strIngredient16,
        strIngredient17 = this.strIngredient17,
        strIngredient18 = this.strIngredient18,
        strIngredient19 = this.strIngredient19,
        strIngredient20 = this.strIngredient20,
        strMeasure1 = this.strMeasure1,
        strMeasure2 = this.strMeasure2,
        strMeasure3 = this.strMeasure3,
        strMeasure4 = this.strMeasure4,
        strMeasure5 = this.strMeasure5,
        strMeasure6 = this.strMeasure6,
        strMeasure7 = this.strMeasure7,
        strMeasure8 = this.strMeasure8,
        strMeasure9 = this.strMeasure9,
        strMeasure10 = this.strMeasure10,
        strMeasure11 = this.strMeasure11,
        strMeasure12 = this.strMeasure12,
        strMeasure13 = this.strMeasure13,
        strMeasure14 = this.strMeasure14,
        strMeasure15 = this.strMeasure15,
        strMeasure16 = this.strMeasure16,
        strMeasure17 = this.strMeasure17,
        strMeasure18 = this.strMeasure18,
        strMeasure19 = this.strMeasure19,
        strMeasure20 = this.strMeasure20,
        strSource= this.strSource,
        strImageSource= this.strImageSource,
        strCreativeCommonsConfirmed= this.strCreativeCommonsConfirmed,
        dateModified= this.dateModified,
    )
}