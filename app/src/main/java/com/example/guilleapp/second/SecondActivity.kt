package com.example.guilleapp.second

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.example.guilleapp.R


class SecondActivity : AppCompatActivity(), SecondVPFragment.ButtonClick {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ViewPagerFragment.newInstance())
                .commit()
        }
    }

    // ---- SecondActivity.ButtonCLick ----

    override fun buttonPressed() {

        //val thirdFragment = ThirdFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ThirdFragment())
            .addToBackStack(null)
            .commit()
    }

    // ---- END SecondActivity.ButtonCLick ----
}
