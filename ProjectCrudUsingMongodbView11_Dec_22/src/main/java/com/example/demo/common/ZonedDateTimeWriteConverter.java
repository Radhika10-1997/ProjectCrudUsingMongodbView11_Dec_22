package com.example.demo.common;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {

	@Override
	public Date convert(ZonedDateTime source) {
		// TODO Auto-generated method stub
		return Date.from(source.toInstant());
	}

}
