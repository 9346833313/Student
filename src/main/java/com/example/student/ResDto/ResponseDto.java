package com.example.student.ResDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {

	@JsonProperty("StatusCode")
	private Integer statusCode;
	@JsonProperty("isError")
	private Object isError;
	@JsonProperty("Result")
	private Object result;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Object getIsError() {
		return isError;
	}
	public void setIsError(Object isError) {
		this.isError = isError;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}

	
}
