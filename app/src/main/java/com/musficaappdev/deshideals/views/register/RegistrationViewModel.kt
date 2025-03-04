package com.musficaappdev.deshideals.views.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.musficaappdev.deshideals.core.DataState
import com.musficaappdev.deshideals.data.models.UserRegister
import com.musficaappdev.deshideals.data.repsitories.AuthRepository

class RegistrationViewModel : ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()

    val registrationResponse : LiveData<DataState<UserRegister>> = _registrationResponse

    fun userRegistration(user: UserRegister){

        _registrationResponse.postValue(DataState.Loading())

        val authService = AuthRepository()

        authService.userRegistration(user)
            .addOnSuccessListener {

                _registrationResponse.postValue(DataState.Success(user))

        }.addOnFailureListener { error ->

                _registrationResponse.postValue(DataState.Error("${error.message}"))

        }
    }
}