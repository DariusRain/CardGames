package card.materials;

import card.utils.UserInteractions.Menu;
import card.utils.generators.RandomCardGenerator;
import card.utils.generators.SynchronousCardGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StandardDeck implements Deck {
    private ArrayList<String> cards = new ArrayList<>();
    private SynchronousCardGenerator cardGeneratorSync = new SynchronousCardGenerator();
    private int index = 0;
    /**
     * Returns recursively until card is not a duplicate based on the size of the Set.
     * @return String A unique card
     */
    public String draw() {
        return cards.get(index++);
    }

    /**
     * Clears out Set for a new round of blackjack.
     * @return Nothing
     */
    public void reset() {
        cards.clear();
    }

    public void init() {
        while (cards.size() < 52) {
            cards.add(cardGeneratorSync.nextCard());
        }
    }

    public void test() {
        init();
        System.out.println(cards);
    }
}
