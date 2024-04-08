package com.example.gosporttest.ui.menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gosporttest.domain.CategoryModel
import com.example.gosporttest.domain.MealModel
import com.example.gosporttest.domain.MealsRepository
import com.example.gosporttest.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: MealsRepository
): ViewModel() {

    private val _categoriesState = MutableStateFlow<List<CategoryModel>>(listOf())
    val categoriesState: StateFlow<List<CategoryModel>> = _categoriesState

    private val _mealsState = MutableStateFlow<List<MealModel>>(listOf())
    private val _filteredMealsState = MutableStateFlow<List<MealModel>>(listOf())
    val mealsState: StateFlow<List<MealModel>> = _filteredMealsState

    private val _currentCategory = MutableStateFlow<String?>(null)
    val currentCategory: StateFlow<String?> = _currentCategory

    init {
        getCategories()
        getMeals()
    }

    fun setCurrentCategory(category: String) {
        viewModelScope.launch {
            if(_currentCategory.value != category){
                _currentCategory.value = category
                _filteredMealsState.emit(_mealsState.value.filter { it.strCategory == category })
            } else {
                _currentCategory.value = null
                _filteredMealsState.emit(_mealsState.value)
            }
        }
    }

    private fun getCategories(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.getCategories().collect{
                    when {
                        it.isSuccess -> {
                            _categoriesState.emit(it.getOrThrow())
                            _currentCategory.emit(_categoriesState.value.firstOrNull()?.strCategory)
                        }
                        it.isFailure ->
                            throw Exception (it.exceptionOrNull())
                    }
                }
            } catch (e: Exception) {
                throw Exception ("no data found")
            }
        }
    }

    private fun getMeals(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.getMeals().collect{
                    when {
                        it.isSuccess -> {
                            _mealsState.emit(it.getOrThrow())
                            _filteredMealsState.emit(_mealsState.value)
                        }
                        it.isFailure ->
                            throw Exception (it.exceptionOrNull())
                    }
                }
            } catch (e: Exception) {
                throw Exception ("no data found")
            }
        }
    }
}