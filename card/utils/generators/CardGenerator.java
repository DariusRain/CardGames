package card.utils.generators;
public interface CardGenerator {
    String[] SUITS = {"♢", "♠", "♡", "♣"};
    String[] FACES = {"Jack", "Queen", "King", "Ace"};
    int FACE_VALUES = 13;
    int LOW = 1;
    int HIGH = 10;
    String suit();
    String face();
    String nextCard();
}
