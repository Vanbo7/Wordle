import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {
        System.out.println("Which game would you like to play? (Choose a number from 0 to 2315)");
        int gameNumber = scanner.nextInt();

        WordleGame game = new WordleGame(gameNumber);
        return game;  // TODO - implement and replace me
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
        // TODO - implement
        // I did an implementation first outside of the loop, because I would get an error
        // when trying to access the isGameOver method without initializing a guess
        System.out.println("What's your guess?");
        String guess = scanner.next();
        while(!WordBank.checkInDictionary(guess) || guess.length()<5 || guess.length()>5){
                System.out.println("Invalid guess, please try again");
                System.out.println("What's your guess?");
                guess = scanner.next();
            }
        game.guess(guess);
        System.out.println(game.toString());

        //This is in a while loop so you can write 6 guesses
        while(!game.isGameOver()){
            System.out.println("What's your guess?");
            guess = scanner.next();
            // Checks if word is in dictionary while also checking if the guess is a valid length
            while(!WordBank.checkInDictionary(guess) || guess.length()<5 || guess.length()>5){
                System.out.println("Invalid guess, please try again");
                System.out.println("What's your guess?");
                guess = scanner.next();
            }
            game.guess(guess);
            System.out.println(game.toString());
        }
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        // TODO - implement
        if(game.isGameWin()){
            System.out.println("You won!");
        } else {
            System.out.println("The answer was "+ game.getAnswer());
        }
    }

    // This main method body should not be modified.
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}
