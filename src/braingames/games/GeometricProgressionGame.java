package braingames.games;

import java.util.Random;

/**
 * GeometricProgressionGame implements the game of finding the missing number
 * in a geometric progression.
 */
public class GeometricProgressionGame implements Game {

  private int length;

  private int hiddenIndex;

  private int correctAnswer;

  private int[] progression;

  private final Random random = new Random();

  @Override
  public String getDescription() {
    return "What number is missing in the progression?";
  }

  @Override
  public void generateRound() {
    length = random.nextInt(6) + 5;
    hiddenIndex = random.nextInt(length);
    progression = new int[length];

    int start = random.nextInt(10) + 1;
    int ratio = random.nextInt(5) + 2;
    for (int j = 0; j < length; j++) {
      progression[j] = start * (int) Math.pow(ratio, j);
    }
    correctAnswer = progression[hiddenIndex];
  }

  @Override
  public String getQuestion() {
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < length; j++) {
      if (j == hiddenIndex) {
        sb.append(".. ");
      } else {
        sb.append(progression[j]).append(" ");
      }
    }
    return sb.toString().trim();
  }

  @Override
  public int getCorrectAnswer() {
    return correctAnswer;
  }
}
