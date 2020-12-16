package card.games.gofish;

import card.user.Hand;
import card.user.User;
import card.utils.UI.Console;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishPlayer extends GoFishHand implements User {



    protected HashMap<String, ArrayList<String>> cards = new HashMap<>();
    private boolean goFish = false;
    private int books = 0;
    private String name;
    private String id;

    public GoFishPlayer(String name) { this.name = name; }

    public int getBooks() {
        return books;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public void display() {
        Console.log("Player: " + name);
        Console.log("Cards: " + handSize());
    }

    @Override
    public boolean didWin() {
        return !goFish;
    }


    public boolean isGoFish() {
        return goFish;
    }
}
