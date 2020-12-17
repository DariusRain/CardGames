package card.games.blackjack;

import card.materials.Parser;

public class BlackJackParser extends Parser {

    public static int handleAce(int cardSum) {
        if (cardSum + 11 <= 21) {
            return 11;
        } else {
            return 1;
        }
    }
    public static boolean isBlackJack(int cardSum) { return cardSum == 21; }

    public static int cardValue(String card, int cardSum) {

        if (isAce(card)) {
            return handleAce(cardSum);
        }

        if (isFace(card)) {
            return handleFace();
        }

        if (isNumber(card)) {
            return handleNumber(card);
        }

        return 0;
    }


}
