package com.musficaappdev.deshideals.data.repsitories

import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.musficaappdev.deshideals.data.models.UserRegister
import com.musficaappdev.deshideals.services.AuthService

class AuthRepository :AuthService {
    override fun userRegistration(user: UserRegister) : Task<AuthResult> {

        val mAuth = FirebaseAuth.getInstance()
        return mAuth.createUserWithEmailAndPassword(user.email, user.password)
    }
}