package com.transform.game.value;

public class GameStatus {
	private boolean success; 
	private String message;
	/**
	 * @param success
	 * @param message
	 */
	public GameStatus(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public GameStatus() {
		super();
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GameStatus{" +
				"success=" + success +
				", message='" + message + '\'' +
				'}';
	}
}
