package com.transform.game.value;

public class GameStatusRequest {
	private String id;
	private String player;

	@Override
	public String toString() {
		return "GameStatusRequest{" +
				"id='" + id + '\'' +
				", player='" + player + '\'' +
				'}';
	}

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
}
