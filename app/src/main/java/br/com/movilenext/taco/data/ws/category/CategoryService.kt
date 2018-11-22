package br.com.movilenext.taco.data.ws.category

import br.com.movilenext.taco.data.db.CategoryDao
import br.com.movilenext.taco.data.mappers.CategoryDataMapper
import br.com.movilenext.taco.domain.datasource.category.CategoryDataSource
import io.reactivex.Observable
import javax.inject.Inject

class CategoryService @Inject constructor(
    private val categoryApi: CategoryApi,
    private val categoryDao: CategoryDao,
    private val categoryDataMapper: CategoryDataMapper
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
            categoryDataMapper.toFrom(it)
        }.toTypedArray())
        return categories
    }

}