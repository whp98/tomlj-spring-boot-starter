package com.github.whp98.springframework.boot.env;


import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.tomlj.Toml;
import org.tomlj.TomlArray;
import org.tomlj.TomlParseResult;
import org.tomlj.TomlTable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;

/**
 * Strategy to load TOML files into a {@link PropertySource}.
 *
 * @author whp98
 */
public class TomlPropertySourceLoader implements PropertySourceLoader {

    /**
     * Returns the file extensions that the loader supports (excluding the '.').
     *
     * @return the file extensions
     */
    @Override
    public String[] getFileExtensions() {
        return new String[]{"toml"};
    }

    /**
     * Load the resource into one or more property sources. Implementations may either
     * return a list containing a single source, or in the case of a multi-document format
     * such as yaml a source for each document in the resource.
     *
     * @param name     the root name of the property source. If multiple documents are loaded
     *                 an additional suffix should be added to the name for each source loaded.
     * @param resource the resource to load
     * @return a list property sources
     * @throws IOException if the source cannot be loaded
     */
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        if (!resource.exists()) {
            return emptyList();
        }
        TomlParseResult parseResult = Toml.parse(resource.getInputStream());
        parseResult.errors().forEach(error -> System.err.println(error.toString()));
        Map<String, Object> source = parseResult.toMap();
        if (source.isEmpty()) {
            return emptyList();
        }
        Map<String, Object> result = new LinkedHashMap<>();
        buildFlattenedMap(result, source, null);
        return singletonList(new MapPropertySource(name, result));
    }

    /**
     * 平展map 为k,v格式
     */
    private void buildFlattenedMap(Map<String, Object> result, Map<String, Object> source, String root) {
        boolean rootHasText = (null != root && !root.trim().isEmpty());

        source.forEach((key, value) -> {
            String path;

            if (rootHasText) {
                if (key.startsWith("[")) {
                    path = root + key;
                } else {
                    path = root + "." + key;
                }
            } else {
                path = key;
            }

            if (value instanceof TomlTable) {
                Map<String, Object> map = ((TomlTable) value).toMap();
                buildFlattenedMap(result, map, path);
            } else if (value instanceof TomlArray) {
                Collection<Object> collection = ((TomlArray) value).toList();
                int count = 0;
                for (Object object : collection) {
                    buildFlattenedMap(result, singletonMap("[" + (count++) + "]", object), path);
                }
            } else {
                if (value instanceof LocalDateTime) {
                    /*localDateTime会被 FormattingConversionServiceFactoryBean.java 转化成本地日期,这里改成String*/
                    String stringValue = ((LocalDateTime) value).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    result.put(path, stringValue);
                } else if (value instanceof LocalDate) {
                    String stringValue = ((LocalDate) value).format(DateTimeFormatter.ISO_LOCAL_DATE);
                    result.put(path, stringValue);
                } else if (value instanceof LocalTime) {
                    String stringValue = ((LocalTime) value).format(DateTimeFormatter.ISO_LOCAL_TIME);
                    result.put(path, stringValue);
                } else {
                    result.put(path, null == value ? "" : value);
                }
            }
        });
    }
}
