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
public class TomlPropertySourceLoaderOctTest {

    @Value("${number.oct.oct1}")
    private long oct1;
    @Value("${number.oct.oct2}")
    private long oct2;

    @Test
    public void testOct1() {
        assertThat(oct1, is(001234567L));
    }

    @Test
    public void testOct2() {
        assertThat(oct2, is(0755L));
    }


    @SpringBootApplication
    static class Application {
    }
}
