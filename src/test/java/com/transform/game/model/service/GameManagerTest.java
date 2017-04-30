package com.transform.game.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.transform.game.model.InvalidRemoveException;
import com.transform.game.model.InvalidStartException;

public class GameManagerTest {

	@Test
	public final void testGetInstance() {
		GameManager gm1 = GameManager.getInstance();
		GameManager gm2 = GameManager.getInstance();
		assertThat(gm1).isSameAs(gm2);
	}
	@Test
	public final void testContainsWhenTheTournamentIsNotRegistered() {
		GameManager gm1 = GameManager.getInstance();
		assertThat(gm1.containsId("ABCD")).isFalse();
	}
	
	@Test
	public final void testGameID() {
		GameManager gm = GameManager.getInstance();
		try {
			gm.createTicTacToeGame("2", "A", "B");
			assertThat(gm.getGameContext("2").getId()).isEqualTo("2");
		} catch (InvalidStartException e) {
			fail("Exception is not expected here");
		}
	}

	@Test
	public final void testDuplicationOfGameID() {
		GameManager gm = GameManager.getInstance();
		try {
			gm.createTicTacToeGame("3", "A", "B");
			gm.createTicTacToeGame("3", "C", "D");
			fail("Exception is not expected here");
		} catch (InvalidStartException e) {
			assertThat(e).hasMessage("The id 3 is duplicated");
		}
	}
	
	@Test
	public final void testRemoveGame() {
		GameManager gm = GameManager.getInstance();
		try {
			gm.createTicTacToeGame("4", "A", "B");
			assertThat(gm.getGameContext("4").getId()).isEqualTo("4");
			gm.removeGame("4", "A");
			assertThat(gm.containsId("4")).isFalse();
		} catch (InvalidRemoveException | InvalidStartException e) {
			fail("Exception is not expected here");
		}
	}
	@Test
	public final void testRemoveGameByWrongID() {
		GameManager gm = GameManager.getInstance();
		try {
			gm.createTicTacToeGame("5", "A", "B");
			assertThat(gm.getGameContext("5").getId()).isEqualTo("5");
			gm.removeGame("1000", "A");
			fail("Exception is not expected here");
		} catch (InvalidRemoveException e) {
			assertThat(e).hasMessage("id 1000 does not exist");
		}catch (InvalidStartException e) {
			fail("Exception is not expected here");
		}
	}
	@Test
	public final void testRemoveGameByWrongPlayer() {
		GameManager gm = GameManager.getInstance();
		try {
			gm.createTicTacToeGame("6", "A", "B");
			assertThat(gm.getGameContext("6").getId()).isEqualTo("6");
			gm.removeGame("6", "C");
			fail("Exception is not expected here");
		} catch (InvalidRemoveException e) {
			assertThat(e).hasMessage("player C is not eligible to remove");
		}catch (InvalidStartException e) {
			fail("Exception is not expected here");
		}
	}
}
