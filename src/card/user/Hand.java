package card.user;

import card.games.blackjack.BlackJackDealer;
import card.games.blackjack.BlackJackPlayer;

/**
* <h1>Hand</h1>
* <p>
*     This interface contains all the methods needed to handle a player's or even dealers hand
 *     contains methods for adding cards to players hand, adding to players total sum and seeing if the player busted.
 *     as well as many more helpers for the process checkout the comments below to learn more.
* </p>
 * @see BlackJackDealer
 * @see BlackJackPlayer
* @author  Darius Rain
* @version 1.1
* @since   20-11-23
*/
public interface Hand {

    /**
    * Adds card to either split or normal arraylist
    * @param card -> Card to be added to arraylist
     * @see BlackJackPlayer#addCard(String, boolean)
     * @see BlackJackPlayer#cards
    * @return Nothing
    */
    void addCard(String card);

    /**
    * Clears hand for a new deal.
    * @see BlackJackPlayer#clear()
    * @return Nothing
    */
    void clear();


    /**
    * Displays a player's hand and total sum of cards
     * Note: Dealer implements all of the above too.
    * @see BlackJackPlayer#display()
    * @return Nothing
    */
    void displayHand();


}
