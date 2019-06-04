package com.example.guilleapp.second

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.guilleapp.R

class SecondVPFragment : Fragment() {

    private var listenerButtonClick: ButtonClick? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_second_vp, container, false)

        val textView = view.findViewById<TextView>(R.id.txtMain)
        textView.setText(R.string.second_fragment)

        val imageView = view.findViewById<ImageView>(R.id.imgMain)
        imageView.setImageResource(R.mipmap.ic_launcher)

        val btn = view.findViewById<Button>(R.id.btnOver)
        btn.setOnClickListener {
            listenerButtonClick?.buttonPressed()

        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listenerButtonClick = context as? ButtonClick?
    }

    override fun onDetach() {
        super.onDetach()

        listenerButtonClick = null
    }

    // ---- Interface ----

    interface ButtonClick {
        fun buttonPressed()
    }

    // ---- END Interface ----

    companion object {
        fun newInstance(): SecondVPFragment {
            return SecondVPFragment()
        }
    }
}

