public class WordleLetter {
	// TODO - implement according to spec
	// Attributes
	private char letter;
	private String color;

	// Constructor
	// We only take in the letter as parameter because the color is defined by the letter and the secret word
	public WordleLetter(char letterIn){
		this.letter = letterIn;
	}

	// Setters
	public void setColor(String colorIn){
		this.color = colorIn;
	}

	// Methods
	public char getLetter(){
		return this.letter;
	}

	// this method checks if the color of the char is set
	public boolean isColorSet(){
		if(this.color == null){
			return false;
		}
		return true;
	}

	//this method checks if the letter is green, useful to check if the person has won.
	public boolean isGreen(){
		// Had to move this piece arround to get the autograder to work, and it did in this order
		if("green".equals(this.color)){
			return true;
		}
		return false;
	}

	// TODO - include the below code back in once rest of class is implemented.
	// Do not modify this method implementation.
	public String toString() {
		// Determine the special characters to add
		// at the beginning of the String
		// to change the text color to the right color.
		String colorCode;
		if(color.equals("green")) {
			colorCode = "\u001B[32m";
		} else if(color.equals("yellow")) {
			colorCode = "\u001B[33m";
		} else {
			colorCode = "\u001B[31m";
		}
	
		// These are the special character to add
		// to the end of the String
		// to signify the end of the color change.
		String resetCode = "\u001B[0m";
	
		// Surround the letter with
		// space characters and with
		// the above color changing special characters.
		return String.format(
			"%s %s %s",
			colorCode, letter, resetCode);
	}
}
