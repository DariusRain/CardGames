package card.materials;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static int FACE_CARD_VALUE = 10;
    private static int ACE_VALUE = 1;
    /**
    * Compares any string to another with regexp
    * @param toParse
    * @param regex
    * @return boolean
    */
    public static boolean compare(String toParse, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toParse);
        return matcher.find();
    }

    public static boolean isAce(String toParse) { return compare(toParse, "Ace" ); }

    public static boolean isFace(String toParse) { return compare(toParse, "Jack|Queen|King"); }

    public static boolean isNumber(String toParse) { return compare(toParse, "^♡|♣|♠|♢[2-9]|10$"); }

    public static int handleNumber(String toParse) {return Integer.parseInt(toParse.replaceAll("[♡♣♠♢]", ""));}




    public static int handleFace() {return FACE_CARD_VALUE;}


}
