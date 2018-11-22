package br.com.movilenext.taco.presentation.features.category

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import br.com.movilenext.taco.R
import br.com.movilenext.taco.core.extension.contentView
import br.com.movilenext.taco.core.platform.BaseActivity
import br.com.movilenext.taco.databinding.ActivityCategoryBinding
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.container_error.view.*
import javax.inject.Inject

class CategoryActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: CategoryListAdapter

    private val binding: ActivityCategoryBinding by contentView(layoutResource())

    private val viewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(CategoryViewModel::class.java)
    }

    override fun layoutResource() = R.layout.activity_category

    override fun init() {
        binding.viewModel = viewModel
        viewModel.load

        bindViewModels()
        rv_category.adapter = adapter
    }

    override fun insertListener() {
        container_error.btn_try_again.setOnClickListener {
            viewModel.loadCategories()
        }
    }

    private fun bindViewModels() {
        viewModel.state.observe(this, Observer {
            it?.let { state ->
                handleCategoriesState(state)
            }
        })
    }

    private fun handleCategoriesState(state: CategoriesState) {
        when (state) {
            is CategoriesLoading -> {
                loading.show()
            }
            is CategoriesData -> {
                loading.hide()
                adapter.items = state.data
            }
            is CategoriesError -> {
                loading.hide()
            }
        }
    }


}
