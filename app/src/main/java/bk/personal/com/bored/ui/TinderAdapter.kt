package bk.personal.com.bored.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import bk.personal.com.bored.R
import bk.personal.com.bored.model.BoredItem

class TinderAdapter : RecyclerView.Adapter<TinderAdapter.CustomCardViewHolder>() {

    private var listOfItems: List<BoredItem> = emptyList()

    inner class CustomCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)

        var data: BoredItem? = null
            set(value) {
                field = value
                setData()
            }

        private fun setData() {
            data?.let {
                title.text = it.activity
            }
        }
    }

    fun setAllData(list: List<BoredItem>) {
        listOfItems = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomCardViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.element_bored_item, parent, false)
        return CustomCardViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomCardViewHolder, position: Int) {
        holder.data = listOfItems[position]
    }

    override fun getItemCount() = listOfItems.size
}