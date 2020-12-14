package card.materials;
import card.utils.UserInteractions.Menu;
import card.utils.generators.RandomCardGenerator;
import java.util.HashSet;
import java.util.Set;

/**
* <h1>Deck</h1>
* <p>
*       Contains a set that holds randomly generated cards using
*   the {@code CardGenerator.nextCard()} method.  So deck has no cards initially but adds them throughout
*   the game with no risk of duplicates because of the nature of a {@code Set}.
* </p>
* @author  Darius Rain
* @version 1.0
* @since   2020-11-14
*/
public class InfiniteDeck implements Deck {

    private Set<String> cards = new HashSet<>();
    private RandomCardGenerator randCard = new RandomCardGenerator();
    /**
     * Returns recursively until card is not a duplicate based on the size of the Set.
     * @return String A unique card
     */
    public String draw() {
        int lastSize = cards.size() * 1;
        String card = randCard.nextCard();
        cards.add(card);
        if (lastSize == cards.size()) { return draw(); }
        Menu.log("Draw: " + card);
        return card;
    }


    /**
    * Clears out Set for a new round of blackjack.
    * @return Nothing
    */
    public void reset() {
        cards.clear();
    }

}


