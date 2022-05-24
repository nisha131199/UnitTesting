package com.example.unittesting

import android.content.Intent
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.StringContains.containsString
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

//    @Rule
//    var activityTestRule: ActivityTestRule<MainActivity?> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1() {

        val activityTestRule: ActivityTestRule<MainActivity?> = ActivityTestRule(MainActivity::class.java)

        activityTestRule.launchActivity(Intent())


        onView(withId(R.id.et1))
            .perform(typeText("Hello"))
            .check(matches(withText("Hello")))


        onView(withId(R.id.btn3))
            .check(matches(withText(containsString("Red"))))
    }
}