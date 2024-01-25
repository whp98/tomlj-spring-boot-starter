package io.github.whp98.springframework.boot.env;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author whp98
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(@Nullable String source) {
        if (source != null) {
            return LocalDate.parse(source, DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return null;
        }
    }
}
