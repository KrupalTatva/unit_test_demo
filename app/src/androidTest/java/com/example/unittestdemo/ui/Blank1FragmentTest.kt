package com.example.unittestdemo.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.example.unittestdemo.R
import com.example.unittestdemo.fragment.Blank1Fragment
import com.example.unittestdemo.fragment.Blank1FragmentDirections
import com.example.unittestdemo.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import kotlin.Throws
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.lang.Exception

//todo we can not user reified inline  function in java class so ...

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class Blank1FragmentTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun test_navigation_to_fragment2(){
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<Blank1Fragment> {
            Navigation.setViewNavController(requireView(), navController)
        }


        onView(withId(R.id.btnGoToFragment2)).perform(click())

        verify(navController).navigate(
                Blank1FragmentDirections.actionBlank1FragmentToBlank2Fragment()
        )
    }
}