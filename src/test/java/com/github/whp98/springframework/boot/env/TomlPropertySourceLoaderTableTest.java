package com.github.whp98.springframework.boot.env;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TomlPropertySourceLoaderTableTest {
    @Value("${table-1.key1}")
    private String key1;
    @Value("${dog.tater.man.type.name}")
    private String name;
    @Value("${dog.tater.man.animal.type.name}")
    //    内联表
    private String animalName;
    /*表数组*/
    @Resource
    TableArrayConfigurationProperties tableArrayConfigurationProperties;

    @Test
    public void testAll() {
        assertThat(key1, is("some string"));
        assertThat(name, is("pug"));
        assertThat(animalName, is("pug"));
    }

    @Test
    public void testTableArray(){
        //不支持表数组注入
        //System.out.println(tableArrayConfigurationProperties);
    }


    @SpringBootApplication
    static class Application {
    }
}
