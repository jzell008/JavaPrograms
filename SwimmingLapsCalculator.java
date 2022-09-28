import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SwimmingLapsCalculator { // Calculates the average, minimum and maximum amounts of seconds it takes
										// to swim a lap in an Olympic sized swimming pool.
	static boolean hasMoreLaps = true;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numberOfLaps;
		double total = 0.0;
		double average = 0.0;
		double max = 0.0;
		double min;

		System.out.println("\tWelcome to The McAuley Aquatic Center\n\n" // Formatted welcome message
				+ "Our facility was rated one of “The 10 Best Collegiate Competition Swimming Pools”in\n2016 "
				+ "and is home to aspiring swimmers of all kinds! Did you know the average person\ncan swim "
				+ "a lap in about 60 seconds? The world record  is 20.91 seconds!! It was set \nby Cesar Cielo (Brazil) in 2009.\n\n"
				+ "Go ahead, swim a lap then enter in how many seconds it took you below.\n");

		ArrayList<String> lapsList = new ArrayList<String>(); // Creating an ArrayList to store laps times.

		do {
			System.out.print("How many seconds did it take you? Enter lap time:"); // Asking user to enter their lap
																					// times in a loop.
			String lapTime = scnr.next();
			lapsList.add(lapTime);

			System.out.print("Add another lap? [yes, no]"); // Asking user to end/exit the loop.
			String response = scnr.next();
			if (response.toUpperCase().startsWith("N")) {
				hasMoreLaps = false;
			}
		} while (hasMoreLaps);

		String[] stringArray = lapsList.toArray(new String[lapsList.size()]); // Converting ArrayList to double array.
		double[] laps = Arrays.stream(stringArray).mapToDouble(Double::parseDouble).toArray();

		max = laps[0]; // Finding max , min lap times using for loops.
		min = laps[0];
		for (int i = 0; i < laps.length; i++) {
			if (laps[i] > max) {
				max = laps[i];
			}
		}

		for (int i = 0; i < laps.length; i++) {
			if (laps[i] < min) {
				min = laps[i];
			}
		}

		for (int i = 0; i < laps.length; i++) { // Finding average lap time.
			total += laps[i];
		}
		numberOfLaps = laps.length;
		average = total / numberOfLaps;

		System.out.printf( // Printing formatted results.
				"\nGood Job!! Give yourself a pat on the back!" + " Here are your stats:\n\nYour Average time is: %.2f"
						+ "\nYour Maximum time was: %.2f\nYour Minimum time was: %.2f\n\n",
				average, max, min);
		System.out.println(
				"Towels are by the lockers and you can leave them\nin the big blue bins when your done with them. Thanks for swimming!");
	}
}
