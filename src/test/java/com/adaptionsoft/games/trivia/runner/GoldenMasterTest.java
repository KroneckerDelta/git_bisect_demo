package com.adaptionsoft.games.trivia.runner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class GoldenMasterTest {

	@Test
	public void testMasterFor2Players() throws Throwable {
		String testResultFile = "./testResult.txt";
		System.setOut(new PrintStream(testResultFile));
		for (int seed = 0; seed < GoldenMasterFactory.SEEDS; seed++) {
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
		Assert.assertEquals(this
				.readFileContent(GoldenMasterFactory.MASTER_FOR_TWO_PLAYERS),
				this.readFileContent(testResultFile));
	}

	@Test
	public void testMasterFor6Players() throws Throwable {
		String testResultFile = "./testResult.txt";
		System.setOut(new PrintStream(testResultFile));
		for (int seed = 0; seed < GoldenMasterFactory.SEEDS; seed++) {
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
		Assert.assertEquals(this
				.readFileContent(GoldenMasterFactory.MASTER_FOR_SIX_PLAYERS),
				this.readFileContent(testResultFile));
	}

	@Test
	public void testReadFileContent() throws Throwable {
		Assert.assertEquals("MASTER\nSLAVE\n",
				this.readFileContent("./fileContentTest.txt"));
	}

	private String readFileContent(String fileName) throws Throwable {
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String line = null;
		StringBuffer result = new StringBuffer();
		while ((line = bf.readLine()) != null) {
			result.append(line).append("\n");
		}
		bf.close();
		return result.toString();
	}

}
