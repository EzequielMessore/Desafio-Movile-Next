package br.com.movilenext.taco.data.db

import br.com.movilenext.taco.data.ws.Category
import br.com.movilenext.taco.domain.datasource.CategoryDataSource
import dagger.Reusable
import io.reactivex.Observable
import javax.inject.Inject

@Reusable
class CategoryRepository @Inject constructor(private val categoryDao: CategoryDao) : CategoryDataSource {

    override fun listCategory(): Observable<List<Category>> {
        return categoryDao.getAll().toObservable().map { list -> list.map { Category(it.id, it.name) } }
    }

    fun save(category: Category) {

    }
}