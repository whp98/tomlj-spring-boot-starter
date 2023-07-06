package com.github.whp98.springframework.boot.env;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TomlPropertySourceLoaderStringNoEscapeMuiltRowTest {
    @Value("${string.no_escape_muilt_row.re}")
    private String re;
    @Value("${string.no_escape_muilt_row.lines}")
    private String lines;

    @Test
    public void testPath() {
        assertThat(re, is("I [dw]on't need \\d{2} apples"));
    }

    @Test
    public void testPath2() {
        assertThat(lines, equalTo("原始字符串中的\r\n" +
                "第一个换行被剔除了。\r\n" +
                "所有其它空白\r\n" +
                "都保留了。\r\n"));
    }


    @SpringBootApplication
    static class Application {
    }
}
