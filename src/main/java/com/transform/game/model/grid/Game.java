package com.transform.game.model.grid;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rajesh on 29-Apr-17.
 */
public abstract class Game {

    protected static final char COUNTER_PLAYER_MARK = 'o';
	protected static final char EMPTY_MARK = '-';
	protected static final char PLAYER_MARK = 'x';
	protected static final String OUTER_DELIMITER = "| ";
	protected static final String INNER_DELIMITER = " | ";
    protected GAME_OPERATION gameStatus = GAME_OPERATION.INITIALIZED;
    protected String winner = "";
    protected Map<String,Character> players = new HashMap<>(2);
    protected char[][] grid;
    protected String player;
    protected String counterPlayer;

	// Print the current grid
    public abstract String getPrintBoard();

    public abstract boolean checkForWin();

    // Tells which player's turn is next
    public abstract String whosTurn();

    public String getWinner() {
        return winner;
    }

    public String getGameStatus() {
        return gameStatus.name();
    }

    // Places a mark at the cell specified by row and col with the mark of the given player.
    public abstract boolean placeMark(int row, int col, String player);

    public static enum GAME_OPERATION {
        INITIALIZED,
        PLAYING,
        COMPLETE_WIN,
        COMPLETE_DRAW;
    }
    public boolean containsPlayer(String player) {
    	return players.keySet().contains(player);
    }
    
    public String getPlayer() {
		return player;
	}

	public String getCounterPlayer() {
		return counterPlayer;
	}
}
