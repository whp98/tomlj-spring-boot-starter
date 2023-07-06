package com.github.whp98.springframework.boot.env;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TomlPropertySourceLoaderStringNoEscapeOneRowTest {
    @Value("${string.no_escape_one_row.path}")
    private String path;
    @Value("${string.no_escape_one_row.path2}")
    private String path2;
    @Value("${string.no_escape_one_row.quoted}")
    private String quoted;
    @Value("${string.no_escape_one_row.regex}")
    private String regex;

    @Test
    public void testPath() {
        assertThat(path, is("C:\\Users\\nodejs\\templates"));
    }

    @Test
    public void testPath2() {
        assertThat(path2, is("\\\\User\\admin$\\system32"));
    }

    @Test
    public void testQuote() {
        assertThat(quoted, is("Tom \"Dubs\" Preston-Werner"));
    }

    public void testRegex() {
        assertThat(regex, is("<\\i\\c*\\s*>"));
    }

    @SpringBootApplication
    static class Application {
    }
}
