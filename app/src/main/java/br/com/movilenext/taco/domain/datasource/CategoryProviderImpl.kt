package br.com.movilenext.taco.domain.datasource

import br.com.movilenext.taco.data.db.CategoryRepository
import br.com.movilenext.taco.data.ws.Category
import br.com.movilenext.taco.data.ws.CategoryService
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject

class CategoryProviderImpl @Inject constructor(
    private val repository: Lazy<CategoryRepository>,
    private val categoryService: Lazy<CategoryService>
) : CategoryProvider {

    override fun listCategory(): Observable<List<Category>> {
        return repository
            .get()
            .listCategory()
            .flatMap {
                if (it.isEmpty()) categoryService.get().listCategory() else Observable.just(it)
            }

    }

}