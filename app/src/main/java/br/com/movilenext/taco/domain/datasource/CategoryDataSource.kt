package br.com.movilenext.taco.domain.datasource

import br.com.movilenext.taco.data.ws.Category
import io.reactivex.Observable

interface CategoryDataSource {
    fun listCategory(): Observable<List<Category>>
}