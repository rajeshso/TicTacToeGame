package com.transform.game.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.transform.game.value.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class GameController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/startGame", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> startGame(@RequestBody StartGame startGame) {
        logger.debug("startGame called with "+ startGame);
    	return new ResponseEntity<GameStatus>(new GameStatus(), HttpStatus.OK);
    }
    @RequestMapping(value = "/placeMark", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> placeMark(@RequestBody PlaceMark placeMark) {
        logger.debug("placeMark called with "+ placeMark);
        return new ResponseEntity<GameStatus>(new GameStatus(), HttpStatus.OK);
    }
    @RequestMapping(value = "/completeGame", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> completeGame(@RequestBody CompleteGame completeGame) {
        logger.debug("completeGame called with "+ completeGame);
        return new ResponseEntity<GameStatus>(new GameStatus(), HttpStatus.OK);
    }
    @RequestMapping(value = "/gameStatus", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> gameStatus(@RequestBody GameStatusRequest gameStatusRequest) {
        logger.debug("gameStatus called with "+ gameStatusRequest);
        return new ResponseEntity<GameStatus>(new GameStatus(), HttpStatus.OK);
    }
}
