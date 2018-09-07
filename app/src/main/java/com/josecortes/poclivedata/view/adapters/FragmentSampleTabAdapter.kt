package com.josecortes.poclivedata.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.josecortes.poclivedata.view.ItemDetailFragment

/**
 * Tab Adapter that will contain N identical Fragments to test the data sharing with the Activity
 */
class FragmentSampleTabAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    var fragment0: ItemDetailFragment? = null
    var fragment1: ItemDetailFragment? = null
    var fragment2: ItemDetailFragment? = null
    var fragment3: ItemDetailFragment? = null

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                if (fragment0 == null)
                    fragment0 = ItemDetailFragment()
                return fragment0!!
            }
            1 -> {
                if (fragment1 == null)
                    fragment1 = ItemDetailFragment()
                return fragment1!!
            }
            2 -> {
                if (fragment2 == null)
                    fragment2 = ItemDetailFragment()
                return fragment2!!
            }
            3 -> {
                if (fragment3 == null)
                    fragment3 = ItemDetailFragment()
                return fragment3!!
            }
            else -> {
                ItemDetailFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Fragment1"
            1 -> "Fragment2"
            2 -> "Fragment3"
            3 -> "Fragment4"

            else -> {
                "Fragment Invalid"
            }
        }
    }

}