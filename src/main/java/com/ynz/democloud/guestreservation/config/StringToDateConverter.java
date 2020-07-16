package com.ynz.democloud.guestreservation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date parsed = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            parsed = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            log.info("Parse exception: ", e);
        }

        return parsed;
    }
}
