package com.transform.game.model.grid;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.transform.game.model.InvalidPlaceException;
import com.transform.game.model.InvalidRemoveException;
import com.transform.game.model.InvalidStartException;
import com.transform.game.model.grid.TicTacToe;
import com.transform.game.model.service.GameContext;

public class TicTacToeScenarios {

	/**
	 * Scenario 1 TicTacToe is initialized Player A starts the game Player A and
	 * B play the game Player A wins
	 */
	@Test
	public final void testScenario1() {
		try {
			TicTacToe gc = new TicTacToe("A", "B");
			// Initialized
			assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.getPlayer()).isEqualTo("A");
			assertThat(gc.getCounterPlayer()).isEqualTo("B");

			// Player A first move
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(0, 2, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			//Player A Duplicate move becomes invalid
			try {
				assertThat(gc.placeMark(0, 2, "A")).isFalse();
				fail("Exception is expected here");
			}catch(InvalidPlaceException e) {
				assertThat(e).hasMessage("Player A is not in this turn");
			}
			
			//Player B places in the non empty cell
			try {
				assertThat(gc.placeMark(0, 2, "B")).isFalse();
				fail("Exception is expected here");
			}catch(InvalidPlaceException e) {
				assertThat(e).hasMessage("The row and col position is full. Sorry");
			}
			
			//Player B corrects himself and continues the game
			assertThat(gc.whosTurn()).isEqualTo("B");
			assertThat(gc.placeMark(0, 0, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("A");
			
			//Player A 
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(1, 2, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			//Player B
			assertThat(gc.whosTurn()).isEqualTo("B");
			assertThat(gc.placeMark(1, 0, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("A");
			
			//Player A 
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(2, 2, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("COMPLETE_WIN");
			assertThat(gc.checkForWin()).isTrue();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			//Player B tries a completed game
			try {
				gc.placeMark(2, 0, "B");
				fail("Exception is expected here");
			}catch(InvalidPlaceException e) {
				assertThat(e).hasMessage("Oops! Game is over");
			}
			
			//Winner is A
			assertThat(gc.getWinner()).isEqualTo("A");
		} catch (Exception e) {
			fail("Exception is not expected here");
		}
	}
	
	/**
	 * Scenario 2 TicTacToe is initialized. Player A and B play.
	 * The game ends in a draw
	 */
	@Test
	public final void testScenario2() {
		try {
			TicTacToe gc = new TicTacToe("A", "B");
			// Initialized
			assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.getPlayer()).isEqualTo("A");
			assertThat(gc.getCounterPlayer()).isEqualTo("B");

			// Player A first move
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(0, 0, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
		
			//Player B continues the game
			assertThat(gc.whosTurn()).isEqualTo("B");
			assertThat(gc.placeMark(0, 1, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("A");
			
			//Player A 
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(1,0, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			//Player B
			assertThat(gc.whosTurn()).isEqualTo("B");
			assertThat(gc.placeMark(1, 1, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("A");
			
			//Player A 
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(2,1, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			
			//Both fill the board but do not win			
			assertThat(gc.placeMark(1, 2, "B")).isTrue();
			assertThat(gc.placeMark(0,2, "A")).isTrue();
			assertThat(gc.placeMark(2, 0, "B")).isTrue();
			assertThat(gc.placeMark(2, 2, "A")).isTrue();
			
			assertThat(gc.getGameStatus()).isEqualTo("COMPLETE_DRAW");
			assertThat(gc.getWinner()).isEqualTo("");
			try {
			assertThat(gc.placeMark(2, 2, "B")).isTrue();
			}catch(InvalidPlaceException e) {
				assertThat(e).hasMessage("Oops! Game is over");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail("Exception is not expected here");
		}
	}
	/**
	 * Scenario 3 TicTacToe is initialized. Player A and B play.
	 * The game ends with a winner based on Diagnol win
	 */
	@Test
	public final void testScenario3() {
		try {
			TicTacToe gc = new TicTacToe("A", "B");
			// Initialized
			assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.getPlayer()).isEqualTo("A");
			assertThat(gc.getCounterPlayer()).isEqualTo("B");

			// Player A first move
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(0, 2, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
		
			//Player B continues the game
			assertThat(gc.whosTurn()).isEqualTo("B");
			assertThat(gc.placeMark(0, 0, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("A");
			
			//Player A 
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(1, 2, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			//Player B
			assertThat(gc.whosTurn()).isEqualTo("B");
			assertThat(gc.placeMark(2, 2, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("A");
			
			//Player A 
			assertThat(gc.whosTurn()).isEqualTo("A");
			assertThat(gc.placeMark(1, 0, "A")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("PLAYING");
			assertThat(gc.checkForWin()).isFalse();
			assertThat(gc.whosTurn()).isEqualTo("B");
			
			//Both fill the board till win			
			assertThat(gc.placeMark(2, 0, "B")).isTrue();
			assertThat(gc.placeMark(0, 1, "A")).isTrue();
			assertThat(gc.placeMark(1, 1, "B")).isTrue();
			assertThat(gc.getGameStatus()).isEqualTo("COMPLETE_WIN");
			//Winner is B
			assertThat(gc.getWinner()).isEqualTo("B");
		} catch (Exception e) {
			fail("Exception is not expected here");
		}
	}
}
