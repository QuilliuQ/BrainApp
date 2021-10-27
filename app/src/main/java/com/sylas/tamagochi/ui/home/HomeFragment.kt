package com.sylas.tamagochi.ui.home

import android.app.AlertDialog
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sylas.tamagochi.R
import com.sylas.tamagochi.api.MeditationAPI
import com.sylas.tamagochi.api.RetrofitBuilder
import com.sylas.tamagochi.databinding.FragmentHomeBinding
import com.sylas.tamagochi.model.FeelingsItem
import com.sylas.tamagochi.model.FeelingsResponse
import com.sylas.tamagochi.model.QuotesItem
import com.sylas.tamagochi.model.QuotesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    var list: ArrayList<FeelingsItem> = arrayListOf()
    var listQuoutes:ArrayList<QuotesItem> = arrayListOf()
    lateinit var feelingsRecyclerView:RecyclerView
    lateinit var quotesRecyclerView: RecyclerView
    lateinit var api : MeditationAPI

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sharedPreferences = activity?.getSharedPreferences("main",MODE_PRIVATE)
        val nickNameValue = sharedPreferences?.getString("nickName","Default")
        val nickName: TextView = root.findViewById(R.id.nickNameText)
        nickName.text = "С возвращением, $nickNameValue!"
        feelingsRecyclerView = root.findViewById(R.id.feelingsRecyclerView)
        quotesRecyclerView = root.findViewById(R.id.statesRecyclerView)
        val retrofitBuilder = RetrofitBuilder().getRetrofit()
        api = retrofitBuilder.create(MeditationAPI::class.java)
        val avatar : ImageView = root.findViewById(R.id.avatar)
        val avatarURL = sharedPreferences?.getString("avatar","http://mskko2021.mad.hakta.pro/uploads/files/racoon.jpg")
        Glide.with(this).load(avatarURL).circleCrop().into(avatar)
        avatar.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_profile)
        }
        getFeel()
        getQuotes()






        return root
    }

    private fun getQuotes() {
        api.getQuotes().enqueue(object:Callback<QuotesResponse>{
            override fun onResponse(
                call: Call<QuotesResponse>,
                response: Response<QuotesResponse>
            ) {
                if(response.isSuccessful){
                    listQuoutes = response.body()!!.data
                    quotesRecyclerView.adapter = QuotesRecyclerAdapter(requireContext(),listQuoutes)
                }
                else{
                    AlertDialog.Builder(requireContext())
                        .setTitle("Ошибка")
                        .setMessage(response.errorBody().toString())
                        .setPositiveButton("ОК", null)
                        .create()
                        .show()
                }


            }

            override fun onFailure(call: Call<QuotesResponse>, t: Throwable) {
                AlertDialog.Builder(requireContext())
                    .setTitle("Ошибка")
                    .setMessage(t.localizedMessage)
                    .setPositiveButton("ОК", null)
                    .create()
                    .show()
            }

        })
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun getFeel(){
        api.getFeelings().enqueue(object : Callback<FeelingsResponse>{
            override fun onResponse(
                call: Call<FeelingsResponse>,
                response: Response<FeelingsResponse>
            ) {
                list = response.body()!!.data
                feelingsRecyclerView.adapter = FeelingsRecyclerAdapter(list,requireContext())
            }

            override fun onFailure(call: Call<FeelingsResponse>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}