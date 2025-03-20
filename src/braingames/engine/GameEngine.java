package braingames.engine;

import braingames.games.Game;
import java.util.Scanner;

/**
 * GameEngine class containing the common logic for running games.
 */
public class GameEngine {

  /** Number of rounds for each game. */
  public static final int ROUNDS = 3;

  /**
   * Runs a game using the provided Game instance.
   *
   * @param scanner    the Scanner object for user input
   * @param playerName the player's name
   * @param game       the game instance implementing the Game interface
   */
  public static void runGame(Scanner scanner, String playerName, Game game) {
    System.out.println("\n" + game.getDescription());
    for (int i = 0; i < ROUNDS; i++) {
      game.generateRound();
      System.out.println("Question: " + game.getQuestion());
      System.out.print("Your answer: ");
      int userAnswer = scanner.nextInt();
      if (userAnswer != game.getCorrectAnswer()) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
          + game.getCorrectAnswer() + "'.");
        System.out.println("Let's try again, " + playerName + "!");
        return;
      } else {
        System.out.println("Correct!");
      }
    }
    System.out.println("Congratulations, " + playerName + "!");
  }
}