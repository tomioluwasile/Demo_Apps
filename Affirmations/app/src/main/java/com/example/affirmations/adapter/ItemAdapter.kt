package com.example.affirmations.adapter

import android.content.Context
import android.hardware.biometrics.BiometricManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/**
 * Adapter for the [RecyclerView] widget in MainActivity. Displays "Affirmation" data object.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // A nested class that holds references to the individual views within the list item layout
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // automatically generate override methods with ctrl + i on ItemAdapter

    /**
     * This function creates new view holders for the RecyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        /* adapterLayout takes three parameters; xml layout resource id, parent view group
         * and boolean argument "attachToRoot" which is set to false
         */

        return ItemViewHolder(adapterLayout)
    }

    /**
     * This function replaces the content of a view
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * This function returns the size of your dataset/items
     */
    override fun getItemCount() = dataset.size
}