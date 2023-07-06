package com.github.whp98.springframework.boot.env;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TomlPropertySourceLoaderDateTimeTest {
    @Value("${date.zone.odt1}")
    private OffsetDateTime zoneDate1;
    @Value("${date.zone.odt2}")
    private OffsetDateTime zoneDate2;
    @Value("${date.zone.odt3}")
    private OffsetDateTime zoneDate3;
    // no zone local datetime
    @Value("${date.nozone.ldt1}")
    private LocalDateTime nozoneDate1;
    @Value("${date.nozone.ldt2}")
    private LocalDateTime nozoneDate2;
    /*local date*/
    @Value("${date.one_day.ld1}")
    private LocalDate oneDay;
    /*local time*/
    @Value("${date.time.lt1}")
    private LocalTime localTime1;
    @Value("${date.time.lt2}")
    private LocalTime localTime2;

    // 定义日期时间格式
    DateTimeFormatter isoOffsetDateTime = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Test
    public void testZone() {
        OffsetDateTime dateTime1 = OffsetDateTime.parse("1979-05-27T07:32:00Z", isoOffsetDateTime);
        assertThat(zoneDate1, is(dateTime1));
        OffsetDateTime dateTime2 = OffsetDateTime.parse("1979-05-27T00:32:00-07:00", isoOffsetDateTime);
        assertThat(zoneDate2, is(dateTime2));
        OffsetDateTime dateTime3 = OffsetDateTime.parse("1979-05-27T00:32:00.999999-07:00", isoOffsetDateTime);
        assertThat(zoneDate3, is(dateTime3));
    }

    //本地日期时间格式化
    DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Test
    public void testNoZone() {
        LocalDateTime dateTime1 = LocalDateTime.parse("1979-05-27T07:32:00", isoLocalDateTime);
        LocalDateTime dateTime2 = LocalDateTime.parse("1979-05-27T00:32:00.999999", isoLocalDateTime);
        assertThat(nozoneDate1, is(dateTime1));
        assertThat(nozoneDate2, is(dateTime2));
    }

    @Test
    public void testOneDate() {
        LocalDate localDate = LocalDate.parse("1979-05-27", DateTimeFormatter.ISO_LOCAL_DATE);
        assertThat(oneDay, is(is(localDate)));
    }

    /*本地时间*/
    @Test
    public void testLocalTime() {
        LocalTime lt1 = LocalTime.parse("07:32:00", DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTime lt2 = LocalTime.parse("00:32:00.999999", DateTimeFormatter.ISO_LOCAL_TIME);
        assertThat(localTime1, is(is(lt1)));
        assertThat(localTime2, is(is(lt2)));
    }

    @SpringBootApplication
    static class Application {
    }
}




