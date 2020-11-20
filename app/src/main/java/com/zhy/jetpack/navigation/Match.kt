package com.zhy.jetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class Match : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_match, container, false)
        view.findViewById<View>(R.id.play_btn3).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_match_to_in_game)
        }
        return view
    }
}