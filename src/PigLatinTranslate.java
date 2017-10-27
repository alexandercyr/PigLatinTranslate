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

			//Prompt user for word
			System.out.println();
			System.out.print("Enter a line to be translated: ");
			System.out.println();
			userInput = scnr.nextLine();
			
			//Validate whether user entry is not empty
			while (userInput.isEmpty()) {
				System.out.print("Nothing entered. Enter a line to be translated: ");
				userInput = scnr.nextLine();
			}
			
			System.out.println(translateString(userInput));

			//Prompt user to continue or end
			System.out.println();
			System.out.print("Translate another line? (y/n) ");
			continueRun = scnr.nextLine().toLowerCase().charAt(0);
		}

		System.out.println("Program terminated.");
		scnr.close();

	}

	public static String translateString(String userInput) {

		StringBuilder sb = new StringBuilder();
		
		//create array of words from userString splitting at SPACE
		String[] words = userInput.split(" ");

		//For each word in array, perform specified changes
		for (int i = 0; i < words.length; i++) {
			String newString = "";

			//Check if entered word contains @, if so, do nothing to word
			if (words[i].indexOf("@") >= 0) {
				newString = words[i].concat(" ");
			}

			else {
				boolean vowelFound = false;
				int count = 0;
				newString = words[i];
				//loop through each word until vowel is found
				while (!vowelFound) {
					char firstLetter = words[i].charAt(count);
					
					//
					switch (firstLetter) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						vowelFound = true;
						if (count == 0) {
							newString = newString.concat("way ");
						} else {
							newString = newString.concat("ay ");
						}
						break;
					default: //if first character is not vowel, move consonant to the end
						newString = newString.substring(1).concat(String.valueOf(firstLetter)).toLowerCase();
						break;	
					}
					
					//to prevent infinite loop if word contains only consonants 
					if (count == words.length) {
						vowelFound = true;
					}
					count++;
				}
			}
			
			sb.append(newString);

		}

		return String.valueOf(sb);
	}

}
