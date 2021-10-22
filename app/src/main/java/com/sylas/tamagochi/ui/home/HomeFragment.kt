package com.sylas.tamagochi.ui.home

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sylas.tamagochi.R
import com.sylas.tamagochi.api.MeditationAPI
import com.sylas.tamagochi.api.RetrofitBuilder
import com.sylas.tamagochi.databinding.FragmentHomeBinding
import com.sylas.tamagochi.model.FeelingsItem
import com.sylas.tamagochi.model.FeelingsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    var list: ArrayList<FeelingsItem> = arrayListOf()

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
        val recyclerView : RecyclerView = root.findViewById(R.id.feelingsRecyclerView)
        val retrofitBuilder = RetrofitBuilder().getRetrofit()
        val api = retrofitBuilder.create(MeditationAPI::class.java)
        api.getFeelings().enqueue(object : Callback<FeelingsResponse>{
            override fun onResponse(
                call: Call<FeelingsResponse>,
                response: Response<FeelingsResponse>
            ) {
                list = response.body()!!.data
                recyclerView.adapter = FeelingsRecyclerAdapter(list,requireContext())
            }

            override fun onFailure(call: Call<FeelingsResponse>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })






        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}