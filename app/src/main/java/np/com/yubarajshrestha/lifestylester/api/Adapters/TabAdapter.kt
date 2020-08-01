package np.com.yubarajshrestha.lifestylester.api.Adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import np.com.yubarajshrestha.lifestylester.ui.ProductFragment

class TabAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? = when(position) {
        0 -> {
            ProductFragment.newInstance("First Fragment")
        }
        1 -> {
            ProductFragment.newInstance("Second Fragment")
        }
        2 -> {
            ProductFragment.newInstance("Third Fragment")
        }
        3 -> {
            ProductFragment.newInstance("Fourth Fragment")
        }
        4 -> {
            ProductFragment.newInstance("Fifth Fragment")
        }
        5 -> {
            ProductFragment.newInstance("Sixth Fragment")
        }
        6 -> {
            ProductFragment.newInstance("Seventh Fragment")
        }
        7 -> {
            ProductFragment.newInstance("Eighth Fragment")
        }
        8 -> {
            ProductFragment.newInstance("Ninth Fragment")
        }
        9 -> {
            ProductFragment.newInstance("Tenth Fragment")
        }
        10 -> {
            ProductFragment.newInstance("Eleventh Fragment")
        }
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when(position) {
        //return super.getPageTitle(position)
        0 -> "Bags"
        1 -> "Blazers"
        2 -> "Glasses"
        3 -> "Basics"
        4 -> "Jewels"
        5 -> "Shoes"
        6 -> "Shirts"
        7 -> "Trousers"
        8 -> "Skirts"
        9 -> "Wallets"
        10 -> "Hats"
        else -> ""
    }

    override fun getCount(): Int = 11
}