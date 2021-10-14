package com.sylas.tamagochi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.isDigitsOnly
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var password: EditText
    lateinit var rePassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.emailEditText)
        phone = findViewById(R.id.phoneEditText)
        password = findViewById(R.id.passwordEditText)
        rePassword = findViewById(R.id.repasswordEditText)
    }


    fun signup(view: android.view.View) {
        val emailText = email.text.toString()
        val phoneText = phone.text.toString()
        val passwordText = password.text.toString()
        val rePasswordText = rePassword.text.toString()
        if(emailText.isNotBlank()&&
           phoneText.isNotBlank()&&
           passwordText.isNotBlank()&&
           rePasswordText.isNotBlank()
                ){
            if(passwordText == rePasswordText){
                    AlertDialog.Builder(this)
                        .setTitle("Поздравляем")
                        .setMessage("Вы успешно зарегистрировались")
                        .setPositiveButton("OK",{_,_ ->
                            val intent = Intent(this,SignInActivity::class.java)
                            startActivity(intent)
                        } )
                        .create()
                        .show()

            }
            else{
                Snackbar.make(view,"Пароли неравны",Snackbar.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show()
        }
    }
}