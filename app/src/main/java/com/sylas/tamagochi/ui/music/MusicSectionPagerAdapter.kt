package com.sylas.tamagochi.ui.music

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sylas.tamagochi.ui.music.fragments.FavouritesFragment
import com.sylas.tamagochi.ui.music.fragments.NewFragment
import com.sylas.tamagochi.ui.music.fragments.AllFragment

class MusicSectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    val listTitle = arrayListOf<String>("Все","Новинки","Избранное")

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitle[position]
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return AllFragment()
            1-> return NewFragment()
            2-> return FavouritesFragment()
            else -> return AllFragment()
        }
    }

    override fun getCount(): Int {
        return listTitle.size
    }


}