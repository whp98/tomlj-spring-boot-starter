package com.github.whp98.springframework.boot.env;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author whp98
 */
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(@Nullable String source) {
        if (source != null) {
            return LocalDateTime.parse(source, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
        return null;
    }
}
