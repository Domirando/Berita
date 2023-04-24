package com.example.myapplication

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMainBinding.inflate(inflater, container, false)
        loadFragment(HomeFragment())
        binding.nav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> loadFragment(HomeFragment())
                R.id.profile -> loadFragment(ProfileFragment())
                R.id.search -> loadFragment(SearchFragment())
            }
            true
        }
        return binding.root
    }
    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
    }
}