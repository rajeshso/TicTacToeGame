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

public class TicTacToeTest {
	private final static String VALID_BORDER = "-------------";
	private final static String VALID_ALL_EMPTY_CELLS = "| - | - | - | ";

	@Test
	public void testGetPrintBoardOnStart() {
		TicTacToe gc = new TicTacToe("A", "B");
		String board = gc.getPrintBoard();
		String[] lines = board.split("\r\n|\r|\n|\r|\n|\r|\n|\r|\n\r|\n\r|\n");
		assertThat(lines.length).isEqualTo(7);
		assertThat(lines[0]).isEqualTo(VALID_BORDER);
		assertThat(lines[1]).isEqualTo(VALID_ALL_EMPTY_CELLS);
		assertThat(lines[2]).isEqualTo(VALID_BORDER);
		assertThat(lines[3]).isEqualTo(VALID_ALL_EMPTY_CELLS);
		assertThat(lines[4]).isEqualTo(VALID_BORDER);
		assertThat(lines[5]).isEqualTo(VALID_ALL_EMPTY_CELLS);
	}



	@Test
	public final void testWhosTurnOnStart() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.whosTurn()).isEqualTo("A");
	}


	@Test
	public final void testGetWinnerBeforeStart() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.checkForWin()).isFalse();
	}
	
	@Test
	public final void testIfBoardIsFullBeforeStart() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.isBoardFull()).isFalse();
	}

	@Test
	public final void testGetGameStatusBeforeStart() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
	}

	@Test
	public final void testValidatePlaceMarkForIncorrectColumn() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
		try {
			gc.placeMark(10, 0, "A");
			fail("This is unexpected");
		}catch(InvalidPlaceException e) {
			assertThat(e).hasMessage("The row and col positions are incorrect");
		}
	}
	@Test
	public final void testValidatePlaceMarkForIncorrectRow() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
		try {
			gc.placeMark(0, 10, "A");
			fail("This is unexpected");
		}catch(InvalidPlaceException e) {
			assertThat(e).hasMessage("The row and col positions are incorrect");
		}
	}
	
	@Test
	public final void testValidatePlaceMarkForIncorrectPlayer() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
		try {
			gc.placeMark(0, 1, "C");
			fail("This is unexpected");
		}catch(InvalidPlaceException e) {
			assertThat(e).hasMessage("Player C is not in this game");
		}
	}
	
	@Test
	public final void testValidatePlaceMarkForIncorrectPlayerTurn() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.getGameStatus()).isEqualTo("INITIALIZED");
		try {
			gc.placeMark(0, 1, "B");
			fail("This is unexpected");
		}catch(InvalidPlaceException e) {
			assertThat(e).hasMessage("Player B is not in this turn");
		}
	}

}
