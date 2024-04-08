package com.example.gosporttest.ui.menu

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gosporttest.R
import com.example.gosporttest.databinding.ChipItemBinding
import com.example.gosporttest.domain.CategoryModel

class ChipsAdapter(
    private val context: Context,
    private val onCategorySelected: (String) -> Unit
) : RecyclerView.Adapter<ChipsAdapter.CategoryViewHolder>() {

    companion object {
        private val EMPTY_PAYLOADS = listOf<Boolean>()
    }

    private var categoryList: List<CategoryModel> = listOf()
    private var lastSelectedCategoryIndex: Int = -1

    fun setCategoryList(newCategoryList: List<CategoryModel>) {
        categoryList = newCategoryList
        notifyDataSetChanged()
    }

    fun setSelectedCategory(selectedCategory: String) {
        val indexOfSelectedCategory = categoryList.indexOfFirst {
            it.strCategory == selectedCategory
        }
        notifyItemChanged(indexOfSelectedCategory, true)
        notifyItemChanged(lastSelectedCategoryIndex, false)
        lastSelectedCategoryIndex = indexOfSelectedCategory
    }

    fun clearSelectedCategory() {
        notifyItemChanged(lastSelectedCategoryIndex, false)
        lastSelectedCategoryIndex = -1
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChipsAdapter.CategoryViewHolder {
        val binding = ChipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        onBindViewHolder(holder, position, EMPTY_PAYLOADS)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int, payload: List<Any>) {
        val category = categoryList[position]
        holder.bind(category, payload.firstOrNull() as Boolean? ?: false)
    }

    override fun getItemCount() = categoryList.size

    inner class CategoryViewHolder(
        private val binding: ChipItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind (category: CategoryModel, isSelected: Boolean) {
            binding.root.text = category.strCategory
            binding.root.setOnClickListener {
                onCategorySelected(category.strCategory ?: "")
            }
            if(isSelected)
                binding.root.chipBackgroundColor = ColorStateList.valueOf(
                    ContextCompat.getColor(context, R.color.pink)
                )
            else
                binding.root.chipBackgroundColor = ColorStateList.valueOf(
                    ContextCompat.getColor(context, R.color.white)
                )
        }
    }

}