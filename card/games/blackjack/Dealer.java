package card.games.blackjack;

import card.materials.InfiniteDeck;
import card.utils.UserInteractions.Calculator;
import card.utils.UserInteractions.Console;
import card.utils.UserInteractions.Parser;
import card.materials.Table;
import card.utils.UserInteractions.Menu;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* <h1>Dealer</h1>
* <p>
*   This class contains Deck and methods that handle players in the game,
*   this would be located in the Table class
* </p>
* @see card.materials.Table
* @author  Darius Rain
* @version 1.1
* @since   20-11-14
*/
public class Dealer extends Player implements Hand {

    private InfiniteDeck deck = new InfiniteDeck();
    private static final int RULE = 17;

    public Dealer(String name) {
        super(name);
    }

    /**
    * Checks if dealer has exceeded the limit of 17
    * @see Dealer#RULE
    * @return boolean
    */
    public boolean limit() {
        return RULE <= cardSum[0] || (didSplit && RULE <= cardSum[1]);
    }

    /**
    * Takes input and passes the integer as the user's buy in.
    * @param user -> Uses the buy in method since classes only within package.players can call it.
    * @see Player#buyIn(int)
    * @see Menu#askForInt(String)
    */
    public void getBuyIn(Player user) {
        int numberOfChips = Menu.askForInt("Buy in: $");
        user.buyIn(numberOfChips);
        Console.log("Your ID: " + user.id);
    }

    /**
    * Loops through a linked hashmap of {@code Player} classes expected to be passed as
    * an argument.  Before dealing the first card each player will be prompted for their
    * bet then the dealing continues on.
    * NOTE: Dealer also deals to itself
    * @param players -> {@code LinkedHashMap<String,Player>}
    * @see Player
    * @see LinkedHashMap
//    * @see BlackJack#start()
//    * @see Calculator#bet(int)
    */
    public void dealRound(LinkedHashMap<String, Player> players) {
        // https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
        deck.reset();
        int dealCount = 0;
        while ( dealCount++ < 2 ) {
            // Class made for iterating collections,  similar to Scanner.nextLine()
            Iterator iterator = players.entrySet().iterator();
            while (iterator.hasNext()) {
                // This returns the key and value in object.
                Map.Entry obj = (Map.Entry)iterator.next();
                Player onPlayer = (Player) obj.getValue();


                if (dealCount == 1) {
                    onPlayer.display();
//                    int numberOfChips = Calculator.bet(onPlayer.chips);
//                    onPlayer.bet(numberOfChips);
                }

                onPlayer.hit(deck.draw(), false);
                if (Parser.isBlackJack(onPlayer.cardSum[0])) {
                    Console.log("****** ( Blackjack Bonus ) ******");
                    onPlayer.blackjack = true;
                    Console.logf(onPlayer.name + " -> ");
//                    Menu.blackJack();
                }
            }

            // This is the the Dealer's hand
            this.hit(deck.draw(), false);
            if (Parser.isBlackJack(this.cardSum[0])) {
                this.blackjack = true;
                Console.logf(this.name + " -> ");
//                Menu.blackJack();
            }

        }
    }


    /**
     * Iterates through a linked hashmap from the Table class then displays
     * and asks each player if they want to hit. Then the dealer hits himself
     * based on sum being less than 17.
     * @param players Linked hashmap of players to be iterated through.
     * @see Table
//     * @see Calculator#deliverHit(Player, Deck)
//     * @see BlackJack#start()
    */
    public void dealHits(LinkedHashMap<String, Player> players) {

        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        Iterator iterator = players.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry obj = (Map.Entry) iterator.next();
            Player onPlayer = (Player) obj.getValue();
            if (!onPlayer.blackjack) {
                Menu.log("Dealer card: " + cards.get("normal").get(0));
//                Calculator.deliverHit(onPlayer, deck);
            } else {
                Menu.log(onPlayer.name + "ID#" + onPlayer.id + " )" + " got blackjack");
            }

        }
        // Else must be on dealer
//        Calculator.deliverHit(this, deck);
    }


    /**
    * Iterates through players and add chips or subtract chips bet by each player.  Based on
    * each player's comparison to the dealer.  And for players who got blackjack they get x2.5 and double x2.
    * @param players
    * @see card.materials.Table
//    * @see BlackJack#start()
//    * @see Calculator#determineWinner(Player, Dealer)
    */
    public void dispense(LinkedHashMap<String, Player> players) {
            Console.clearScreen();
            Console.log("Game Results: ");
            Iterator iterator = players.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry obj = (Map.Entry)iterator.next();
                Player onPlayer = (Player) obj.getValue();
//                Calculator.determineWinner(onPlayer, this);
            }

            // Clear dealers fields for new round.
            this.clear();
            Console.clearScreen();

    }

}
