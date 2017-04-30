package com.transform.game.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;

import com.transform.game.model.InvalidStartException;
import com.transform.game.model.grid.TicTacToe;

/**
 * Created by Rajesh on 30-Apr-17.
 */
public class GameContextTest {
  private final static String VALID_BORDER = "-------------";
  private final static String VALID_ALL_EMPTY_CELLS = "| - | - | - | ";
 @Test
 public void testGoodCreationOfGameContext() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("A","B"));
		assertThat(gc.getId()).isEqualTo("1");
		assertThat(gc.getPlayer()).isEqualTo("A");
		assertThat(gc.getCounterPlayer()).isEqualTo("B");
	} catch (InvalidStartException e) {
		fail("An Exception is not expected here");
	}
 }
 @Test
 public void testIfGameContextHandlesNonPlayersInTournaments() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("NonPlayerA","B"));
		fail("An Exception is not expected here");
	} catch (InvalidStartException e) {
		assertThat(e).hasMessage("NonPlayerA is not valid");
	}
 }
 @Test
 public void testIfGameContextHandlesNonCounterPlayersInTournaments() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("A","NonPlayerB"));
		fail("An Exception is not expected here");
	} catch (InvalidStartException e) {
		assertThat(e).hasMessage("NonPlayerB is not valid");
	}
 }
 @Test
 public void testGameStatusWhenGameHasNotStarted() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("A","B"));
		assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
	} catch (InvalidStartException e) {
		fail("Exception is not expected here");
	}
 }
 @Test
 public void testWinnerWhenGameHasNotStarted() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("A","B"));
		assertThat(gc.getWinner()).isEqualTo("");
	} catch (InvalidStartException e) {
		fail("Exception is not expected here");
	}
 }
 @Test
 public void testWhoIsNextTurnWhenGameHasNotStarted() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("A","B"));
		assertThat(gc.whosNextTurn()).isEqualTo("A");
	} catch (InvalidStartException e) {
		fail("Exception is not expected here");
	}
 }
 @Test
 public void testTicTacToeBoardWhenGameHasNotStarted() {
	 try {
		GameContext gc = new GameContext("1", new TicTacToe("A","B"));
		String board = gc.getCurrentBoardImage();
		String[] lines = board.split("\r\n|\r|\n|\r|\n|\r|\n|\r|\n\r|\n\r|\n");
		assertThat(lines.length).isEqualTo(7);
		assertThat(lines[0]).isEqualTo(VALID_BORDER);
		assertThat(lines[1]).isEqualTo(VALID_ALL_EMPTY_CELLS);
		assertThat(lines[2]).isEqualTo(VALID_BORDER);
		assertThat(lines[3]).isEqualTo(VALID_ALL_EMPTY_CELLS);
		assertThat(lines[4]).isEqualTo(VALID_BORDER);
		assertThat(lines[5]).isEqualTo(VALID_ALL_EMPTY_CELLS);
	} catch (InvalidStartException e) {
		fail("Exception is not expected here");
	}
 }
}
