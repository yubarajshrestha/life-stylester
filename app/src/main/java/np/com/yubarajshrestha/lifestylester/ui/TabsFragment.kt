package np.com.yubarajshrestha.lifestylester.ui


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import np.com.yubarajshrestha.lifestylester.R
import np.com.yubarajshrestha.lifestylester.api.Adapters.TabAdapter


/**
 * A simple [Fragment] subclass.
 */
class TabsFragment : Fragment() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var adapter: TabAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_tabs, container, false)

        retainInstance = true

        (activity as AppCompatActivity).supportActionBar!!.title = "Product Collections"

        tabLayout = layout.findViewById(R.id.tab_layout)
        viewPager = layout.findViewById(R.id.view_pager)
        adapter = TabAdapter(childFragmentManager)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        return layout
    }

}// Required empty public constructor
