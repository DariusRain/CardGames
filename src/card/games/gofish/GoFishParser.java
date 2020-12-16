package card.games.gofish;

import card.materials.Parser;

public class GoFishParser extends Parser {
    private static String[] cardSplit(String toParse) { return toParse.split("[♡♣♠♢]");}
    public static String cardSuit(String toParse) {return cardSplit(toParse)[0];}
    public static String cardValue(String toParse) { return cardSplit(toParse)[1];}
    public static String cardByNumber(int num) {
        switch (num) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return num + "";
        }
    }
}
