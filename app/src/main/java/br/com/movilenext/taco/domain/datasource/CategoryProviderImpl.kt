package br.com.movilenext.taco.domain.datasource

import br.com.movilenext.taco.data.db.CategoryRepository
import br.com.movilenext.taco.data.mappers.CategoryModelMapper
import br.com.movilenext.taco.data.ws.CategoryService
import br.com.movilenext.taco.presentation.features.category.CategoryModel
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject

class CategoryProviderImpl @Inject constructor(
    private val repository: Lazy<CategoryRepository>,
    private val categoryService: Lazy<CategoryService>,
    private val modelMapper: CategoryModelMapper
) : CategoryProvider {

    override fun listCategory(): Observable<List<CategoryModel>> {
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