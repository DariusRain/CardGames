package card.utils.generators;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
* <h1>IdGenerator</h1>
* <p>
*     General purpose ID generator, generates a number from 1 to 1000 into a string.
 *     Good for dealing with users with the same name and obviously identifying users.
* </p>
* @author  Darius Rain
* @version 1.1
* @since  20-11-24
*/
public class RandomIdGenerator extends RandomNumberGenerator {

    public static HashMap<String, String> users = new HashMap<>();
    public static Set<String> ids = new HashSet<>();

    /**
    * Returns a unique id for a user
    * @param playerName
    * @return String
    */
    public static String id(String playerName) {

        int lastSize = ids.size() * 1;

        String id = generate(1000) + "";

        ids.add(id);

        if(ids.size() == lastSize) {
            return id(playerName);
        }

        users.put(id, playerName);

        return id;
    }


    /**
    * Returns a key for use in other hashmaps.
    * @param name
     * @param  id
     * @see card.materials.Table
    * @return String
    */
    public static String toKey(String name, String id) {return name + "-" + id;}

}
