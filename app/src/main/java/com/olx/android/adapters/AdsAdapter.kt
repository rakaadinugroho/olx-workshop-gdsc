package com.olx.android.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olx.android.databinding.ItemAdsBinding
import com.olx.android.models.Ads

class AdsAdapter(private val items: List<Ads>, private val listener: AdsListener): RecyclerView.Adapter<AdsAdapter.AdsViewHolder>() {

    inner class AdsViewHolder(val binding: ItemAdsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        val binding = ItemAdsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.tvTitleAds.text = this.title
                binding.tvLocationAds.text = this.location
                binding.tvPriceAds.text = this.price

                binding.containerAds.setOnClickListener {
                    listener.onClickAds(this)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}