package braingames;

import braingames.engine.GameEngine;
import braingames.games.GeometricProgressionGame;
import braingames.games.LcmGame;
import java.util.Scanner;

/**
 * Main class to start the Brain Games application.
 */
public final class BrainGames {

  /**
   * Private constructor to prevent instantiation.
   */
  private BrainGames() {
  }

  /**
   * Main method to run the application.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = greetUser(scanner);
    chooseGame(scanner, name);
    scanner.close();
  }

  /**
   * Greets the user and returns the player's name.
   *
   * @param scanner the Scanner object for user input
   * @return the name entered by the user
   */
  private static String greetUser(Scanner scanner) {
    System.out.println("Welcome to the Brain Games!");
    System.out.print("May I have your name? ");
    String name = scanner.nextLine();
    System.out.println("Hello, " + name + "!");
    return name;
  }

  /**
   * Displays the game selection menu and starts the chosen game.
   *
   * @param scanner the Scanner object for user input
   * @param name    the player's name
   */
  private static void chooseGame(Scanner scanner, String name) {
    boolean validChoice = false;
    while (!validChoice) {
      System.out.println("\nChoose a game:");
      System.out.println("1 - LCM Game (Least Common Multiple)");
      System.out.println("2 - Geometric Progression Game");
      System.out.print("Enter the game number (1 or 2): ");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          GameEngine.runGame(scanner, name, new LcmGame());
          validChoice = true;
          break;
        case 2:
          GameEngine.runGame(scanner, name, new GeometricProgressionGame());
          validChoice = true;
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
          break;
      }
    }
  }
}
