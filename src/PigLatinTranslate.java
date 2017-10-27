import java.util.Scanner;

/**
 * Program translates user input into Pig Latin.
 *
 * @author Alexander Cyr
 *
 */

public class PigLatinTranslate {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		char continueRun = 'y';
		String userInput = "";

		System.out.println("Welcome to the Pig Latin Translator!");

		while (continueRun == 'y') {

			
			System.out.println();
			System.out.print("Enter a line to be translated: ");
			System.out.println();
			userInput = scnr.nextLine();
			
			System.out.println(translateString(userInput));

			System.out.println();
			System.out.print("Translate another line? (y/n) ");
			

			
			continueRun = scnr.nextLine().toLowerCase().charAt(0);
		}
		System.out.println("Program terminated.");

		scnr.close();

	}
	
	public static String translateString(String userInput) {
		
		StringBuilder sb = new StringBuilder();
		String[] words = userInput.split(" ");
		
		for(int i = 0; i < words.length; i ++) {
			String newString = "";
			char firstLetter = words[i].charAt(0);
			boolean upperCase = Character.isUpperCase(words[i].charAt(0));
			if (words[i].indexOf("@") >= 0) {
				newString = words[i].concat(" ");
			}
			else {
			switch(firstLetter) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				newString = words[i].concat("way ");
				break;
			default:
				newString = words[i].substring(1).concat(String.valueOf(firstLetter)).concat("ay ").toLowerCase();
				if (upperCase){
					newString = newString.substring(0, 1).toUpperCase() + newString.substring(1);
				}
				break;
			}
			}
			sb.append(newString);
			

		}
		
		return String.valueOf(sb);
	}

}
