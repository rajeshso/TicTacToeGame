package com.transform.game.model.service;

import com.transform.game.model.InvalidPlaceException;
import com.transform.game.model.InvalidRemoveException;
import com.transform.game.model.InvalidStartException;
import com.transform.game.model.grid.Game;
import com.transform.game.model.grid.TicTacToe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This is the GameManager Service Model. The API can be used by a command line or a GUI or a Rest API
 * This is a Singleton.
 */
public final class GameManager {
    private static final GameManager instance = new GameManager();
    private final ConcurrentHashMap<String, GameContext> games = new ConcurrentHashMap<>(10);
    private GameManager() {}
    public static GameManager getInstance() {
        return instance;
    }
    /**
     * Check if a unique Game ID exists
     * 
     * @param id
     * @return true if exists
     */
    public boolean containsId(String id) {
        return games.containsKey(id);
    }
    /**
     * Use this method to start a game.
     * Remember that only the player can start and remove the game.
     * The players should be from the configured set of players
     * 
     * @param id unique id
     * @param player registered player
     * @param counterPlayer a registered player
     * @throws InvalidStartException If the input is incorrect
     */
    public void createTicTacToeGame(String id, String player, String counterPlayer) throws InvalidStartException {
    	if (containsId(id)) throw new InvalidStartException("The id "+id+" is duplicated");
        Game game = new TicTacToe(player, counterPlayer);
        GameContext gameContext = new GameContext(id, game);
        games.put(id, gameContext);
    }
    
    /**
     * Every game has a context.
     * It is a container to hold the players and the state of the game 
     * 
     * @param id
     * @return
     */
    public GameContext getGameContext(String id) {
        return games.get(id);
    }
    /**
     * Place the player's mark
     * 
     * @param id
     * @param row
     * @param col
     * @param player
     * @return
     * @throws InvalidPlaceException
     */
    public boolean placeMark(String id, int row, int col, String player) throws InvalidPlaceException {
    	GameContext gc = getGameContext(id);
    	Game game = gc.getGame();
    	return game.placeMark(row, col, player);
    }
    
    /**
     * The player can remove the game from the tournament.
     * @param id
     * @param player
     * @throws InvalidRemoveException
     */
    public void removeGame(String id, String player) throws InvalidRemoveException {
        if (!containsId(id)) 
        	throw new InvalidRemoveException("id "+id + " does not exist");
        GameContext gameContext = getGameContext(id);
        if(!gameContext.getGame().containsPlayer(player)) 
        	throw new InvalidRemoveException("player "+player+" is not eligible to remove");;
       	games.remove(id);
    }
    
    public String getGameStatus(String id) throws Exception {
    	if (!containsId(id)) 
    		throw new Exception("Incorrect Game ID");
    	GameContext gameContext = getGameContext(id);
    	StringBuilder builder = new StringBuilder();
    	builder.append("\nGame Status = " + gameContext.getGameStatus());
    	builder.append("\nGame Board = "+ gameContext.getCurrentBoardImage());
    	builder.append("\nPlayer = "+ gameContext.getPlayer());
    	builder.append("\nCounter Player = "+ gameContext.getCounterPlayer());
    	builder.append("\nWhos next turn = "+ gameContext.whosNextTurn());
    	builder.append("\nWinner = "+ gameContext.getWinner());
    	return builder.toString();
    }
}
