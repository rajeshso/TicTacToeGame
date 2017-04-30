package com.transform.game.value;

public class StartGame {
	private String id;
	private String player;
	private String counterPlayer;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getCounterPlayer() {
		return counterPlayer;
	}
	public void setCounterPlayer(String counterPlayer) {
		this.counterPlayer = counterPlayer;
	}

	@Override
	public String toString() {
		return "StartGame{" +
				"id='" + id + '\'' +
				", player='" + player + '\'' +
				", counterPlayer='" + counterPlayer + '\'' +
				'}';
	}
}
