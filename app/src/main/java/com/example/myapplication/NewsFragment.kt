package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {
    lateinit var bottomSheetFragment: BottomSheetFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentNewsBinding.inflate(inflater)
        var arg = this.arguments
        val info = arg?.getString("info")
        val img = arg?.getInt("img")
        val watches = arg?.getString("watches")
        val likes = arg?.getString("likes")
        val news_comp = arg?.getString("news_comp")
        val news_comp_icon = arg?.getInt("icon")
        val days = arg?.getString("days")
        val news_type = arg?.getString("news_type")
        binding.newsInfo.text = info.toString()
        binding.watches.text = watches.toString()
        binding.likes.text = likes.toString()
        binding.newsCompName.text = news_comp.toString()
        binding.newsDay.text = days.toString()
        binding.newsDay.text = news_comp.toString()
        binding.type.text = news_type.toString()
        binding.wallpaper.setImageResource(img as Int)
        binding.newsCompIcon.setImageResource(news_comp_icon as Int)
        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, HomeFragment())
                .commit()
        }
        binding.share.setOnClickListener {
            bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(parentFragmentManager, "BSDialogFragment")
        }

        return binding.root
    }

}