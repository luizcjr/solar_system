package com.example.solarsystemclean.presentation.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.solarsystemclean.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun shouldHomeItemMenuNavigationBottomViewIsDisplayed() {
        val bottomNavigationItemView = onView(
            Matchers.allOf(
                withId(R.id.navigation_home), withContentDescription("Home"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val imageView = onView(
            Matchers.allOf(
                withId(R.id.icon),
                withParent(
                    Matchers.allOf(
                        withId(R.id.navigation_home), withContentDescription("Home"),
                        withParent(IsInstanceOf.instanceOf(ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))
    }

    @Test
    fun shouldSearchItemMenuNavigationBottomViewIsDisplayed() {
        val bottomNavigationItemView = onView(
            Matchers.allOf(
                withId(R.id.navigation_search), withContentDescription("Buscar"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val imageView = onView(
            Matchers.allOf(
                withId(R.id.icon),
                withParent(
                    Matchers.allOf(
                        withId(R.id.navigation_search), withContentDescription("Buscar"),
                        withParent(IsInstanceOf.instanceOf(ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))
    }

    @Test
    fun shouldFavoritesItemMenuNavigationBottomViewIsDisplayed() {
        val bottomNavigationItemView = onView(
            Matchers.allOf(
                withId(R.id.navigation_favorites), withContentDescription("Favoritos"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val imageView = onView(
            Matchers.allOf(
                withId(R.id.icon),
                withParent(
                    Matchers.allOf(
                        withId(R.id.navigation_favorites), withContentDescription("Favoritos"),
                        withParent(IsInstanceOf.instanceOf(ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))
    }

    @Test
    fun shouldProfileItemMenuNavigationBottomViewIsDisplayed() {
        val bottomNavigationItemView = onView(
            Matchers.allOf(
                withId(R.id.navigation_profile), withContentDescription("Perfil"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val imageView = onView(
            Matchers.allOf(
                withId(R.id.icon),
                withParent(
                    Matchers.allOf(
                        withId(R.id.navigation_profile), withContentDescription("Perfil"),
                        withParent(IsInstanceOf.instanceOf(ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))
    }


    /** Função gerada utilizando o Record Espresso Test
     *   Run > Record Espresso Test
     *   Facilitou bem o entendimento da lógica para criar os testes da bottom navigation
     */
    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}