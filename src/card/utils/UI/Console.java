package card.utils.UI;
import card.materials.Parser;

import java.util.Scanner;

// In charge of inputting & outputting to the user.
public class Console {

    // Every instantiated class will use this variable for input
    private static Scanner input = new Scanner(System.in);

    // Every instantiated class will use this variable for output
    // --> output will keep concatenating previous elements with hyphens
    public static String output;

    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }

    public static void log(String s) {
        System.out.println(s);
        output += s + "-";
    }

    public static void logf(String s) {
        System.out.print(s);
        output += s + "-";
    }

    public static String input(String message) {
        System.out.print(message);
        return input.nextLine();
    }

    public static String input() {
        return input.nextLine();
    }
    // Returns false if Y or y is not.
    public static boolean choice(String message) {
        return Parser.compare(input(message + " (Y/N): ").toUpperCase().strip().trim(), "^Y$");
    }

    // Returns an invalid message with the invalid input
    public static void invalid(String invalidInput) {
        log("Invalid Input -> " + "\"" + invalidInput + "\"");
    }

    // askFor methods Returns any extpected return value user types in, removes whitespace
    public static String askForString(String message) {

        String response = input(message);
        String parsedResponse = response.replaceAll("\\W+|\\d+", "").strip().trim();

        if (parsedResponse.length() > 0) {
            return parsedResponse;
        }

        invalid(response);
        return askForString(message);

    }

    public static int askForInt(String message) {

        String response = input(message);
        if (Parser.compare(response, "^\\d+$")) {
            try {
                return Integer.parseInt(response);
            } catch (NumberFormatException e) {
                invalid(response + "(Too large!!)");

                return askForInt(message);
            }
        }

        invalid(response);
        return askForInt(message);

    }

}