import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank {

  // This first method implementation is completed for you already.
  // Do not modify the method signature.
  public static String getAnswerForPuzzleNumber(int puzzleNumber) throws FileNotFoundException {
    // Create a file scanner to read answers.txt.
    Scanner scanner = new Scanner(new File("answers.txt"));
    // Skip the first puzzleNumber number of words in the file.
    for (int i = 0; i < puzzleNumber; i++) {
      scanner.next();
    }
    // Return the very next word.
    return scanner.next();
  }

  // Do not modify the method signature.
  public static boolean checkInDictionary(String proposed) throws FileNotFoundException {

    //Created a new scanner to read the dictionary file
    Scanner scanner = new Scanner(new File("dictionary.txt"));

    while (scanner.hasNext()) {
      if(scanner.next().equals(proposed)){
        return true;
      }
    }
    return false;  // TODO - implement and replace me
  }
}
