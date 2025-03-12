import java.util.Random;
import java.util.Scanner;

public class BrainGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("\nВыберите игру:");
            System.out.println("1 - Игра \"НОК\" (наименьшее общее кратное)");
            System.out.println("2 - Игра \"Геометрическая прогрессия\"");
            System.out.print("Введите номер игры (1 или 2): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playLCMGame(scanner, name);
                    validChoice = true;
                    break;
                case 2:
                    playGeometricProgressionGame(scanner, name);
                    validChoice = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите 1 или 2.");
                    break;
            }
        }
        scanner.close();
    }

    private static void playLCMGame(Scanner scanner, String name) {
        System.out.println("\nFind the smallest common multiple of given numbers.");
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            int a = random.nextInt(50) + 1;
            int b = random.nextInt(50) + 1;
            int c = random.nextInt(50) + 1;

            int correctAnswer = lcm(a, lcm(b, c));
            System.out.println("Question: " + a + " " + b + " " + c);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

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
            int correctAnswer = progression[hiddenIndex];
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

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
