package br.com.movilenext.taco.core.di

import br.com.movilenext.taco.domain.datasource.CategoryProvider
import br.com.movilenext.taco.domain.datasource.CategoryProviderImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class CategoryModule {
    @Provides
    @Reusable
    fun provideCategoryProvider(categoryProvider: CategoryProviderImpl): CategoryProvider = categoryProvider
}