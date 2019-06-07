package com.example.guilleapp.main.countrylist

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guilleapp.R
import com.example.guilleapp.main.Country
import com.example.guilleapp.main.countrydetail.CountryDetailFragment
import kotlinx.android.synthetic.main.fragment_list.*

class CountryListFragment : Fragment(), CountryListFragmentView {

    private val presenter: PresenterCountryList = PresenterCountryListImpl(view = this)

    private var listenerResponse: Response? = null

    private var countries: ArrayList<Country>? = null

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
        configAdapter()
        if (savedInstanceState == null) {
            presenter.getCountries()
        }
        else {
            countries = savedInstanceState.getParcelableArrayList<Country>(COUNTRIES)?.also {
                showCountries(it)
            }
        }
    }

    private fun configAdapter() {

        my_recycler_view?.layoutManager = activity?.let { LinearLayoutManager(it) }

        val adapter = AdapterCountry(ArrayList())

        adapter.responseListener = object : AdapterCountry.Response {
            override fun itemPressed(item: Country) {
                listenerResponse?.itemPressed(item)
            }
        }
        my_recycler_view?.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(COUNTRIES, countries)

        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val COUNTRIES = "COUNTRIES"
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listenerResponse = context as? Response?
    }

    override fun onDetach() {
        super.onDetach()

        listenerResponse = null
    }

    // ---- CountryListFragmentView ----

    override fun showCountries(countries: ArrayList<Country>) {
        this.countries = countries
        (my_recycler_view?.adapter as? AdapterCountry?)?.update(countries = countries)
    }

    // ---- END CountryListFragmentView ----

    // ---- Interface ----

    interface Response {
        fun itemPressed(item: Country)
    }

    // ---- END Interface ----

}