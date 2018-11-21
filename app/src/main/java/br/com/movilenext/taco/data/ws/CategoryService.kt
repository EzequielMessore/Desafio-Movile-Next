package br.com.movilenext.taco.data.ws

import br.com.movilenext.taco.data.db.CategoryDao
import br.com.movilenext.taco.data.db.CategoryEntity
import br.com.movilenext.taco.domain.datasource.CategoryDataSource
import io.reactivex.Observable
import javax.inject.Inject

class CategoryService @Inject constructor(
    private val categoryApi: CategoryApi,
    private val categoryDao: CategoryDao
) : CategoryDataSource {
    override fun listCategory(): Observable<List<Category>> =
        categoryApi
            .listCategories()
            .flatMapIterable { it }
            .filter { it.id <= 9 }
            .toList()
            .toObservable()
            .map { save(it) }

    private fun save(categories: List<Category>): List<Category> {
        categoryDao.insert(*categories.map {
            CategoryEntity(it.id, it.name)
        }.toTypedArray())
        return categories
    }

}