package com.transform.game.value;

public class GameStatus {
	private boolean success; 
	private String message;
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
