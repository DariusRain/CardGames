package card.utils.generators;

//import RandomNumberGenerator;
/**
* <h1>CardGenerator</h1>
* <p>
*   This class generates any player card based on random integer values that could be used to for the face
 *   value or an index in a array of strings for special non number cards.  Could do everything with numbers but wanted
 *   to give the user the comfort of readability. Cards will be parsed as values using the Parser class and the methods
 *   it contains.
* </p>
 * @see card.utils.UserInteractions.Parser
 * @see card.utils.UserInteractions.Parser#cardValue(String, int)
* @author  Darius Rain
* @version 1.1
* @since   20-11-24
*/
public class RandomCardGenerator implements CardGenerator {

    /**
    * Returns a string representing the suit which could be any string in the SUITS array
    * @see RandomNumberGenerator#generate(int)
    * @return String
    */
    public String suit() { return SUITS[RandomNumberGenerator.generate(SUITS.length) - 1]; }

    /**
    * Could return any face value ranging from (2,3,4,5 ... 10, Jack, Queen, King, Ace) at random.
    * @see RandomNumberGenerator#generate(int)
    * @return String
    */
    public String face() {
        int faceValue = RandomNumberGenerator.generate(FACE_VALUES);
        if (faceValue <= HIGH && faceValue > LOW) {
            return faceValue + "";
        } else {
            faceValue = RandomNumberGenerator.generate(FACES.length);
            return FACES[faceValue == FACES.length ? 0 : faceValue];
        }
    }

    /**
    * Returns a random suit with a random face by using the above methods.
    * @return String
    */
    public String nextCard() {
        return suit() + face();
    }

}
