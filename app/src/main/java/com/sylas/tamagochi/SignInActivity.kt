package com.sylas.tamagochi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import com.sylas.tamagochi.api.MeditationAPI
import com.sylas.tamagochi.api.RetrofitBuilder
import com.sylas.tamagochi.model.AuthResponse
import com.sylas.tamagochi.model.ErrorResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.authEmailEditText)
        password = findViewById(R.id.authPasswordEditText)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
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
                            val editor = sharedPreferences.edit()
                           editor.putString("avatar",response.body()?.avatar)
                           editor.putString("nickName",response.body()?.nickName)
                           editor.putString("token",response.body()?.token)
                           editor.apply()
                            val intent  = Intent(this@SignInActivity,MainScreenActivity::class.java)
                           startActivity(intent)
                       }
                       else{
                           val gson = Gson().fromJson(response.errorBody()?.string(),ErrorResponse::class.java)
                           
                           Toast.makeText(this@SignInActivity,gson.error, Toast.LENGTH_SHORT).show()
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


