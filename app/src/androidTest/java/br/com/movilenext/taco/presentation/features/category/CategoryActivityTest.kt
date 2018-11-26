package br.com.movilenext.taco.presentation.features.category

import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class CategoryActivityTest {
    private val server by lazy {
        MockWebServer()
    }

    private lateinit var robot: CategoryRobot

    @Before
    fun setUp() {
        server.start(8080)
        robot = CategoryRobot(server)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun test() {
        robot
            .injectCategories()
            .start()
            .checkItemInRecyclerView("Cereais e derivados")
    }
}