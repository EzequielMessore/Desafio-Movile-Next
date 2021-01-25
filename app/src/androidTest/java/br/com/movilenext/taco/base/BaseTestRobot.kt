package br.com.movilenext.taco.base

import android.content.res.Resources
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import android.view.KeyEvent.KEYCODE_ENTER
import org.hamcrest.CoreMatchers.*

open class BaseTestRobot {
    protected fun fillEditText(resId: Int, text: String) = onView(withId(resId)).perform(
        ViewActions.replaceText(text),
        ViewActions.closeSoftKeyboard()
    )

    protected fun clickView(resId: Int) =
        onView((withId(resId))).perform(ViewActions.click())

    private fun textView(resId: Int) = onView(withId(resId))

    private fun matchText(viewInteraction: ViewInteraction, text: String) =
        viewInteraction.check(ViewAssertions.matches(withText(text)))

    protected fun matchText(resId: Int, string: Int) =
        textView(resId).check(ViewAssertions.matches(withId(string)))

    protected fun matchText(resId: Int, text: String) = matchText(textView(resId), text)

    protected fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    protected fun checkTextIsDisplayedWithDescendant(text: String, @IdRes descendantId: Int) {
        onView(allOf(withText(text), isDescendantOfA(withId(descendantId))))
    }

    protected fun checkTextIsNotDisplayed(text: String) {
        onView(withText(text)).check(matches(not(isDisplayed())))
    }

    protected fun checkTextIsVisible(text: String) {
        onView(withText(text)).check(matches(isDisplayed()))
    }

    protected fun checkIdIsVisible(@IdRes id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))
    }

    protected fun checkIdNotVisible(@IdRes id: Int) {
        onView(withId(id)).check(doesNotExist())
    }

    protected fun setTextInSearchView(text: String) {
        onView(withId(Resources.getSystem().getIdentifier("search_src_text", "id", "android")))
            .perform(ViewActions.typeText(text), pressKey(KEYCODE_ENTER))
            .perform(closeSoftKeyboard())
    }
}
