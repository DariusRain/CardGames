package card.games.gofish;

import card.games.blackjack.BlackJackParser;
import card.user.Hand;
import card.utils.UI.Console;

import java.util.*;

public class GoFishHand implements Hand {

    private HashMap<String, ArrayList<String>> cards = new HashMap<>();
    private int cardCount = 0;

    private ArrayList<String> giveAway = new ArrayList<>();

    public ArrayList<String> getGiveAway() {
        return giveAway;
    }
    public void clearGiveAway() {cardCount -= giveAway.size(); giveAway.clear();}


    public int handSize() { return cardCount; }

    public boolean hasMatch(String cardType) {
        if(cards.containsKey(cardType)) {
            Console.log("Has" + cardType + "(s)!");
            giveAway = cards.get(cardType);
            cards.remove(cardType);
            return true;
        }
        Console.log("Does not have " + cardType + "(s)!");
        return false;
    }


    public int checkBooks() {
        Iterator iterator = cards.entrySet().iterator();
        int bookCount = 0;
        while (iterator.hasNext()) {
            Map.Entry obj = (Map.Entry) iterator.next();
            ArrayList<String> cardGroup = (ArrayList<String>)(obj.getValue());
            if (cardGroup.size() == 4) {
                Console.log("BOOK");
                bookCount += 1;
                Console.log(bookCount +"");
                iterator.remove();
            }
        }
        Console.log(bookCount +"");
l
        return bookCount;

    }

    @Override
    public void addCard(String card) {
        String cardType = GoFishParser.cardValue(card);
        cards.putIfAbsent(cardType, new ArrayList<>());
        cards.get(cardType).add(GoFishParser.cardSuit(card));
        cardCount += 1;
    }

    @Override
    public void clear() { cards.clear(); }

    @Override
    public void displayHand() {
        Console.log("Hand: " + cards.toString() + "");
    }



}
