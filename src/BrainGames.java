import java.util.Random;
import java.util.Scanner;

/**
 * A collection of brain games.
 */
public final class BrainGames {

  /**
   * Private constructor to prevent instantiation.
   */
  private BrainGames() {
  }

  /**
   * Main method to start the Brain Games.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the Brain Games!");
    System.out.print("May I have your name? ");
    String name = scanner.nextLine();
    System.out.println("Hello, " + name + "!");

    boolean validChoice = false;
    while (!validChoice) {
      System.out.println("\nChoose a game:");
      System.out.println("1 - LCM Game (Least Common Multiple)");
      System.out.println("2 - Geometric Progression Game");
      System.out.print("Enter the game number (1 or 2): ");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          playLcmGame(scanner, name);
          validChoice = true;
          break;
        case 2:
          playGeometricProgressionGame(scanner, name);
          validChoice = true;
          break;
        default:
          System.out.println("Invalid choice. Please select 1 or 2.");
          break;
      }
    }
    scanner.close();
  }

  /**
   * Plays the Least Common Multiple (LCM) game.
   *
   * @param scanner the Scanner object for user input
   * @param name    the name of the player
   */
  private static void playLcmGame(Scanner scanner, String name) {
    System.out.println("\nFind the least common multiple of given numbers.");
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      int a = random.nextInt(50) + 1;
      int b = random.nextInt(50) + 1;
      int c = random.nextInt(50) + 1;

      int correctAnswer = lcm(a, lcm(b, c));
      System.out.println("Question: " + a + " " + b + " " + c);
      if (checkAnswer(scanner, name, correctAnswer)) {
        return;
      }
    }
    System.out.println("Congratulations, " + name + "!");
  }

  /**
   * Plays the Geometric Progression game.
   *
   * @param scanner the Scanner object for user input
   * @param name    the name of the player
   */
  private static void playGeometricProgressionGame(Scanner scanner, String name) {
    System.out.println("\nWhat number is missing in the progression?");
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      int start = random.nextInt(10) + 1;
      int ratio = random.nextInt(5) + 2;
      int length = random.nextInt(6) + 5;
      int hiddenIndex = random.nextInt(length);

      int[] progression = new int[length];
      for (int j = 0; j < length; j++) {
        progression[j] = start * (int) Math.pow(ratio, j);
      }
      final int correctAnswer = progression[hiddenIndex];
      progression[hiddenIndex] = -1;

      System.out.print("Question: ");
      for (int num : progression) {
        if (num == -1) {
          System.out.print(".. ");
        } else {
          System.out.print(num + " ");
        }
      }
      System.out.println();

      if (checkAnswer(scanner, name, correctAnswer)) {
        return;
      }
    }
    System.out.println("Congratulations, " + name + "!");
  }

  private static boolean checkAnswer(Scanner scanner, String name, int correctAnswer) {
    System.out.print("Your answer: ");
    int userAnswer = scanner.nextInt();

    if (userAnswer == correctAnswer) {
      System.out.println("Correct!");
    } else {
      System.out.println("'" + userAnswer + "' is wrong answer ;(. "
          + "Correct answer was '" + correctAnswer + "'.");
      System.out.println("Let's try again, " + name + "!");
      return true;
    }
    return false;
  }

  /**
   * Calculates the least common multiple (LCM) of two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the least common multiple of a and b
   */
  private static int lcm(int a, int b) {
    return a * (b / gcd(a, b));
  }

  /**
   * Calculates the greatest common divisor (GCD) of two numbers.
   *
   * @param a the first number
   * @param b the second number
   * @return the greatest common divisor of a and b
   */
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
