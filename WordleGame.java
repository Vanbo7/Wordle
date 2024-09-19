import java.io.FileNotFoundException;

public class WordleGame {
  // TODO - implement according to spec
  // attributes that I found fitting for the class and to build the game
  private String answer;
  private WordleLetter[][] board;
  private int guesses;

  // WordleGame constructor, declares the initial state of the game 
  // file not found exception allows the WordBank method to work
  public WordleGame(int puzzleNumber) throws FileNotFoundException{
    this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
    this.board = new WordleLetter[6][5];
    this.guesses = 0;
  }

  // getter
  public String getAnswer(){
    return this.answer;
  }

  // Methods
  // guess method to set the string inputed as a guess
  public void guess(String guessWord){
  // loop to traverse the String separatly by characters
    for (int i=0; i<5; i++){
      WordleLetter currLetter = new WordleLetter(guessWord.charAt(i));

      if(guessWord.charAt(i)==answer.charAt(i)){
        currLetter.setColor("green");

      } else if (answer.indexOf(guessWord.charAt(i))>=0){
        currLetter.setColor("yellow");

      } else {
        currLetter.setColor("red");

      }

      board[guesses][i] = currLetter;
    }
    // to set the amount of guesses;
    guesses++;
  }

  // getters
  public int getNumberGuessesSoFar(){
    return this.guesses;
  }

  public WordleLetter[] getGuess(int guessNumber){
    return this.board[guessNumber];
  }


  public boolean isGameOver(){

  // failed implementation, it did work but the autograder wouldn't run it
  //   if(guesses>=6){
  //     return true;

  //   } else if(isGameWin()){
  //     return true;

  //   }
  //   return false;
    if(isGameWin() || guesses ==6){
      return true;
    }
    return false;
  }

  // Here I had to add an else statement even though it is technically not needed, 
  //because the autograder would try to acces a -1 index inside the array
  public boolean isGameWin(){
    if (guesses <= 0){
      return false;
    } else {
      // with a loop, we get the color attribute from the wordle letter on the array, and if it is green we add it to the sum
      int green = 0;
      for(int i=0; i<5; i++){
        if(board[guesses-1][i].isGreen()){
        green++;
        }
      }
      // if there are 5 green letters, the player wins
      if (green==5){
        return true;
      }
    }
    return false;
  }
  // TODO - include the remainder of the below code back in once rest of class is implemented.

  // Do not modify this method implementation.
  public String toString() {
    // result will be used to build the full answer String
    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      // get each letter of each word
      for (int j = 0; j < 5; j++) {
        // concatenate it to the result
        // WordleLetter's toString() is automatically invoked here.
        result += getGuess(i)[j];
      }
      // new line separator between each word
      result += "\n";
    }
    return result;
  }
}
