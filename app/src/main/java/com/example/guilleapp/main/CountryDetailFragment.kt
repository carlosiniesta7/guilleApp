package com.example.guilleapp.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.guilleapp.R
import kotlinx.android.synthetic.main.fragment_detail.*

class CountryDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_detail,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val countryDetail = countryDetail

        bindCountryDetail(countryDetail)

    }

    @SuppressLint("SetTextI18n")
    private fun bindCountryDetail(countryDetail: Country) {
        context?.let { Glide.with(it).load(countryDetail.flag).into(detailFlag) }
        txtDetailName.text = countryDetail.name
        txtDetailPob.text = countryDetail.poblation.toString()
        txtDetailPib.text = "${countryDetail.PIB} Billones"
    }

    private val countryDetail: Country
        get() {
            val f = arguments?.let { CountryDetailFragmentArgs.fromBundle(it).id }
            val name= arguments?.let { CountryDetailFragmentArgs.fromBundle(it).countryName }
            val pob = arguments?.let { CountryDetailFragmentArgs.fromBundle(it).countryPoblation }
            val pib = arguments?.let { CountryDetailFragmentArgs.fromBundle(it).countryPIB }

            return Country(name.toString(), pob?.toInt()!!, f, pib?.toInt()!!)
        }

    companion object {
        fun newInstance(): CountryDetailFragment {
            return CountryDetailFragment()
        }
    }

}
