package card.games.gofish;

import card.user.Hand;
import card.utils.UI.Console;

import java.util.*;

public class GoFishHand implements Hand {

    private final HashMap<String, ArrayList<String>> cards = new HashMap<>();
    private int cardCount = 0;
    private ArrayList<String> giveAway = new ArrayList<>();

    public ArrayList<String> getGiveAway() {
        return giveAway;
    }
    public void clearGiveAway() {giveAway.clear();}


    public int handSize() { return cardCount; }

    public boolean hasMatch(String cardType) {
        if(cards.containsKey(cardType)) {
            giveAway = cards.get(cardType);
            cards.remove(cardType);
            return true;
        }
        return false;
    }


    public int checkBooks() {
        Iterator iterator = cards.entrySet().iterator();
        Console.log("Hand: ");
        int bookCount = 0;
        while (iterator.hasNext()) {
            Map.Entry obj = (Map.Entry) iterator.next();
            if (((ArrayList<String>)(obj.getValue())).size() == 4) {
                bookCount += 1;
            }
        }
        return bookCount;

    }

    @Override
    public void addCard(String card) {
        String cardType = GoFishParser.cardValue(card);
        if (!hasMatch(cardType)) {
            cards.put(cardType, new ArrayList<>());
        }
        cards.get(cardType).add(GoFishParser.cardSuit(card));
        cardCount += 1;
    }

    @Override
    public void clear() { cards.clear(); }

    @Override
    public void displayHand() {
        Iterator iterator = cards.entrySet().iterator();
        Console.log("Hand: ");
        while (iterator.hasNext()) {
            Map.Entry obj = (Map.Entry) iterator.next();
            Console.log(( (String)obj.getKey()) + " = " + ((ArrayList<String>)obj.getValue()).size());
        }
    }



}
