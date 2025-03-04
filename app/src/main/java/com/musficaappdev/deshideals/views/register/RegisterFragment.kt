package com.musficaappdev.deshideals.views.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.musficaappdev.deshideals.R
import com.musficaappdev.deshideals.core.DataState
import com.musficaappdev.deshideals.data.models.UserRegister
import com.musficaappdev.deshideals.databinding.FragmentRegisterBinding
import com.musficaappdev.deshideals.databinding.FragmentStartBinding
import com.musficaappdev.deshideals.isEmpty


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    private val viewModel : RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)

        setListener()
        registrationObserver()
        return binding.root
    }



    private fun setListener() {

        with(binding){

            btnLogin.setOnClickListener {
                etName.isEmpty()
                etEmail.isEmpty()
                etPassword.isEmpty()
                
                if (!etName.isEmpty() && !etEmail.isEmpty() && !etPassword.isEmpty()){

                    Toast.makeText(context, "All Input Done!", Toast.LENGTH_SHORT).show()
                    val user = UserRegister(
                        etName.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        "seller",
                        ""
                    )
                    viewModel.userRegistration(user)
                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

        }

    }
    private fun registrationObserver() {

        viewModel.registrationResponse.observe(viewLifecycleOwner){
            when(it){
                is DataState.Error -> {

                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {

                    Toast.makeText(context, "Loading.", Toast.LENGTH_SHORT).show()
                }
                is DataState.Success -> {

                    Toast.makeText(context, "Created : ${it.data}", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


}