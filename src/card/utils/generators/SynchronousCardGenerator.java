package card.utils.generators;

public class SynchronousCardGenerator implements CardGenerator {
   private int onSuit = 0;
   private int onCard = 1;

   /**
    * Returns a string representing the suit which could be any string in the SUITS array
    * @see RandomNumberGenerator#generate(int)
    * @return String
    */
   public String suit() {
      return SUITS[onSuit];
   }

   /**
    * Could return any face value ranging from (2,3,4,5 ... 10, Jack, Queen, King, Ace) at random.
    * @see RandomNumberGenerator#generate(int)
    * @return String
    */
   public String face() {
      if (onCard <= 10) {
         return onCard + "";
      } else {
//         faceValue = RandomNumberGenerator.generate(FACES.length);
         return FACES[(onCard - 10) - 1];
      }
   }

   /**
    * Returns a random suit with a random face by using the above methods.
    * @return String
    */
   public String nextCard() {
      logic();
      return suit() + face();
   }


   private void logic() {
      if(onCard == 14) {
         onCard = 2;
         onSuit += 1;
      } else {
         onCard += 1;
      }
   }
}
