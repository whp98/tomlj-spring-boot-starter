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
public class TomlPropertySourceLoaderInfiniteTest {

    @Value("${number.infinity.infinite1}")
    private Double inf1;
    @Value("${number.infinity.infinite2}")
    private Double inf2;
    @Value("${number.infinity.infinite3}")
    private Double inf3;

    @Test
    public void testInf1() {
        assertThat(inf1, is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testInf2() {
        assertThat(inf2, is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testInf3() {
        assertThat(inf3, is(Double.NEGATIVE_INFINITY));
    }

    @SpringBootApplication
    static class Application {
    }
}
