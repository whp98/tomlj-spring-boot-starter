package io.github.whp98.springframework.boot.env;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TomlPropertySourceLoaderStringEscapeOneRowTest {

    @Value("${string.escape_one_row.str1}")
    private String str1;
    @Value("${string.escape_one_row.str2}")
    private String str2;
    @Value("${string.escape_one_row.str3}")
    private String str3;

    @Test
    public void testStr1() {
        assertThat(str1, is("I'm a string."));
    }

    @Test
    public void testStr2() {
        assertThat(str2, is("You can \"quote\" me."));
    }

    @Test
    public void testStr3() {
        assertThat(str3, is("Name\tJos\u00E9\nLoc\tSF."));
    }

    @SpringBootApplication
    static class Application {
    }
}
