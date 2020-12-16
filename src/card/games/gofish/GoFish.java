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
    }

    private void initPlayers() {
        while (Console.choice("New Player (Y)Yes/(N)No?")) {
            String name = Console.askForString("Name: ");
            table.addPlayer(new GoFishPlayer(name));
        }
    }

    private void runRound() {
        table.displayPlayers();
        GoFishPlayer currentPlayer = table.nextPlayer();
        Console.logf("On player >> ");
        currentPlayer.display();
        currentPlayer.displayHand();
        request(currentPlayer);
    }

    private boolean request(GoFishPlayer requester) {
        int cardTypeByNumber = 0;
        while(13 < cardTypeByNumber || cardTypeByNumber < 1) {
            cardTypeByNumber = Console.askForInt("Request card type (1-13) (Ace-King):");
        }
        String cardType = GoFishParser.cardByNumber(cardTypeByNumber);
        int playerIndex = -1;
        int tableSize = table.getPlayers().size();
        while (tableSize < playerIndex || playerIndex < 0) {
            playerIndex =  Console.askForInt("Request from (Number): ") - 1;
        }
        boolean hasCardType = table.getPlayers().get(playerIndex).hasMatch(cardType);
        if (hasCardType) {
            for(String card: table.getPlayers().get(playerIndex).getGiveAway()) {
                requester.addCard(card);
            }
            table.getPlayers().get(playerIndex).clearGiveAway();
            return true;
        }
        return false;
    }

    public void start() {
        while(table.getBookCount() != 13) {
            runRound();
        }
    }
}
