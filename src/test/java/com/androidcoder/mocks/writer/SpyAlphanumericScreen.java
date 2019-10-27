package com.androidcoder.mocks.writer;

import com.androidcoder.writer.AlphanumericScreen;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpyAlphanumericScreen implements AlphanumericScreen {

    private String actualText= "";

    @Override
    public void print(String text) {
        actualText += text;
    }

    public void verifyPrinted(String expectedText){
        assertThat("Alphanumeric screen display different text than expected", actualText, is(expectedText));
    }
}
