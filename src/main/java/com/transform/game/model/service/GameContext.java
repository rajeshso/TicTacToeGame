package com.transform.game.model.service;


import com.transform.game.conf.ApplicationConfiguration;
import com.transform.game.model.InvalidStartException;
import com.transform.game.model.grid.Game;

/**
 * Created by Rajesh on 29-Apr-17.
 */
public class GameContext {
    private String id;
    private Game game;
    private String player;
    private String counterPlayer;

    public GameContext(String id, Game game) throws InvalidStartException {
    	this.id = id;
        this.game = game;
        this.player = game.getPlayer();
        this.counterPlayer = game.getCounterPlayer();
        if (!ApplicationConfiguration.containsPlayerId(this.player))
            throw new InvalidStartException(this.player + " is not valid");
        if (!ApplicationConfiguration.containsPlayerId(this.counterPlayer))
            throw new InvalidStartException(this.counterPlayer + " is not valid");
    }
    public String getId() {
        return id;
    }
    public Game getGame() {
        return game;
    }

    public String getPlayer() {
        return player;
    }

    public String getCounterPlayer() {
        return counterPlayer;
    }
    public String getGameStatus() {
        return game.getGameStatus();
    }
    public String getWinner() {
        return game.getWinner();
    }
    public String whosNextTurn() {
        return game.whosTurn();
    }
    public String getCurrentBoardImage() {
        return game.getPrintBoard();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nPlayer 1 is "+ player + " and the Player 2 is "+ counterPlayer);
        builder.append("\nGame Status is "+ getGameStatus());
        builder.append("\nCurrent Game Board is \n");
        builder.append(getCurrentBoardImage());
        return builder.toString();
    }
}
