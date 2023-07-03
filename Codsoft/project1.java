import java.util.Scanner;
import java.util.Random;

public class project1 {
    public static void main(String[] args) {
        playMultipleRounds();
    }

    public static void playGame() {
        int lowerLimit = 1;
        int upperLimit = 100;
        Random random = new Random();
        int randomNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game");
        System.out.printf("I'm thinking of a number between %d and %d.%n", lowerLimit, upperLimit);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Take a guess!!: ");

            
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.printf("Congratulations!!!! You guessed the correct number in %d attempts.%n", attempts);
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low!__ Try guessing a higher number.");
            } else {
                System.out.println("Too high!___ Try guessing a lower number.");
            }
        }
    }

    public static boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    public static void playMultipleRounds() {
        int roundsPlayed = 0;
        int totalAttempts = 0;
        int roundsWon = 0;
        int attempts=0;

        do {
            roundsPlayed++;
            System.out.printf("%nRound %d:%n", roundsPlayed);
            playGame();
            totalAttempts += attempts;

            System.out.printf("Round %d ended. It took you %d attempts.%n", roundsPlayed, attempts);

            if (attempts == 1) {
                roundsWon++;
            }
        } while (playAgain());

        double averageAttempts = (double) totalAttempts / roundsPlayed;
        int scoreBasedOnAttempts = 100 - totalAttempts;
        int scoreBasedOnRoundsWon = (int) ((double) roundsWon / roundsPlayed * 100);

        System.out.printf("%nYou played %d rounds.%n", roundsPlayed);
        System.out.printf("Average number of attempts per round: %.2f%n", averageAttempts);
        System.out.printf("Score based on attempts taken: %d%n", scoreBasedOnAttempts);
        System.out.printf("Score based on rounds won: %d%%%n", scoreBasedOnRoundsWon);
    }
}
