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
import kotlinx.android.synthetic.main.fragment_list.*

class CountryListFragment : Fragment(), CountryListFragmentView {

    private val presenter: PresenterCountryList = PresenterCountryListImpl(view = this)

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
        configAdapter()
        presenter.getCountries()
    }

    private fun configAdapter() {
        my_recycler_view?.layoutManager = LinearLayoutManager(activity)

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

    // ---- CountryListFragmentView ----

    override fun showCountries(countries: List<Country>) {
        (my_recycler_view?.adapter as? AdapterCountry?)?.update(countries = countries)
    }

    // ---- END CountryListFragmentView ----

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