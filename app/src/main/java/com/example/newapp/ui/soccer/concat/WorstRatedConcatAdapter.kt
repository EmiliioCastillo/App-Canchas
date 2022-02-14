package com.example.newapp.ui.soccer.concat
/*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.core.BaseConcatHolder
import com.example.newapp.databinding.WorstSoccerRowBinding
import com.example.newapp.ui.soccer.adapters.SoccerAdapter

class WorstRatedConcatAdapter (private val soccerAdapter: SoccerAdapter) :  RecyclerView.Adapter<BaseConcatHolder<*>>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding =
            WorstSoccerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatViewHolder -> holder.bind(soccerAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: WorstSoccerRowBinding) : BaseConcatHolder<SoccerAdapter>(binding.root) {
        override fun bind(adapter: SoccerAdapter) {
            binding.rvWorstCourt.adapter = adapter
        }
    }
}

 */