package screen.play;

import java.util.HashMap;
import java.util.Map;

// Utility class responsible for containing
// all the computations and sub-services used
// methods are static for easy use in the controller
public class Utility {

    //max score constant
    private final static int MAX_SCORE = 18;

    // takes in the coordinates that were hit and
    // the map in which those coordinates are to be searched
    // return true iff the coordinates are found in the map
    public static boolean hit (int x, int y, Map<Integer, Integer> map){

        if (map.containsKey(x) && (y == map.get(x))){
            return true;
        }

        return false;
    }

    // method to generate computer's ship coordinates dynamically
    public static Map<Integer,Integer> generateComputerShipCoordinates() {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 9; i++){

            map.put((int)(Math.random()*10), (int)(Math.random()*10));
        }

        return map;
    }

    // random coordinate generator
    public static int randomValueGenerator(){

        return (int)(Math.random()*10);
    }

    // return true if game is over
    public static boolean gameOver(int userScore, int computerScore){

        if (userScore == MAX_SCORE || computerScore == MAX_SCORE){

            return true;
        }

        return false;
    }
}
