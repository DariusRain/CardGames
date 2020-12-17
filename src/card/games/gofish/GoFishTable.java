package card.games.gofish;

import card.materials.StandardDeck;
import card.materials.Table;
import card.utils.UI.Console;
import card.utils.generators.RandomIdGenerator;

import java.util.*;

public class GoFishTable implements Table {
    public static final int MAX_SIZE = 5;
    public static final int MIN_SIZE = 2;
    private int onPlayer = 0;
    private List<GoFishPlayer> players = new ArrayList<>();

    private StandardDeck deck = new StandardDeck();

    public void addPlayer(GoFishPlayer user) { players.add(user); }

    @Override
    public boolean empty() { return players.size() == 0; }

    @Override
    public boolean full() { return players.size() == MAX_SIZE; }

    public List<GoFishPlayer> getPlayers() { return players; }

    public StandardDeck getDeck() { return deck;}


    public void displayPlayers() {
        int count = 0;
        for (GoFishPlayer user : players) {
            count += 1;
            Console.logf(count + " ");
            user.display();
        }
    }


    public GoFishPlayer nextPlayer() {
        if (onPlayer == players.size()) {
            onPlayer = 0;
        }
        return players.get(onPlayer++);
    }
}
