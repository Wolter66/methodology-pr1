package braingames.games;


import java.util.Random;

/**
 * LcmGame implements the game of calculating the least common multiple (LCM).
 */
public class LcmGame implements Game {

  private int firstNumber;

  private int secondNumber;

  private int thirdNumber;

  private int correctAnswer;

  private final Random random = new Random();

  @Override
  public String getDescription() {
    return "Find the least common multiple of given numbers.";
  }

  @Override
  public void generateRound() {
    firstNumber = random.nextInt(50) + 1;
    secondNumber = random.nextInt(50) + 1;
    thirdNumber = random.nextInt(50) + 1;
    correctAnswer = lcm(firstNumber, lcm(secondNumber, thirdNumber));
  }

  @Override
  public String getQuestion() {
    return firstNumber + " " + secondNumber + " " + thirdNumber;
  }

  @Override
  public int getCorrectAnswer() {
    return correctAnswer;
  }

  /**
   * Calculates the least common multiple (LCM) of two numbers.
   *
   * @param x the first number
   * @param y the second number
   * @return the least common multiple
   */
  private int lcm(int x, int y) {
    return x * (y / gcd(x, y));
  }

  /**
   * Calculates the greatest common divisor (GCD) of two numbers.
   *
   * @param x the first number
   * @param y the second number
   * @return the greatest common divisor
   */
  private int gcd(int x, int y) {
    while (y != 0) {
      int temp = y;
      y = x % y;
      x = temp;
    }
    return x;
  }
}
