package card.materials;

public interface Deck {
    /**
     * Returns recursively until card is not a duplicate based on the size of the Set.
     * @return String A unique card
     */
    String draw();
    /**
     * Clears out Set for a new round of blackjack.
     * @return Nothing
     */
    void reset();
}
