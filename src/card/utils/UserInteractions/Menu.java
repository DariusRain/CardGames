package card.utils.UserInteractions;
import java.util.HashMap;
import java.util.ArrayList;

public class Menu extends Console {

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

    public static void welcome(String gameName) {
        log("****************( Welcome to "+ gameName +"! )****************");
    }

//    public static void message(String msg) { log(msg); }

//    public static void newRound() {
//        log("New round starting, new players may join!");
//    }



}