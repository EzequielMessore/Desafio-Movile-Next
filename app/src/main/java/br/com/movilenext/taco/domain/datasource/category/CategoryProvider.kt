package br.com.movilenext.taco.domain.datasource.category

import br.com.movilenext.taco.data.db.category.CategoryRepository
import br.com.movilenext.taco.data.mappers.CategoryModelMapper
import br.com.movilenext.taco.data.ws.category.CategoryService
import br.com.movilenext.taco.presentation.features.category.CategoryModel
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject

class CategoryProvider @Inject constructor(
    private val repository: Lazy<CategoryRepository>,
    private val categoryService: Lazy<CategoryService>,
    private val modelMapper: CategoryModelMapper
) {

    fun listCategory(): Observable<List<CategoryModel>> {
        return repository
            .get()
            .listCategory()
            .flatMap {
                if (it.isEmpty()) {
                    categoryService.get().listCategory().map { modelMapper.toFrom(it) }
                } else {
                    Observable.just(modelMapper.toFrom(it))
                }
            }

    }

}