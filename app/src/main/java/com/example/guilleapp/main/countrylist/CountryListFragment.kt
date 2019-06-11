package com.example.guilleapp.main.countrylist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guilleapp.R
import com.example.guilleapp.main.Country
import kotlinx.android.synthetic.main.fragment_list.*
import java.io.Serializable

@Suppress("UNCHECKED_CAST")
class CountryListFragment : Fragment() {

    private lateinit var viewModel: CountryListViewModel

    private var listenerResponse: Response? = null

    private var countries: List<Country>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, CountryListViewModelFactory()).get(CountryListViewModel::class.java)

        return inflater.inflate(
            R.layout.fragment_list,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configAdapter()
        if (savedInstanceState == null) {
            viewModel.getCountriesLD().observe(this, Observer { countries ->
                if (countries != null) {
                    showCountries(countries)
                }
            })
        }
        else {
            countries = (savedInstanceState.getSerializable(COUNTRIES) as? List<Country>)?.also {
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

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listenerResponse = context as? Response?
    }

    override fun onDetach() {
        super.onDetach()

        listenerResponse = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(COUNTRIES, countries as Serializable)

        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val COUNTRIES = "COUNTRIES"
    }

    private fun showCountries(countries: List<Country>) {
        this.countries = countries
        (my_recycler_view?.adapter as? AdapterCountry?)?.update(countries = countries)
    }

    // ---- Interface ----

    interface Response {
        fun itemPressed(item: Country)
    }
    // ---- END Interface ----

}