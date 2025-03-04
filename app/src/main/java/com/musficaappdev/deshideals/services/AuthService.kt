package com.musficaappdev.deshideals.services

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.musficaappdev.deshideals.data.models.UserRegister

interface AuthService {

    fun userRegistration(user: UserRegister) : Task<AuthResult>
}