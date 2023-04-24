package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCreateAccountBinding

class CreateAccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        binding.btn.setOnClickListener {
            if (binding.btn.text == "Sign up"){
                binding.title.text = "Let's Sign You In"
                binding.btn.text = "Sign up"
                binding.sign.text = "Sign in"
                binding.q1.text = "Don't have an account?"
            }else{
                binding.title.text = "Create an Account"
                binding.btn.text = "Sign in"
                binding.q1.text = "Already have an account?"
                binding.sign.text = "Sign up"
            }
        }

        binding.sign.setOnClickListener {
            var correct_e = false
            var correct_p = false
            if (!binding.emailInput.text.isEmpty() && binding.emailInput.text.contains("@") && binding.emailInput.text.contains(".")){
                correct_e = true
                binding.warnEmail.visibility = View.GONE
            }else{
                binding.warnEmail.visibility = View.VISIBLE
            }
            if (!binding.passwordInput.text.isEmpty() && binding.passwordInput.text.length>=8){
                correct_p = true
                binding.warnPassword.visibility = View.GONE
            }else{
                binding.warnPassword.visibility = View.VISIBLE

            }
            if (correct_e && correct_p){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.screen, MainFragment())
                    .commit()
            }
        }
        return binding.root
    }
}