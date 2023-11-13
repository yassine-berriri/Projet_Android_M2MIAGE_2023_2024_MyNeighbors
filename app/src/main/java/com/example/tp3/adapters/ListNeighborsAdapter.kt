package com.example.tp3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tp3.R
import com.example.tp3.models.Neighbor

class ListNeighborsAdapter(  items: List<Neighbor>, listNeighborHandler:ListNeighborHandler
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {
    private val mNeighbours: List<Neighbor> = items
    private val mListNeighborHandler: ListNeighborHandler = listNeighborHandler



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListNeighborsAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.neighbor_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListNeighborsAdapter.ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        val context = holder.mNeighbourAvatar.context
// Display Neighbour Avatar
        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.baseline_person_outline_24)
            .error(R.drawable.baseline_person_outline_24)
            .skipMemoryCache(false)
            .into(holder.mNeighbourAvatar)
        // Display Neighbour Name
        holder.mNeighbourName.text = neighbour.name

        holder.mDeleteButton.setOnClickListener {
            mListNeighborHandler.onDeleteNeighbor(neighbour)
        }

    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val mNeighbourAvatar: ImageView
        val mNeighbourName: TextView
        val mDeleteButton: ImageButton

        init {
            // Enable click on item
            mNeighbourAvatar = view.findViewById(R.id.item_list_avatar)
            mNeighbourName = view.findViewById(R.id.item_list_name)
            mDeleteButton = view.findViewById(R.id.item_list_delete_button)


        }
    }

}