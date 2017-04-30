package com.transform.game.model.grid;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

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

	@Ignore
	public final void testCheckForWin() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWhosTurnOnStart() {
		TicTacToe gc = new TicTacToe("A", "B");
		assertThat(gc.whosTurn()).isEqualTo("A");
	}

	@Ignore
	public final void testPlaceMark() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	public final void testTicTacToe() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	public final void testGetWinner() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	public final void testGetGameStatus() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	public final void testContainsPlayer() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	public final void testGetPlayer() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore
	public final void testGetCounterPlayer() {
		fail("Not yet implemented"); // TODO
	}

}
