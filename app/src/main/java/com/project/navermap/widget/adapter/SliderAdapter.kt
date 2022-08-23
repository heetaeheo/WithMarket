package com.project.navermap.widget.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.project.navermap.databinding.SlideItemContainerBinding
import com.project.navermap.domain.model.SliderItemModel
import kotlin.Byte.Companion.MAX_VALUE

class SliderAdapter(
    private val sliderItems: MutableList<SliderItemModel>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private val runnable = Runnable {
        sliderItems.addAll(sliderItems)
        //viewPager2.currentItem = 0
    }

    inner class SliderViewHolder(val binding: SlideItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Item: SliderItemModel) {
            binding.itemNameText.text = (position % 3 + 1).toString()
            binding.pagerimage.setImageResource(Item.image)
        }
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding =
            SlideItemContainerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(sliderItems[(position % 3)])
        Log.d("sliderItems", sliderItems.size.toString())
        Log.d("position", position.toString())
        //position이 3일때 다시 post 한다.
        if (position == sliderItems.size - 1) {
            //viewPager2.currentItem = 0
            viewPager2.post(runnable)
        }
    }
}