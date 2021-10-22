package com.sylas.tamagochi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.sylas.tamagochi.api.MeditationAPI
import com.sylas.tamagochi.api.RetrofitBuilder
import com.sylas.tamagochi.model.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.authEmailEditText)
        password = findViewById(R.id.authPasswordEditText)
    }

    fun auth(view: android.view.View) {
        val emailValue = email.text.toString()
        val passwordValue = password.text.toString()

        if(emailValue.isNotEmpty() && passwordValue.isNotEmpty()){
            if (emailValue.contains("@")){
                val retrofit = RetrofitBuilder().getRetrofit()
                val api = retrofit.create(MeditationAPI::class.java)
                val hashMap = hashMapOf<String,String>()
                hashMap.put("email",emailValue)
                hashMap.put("password",passwordValue)
                api.getAuth(hashMap).enqueue(object : Callback<AuthResponse> {
                    override fun onResponse(
                        call: Call<AuthResponse>,
                        response: Response<AuthResponse>
                    ) {
                       if(response.isSuccessful){
                            val intent  = Intent(this@SignInActivity,MainScreenActivity::class.java)
                            intent.putExtra("nickName",response.body()?.nickName)
                            intent.putExtra("avatar",response.body()?.avatar)
                           startActivity(intent)
                       }
                       else{
                           Toast.makeText(this@SignInActivity, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
                       }




                    }

                    override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                        Toast.makeText(this@SignInActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                })










            }
            else{
                AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Некорректный email")
                    .setPositiveButton("ОК", null)
                    .create()
                    .show()
            }
        }
        else {
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Поля пустые")
                .setPositiveButton("ОК", null)
                .create()
                .show()
        }


    }


    fun register(view: android.view.View) {

    }
}