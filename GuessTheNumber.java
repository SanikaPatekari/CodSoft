import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber
	{
    public static void main(String[] args) 
		{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number game!");

        while (playAgain)
			{
            int secretNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 5; // You can adjust the maximum number of attempts here

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (!guessedCorrectly && attempts < maxAttempts)
				{
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                attempts++;

                if (userGuess < 1 || userGuess > 100) 
					{
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (userGuess == secretNumber) 
					{
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < secretNumber) 
					{
                    System.out.println("Too low! Try again.");
                } else 
					{
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) 
				{
                System.out.println("Sorry, you've run out of attempts. The number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) 
				{
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}