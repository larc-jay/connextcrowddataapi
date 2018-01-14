package com.connextcrowd.wrapper;

import com.connextcrowd.util.ResponseEnums.StatusCode;

public class ServiceResponse<T> {
	private ResStatus status;
	private String message;
	private T data;
	private String errorStackTrace;
	private StatusCode statusCode;

	public ResStatus getStatus() {
		return status;
	}

	public void setStatus(ResStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorStackTrace() {
		return errorStackTrace;
	}

	public void setErrorStackTrace(String errorStackTrace) {
		this.errorStackTrace = errorStackTrace;
	}
	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return String.format("Response [data=%s, message=%s, status=%s]", data, message, status);
	}
	public enum ResStatus {
		SUCCESS, WARNING, ERROR;

		public String toString() {
			return this.name().toLowerCase();
		}
	}
}
