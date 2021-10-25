package com.sylas.tamagochi.ui.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sylas.tamagochi.R
import com.sylas.tamagochi.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {


    private var _binding: FragmentMusicBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val viewPager: ViewPager = root.findViewById(R.id.view_pager)
        val tabs : TabLayout = root.findViewById(R.id.tabs)
        viewPager.adapter = MusicSectionPagerAdapter(parentFragmentManager)
        tabs.setupWithViewPager(viewPager)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}