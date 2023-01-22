package com.example.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.common.DateUtils;

@Component
public class LogicUtils {
	 private final MessageSource messageSource;

	    private final DateUtils dateUtils;

	    @Autowired
	    public LogicUtils(MessageSource messageSource, DateUtils dateUtils) {

	        this.messageSource = messageSource;
	        this.dateUtils = dateUtils;
	    }
	    
	    public String getIllegalGuidMessage(String inputGuid) {

	        return messageSource.getMessage("illegal.object.guid", new String[] {inputGuid},
	                LocaleContextHolder.getLocale());
	    }
	    
	    public String getPowerBiUrlExpired() {

	        return messageSource.getMessage("powerbi.url.expired", null,
	                LocaleContextHolder.getLocale());
	    }

}
