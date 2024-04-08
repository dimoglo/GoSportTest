package com.example.gosporttest.data

import com.example.gosporttest.data.local.CategoryEntity
import com.example.gosporttest.data.local.MealEntity
import com.example.gosporttest.data.mapper.toEntity
import com.example.gosporttest.data.mapper.toModel
import com.example.gosporttest.data.remote.ApiService
import com.example.gosporttest.domain.CategoryModel
import com.example.gosporttest.domain.MealModel
import com.example.gosporttest.domain.MealsRepository
import io.realm.kotlin.Realm
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val realm: Realm,
    private val apiService: ApiService
): MealsRepository {
    override suspend fun getMeals() = flow {
        try {
            val oldMeals = realm.query(MealEntity::class).find().map {
                it.toModel()
            }
            emit(Result.success(oldMeals))
            val response = apiService.getMeals()
            val newMeals = mutableListOf<MealModel>()
            realm.writeBlocking {
                delete(MealEntity::class)
                response.meals.forEach {
                    val newEntity = it.toEntity() ?:
                    throw Exception("meals parsing failed")
                    copyToRealm(newEntity)
                    newMeals.add(newEntity.toModel())
                }
            }
            emit(Result.success(newMeals))
        } catch (e: HttpException) {
            when (e.code()) {
                in 300..399 ->
                    emit(Result.failure(Exception("Перенаправление: ${e.message()}")))
                in 400..499 ->
                    emit(Result.failure(Exception("Ошибка клиента: ${e.message()}")))
                in 500..599 ->
                    emit(Result.failure(Exception("Ошибка сервера: ${e.message()}")))
                else ->
                    emit(Result.failure(Exception("Неизвестная ошибка HTTP: ${e.message()}")))
            }
        } catch (e: IOException) {
            emit(Result.failure(e))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getCategories() = flow {
        try {
            val oldCategories = realm.query(CategoryEntity::class).find().map {
                it.toModel()
            }
            emit(Result.success(oldCategories))
            val response = apiService.getCategories()
            val newCategories = mutableListOf<CategoryModel>()
            realm.writeBlocking {
                delete(CategoryEntity::class)
                response.categories.forEach {
                    val newEntity = it.toEntity() ?:
                    throw Exception("category parsing failed")
                    copyToRealm(newEntity)
                    newCategories.add(newEntity.toModel())
                }
            }
            emit(Result.success(newCategories))
        } catch (e: HttpException) {
            when (e.code()) {
                in 300..399 ->
                    emit(Result.failure(Exception("Перенаправление: ${e.message()}")))
                in 400..499 ->
                    emit(Result.failure(Exception("Ошибка клиента: ${e.message()}")))
                in 500..599 ->
                    emit(Result.failure(Exception("Ошибка сервера: ${e.message()}")))
                else ->
                    emit(Result.failure(Exception("Неизвестная ошибка HTTP: ${e.message()}")))
            }
        } catch (e: IOException) {
            emit(Result.failure(e))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

}