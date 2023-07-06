package com.github.whp98.springframework.boot.env;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TomlPropertySourceLoaderArrayTest {
    @Resource
    ArrayConfigurationProperties arrayConfigurationProperties;

    @Test
    public void testArray1() {
        assertThat(arrayConfigurationProperties.getIntegers()[0], is(1));
    }

    @Test
    public void testArray2() {
        assertThat(arrayConfigurationProperties.getColors()[0], is("红"));
    }

    @Test
    public void testArray3() {
        assertThat(arrayConfigurationProperties.getNested_array_of_ints()[0][0], is(1));
    }

    @Test
    public void testArray4() {
        assertThat(arrayConfigurationProperties.getNested_mixed_array()[0][0], is(1L));
    }

    @Test
    public void testArray5() {
        assertThat(arrayConfigurationProperties.getString_array()[0], is("所有的"));
    }


    @Test
    public void testArray6() {
        assertThat(arrayConfigurationProperties.getNumbers()[3], is(1L));
    }

    @Test
    public void testArray7() {
//        assertThat(((Map<String, Object>) arrayConfigurationProperties.getContributors()[2]).get("email"),
//                is("bazqux@example.com"));
        //不支持混合类型
    }

    @SpringBootApplication
    static class Application {
    }
}
