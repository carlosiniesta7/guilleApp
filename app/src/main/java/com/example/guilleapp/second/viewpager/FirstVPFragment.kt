package com.example.guilleapp.second.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guilleapp.R
import kotlinx.android.synthetic.main.fragment_first_vp.*

class FirstVPFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first_vp, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        txtMain?.setText(R.string.first_fragment)
        imgMain?.setImageResource(R.mipmap.ic_launcher)
    }

    companion object {
        fun newInstance(): FirstVPFragment {
            return FirstVPFragment()
        }
    }
}
