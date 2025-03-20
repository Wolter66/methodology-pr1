package braingames.games;

/**
 * Game interface describing common methods for all games.
 */
public interface Game {

  /**
   * Returns the description of the game.
   *
   * @return the game description
   */
  String getDescription();

  /**
   * Generates a new round of the game.
   */
  void generateRound();

  /**
   * Returns the question for the current round.
   *
   * @return the round question
   */
  String getQuestion();

  /**
   * Returns the correct answer for the current round.
   *
   * @return the correct answer
   */
  int getCorrectAnswer();
}
