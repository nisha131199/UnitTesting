package com.example.unittesting

import android.content.Intent
import android.support.test.espresso.matcher.ViewMatchers.*
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.StringContains.containsString
import org.junit.Test

class MainActivityTest {

    @Test
    fun test1() {

        val activityTestRule: ActivityTestRule<MainActivity?> = ActivityTestRule(MainActivity::class.java)

        activityTestRule.launchActivity(Intent())

        onView(withId(R.id.et1))
            .perform(typeText("Green"))
            .check(matches(withText("Green")))

        onView(withId(R.id.et3))
            .perform(typeText("Yellow"))
            .check(matches(withText("Yellow")))

        onView(withId(R.id.btn3))
            .perform(longClick())
            .check(matches(withText(containsString("Red"))))
    }
}