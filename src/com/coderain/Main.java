package com.coderain;

import card.games.gofish.GoFish;
import card.materials.StandardDeck;
import card.utils.UI.Console;

public class Main {

    public static void main(String[] args) {
// Test deck
//        StandardDeck deck = new StandardDeck();
//        deck.test();
        GoFish goFishGame = new GoFish();
        goFishGame.start();
    }
}
