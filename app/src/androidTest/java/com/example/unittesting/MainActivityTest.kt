package com.example.unittesting

import android.content.Intent
import android.support.test.espresso.matcher.ViewMatchers.*
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.example.unittesting.models.Data
import org.hamcrest.core.StringContains.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

//    @get:Rule
//    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
//    @get:Rule
//    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1() {

        val activityTestRule = ActivityTestRule(MainActivity::class.java)
        activityTestRule.launchActivity(Intent())

//        activityScenarioRule.scenario.onActivity {
//            ActivityScenario.ActivityAction<MainActivity> {
//                it.startActivity(Intent())
//            }
//        }
//        activityScenarioRule.scenario.moveToState(Lifecycle.State.CREATED)

        onView(withId(R.id.et1))
            .perform(typeText("Green"))
            .check(matches(withText("Green")))

        onView(withId(R.id.et3))
            .perform(typeText("Yellow"))
            .check(matches(withText("Yellow")))

        onView(withId(R.id.btn3))
            .perform(click())
            .check(matches(withText(containsString("Green"))))
    }
}