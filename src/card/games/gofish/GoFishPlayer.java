package card.games.gofish;

import card.user.Hand;
import card.user.User;
import card.utils.UI.Console;
import card.utils.generators.RandomIdGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishPlayer extends GoFishHand implements User {



    protected HashMap<String, ArrayList<String>> cards = new HashMap<>();
    private boolean goFish = false;
    private int books = 0;
    private String name;
    private String id;

    public GoFishPlayer(String name) {

        this.name = name;
        id = RandomIdGenerator.id(name);
    }

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
        books += checkBooks();
        Console.log("{ Player= [" + name + "], Cards=[" + handSize() + "], Books=[" + books + "], ID=[" + id +"]}");
    }

    @Override
    public boolean didWin() {
        return !goFish;
    }


}
