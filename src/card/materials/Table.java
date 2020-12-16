package card.materials;

//import blackjack.Dealer;
//import card.games.blackjack.Player;
import card.games.blackjack.BlackJackPlayer;
import card.games.gofish.GoFishPlayer;

/**
* <h1>Table</h1>
* <p>
*     Holds list of players, a dealer and methods that performs operations on them (i.e players, dealer).
* </p>
//* @see Dealer
//* @see Player
* @author  Darius Rain
* @version 1.0
* @since   2020-11-14
*/

public interface Table {

    boolean empty();
//
    boolean full();

}
