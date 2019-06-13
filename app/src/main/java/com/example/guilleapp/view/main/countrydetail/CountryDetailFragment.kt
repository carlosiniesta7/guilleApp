package com.example.guilleapp.view.main.countrydetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.guilleapp.R
import com.example.guilleapp.view.main.model.Country
import kotlinx.android.synthetic.main.fragment_detail.*

class CountryDetailFragment : Fragment() {

    private val args: CountryDetailFragmentArgs by navArgs()

    private lateinit var viewModel: CountryDetailViewModel

    private var listenerButtonClick: ButtonClick? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, CountryDetailViewModelFactory(country = args.modelIn.country)).get(CountryDetailViewModel::class.java)

        return inflater.inflate(
            R.layout.fragment_detail,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val btn = view.findViewById<Button>(R.id.delete_btn)
        btn?.setOnClickListener {
            listenerButtonClick?.buttonPressed()
        }

        viewModel.getCountryLD().observe(this, Observer { country ->
            if (country != null) {
                showCountry(country)
            }
        })
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        listenerButtonClick = context as? ButtonClick?
    }

    override fun onDetach() {
        super.onDetach()

        listenerButtonClick = null
    }

    private fun showCountry(country: Country) {
        context?.let {
            Glide.with(it).load(country.flag).into(detailFlag)
        }
        txtDetailName?.text = country.name
        txtDetailPob?.text = country.poblation.toString()
        txtDetailPib?.text = country.PIB.toString()
        txtDetailPibHab?.text = country.PIBPerHab.toString()
    }

    // ---- Interface ----

    interface ButtonClick {
        fun buttonPressed()
    }

    // ---- END Interface ----
}