package br.com.movilenext.taco.core.di

import br.com.movilenext.taco.presentation.features.category.CategoryActivity
import br.com.movilenext.taco.presentation.features.food.FoodActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeCategoryActivity(): CategoryActivity

    @ContributesAndroidInjector
    abstract fun contributeFoodActivity(): FoodActivity

}