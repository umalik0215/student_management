package com.test.helper;

import java.util.List;

public class ResponsesEntity {

	private Object data;
	private List<String> message;

	public ResponsesEntity() {
	}

	public ResponsesEntity(Object data, List<String> message) {
		super();
		this.data = data;
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

}
