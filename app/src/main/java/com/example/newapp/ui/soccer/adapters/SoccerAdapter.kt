package com.example.newapp.ui.soccer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newapp.core.BaseViewHolder
import com.example.newapp.data.model.Soccer
import com.example.newapp.databinding.SoccerItemBinding

class SoccerAdapter(private val soccerList: Triple<Result<List<Soccer>>, Result<List<Soccer>>, Result<List<Soccer>>>, private val itemClickListener: OnSoccerListener) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnSoccerListener {
        fun OnMovieClick(soccer : Soccer)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            SoccerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var holder = SoccerViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.getBindingAdapterPosition().takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.OnMovieClick(soccerList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is SoccerViewHolder -> holder.bind(soccerList[position])
        }
    }

    override fun getItemCount(): Int = soccerList.size


    private inner class SoccerViewHolder(val binding: SoccerItemBinding, val context: Context) :
        BaseViewHolder<Soccer>(binding.root) {
        override fun bind(item: Soccer) {
            Glide.with(context).load(item.profile_picture).centerCrop().into(binding.imgCourt)
        }
    }
}
