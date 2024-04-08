package com.example.gosporttest.ui.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gosporttest.R

class BannersAdapter(
    private val context: Context,
) : RecyclerView.Adapter<BannersAdapter.BannerViewHolder>() {
    private var banners: List<String> = listOf()

    fun setBanners(newBanners: List<String>){
        banners = newBanners
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.banner_item, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val context = holder.imageView.context
        Glide.with(context).load(banners[position]).into(holder.imageView)
    }

    inner class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_banner)
    }
}