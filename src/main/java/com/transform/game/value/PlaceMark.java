package com.transform.game.value;

public class PlaceMark { 
	private String gameId;
	private String player;
	private int row;
	private int col;
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "PlaceMark{" +
				"gameId='" + gameId + '\'' +
				", player='" + player + '\'' +
				", row=" + row +
				", col=" + col +
				'}';
	}
}
