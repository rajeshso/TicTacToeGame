package com.transform.game.value;

public class PlaceMark { 
	private String gameId;
	private char player;
	private int row;
	private int col;
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public char getPlayer() {
		return player;
	}
	public void setPlayer(char player) {
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
}
