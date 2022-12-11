package com.example.demo.api.response;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

	    private static final int FAIL_STATUS = 0;

	    private static final int SUCCESS_STATUS = 1;

	    private static final String SUCCESS_MSG = "Success";

	    private static final String ERROR_MSG = "Fail";

	    private static final String RECORD_NOT_FOUND = "Record Not Found";

	    private int status = 1;

	    private HttpStatus httpStatus;

	    private String message;

	    private List<String> errors;

	    private Object result;

	    public BaseResponse() {

	        super();
	        this.status = 1;
	        this.message = SUCCESS_MSG;

	    }

	    public <T> BaseResponse(int status, String message, List<String> errors, T result) {

	        super();
	        this.status = status;
	        this.message = message;
	        this.errors = errors;
	        this.result = result;
	    }

	    public BaseResponse(int status, HttpStatus httpStatus, String message) {

	        super();
	        this.status = status;
	        this.httpStatus = httpStatus;
	        this.message = message;
	    }

	    public BaseResponse(int status, HttpStatus httpStatus, String message, List<String> errors) {

	        super();
	        this.status = status;
	        this.httpStatus = httpStatus;
	        this.message = message;
	        this.errors = errors;
	    }

	    public BaseResponse(int status, HttpStatus httpStatus, String message, String error) {

	        super();
	        this.status = status;
	        this.httpStatus = httpStatus;
	        this.message = message;
	        this.errors = Arrays.asList(error);
	    }

	    public BaseResponse(List<String> errors) {

	        this(FAIL_STATUS, ERROR_MSG, errors, null);
	    }

	    public <T> BaseResponse(String message, T result) {

	        this(SUCCESS_STATUS, message, null, result);
	    }

	    public <T> BaseResponse(T result) {

	        this(SUCCESS_STATUS, SUCCESS_MSG, null, result);
	    }

	    public BaseResponse(int status, String message) {

	        this(status, message, null, null);
	    }

	    public <T> BaseResponse(String message, List<T> result) {

	        this(1, message, null, result);
	        if(Objects.isNull(result)) {
	            result = Collections.emptyList();
	        }
	        if(result.isEmpty()) {
	            this.message = RECORD_NOT_FOUND;
	        }
	        if(this.message == null) {
	            this.message = SUCCESS_MSG;
	        }
	    }

	    public <T> BaseResponse(String message, Set<T> result) {

	        this(1, message, null, result);
	        if(result.isEmpty()) {
	            this.message = RECORD_NOT_FOUND;
	        }
	        if(this.message == null) {
	            this.message = SUCCESS_MSG;
	        }
	    }

	    public int getStatus() {

	        return status;
	    }

	    public void setStatus(int status) {

	        this.status = status;
	        if(this.status == FAIL_STATUS) {
	            this.message = ERROR_MSG;
	        }
	        if(this.status == SUCCESS_STATUS) {
	            this.message = SUCCESS_MSG;
	        }
	    }

	    public String getMessage() {

	        return message;
	    }

	    public void setMessage(String message) {

	        this.message = message;
	    }

	    public List<String> getErrors() {

	        return errors;
	    }

	    public void setErrors(List<String> errors) {

	        this.errors = errors;
	    }

	    public Object getResult() {

	        return result;
	    }

	    public void setResult(Object result) {

	        if(Objects.isNull(result)) {
	            this.status = FAIL_STATUS;
	            this.message = ERROR_MSG;

	        }
	        this.result = result;
	    }

	    public HttpStatus getHttpStatus() {

	        return httpStatus;
	    }

	    public void setHttpStatus(HttpStatus httpStatus) {

	        this.httpStatus = httpStatus;
	    }

	}


