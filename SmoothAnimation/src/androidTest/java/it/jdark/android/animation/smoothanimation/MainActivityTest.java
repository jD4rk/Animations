package it.jdark.android.animation.smoothanimation;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by jdark on 15/03/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }
    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testViewPreAnimationDisplayed() {
        onView(withId(R.id.fadeLayer)).check(matches(isDisplayed()));
    }

    public void testViewPostAnimationDisplayed() throws InterruptedException {
//        Thread.sleep(MainActivity.ANIMATION_DURATION_MS);
        onView(withId(R.id.fadeLayer)).check(matches(not(isDisplayed())));
    }
}
