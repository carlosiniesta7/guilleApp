package com.example.guilleapp.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.guilleapp.MapsActivity
import com.example.guilleapp.R
import com.example.guilleapp.main.countrylist.CountryListFragment
import com.example.guilleapp.main.countrylist.CountryListFragmentDirections
import com.example.guilleapp.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import androidx.navigation.Navigation.findNavController as findNavController1

class MainActivity : AppCompatActivity(), CountryListFragment.Response,
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_main)

            setSupportActionBar(toolbar)

            //val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
            if (savedInstanceState == null) {
                val host = NavHostFragment.create(R.navigation.nav_graph)
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, host)
                    .setPrimaryNavigationFragment(host).commit()
            }

            val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            drawer_layout.addDrawerListener(toggle)
            toggle.syncState()

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
                //Reemplazar a Countries
                val host = NavHostFragment.create(R.navigation.nav_graph)
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, host)
                    .setPrimaryNavigationFragment(host).commit()
            }
            R.id.nav_countryStar -> {
                Toast.makeText(this, "Deshabilitado", Toast.LENGTH_SHORT).show()
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
                //Toast.makeText(this, "Cambiar a Activity con ViewPager", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondActivity::class.java)

                /*// To pass any data to next activity
                intent.putExtra("keyIdentifier", value)*/

                // start your next activity
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    // ---- END NavigationView.OnNavigationItemSelectedListener ----


    // ---- CountryListFragment.Response ----

    override fun itemPressed(item: Country) {
        val action = CountryListFragmentDirections.actionShowDetail(item.flag!!)
        action.countryName = item.name
        action.countryPoblation = item.poblation.toString()
        action.countryPIB = item.PIB.toString()

        findNavController(R.id.nav_host_fragment).navigate(action)
    }

    // ---- END CountryListFragment.Response ----

}




