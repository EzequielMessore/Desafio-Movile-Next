package br.com.movilenext.taco.core.di

import android.arch.persistence.room.Room
import android.content.Context
import br.com.movilenext.taco.data.db.CategoryDao
import br.com.movilenext.taco.data.db.TacoRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    internal fun providesRoomDatabase(context: Context): TacoRoomDatabase =
        Room.databaseBuilder(context.applicationContext, TacoRoomDatabase::class.java, "taco-db").build()

    @Singleton
    @Provides
    internal fun providesCategoryDao(demoDatabase: TacoRoomDatabase): CategoryDao = demoDatabase.categoryDao()

}