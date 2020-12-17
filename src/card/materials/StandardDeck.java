package card.materials;

import card.utils.generators.SynchronousCardGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StandardDeck implements Deck {
    private ArrayList<String> cards = new ArrayList<>();
    private SynchronousCardGenerator cardGeneratorSync = new SynchronousCardGenerator();
    private int index = 0;
    public StandardDeck() {
        init();
    }

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
    public void reset() { Collections.shuffle(cards); }

    public void init() {
        while (cards.size() < 52) {
            cards.add(cardGeneratorSync.nextCard());
        }
    }

    public void test() {
        init();
    }

    public int getIndex() {
        return index;
    }
}
