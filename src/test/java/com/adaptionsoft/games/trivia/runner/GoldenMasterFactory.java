package com.adaptionsoft.games.trivia.runner;

import java.io.PrintStream;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GoldenMasterFactory {

	public static final int SEEDS = 10;
	public static final String MASTER_FOR_TWO_PLAYERS = "./master_for_two_players.txt";
	public static final String MASTER_FOR_SIX_PLAYERS = "./master_for_six_players.txt";

	public static void main(String[] args) throws Throwable {
		createMasterFor2Players();
		createMasterFor6Players();
	}

	public static void createMasterFor2Players() throws Throwable {

		System.setOut(new PrintStream(MASTER_FOR_TWO_PLAYERS));
		for (int seed = 0; seed < SEEDS; seed++) {
			Game aGame = new Game();
			aGame.add("PLAYER_ONE");
			aGame.add("PLAYER_TWO");
			Random rand = new Random(seed);
			boolean notAWinner;
			do {
				aGame.roll(rand.nextInt(5) + 1);
				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.wrongAnswer();
				} else {
					notAWinner = aGame.wasCorrectlyAnswered();
				}
			} while (notAWinner);
		}

	}

	public static void createMasterFor6Players() throws Throwable {

		System.setOut(new PrintStream(MASTER_FOR_SIX_PLAYERS));
		for (int seed = 0; seed < SEEDS; seed++) {
			Game aGame = new Game();
			aGame.add("PLAYER_ONE");
			aGame.add("PLAYER_TWO");
			aGame.add("PLAYER_THREE");
			aGame.add("PLAYER_FOUR");
			aGame.add("PLAYER_FIVE");
			aGame.add("PLAYER_SIX");
			Random rand = new Random(seed);
			boolean notAWinner;
			do {
				aGame.roll(rand.nextInt(5) + 1);
				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.wrongAnswer();
				} else {
					notAWinner = aGame.wasCorrectlyAnswered();
				}
			} while (notAWinner);
		}

	}
}
