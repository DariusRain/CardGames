package card.games.gofish;

import card.materials.Table;
import card.utils.UI.Console;
import card.utils.generators.RandomCardGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
* <h1>Dealer</h1>
* <p>
*
* </p>
* @author  Darius Rain
* @version 0.3
* @since   YY-MM-DD
*/
public class GoFish {
    GoFishTable table = new GoFishTable();

    public GoFish() {
        initPlayers();
        initDeal();
    }

    private void initPlayers() {
        while ((Console.choice("New Player (Y)Yes/(N)No?") || table.getPlayers().size() < table.MIN_SIZE) && !table.full()) {
            String name = Console.askForString("Name: ");

            table.addPlayer(new GoFishPlayer(name));
        }
    }

    private void initDeal() {
        table.getDeck().reset();
        int amountOfCardsDealt = table.getPlayers().size() < 4 ? 7 : 5;
        while (amountOfCardsDealt-->0) {
            for (GoFishPlayer user: table.getPlayers()) {
                System.out.println(user);
                user.addCard(table.getDeck().draw());
            }
        }
    }

    private void playerTurn() {
        table.displayPlayers();
        GoFishPlayer currentPlayer = table.nextPlayer();
        Console.log("\n\nOn player >>");
        currentPlayer.display();
        request(currentPlayer);

    }

    private void request(GoFishPlayer requester) {
        int cardTypeByNumber = 0;
        requester.displayHand();
        while(13 < cardTypeByNumber || cardTypeByNumber < 1) {
            cardTypeByNumber = Console.askForInt("Request card type (1-13) (Ace-King):");
        }
        String cardType = GoFishParser.cardByNumber(cardTypeByNumber);
        int playerIndex = -1;
        int tableSize = table.getPlayers().size();
        while (tableSize <= playerIndex || -1 == playerIndex) {
            playerIndex =  Console.askForInt("Request from (Number): ") - 1;
        }
        boolean hasCardType = table.getPlayers().get(playerIndex).hasMatch(cardType);
        if (hasCardType) {
            for(String suit: table.getPlayers().get(playerIndex).getGiveAway()) {
                requester.addCard(suit+cardType);
            }
            table.getPlayers().get(playerIndex).clearGiveAway();
            request(requester);

        } else {

            Console.log("Go fish!!!");
            requester.addCard(table.getDeck().draw());
        }
    }

    public void start() {
        while(table.getDeck().getIndex() <= 52) {
            playerTurn();
        }
    }
}
