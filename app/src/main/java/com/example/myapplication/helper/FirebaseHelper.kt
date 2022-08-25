package com.example.myapplication.helper

import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FirebaseHelper {

    companion object{

        //função para recuperar instância do banco de dados retornando a receferência
        fun getDatabase() = FirebaseDatabase.getInstance().reference

        //Função para recuperara instâcia de autenticação do usuário
        private fun getAuth( ) = FirebaseAuth.getInstance()

        //Função para recuperar a instâcia do ID do usuário
        fun getIdUser() = getAuth().uid

        //Função para ferificar se o usuário está autenticado no app
        fun isAutenticated() = getAuth().currentUser != null

        //Função para validar o erro nos fragments Login, Recover e register
        fun validError(error: String) : Int {
            return when{
                error.contains("There is no user record corresponding to this identifier")
                ->{
                    R.string.acount_not_registered_register_fragment
                }
                error.contains("The email address is badly formatted") ->{
                    R.string.invalid_email_register_fragment
                }
                error.contains("The password is invalid or the user does not have a password")
                -> {
                    R.string.invalid_password_register_fragment
                }
                error.contains("The email address is already in use by another account") -> {
                    R.string.email_in_use_register_fragment
                }
                error.contains("Password should be at least 6 characters") -> {
                    R.string.strong_password_register_fragment
                }
                else -> {
                    R.string.error_reneric
                }
            }
        }
    }
}