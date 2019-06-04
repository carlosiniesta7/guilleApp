package com.example.guilleapp.second

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.guilleapp.R

class ThirdFragment : Fragment() {

    /*companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_third_vp, container, false)

        val textView = view.findViewById<TextView>(R.id.txtMain)
        textView.setText(R.string.third_fragment)

        val imageView = view.findViewById<ImageView>(R.id.imgMain)
        imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)

        return view
    }

    companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }
}
