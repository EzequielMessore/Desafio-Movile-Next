package br.com.movilenext.taco.domain.interactor

import br.com.movilenext.taco.core.interactor.UseCase.None
import br.com.movilenext.taco.core.interactor.UseCaseObservable
import br.com.movilenext.taco.core.scheduler.ISchedulersProvider
import br.com.movilenext.taco.domain.datasource.CategoryProvider
import br.com.movilenext.taco.presentation.features.category.CategoryModel
import io.reactivex.Observable
import javax.inject.Inject

class GetCategories @Inject constructor(
    private val categoryProvider: CategoryProvider,
    schedulerProvider: ISchedulersProvider
) : UseCaseObservable<None?, List<CategoryModel>>(schedulerProvider) {

    override fun buildUseCase(params: None?): Observable<List<CategoryModel>> = categoryProvider.listCategory()

}