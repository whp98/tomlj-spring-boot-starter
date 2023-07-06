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
public class TomlPropertySourceLoaderBinTest {

    @Value("${number.bin.bin1}")
    private long bin1;

    @Test
    public void testBin1() {
        assertThat(bin1, is(0b11010110L));
    }




    @SpringBootApplication
    static class Application {
    }
}
