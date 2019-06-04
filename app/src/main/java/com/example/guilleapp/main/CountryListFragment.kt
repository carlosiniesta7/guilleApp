package com.example.guilleapp.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guilleapp.R
import kotlinx.android.synthetic.main.fragment_list.*

class CountryListFragment : Fragment() {

    private var listenerResponse: Response? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_list,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        my_recycler_view?.layoutManager = LinearLayoutManager(activity)

        val countries = ArrayList<Country>()
        addCountries(countries)

        val adapter = AdapterCountry(countries)
        adapter.responseListener = object : AdapterCountry.Response {
            override fun itemPressed(item: Country) {
                listenerResponse?.itemPressed(item)
            }
        }
        my_recycler_view?.adapter = adapter
    }

    private fun addCountries(countries: ArrayList<Country>) {
        countries.add(
            Country(
                "Italia",
                60600000,
                R.drawable.italy,
                1395
            )
        )
        countries.add(
            Country(
                "Francia",
                67000000,
                R.drawable.francia,
                2583
            )
        )
        countries.add(
            Country(
                "Alemania",
                82800000,
                R.drawable.alemania,
                3677
            )
        )
        countries.add(
            Country(
                "España",
                46700000,
                R.drawable.espana,
                1311
            )
        )
        countries.add(
            Country(
                "El Escorial",
                15842,
                R.drawable.escorial,
                9999
            )
        )
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listenerResponse = context as? Response?
    }

    override fun onDetach() {
        super.onDetach()

        listenerResponse = null
    }

    // ---- Interface ----

    interface Response {
        fun itemPressed(item: Country)
    }

    // ---- END Interface ----

    companion object {
        fun newInstance(): CountryListFragment {
            return CountryListFragment()
        }
    }

}