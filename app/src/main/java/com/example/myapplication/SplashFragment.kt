package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var counter = 0
        var binding = FragmentSplashBinding.inflate(inflater, container, false)

        binding.next.setOnClickListener {
            if (counter==1){
                binding.imageView2.setImageResource(R.drawable.ronaldo)
                binding.text1.text = "Sport, politics,"
                binding.text2.text = "healthy,"
                binding.text3.text = "& anything"
                counter++
            }else if(counter==0){
                binding.imageView2.setImageResource(R.drawable.nurse)
                binding.text1.text = "Get actual new from"
                binding.text2.text = ""
                binding.text3.text = "around the world"
                counter++
            }else{
                parentFragmentManager.beginTransaction()
                    .replace(R.id.screen, CreateAccountFragment())
                    .commit()
            }
        }
        binding.skip.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.screen, CreateAccountFragment())
                .commit()
        }
        return binding.root
    }
}