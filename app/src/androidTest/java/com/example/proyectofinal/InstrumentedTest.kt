package com.example.proyectofinal

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    @After


    @Test
    fun useAppContext() {
        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("LAS CADENAS SON IGUALES")
            )
        )


    }
}