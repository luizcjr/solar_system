package com.example.solarsystemclean.util.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.remote.dto.NoResultDTO
import com.example.solarsystemclean.R
import com.example.solarsystemclean.databinding.ItemsNoResultBinding

class NoResultAdapter(
    private val context: Context,
    private val message: String,
    private val color: Int,
    private val icon: Int,
) : RecyclerView.Adapter<NoResultAdapter.NoResultsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoResultsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemsNoResultBinding>(
            inflater,
            R.layout.items_no_result,
            parent,
            false
        )
        return NoResultsViewHolder(view)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: NoResultsViewHolder, position: Int) {
        val noResult = NoResultDTO(icon, message)

        holder.view.txtMessage.setTextColor(context.resources.getColor(color))

        holder.view.data = noResult
    }

    class NoResultsViewHolder(var view: ItemsNoResultBinding) : RecyclerView.ViewHolder(view.root)
}