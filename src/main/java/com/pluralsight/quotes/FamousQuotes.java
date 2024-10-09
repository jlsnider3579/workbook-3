import java.util.InputMismatchException;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        // Create an array of 10 quotes
        String[] quotes = {
                "The only limit to our realization of tomorrow is our doubts of today.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Believe you can and you're halfway there.",
                "What lies behind us and what lies before us are tiny matters compared to what lies within us.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "It does not matter how slowly you go as long as you do not stop.",
                "You are never too old to set another goal or to dream a new dream.",
                "Hardships often prepare ordinary people for an extraordinary destiny.",
                "The best way to predict your future is to create it.",
                "Keep your face always toward the sunshine—and shadows will fall behind you."
        };

        boolean loopZ = true;
        Scanner scanner = new Scanner(System.in);

        while (loopZ) {
            try {
                System.out.println("Choose a number 1 through 10 to display a famous quote");
                int number = scanner.nextInt();

                if (number >= 1 && number <= 10) {
                    System.out.println(" your famous quote choice");
                    System.out.println(quotes[number - 1]);
                } else {
                    System.out.println("Invalid entry Please enter a number between 1 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry  Please choose a number between 1 and 10.");
                scanner.nextInt();

                System.out.println("Another quote");
            }
        }
    }
}



