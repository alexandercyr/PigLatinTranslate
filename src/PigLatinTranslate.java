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

			StringBuilder sb = new StringBuilder();
			
			System.out.println();
			System.out.print("Enter a line to be translated: ");
			System.out.println();
			userInput = scnr.nextLine().toLowerCase();
			String[] words = userInput.split(" ");
			
			for(int i = 0; i < words.length; i ++) {
				String newString = "";
				char firstLetter = words[i].charAt(0);
				switch(firstLetter) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					newString = words[i].concat("way ");
					break;
				default:
					newString = words[i].substring(1).concat(String.valueOf(firstLetter)).concat("ay ");
					break;
				}
				sb.append(newString);
				

			}
			
			System.out.println(sb);

			System.out.println();
			System.out.print("Translate another line? (y/n) ");
			

			
			continueRun = scnr.nextLine().toLowerCase().charAt(0);
		}
		System.out.println();
		System.out.println("Program terminated.");

		scnr.close();

	}

}
