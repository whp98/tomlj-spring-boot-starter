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
public class TomlPropertySourceLoaderFloatTest {

    @Value("${number.float.float1}")
    private Double float1;
    @Value("${number.float.float2}")
    private Double float2;
    @Value("${number.float.float3}")
    private Double float3;
    @Value("${number.float.float4}")
    private Double float4;
    @Value("${number.float.float5}")
    private Double float5;
    @Value("${number.float.float6}")
    private Double float6;
    @Value("${number.float.float7}")
    private Double float7;
    @Value("${number.float.float8}")
    private Double float8;

    @Test
    public void testFloat1() {
        assertThat(float1, is(new Double("1.0")));
    }

    @Test
    public void testFloat2() {
        assertThat(float2, is(new Double("3.1415")));
    }

    @Test
    public void testFloat3() {
        assertThat(float3, is(new Double("-0.01")));
    }

    @Test
    public void testFloat4() {
        assertThat(float4, is(new Double("5e+22")));
    }

    @Test
    public void testFloat5() {
        assertThat(float5, is(new Double("1e06")));
    }

    @Test
    public void testFloat6() {
        assertThat(float6, is(new Double("-2E-2")));
    }

    @Test
    public void testFloat7() {
        assertThat(float7, is(new Double("6.626e-34")));
    }

    @Test
    public void testFloat8() {
        assertThat(float8, is(new Double("224617.445991228")));
    }


    @SpringBootApplication
    static class Application {
    }
}
