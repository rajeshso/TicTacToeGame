package com.transform.game.controller;

import com.transform.game.model.service.GameManager;
import com.transform.game.value.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class GameController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/startGame", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> startGame(@RequestBody StartGame startGame) {
        logger.debug("startGame called with "+ startGame);
        GameStatus gs = new GameStatus();
        GameManager gm = GameManager.getInstance();
        try {
        	gm.createTicTacToeGame(startGame.getId(), startGame.getPlayer(), startGame.getCounterPlayer());
        	gs.setSuccess(true);
        	gs.setMessage("Game Started");
        }catch(Exception e) {
        	gs.setSuccess(false);
        	gs.setMessage(e.getMessage());
        }
        logger.debug("startGame Response is "+ gs);
    	return new ResponseEntity<GameStatus>(gs, HttpStatus.OK);
    }
    @RequestMapping(value = "/placeMark", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> placeMark(@RequestBody PlaceMark placeMark) {
        logger.debug("placeMark called with "+ placeMark);
        GameStatus gs = new GameStatus();
        GameManager gm = GameManager.getInstance();
        try {
        	if (gm.containsId(placeMark.getGameId())){
        		gs.setSuccess(gm.placeMark(placeMark.getGameId(), placeMark.getRow(), placeMark.getCol(), placeMark.getPlayer()));
        		gs.setMessage("Placed Mark");
        	}else {
        		gs.setSuccess(false);
        		gs.setMessage("Incorrect Game ID");
        	}
        }catch(Exception e) {
        	gs.setSuccess(false);
        	gs.setMessage(e.getMessage());
        }
        logger.debug("placeMark Response is "+ gs);
        return new ResponseEntity<GameStatus>(gs, HttpStatus.OK);
    }
    @RequestMapping(value = "/completeGame", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> completeGame(@RequestBody CompleteGame completeGame) {
        logger.debug("completeGame called with "+ completeGame);
        GameStatus gs = new GameStatus();
        GameManager gm = GameManager.getInstance();
        try {
        	gm.removeGame(completeGame.getId(), completeGame.getPlayer());
        	gs.setMessage("Game removed");
        	gs.setSuccess(true);
        }catch(Exception e) {
        	gs.setSuccess(false);
        	gs.setMessage(e.getMessage());
        }
        logger.debug("completeGame Response is "+ gs);
        return new ResponseEntity<GameStatus>(gs, HttpStatus.OK);
    }
    @RequestMapping(value = "/gameStatus", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> gameStatus(@RequestBody GameStatusRequest gameStatusRequest) {
        logger.debug("gameStatus called with "+ gameStatusRequest);
        GameStatus gs = new GameStatus();
        GameManager gm = GameManager.getInstance();
        try {
        	gs.setMessage(gm.getGameStatus(gameStatusRequest.getId()));
        	gs.setSuccess(true);
        }catch(Exception e) {
        	gs.setSuccess(false);
        	gs.setMessage(e.getMessage());
        }
        logger.debug("gameStatus Response is "+ gs);
        return new ResponseEntity<GameStatus>(gs, HttpStatus.OK);
    }
}
