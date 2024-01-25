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
public class TomlPropertySourceLoaderIntTest {

    @Value("${number.int.int1}")
    private long int1;
    @Value("${number.int.int2}")
    private long int2;
    @Value("${number.int.int3}")
    private long int3;
    @Value("${number.int.int4}")
    private long int4;

    @Test
    public void testInt1() {
        assertThat(int1, is(99L));
    }

    @Test
    public void testInt2() {
        assertThat(int2, is(42L));
    }

    @Test
    public void testInt3() {
        assertThat(int3, is(0L));
    }

    @Test
    public void testInt4() {
        assertThat(int4, is(-17L));
    }


    @SpringBootApplication
    static class Application {
    }
}
