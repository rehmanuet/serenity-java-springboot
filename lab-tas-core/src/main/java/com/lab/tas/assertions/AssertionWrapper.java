package com.lab.tas.assertions;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

public class AssertionWrapper {
    private static final String ASSERT_THAT = "Assert that ";

    public static <T> void assertThat(String message, T actual, Matcher<? super T> matcher) {
        Description description = new StringDescription();
        if (matcher.matches(actual)) {
            description.appendText(ASSERT_THAT).appendText(message).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n     and: ");
            matcher.describeMismatch(actual, description);
//            log.info(description.toString());
        } else {
            description.appendText(ASSERT_THAT).appendText(message).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n     but: ");
            matcher.describeMismatch(actual, description);
            AssertionError assertionError = new AssertionError(description.toString());
//            log.error("Exception: {}", assertionError.getMessage());
            throw assertionError;
        }
    }
}