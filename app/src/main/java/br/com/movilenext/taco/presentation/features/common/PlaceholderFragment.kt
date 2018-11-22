package br.com.movilenext.taco.presentation.features.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.movilenext.taco.R

class PlaceholderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.container_error, container, false)
    }

    companion object {
        fun newInstance() = PlaceholderFragment()
    }
}