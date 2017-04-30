package com.transform.game.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transform.game.value.GameStatus;
import com.transform.game.value.Greeting;
import com.transform.game.value.StartGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class GameController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("Hi");
    	logger.info("Hello");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ResponseEntity<GameStatus> startGame(@RequestBody StartGame startGame) {
    	return new ResponseEntity<GameStatus>(new GameStatus(), HttpStatus.OK);
    }
}
