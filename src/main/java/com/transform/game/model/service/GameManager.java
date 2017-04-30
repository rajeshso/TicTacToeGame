package com.transform.game.model.service;

import com.transform.game.model.InvalidRemoveException;
import com.transform.game.model.InvalidStartException;
import com.transform.game.model.grid.Game;
import com.transform.game.model.grid.TicTacToe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rajesh on 29-Apr-17.
 */
public final class GameManager {
    private static final GameManager instance = new GameManager();
    private final ConcurrentHashMap<String, GameContext> games = new ConcurrentHashMap<>(10);
    private GameManager() {}
    public static GameManager getInstance() {
        return instance;
    }
    public boolean containsId(String id) {
        return games.containsKey(id);
    }
    public void createTicTacToeGame(String id, String player, String counterPlayer) throws InvalidStartException {
    	if (containsId(id)) throw new InvalidStartException("The id "+id+" is duplicated");
        Game game = new TicTacToe(player, counterPlayer);
        GameContext gameContext = new GameContext(id, game);
        games.put(id, gameContext);
    }
    public GameContext getGameContext(String id) {
        return games.get(id);
    }
    public void removeGame(String id, String player) throws InvalidRemoveException {
        if (!containsId(id)) 
        	throw new InvalidRemoveException("id "+id + " does not exist");
        GameContext gameContext = getGameContext(id);
        if(!gameContext.getGame().containsPlayer(player)) 
        	throw new InvalidRemoveException("player "+player+" is not eligible to remove");;
       	games.remove(id);
    }
}
