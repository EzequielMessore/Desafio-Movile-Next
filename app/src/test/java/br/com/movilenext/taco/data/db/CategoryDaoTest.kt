package br.com.movilenext.taco.data.db

import android.arch.persistence.room.Room
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CategoryDaoRoboletricTest {

    private lateinit var database: TacoRoomDatabase


    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application,
            TacoRoomDatabase::class.java
        ).build()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun getAll() {
        val list = listOf(
            CategoryEntity(1, "Category 1"),
            CategoryEntity(2, "Category 2"),
            CategoryEntity(3, "Category 3")
        )

        list.map {
            database
                .categoryDao()
                .insert(it)
        }

        val getAll =
            database
                .categoryDao()
                .getAll()
                .blockingFirst()

        assert(getAll.size == 3)
    }

    @Test
    fun insert() {
        val entity = CategoryEntity(1, "Category Test")

        database
            .categoryDao()
            .insert(entity)

        val list = database
            .categoryDao()
            .getAll()
            .blockingFirst()

        assert(list.isNotEmpty())
    }
}