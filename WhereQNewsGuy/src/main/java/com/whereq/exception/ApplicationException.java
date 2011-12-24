package com.whereq.exception;

public class ApplicationException extends Exception {
	private Exception applicationException;

	public ApplicationException(Exception e) {
		this.applicationException = e;
	};
}
