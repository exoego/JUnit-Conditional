package net.exoego.junit;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class TestUtil {
    public static <T extends Comparable<T>> Matcher<T> greaterThan(final T base) {
        return new TypeSafeMatcher<T>() {
            @Override
            protected boolean matchesSafely(final T t) {
                return t.compareTo(base) > 0;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("greater than ");
                description.appendValue(base);
            }
        };
    }

    public static <T extends Comparable<T>> Matcher<T> lessThan(final T base) {
        return new TypeSafeMatcher<T>() {
            @Override
            protected boolean matchesSafely(final T t) {
                return t.compareTo(base) < 0;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("greater than ");
                description.appendValue(base);
            }
        };
    }
}
