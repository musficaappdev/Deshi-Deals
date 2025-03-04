package com.musficaappdev.deshideals

import android.widget.EditText

fun EditText.isEmpty(): Boolean{

    return if (this.text.toString().isEmpty()){
        this.error = "This place needs to be filled"
        true
    }else{
        false
    }
}