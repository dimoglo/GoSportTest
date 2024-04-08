package com.example.gosporttest.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gosporttest.databinding.FragmentMenuBinding
import com.example.gosporttest.utils.ScreenState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment: Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MenuViewModel by viewModels()

    private val imageUrls = listOf(
        "https://img.freepik.com/free-psd/food-menu-and-delicious-pizza-web-banner-template_120329-1774.jpg?size=626&ext=jpg&ga=GA1.1.523418798.1711929600&semt=ais",
        "https://png.pngtree.com/png-clipart/20210905/original/pngtree-pizza-promotion-promotion-banner-png-image_6688030.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkJnFNUmDkFRzzRktJyf5b_FxNWJCD2MGhXy56ZKPubg&s",
        "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/pizza-delivery-take-away-header-banner-pizza-design-template-5d022200977cea21b021452175f60b1a_screen.jpg?ts=1604786816",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC78btHe9S2k5Y80WyiI_11VzqTR_CtKaEZ8zmOuQteQ&s"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bannersAdapter = BannersAdapter(requireContext())
        binding.bannersRecyclerView.adapter = bannersAdapter
        binding.bannersRecyclerView.layoutManager = LinearLayoutManager(requireContext()).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        bannersAdapter.setBanners(imageUrls)

        val chipsAdapter = ChipsAdapter(requireContext()) { selectedCategory ->
            viewModel.setCurrentCategory(selectedCategory)
        }
        binding.chipsRecyclerView.apply {
            adapter = chipsAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        val mealsAdapter = MealsAdapter(requireContext())
        binding.mealsRecyclerView.apply {
            adapter = mealsAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }

        lifecycleScope.launch {
            viewModel.categoriesState.collect {
                chipsAdapter.setCategoryList(it)
            }
        }

        lifecycleScope.launch {
            viewModel.mealsState.collect {
                mealsAdapter.setMealList(it)
            }
        }

        lifecycleScope.launch {
            viewModel.currentCategory.collect{
                if (it != null)
                    chipsAdapter.setSelectedCategory(it)
                else
                    chipsAdapter.clearSelectedCategory()
            }
        }
    }
}