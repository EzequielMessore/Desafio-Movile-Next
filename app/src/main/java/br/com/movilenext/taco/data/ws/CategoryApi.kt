package br.com.movilenext.taco.data.ws

import io.reactivex.Observable
import retrofit2.http.GET

interface CategoryApi {
    @GET("api/v1/category")
    fun listCategories(): Observable<List<Category>>
}