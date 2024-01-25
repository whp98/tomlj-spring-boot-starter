package io.github.whp98.springframework.boot.env;

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
public class TomlPropertySourceLoaderNaNTest {

    @Value("${number.number_nan.not1}")
    private Double nan1;
    @Value("${number.number_nan.not2}")
    private Double nan2;
    @Value("${number.number_nan.not3}")
    private Double nan3;

    @Test
    public void testNAN1() {
        assertThat(nan1, is(Double.NaN));
    }

    @Test
    public void testNAN2() {
        assertThat(nan2, is(Double.NaN));
    }

    @Test
    public void testNAN3() {
        assertThat(nan3, is(Double.NaN));
    }

    @SpringBootApplication
    static class Application {
    }
}
