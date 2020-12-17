package card.games.blackjack;

import card.materials.Table;
import card.utils.generators.RandomIdGenerator;

import java.util.LinkedHashMap;

public class BlackJackTable implements Table {

    private LinkedHashMap<String, BlackJackPlayer> players = new LinkedHashMap<>();
//    private Dealer dealer = new Dealer("House");
    private String[] order;
    private int onPlayer = 0;
    private int chips = 0;
    public static final int MAX = 7;



    /**
     * Removes player from hashmap that is no longer playing.
     * @see BlackJackPlayer
     * @return Nothing
     */
//    public void removePlayers() {
//        Iterator iterator = players.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//
//            Map.Entry obj = (Map.Entry) iterator.next();
//            Player onPlayer = (Player) obj.getValue();
//
//            if (!onPlayer.hasChips()) {
//                iterator.remove();
//            }
//
//        }
//    }

    /**
     * Runs a loop until either table is full or user rejects going further answering (y/n)
//     * @see Menu#choice(String)
     * @return Nothing
     */
    public void loadPlayers() {
        onPlayer = 0;
//         Take in new players if table is not full and Yes is answered.
//        Menu.newRound();
//        while (Menu.choice("New player") && !full()) {
//            String playerName = Menu.askForString("Player name: ");
//            Player user = new Player(playerName);
//            dealer.getBuyIn(user);
//            newPlayer(user);
//        }

    }


    /**
     * Adds new player to players hashmap.
//     * @param user -> Player Object that gets added to the players hashmap.
     * @see BlackJackPlayer
     * @see RandomIdGenerator#toKey(String, String)
     * @return Nothing
     */
    public void newPlayer(BlackJackPlayer player) {

    }

    public void removePlayers() {

    }


    /**
     * Returns the dealer field from the Table class.
     * @see Table#dealer
     * @see BlackJackDealer
     * @return Dealer
     */
//    public Dealer getDealer() { return dealer; }

    /**
     * Returns the players field from the Table class
     * @see Table#players
     * @see LinkedHashMap
     * @return LinkedHashMap<String, Player>
     */
//    public LinkedHashMap<String, Player> getPlayers() { return players; }


    /**
     * Checks if table is empty by checking players size.
     * @see Table#players
     * @return boolean
     */
    public boolean empty() { return players.size() == 0; }

    /**
     * Checks if table is full by checking players size.
     * @see Table#players
     * @return boolean
     */
    public boolean full() { return MAX < players.size(); }



}

