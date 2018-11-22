package br.com.movilenext.taco.presentation.features.category

import android.arch.lifecycle.MutableLiveData
import br.com.movilenext.taco.core.platform.BaseViewModel
import br.com.movilenext.taco.domain.interactor.GetCategories
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import java.util.*
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val getCategories: GetCategories) : BaseViewModel() {

    val state: MutableLiveData<CategoriesState> = MutableLiveData()
    val load by lazy {
        loadCategories()
        MutableLiveData<Any>()
    }
    private lateinit var categories: List<CategoryModel>

    fun loadCategories() {
        state.value = CategoriesLoading
        getCategories(null)
            .subscribeBy(
                onNext = {
                    categories = it
                    state.value = CategoriesData(it)
                },
                onError = {
                    state.value = CategoriesError(it)
                }
            ).addTo(disposable)
    }

    fun filterCategories(query: String) {
        val filteredList = ArrayList<CategoryModel>()

        if (query.isEmpty()) {
            filteredList.addAll(categories)
        } else {
            filteredList.addAll(
                Observable
                    .just(categories)
                    .flatMapIterable { it }
                    .filter { it.name.toLowerCase().contains(query.toLowerCase()) }
                    .toList().blockingGet()
            )
        }
        state.value = CategoriesData(filteredList)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}