package com.example.unittestdemo.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.pressBack
import androidx.test.filters.MediumTest
import com.example.unittestdemo.fragment.Blank1Fragment
import com.example.unittestdemo.fragment.Blank2Fragment
import com.example.unittestdemo.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import kotlin.Throws
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.lang.Exception

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class Blank2FragmentTest {
    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        hiltAndroidRule.inject()
    }


    @Test
    fun test_back_stack_navigation(){
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<Blank2Fragment> {
            Navigation.setViewNavController(requireView(), navController)
        }

        pressBack()

        verify(navController).popBackStack()
    }
}