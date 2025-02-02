import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int rounds = 1;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\n Round " + rounds);
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess a number within the range of 1 to 100.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low !");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high !");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1);
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" used all your attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your total score is: " + totalScore);

            System.out.print(" want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
            rounds++;
        }

        System.out.println("Game Ended ! final score is: " + totalScore);
        scanner.close();
    }
}
