package com.musficaappdev.deshideals.views.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.musficaappdev.deshideals.R
import com.musficaappdev.deshideals.databinding.FragmentLoginBinding
import com.musficaappdev.deshideals.isEmpty


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        setListener()

        return binding.root
    }

    private fun setListener() {

        with(binding){

            btnLogin.setOnClickListener {
                etEmail.isEmpty()
                etPassword.isEmpty()

                if (!etEmail.isEmpty() && !etPassword.isEmpty()){

                    Toast.makeText(context, "All Input Done!", Toast.LENGTH_SHORT).show()
                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }


    }


}