package card.user;

import card.games.blackjack.BlackJackPlayer;

/**
* <h1>Purchases</h1>
* <p>
*     This interface will be implemented by only the player
* </p>
* @author  Darius Rain
* @version 1.0
* @since   YY-MM-DD
*/
public interface Purchases {

    /**
     * Player can bet chips
     *  NOTE: Chips are not subtracted from bet during thi
     * @see BlackJackPlayer#bet
     * @param chips Chips to bet
     * @return boolean -> lets calling class know if the bet is valid
     */
    boolean bet(int chips);


    /**
    * Gives back true or false depending if player has no chips
    * @see BlackJackPlayer#hasChips()
    * @return boolean
    */
    boolean hasChips();

    /**
     * Returns the chips gained or lost by player, by subtracting the amount of chips purchased
     * to the amount chips currently in the player's possession.
     * @see BlackJackPlayer#chips
     * @see BlackJackPlayer#chipsPurchased
     * @return int The amount of chips player profited
     */
    int winnings();



    /**
    * Player gives the buy in amount of chips a player, also numbers out of range of int will be handled prior.
    * @param chips The amount of chips a player is betting
    * @see BlackJackPlayer#buyIn(int chips)
    * @return Nothing
    */
    void buyIn(int chips);


}
