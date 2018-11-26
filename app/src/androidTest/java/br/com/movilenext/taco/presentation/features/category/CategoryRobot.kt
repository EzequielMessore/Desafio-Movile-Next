package br.com.movilenext.taco.presentation.features.category

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.movilenext.taco.R
import br.com.movilenext.taco.base.BaseTestRobot
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule

class CategoryRobot(server: MockWebServer) : BaseTestRobot() {

    private var activityRule
            = ActivityTestRule(CategoryActivity::class.java, false, false)
    @get:Rule
    var serverRule: RequestMatcherRule = InstrumentedTestRequestMatcherRule(server)

    fun start() = apply {
        activityRule.launchActivity(Intent())
    }

    fun injectCategories() = apply {
        serverRule.url("/")
        serverRule.addFixture(200, "categories.json")
    }

    fun checkItemInRecyclerView(text: String) = apply {
        checkTextIsDisplayedWithDescendant(text, R.id.rv_category)
    }
}