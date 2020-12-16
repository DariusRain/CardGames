package card.games.blackjack;
import card.user.Hand;
import card.user.Purchases;
import card.user.User;
import card.utils.UI.Console;
import card.utils.UI.Menu;
import card.utils.generators.RandomIdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


/**
* <h1>Player</h1>
* <p>
*     In this class contains a class made to meet a user's expectations during their experience in a virtual or
 *    a blackjack game at a casino or at home.
* </p>
* @author  Darius Rain
* @version 1.1
* @since   20-11-24
*/
public class BlackJackPlayer implements Hand, Purchases, User {

    protected HashMap<String, ArrayList<String>> cards = new HashMap<>();
    protected final static int BLACKJACK = 21;
    protected final static String SPLIT_HAND = "split";
    protected final static String NORMAL_HAND = "normal";
    protected boolean didSplit = false;
    protected boolean busted = false;
    protected boolean blackjack = false;
    protected boolean doubleDown = false;
    protected int[] cardSum = {0, 0};
    protected int chips = 0;
    protected int bet = 0;
    protected int chipsPurchased = 0;
    public String name;
    public String id;

    /**
    * This constructor only takes a name of a player.
     * Every other field above is default/pre-assigned except for the cards field.
     * Note: the cards field instantiates a hashmap of key:string-hand-type value:Arraylist<String>
    * @param name The only parameter expected
    * @see BlackJackDealer#dealRound(LinkedHashMap) Only place Player gets instantiated.
    */
    public BlackJackPlayer(String name) {
        this.name = name;
        id = RandomIdGenerator.id(name);
        cards.put(NORMAL_HAND, new ArrayList<>());
        cards.put(SPLIT_HAND, new ArrayList<>());
    }

    /**
    * Player can bet chips
    *  NOTE: Chips are not subtracted from bet during the hit, but the bet field is set.
    * @see BlackJackPlayer#bet
    * @param chips Chips to bet
    * @return boolean -> lets calling class know if the bet is valid
    */
    public boolean bet(int chips) {
        if (chips <= this.chips) {
            this.bet = chips;
            return true;
        }

        return false;

    }

    /**
    * Prints player info to the console.
//    * @see Menu#displayPlayer(String, String, int, int, int, int, boolean, HashMap)
    */
    public void display() { /*Menu.displayPlayer(name, id, chips, winnings(), cardSum[0], cardSum[1], didSplit, cards);*/ }



    @Override
    public boolean didWin() {
        return false;
    }


    /**
    *
    * @param houseBlackjack
    * @see ...
    */
    public void lost(boolean houseBlackjack) { this.chips -= houseBlackjack ? (int)(bet * 2.5) : doubleDown ? bet * 2 : bet; }


    /**
    * About ...
//    * @see Calculator#determineWinner(Player, Dealer)
    */
    public void win() { this.chips += blackjack ? (int)(bet * 2.5) : doubleDown ? bet * 2 : bet; }



    // Purchases Interface ================================================
    /**
    * Returns true or false if player can play based on the chips field.
    * @see Purchases#hasChips()
     * @see BlackJackDealer#dispense(LinkedHashMap)
     * @see #chips
    * @return ...
    */
    public boolean hasChips() { return 0 < chips; }

    /**
    * Returns the chips gained or lost by player, by subtracting the amount of chips purchased
    * to the amount chips currently in the player's possession.
    * @see BlackJackPlayer#chips
    * @see BlackJackPlayer#chipsPurchased
    * @return int The amount of chips player profited
    */
    public int winnings() { return chips - chipsPurchased; }

    /**
    * About ...
    * @param chips The amount of chips that a player decides to buy in with.
    * @see Purchases#buyIn(int)
    * @return Nothing
    */
    public void buyIn(int chips) {
        this.chipsPurchased += chips;
        this.chips += chips;
        Menu.log("Purchased: " + chipsPurchased);
        Menu.log(this.name + " now has " + this.chips + " chips...");
    }
    //==============================================================================


    // Hand interface ==============================================================
    /**
    * Adds to normalCardSum or splitCardSum
    * @param card
     * @param isSplit
    * @see Hand#hit(String, boolean)
    * @return Nothing
    */
    public void hit(String card, boolean isSplit) {
        int index = isSplit ? 1 : 0;
        this.addCard(card, isSplit);
        cardSum[index] += BlackJackParser.cardValue(card, this.cardSum[index]);
    }


    /**
    * Checks if a player's normal hand sum or if split hand both are over 21
    * @see Hand#didBust()
    * @return boolean
    */
    public boolean didBust() {
        if (BLACKJACK < this.cardSum[0] || (this.didSplit && BLACKJACK < cardSum[1])) {
            Menu.log("Busted!");
            this.busted = true;
            return true;
        }
        return false;
    }


    /**
     * ( Feature will be added soon! )
     * @see ...
     * @return Nothing
     */
    public void split() { didSplit = true;}

    /**
    * Adds a card to either a player's normal or split hand
    * @param card What gets added to a player or even dealers hand.
     * @param isSplit Determines if card should be added to split hand if so it would be true.
    * @see Hand#addCard(String, boolean)
    * @return ...
    */
    public void addCard(String card, boolean isSplit) { cards.get(isSplit ? "split" : "normal").add(card);}



    /**
     * ( Feature will be added soon!)
     * @see ...
     * @return Nothing
     */
    public void doubleDown() { doubleDown = true;}

    @Override
    public void addCard(String card) {

    }

    /**
     * Clears a player's hand, boolean, integer values for the next round.
     * @see BlackJackDealer#dispense(LinkedHashMap)
     * @return Nothing
     */
    public void clear() {
        didSplit = false;
        busted = false;
        blackjack = false;
        doubleDown = false;
        bet=0;
        cardSum[0] = 0;
        cardSum[1] = 0;
        cards.get("normal").clear();
        cards.get("split").clear();
    }

    @Override
    public void displayHand() {

    }


    public void scan(boolean isSplit) {
        ArrayList<String> aces = new ArrayList<>();
        int index = isSplit ? 1 : 0;
        cardSum[index] = 0;
        for(String card: cards.get(isSplit ? SPLIT_HAND : NORMAL_HAND)) {
            if(BlackJackParser.isAce(card)) {
                aces.add(card);
            } else {
                cardSum[index] += BlackJackParser.cardValue(card, cardSum[index]);
            }
        }
        for(String ace: aces) {
            cardSum[index] += BlackJackParser.cardValue(ace, cardSum[index]);
        }
        Console.log("Scan count: " + cardSum[index]);
    }
    //==============================================================================

    public int getNormalCardSum() {
        return cardSum[0];
    }

    public int getSplitCardSum() {
        return cardSum[1];
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public int getBet() {
        return bet;
    }

    public boolean isDidSplit() {
        return didSplit;
    }
}


