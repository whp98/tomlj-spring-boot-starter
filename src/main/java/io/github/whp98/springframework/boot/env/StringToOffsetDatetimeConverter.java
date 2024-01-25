package io.github.whp98.springframework.boot.env;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: 类型转换</p>
 * <p>Description: </p>
 *
 * @author whp98
 * @version 1
 */
public class StringToOffsetDatetimeConverter implements Converter<String, OffsetDateTime> {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Override
    public OffsetDateTime convert(@Nullable String source) {
        if (source != null) {
            return OffsetDateTime.parse(source, formatter);
        } else {
            return null;
        }
    }
}
