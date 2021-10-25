package com.sylas.tamagochi.ui.music

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.sylas.tamagochi.ui.music.fragments.BestFragment
import com.sylas.tamagochi.ui.music.fragments.FavouritesFragment
import com.sylas.tamagochi.ui.music.fragments.NewFragment

class MusicSectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    val listTitle = arrayListOf<String>("Новинки","Избранное","Лучшее")

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitle[position]
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return NewFragment()
            1-> return FavouritesFragment()
            2-> return BestFragment()
            else -> return NewFragment()
        }
    }

    override fun getCount(): Int {
        return listTitle.size
    }


}