package com.gangofconnectfour.powerfourservice.converter;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime locDateTime) {
        return locDateTime == null ? null : Date.from(locDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date sqlTimestamp) {
        Instant instant = Instant.ofEpochMilli(sqlTimestamp.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}