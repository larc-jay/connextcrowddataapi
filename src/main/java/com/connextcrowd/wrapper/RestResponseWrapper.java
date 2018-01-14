package com.connextcrowd.wrapper;

public class RestResponseWrapper<T> {
	private T entity;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
}
