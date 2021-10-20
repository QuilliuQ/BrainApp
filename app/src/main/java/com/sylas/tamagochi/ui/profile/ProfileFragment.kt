package com.sylas.tamagochi.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sylas.tamagochi.R
import com.sylas.tamagochi.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {


    private var _binding: FragmentProfileBinding? = null
    val list : ArrayList<ImageProfileItem> = arrayListOf(
        ImageProfileItem(R.drawable.imageone,"11:00"),
        ImageProfileItem(R.drawable.imagetwo,"15:00"),
    )


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView:RecyclerView = root.findViewById(R.id.imageProfileList)
        recyclerView.adapter = ImagesProfileAdapter(list,requireContext())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}