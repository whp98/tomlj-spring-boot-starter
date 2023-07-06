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
public class TomlPropertySourceLoaderStringEscapeMuiltRowTest {

    @Value("${string.escape_muilt_row.str1}")
    private String str1;
    @Value("${string.escape_muilt_row.str2}")
    private String str2;

    @Test
    public void testStr1() {
        // https://stackoverflow.com/questions/15433188/what-is-the-difference-between-r-n-r-and-n
        // windows next line
        assertThat(str1, is("Roses are red\r\n" +
                "Violets are blue"));
    }

    @Test
    public void testStr2() {
        assertThat(str2, is("The quick brown fox jumps over the lazy dog."));
    }

    @SpringBootApplication
    static class Application {
    }
}
