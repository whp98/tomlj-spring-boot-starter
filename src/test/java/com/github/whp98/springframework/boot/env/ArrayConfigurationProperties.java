package com.github.whp98.springframework.boot.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author whp98
 */
@Component
@ConfigurationProperties(prefix = "array")
public class ArrayConfigurationProperties {
    private Integer[] integers;
    private String[] colors;
    private int[][] nested_array_of_ints;

    private Object[][] nested_mixed_array;
    private String[] string_array;

    private Object[] numbers;

    private Object contributors;

    public Integer[] getIntegers() {
        return integers;
    }

    public void setIntegers(Integer[] integers) {
        this.integers = integers;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public int[][] getNested_array_of_ints() {
        return nested_array_of_ints;
    }

    public void setNested_array_of_ints(int[][] nested_array_of_ints) {
        this.nested_array_of_ints = nested_array_of_ints;
    }

    public Object[][] getNested_mixed_array() {
        return nested_mixed_array;
    }

    public void setNested_mixed_array(Object[][] nested_mixed_array) {
        this.nested_mixed_array = nested_mixed_array;
    }

    public String[] getString_array() {
        return string_array;
    }

    public void setString_array(String[] string_array) {
        this.string_array = string_array;
    }

    public Object[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Object[] numbers) {
        this.numbers = numbers;
    }

    public Object getContributors() {
        return contributors;
    }

    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }
}
