package com.dara.apod

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dara.apod.model.Picture
import com.dara.apod.ui.MainActivity
import com.dara.apod.ui.PictureAdapter
import org.junit.Rule
import org.junit.Test


class RecyclerViewTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun recyclerViewItem_clickDetected() {
        // Perform item click
        onView(ViewMatchers.withId(R.id.rv_pictures)).perform(
            RecyclerViewActions.actionOnItemAtPosition<PictureAdapter.PictureViewHolder>(
                0, ViewActions.click()
            )
        )

        onView(ViewMatchers.withId(R.id.img_info)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun infoButtonClick_showsBottomModal() {
        recyclerViewItem_clickDetected()

        // Click on info button
        onView(ViewMatchers.withId(R.id.img_info)).perform(
            ViewActions.click()
        )

        onView(ViewMatchers.withId(R.id.root_view)).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )

    }

    @Test
    fun bottomModal_showsCorrectInfo() {
        infoButtonClick_showsBottomModal()

        val samplePicture = Picture(
            "", "", "", "", "", "",
            "M33: The Triangulum Galaxy", ""
        )


        onView(ViewMatchers.withId(R.id.tv_title)).check(
            ViewAssertions.matches(ViewMatchers.withText(samplePicture.title))
        )

    }

}