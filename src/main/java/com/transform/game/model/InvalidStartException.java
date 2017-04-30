package com.transform.game.model;

/**
 * Created by Rajesh on 30-Apr-17.
 */
public class InvalidStartException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public InvalidStartException(String message) {
		super(message);
	}
	
}
