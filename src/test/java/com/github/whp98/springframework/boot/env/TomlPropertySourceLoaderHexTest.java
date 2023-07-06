package com.github.whp98.springframework.boot.env;

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
public class TomlPropertySourceLoaderHexTest {

    @Value("${number.hex.hex1}")
    private long hex1;
    @Value("${number.hex.hex2}")
    private long hex2;
    @Value("${number.hex.hex3}")
    private long hex3;

    @Test
    public void testHex1() {
        assertThat(hex1, is(0xDEADBEEFL));
    }

    @Test
    public void testHex2() {
        assertThat(hex2, is(0xdeadbeefL));
    }

    @Test
    public void testHex3() {
        assertThat(hex3, is(0xdead_beefL));
    }


    @SpringBootApplication
    static class Application {
    }
}
