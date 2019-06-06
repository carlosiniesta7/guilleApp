package com.example.guilleapp.main.countrydetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.guilleapp.R
import com.example.guilleapp.main.Country
import kotlinx.android.synthetic.main.fragment_detail.*

class CountryDetailFragment : Fragment(), CountryDetailFragmentView {
    private val presenter: PresenterCountryDetail = PresenterCountryDetailImpl()

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
            arguments?.let {
                (CountryDetailFragmentArgs.fromBundle(it).modelIn as? CountryDetailViewModelIn?)?.let { model ->
                    presenter.getPIBPerHab(model.country)
                    //Toast.makeText(context, "PIBPerHab= ${model.country.PIBPerHab}", Toast.LENGTH_SHORT).show()
                    initData(model.country)
                }
            }
    }

    private fun initData(country: Country) {
        context?.let {
            Glide.with(it).load(country.flag).into(detailFlag)
        }
        txtDetailName.text = country.name
        txtDetailPob.text = country.poblation.toString()
        txtDetailPib.text = country.PIB.toString()
        txtDetailPibHab.text = country.PIBPerHab.toString()
    }

}
