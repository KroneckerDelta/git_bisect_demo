package com.adaptionsoft.games.trivia.runner;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameTest {

	private Game game;

	@Before
	public void before() {
		this.game = new Game();
	}

	@Test
	public void add() {
		game.add("Theo Tester");
		Assert.assertEquals(1, game.howManyPlayers());
	}

	@Test
	public void addManyPlayers() {
		for (int i = 0; i < 7; i++) {
			if (i < 6) {
				Assert.assertTrue(game.add("Theo Tester"));
			} else {
				Assert.assertFalse(game.add("Theo Tester"));
			}
		}
		Assert.assertEquals(6, game.howManyPlayers());

	}

}
