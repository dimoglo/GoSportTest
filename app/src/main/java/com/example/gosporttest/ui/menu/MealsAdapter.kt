package com.example.gosporttest.ui.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gosporttest.databinding.MealItemBinding
import com.example.gosporttest.domain.MealModel

class MealsAdapter(
    private val context: Context,
): RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    private var mealList: List<MealModel> = listOf()

    fun setMealList(newMealList: List<MealModel>) {
        mealList = newMealList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealsAdapter.MealsViewHolder {
        val binding = MealItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealsAdapter.MealsViewHolder, position: Int) {
        val meal = mealList[position]
        holder.bind(meal)
    }

    override fun getItemCount() = mealList.size

    inner class MealsViewHolder(
        private val binding: MealItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind (meal: MealModel) {
            Glide.with(itemView.context).load(meal.strMealThumb).into(binding.mealIcon)
            binding.title.text = meal.strMeal

            val ingredients = listOfNotNull(
                meal.strIngredient1, meal.strIngredient2, meal.strIngredient3, meal.strIngredient4,
                meal.strIngredient5, meal.strIngredient6, meal.strIngredient7, meal.strIngredient8,
                meal.strIngredient9, meal.strIngredient10, meal.strIngredient11,
                meal.strIngredient12, meal.strIngredient13, meal.strIngredient14,
                meal.strIngredient15, meal.strIngredient16, meal.strIngredient17,
                meal.strIngredient18, meal.strIngredient19, meal.strIngredient20
            ).filter { it.isNotBlank() }.joinToString(separator = ", ")

            binding.description.text = ingredients
            binding.price.text = "от 345 р"
        }
    }
}