package com.example.guilleapp.view.second.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guilleapp.R
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val lFragments = ArrayList<Fragment>()
        lFragments.add(FirstVPFragment.newInstance())
        lFragments.add(SecondVPFragment.newInstance())
        val adapter =
            ViewPagerAdapter(lFragment = lFragments, fm = childFragmentManager)
        viewPager?.adapter = adapter
    }

    companion object {
        fun newInstance(): ViewPagerFragment {
            return ViewPagerFragment()
        }
    }
}
