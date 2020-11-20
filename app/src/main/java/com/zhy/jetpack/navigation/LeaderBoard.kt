package com.zhy.jetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class LeaderBoard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        val viewAdapter = MyAdapter(arrayOf("Flo", "Ly", "Jo"))

        view.findViewById<RecyclerView>(R.id.leaderboard_list).run {
            setHasFixedSize(true)
            adapter = viewAdapter
        }
        return view
    }
}


class MyAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.findViewById<TextView>(R.id.user_name_text).text = myDataset[position]

        holder.item.findViewById<ImageView>(R.id.user_avatar_image)
            .setImageResource(listOfAvatars[position])

        holder.item.setOnClickListener {
            val bundle = bundleOf("userName" to myDataset[position])

            Navigation.findNavController(holder.item).navigate(
                R.id.action_leaderboard_to_userProfile,
                bundle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_view_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }
}

private val listOfAvatars = listOf(
    R.drawable.avatar_1_raster, R.drawable.avatar_2_raster, R.drawable.avatar_3_raster
)