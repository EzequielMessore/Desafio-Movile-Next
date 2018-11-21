package br.com.movilenext.taco.presentation.features.category

import android.arch.lifecycle.MutableLiveData
import br.com.movilenext.taco.core.platform.BaseViewModel
import br.com.movilenext.taco.data.ws.Category
import br.com.movilenext.taco.domain.interactor.GetCategories
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val getCategories: GetCategories) : BaseViewModel() {

    private val disposable = CompositeDisposable()

    val categories: MutableLiveData<List<Category>> = MutableLiveData()

    fun loadCategories() {
        getCategories(null)
            .subscribeBy(
                onNext = {
                    categories.value = it
                }
            ).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}