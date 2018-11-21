package br.com.movilenext.taco.presentation.features.category

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.platform.BaseActivity
import javax.inject.Inject

class CategoryActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(CategoryViewModel::class.java)
    }

    override fun layoutResource() = R.layout.activity_category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCategories()


        viewModel.categories.observe(this, Observer {
            println(it)
        })
    }

}
