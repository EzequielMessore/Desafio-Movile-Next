package br.com.movilenext.taco

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.movilenext.taco.data.ws.category.CategoryApi
import br.com.movilenext.taco.presentation.features.category.CategoryActivity
import net.vidageek.mirror.dsl.Mirror
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class TestTestTes {
    private var server: MockWebServer? = null

    @get:Rule
    var rule: ActivityTestRule<CategoryActivity> = ActivityTestRule(CategoryActivity::class.java, false, false)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        server = MockWebServer()
        server!!.start()
        setupServerUrl()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        server!!.shutdown()
    }

    @Test
    fun check() {
        Espresso.onView(
            CoreMatchers.allOf(
                ViewMatchers.withText("Cereais e derivados"),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.rv_category))
            )
        ).perform(ViewActions.click())
    }

    private fun setupServerUrl() {
        val url = server?.url("/").toString()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val api = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create<CategoryApi>(CategoryApi::class.java)

        setField(api, "api", api)
    }

    private fun setField(target: Any, fieldName: String, value: Any) {
        Mirror()
            .on(target)
            .set()
            .field(fieldName)
            .withValue(value)
    }
}