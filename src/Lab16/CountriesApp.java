package Lab16;

import java.util.Scanner;
import java.util.List;

public class CountriesApp {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		String cont = "y";

		do {
			
			System.out.println("Welcome to the Countries Maintenance Application! \n");
			System.out.println("Here is a list of the Countries:");
		    printList();
			
			System.out.println("\nWhat Would you like to do?");

			String choice = Validator.getStringMatchingRegex(scnr,
					"1 - See list of countries\n2 - Add a country\n3 - Exit\n", "1|2|3", false);

			if (choice.equals("1")) {
				printList();

			} else if (choice.equals("2")) {
				System.out.println("Enter the name of the country that you would like to add:\n");
				String userInput = scnr.nextLine();
				Country country = new Country(userInput);
				CountryTextFile.appendLine(country);
				printList();

			} else {
				break;
			}

			cont = Validator.getString(scnr, "\nWould you like to view Options again? ");
		} while (cont.matches("[yY].*"));

		System.out.println("Thank you! Have a Great Day!");

		scnr.close();
	}

	private static void printList() {
		List<Country> countries = CountryTextFile.readFile();

		for (Country country : countries) {
			System.out.println(country.toString());
		}
	}
}