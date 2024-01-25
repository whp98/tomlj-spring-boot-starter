package io.github.whp98.springframework.boot.env;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author whp98
 */
public class StringToLocalTimeConverter implements Converter<String, LocalTime> {
    @Override
    public LocalTime convert(@Nullable String source) {
        if (source != null) {
            return LocalTime.parse(source, DateTimeFormatter.ISO_LOCAL_TIME);
        } else {
            return null;
        }
    }
}
