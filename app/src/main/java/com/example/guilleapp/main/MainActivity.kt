package com.example.guilleapp.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import androidx.navigation.findNavController
import com.example.guilleapp.MapsActivity
import com.example.guilleapp.R
import com.example.guilleapp.main.countrydetail.CountryDetailViewModelIn
import com.example.guilleapp.main.countrylist.CountryListFragment
import com.example.guilleapp.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CountryListFragment.Response,
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initMenu()
        initListeners()
    }

    private fun initMenu() {
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun initListeners() {
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    // ---- NavigationView.OnNavigationItemSelectedListener ----

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_countries -> {
                findNavController(R.id.nav_host_fragment).navigateUp()
            }
            R.id.nav_countryStar -> {
                findNavController(R.id.nav_host_fragment).navigateUp()
                /*val action = CountryListFragmentDirections.actionShowDetail(R.drawable.escorial)
                action.countryName = "EL ESCORIAL"
                action.countryPoblation = "15842"
                action.countryPIB = "9999"
                findNavController(R.id.nav_host_fragment).navigate(action)*/
            }
            R.id.nav_map -> {
                val intentMap = Intent(this, MapsActivity::class.java)

                startActivity(intentMap)
            }
            R.id.nav_about -> {
                val intent = Intent(this, SecondActivity::class.java)
                /*// To pass any data to next activity
                intent.putExtra("keyIdentifier", value)*/
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    // ---- END NavigationView.OnNavigationItemSelectedListener ----


    // ---- CountryListFragment.Response ----

    override fun itemPressed(item: Country) {
        val modelIn = CountryDetailViewModelIn(item)

        val bundle = Bundle()
        bundle.putParcelable("modelIn", modelIn)

        findNavController(R.id.nav_host_fragment).navigate(R.id.action_showDetail, bundle)
    }

    // ---- END CountryListFragment.Response ----

}




