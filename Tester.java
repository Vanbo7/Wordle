import java.io.FileNotFoundException;

/**
 * Tester file.
 *
 * Use this main method to test classes and methods as you create them.
 * Feel free to modify this file as you wish.
 */
public class Tester {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(WordBank.checkInDictionary("plumb"));  // true
    System.out.println(WordBank.checkInDictionary("asdfg"));  // false

    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(1)); // plumb

    // TODO add tests for Wordle Letter
    // Wordle letter green; checks if the letter turns green
    WordleLetter p = new WordleLetter('p');
    p.setColor("green");
    System.out.println(p.isColorSet());
    System.out.println(p.isGreen());
    System.out.println(p.toString());

    // Wordle letter yellow, testing isColorSet Method
    WordleLetter m = new WordleLetter('m');
    System.out.println(m.isColorSet());
    m.setColor("yellow");
    System.out.println(m.isGreen());
    System.out.println(m.toString());

    // Wordle letter red, checks if the letter turns red
    WordleLetter s = new WordleLetter('s');
    System.out.println(s.isColorSet());
    s.setColor("red");
    System.out.println(s.isColorSet());
    System.out.println(s.isGreen());
    System.out.println(s.toString());

    // TODO add tests for Wordle Game
    // This is to test if the guess set method works
    WordleGame g1 = new WordleGame(2);
    System.out.println(g1.getAnswer());
    g1.guess("clone");
    WordleLetter[] array = g1.getGuess(0);
    // I'm accessing the guess attribute to ensure the method works.
    for(int i=0; i<array.length; i++){
      System.out.print(array[i].getLetter());
    }

    // TODO add tests for Main
    // I didn't need to test the Main method much through here, 
    //because I could just run it on the terminal
  }
}
