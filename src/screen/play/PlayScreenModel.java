package screen.play;

import java.util.Map;

// PlayScreenModel takes the data presented by the user in the
// play screen and returns the value computed from it
public class PlayScreenModel {

    // properties
    private int xUserTarget; //x coordinate where the user picked to fire
    private int yUserTarget; //y coordinate where the user picked to fire

    private int xComputerTarget; //x coordinate where the computer picked to fire
    private int yComputerTarget; //y coordinate where the computer picked to fire

    // property containing the x and y coordinates of
    // each user or computer ship, the key is the x coordinate
    // of the ship and value is the y coordinate of the ship
    private Map<Integer, Integer> userShipCoordinate;
    private Map<Integer, Integer> computerShipCoordinate;

    // variables keeping game score
    private int userScore = 0;
    private int computerScore = 0;

    // getter setter for all properties

    public int getxUserTarget() {
        return xUserTarget;
    }

    public void setxUserTarget(int xUserTarget) {
        this.xUserTarget = xUserTarget;
    }

    public int getyUserTarget() {
        return yUserTarget;
    }

    public void setyUserTarget(int yUserTarget) {
        this.yUserTarget = yUserTarget;
    }

    public int getxComputerTarget() {
        return xComputerTarget;
    }

    public void setxComputerTarget(int xComputerTarget) {
        this.xComputerTarget = xComputerTarget;
    }

    public int getyComputerTarget() {
        return yComputerTarget;
    }

    public void setyComputerTarget(int yComputerTarget) {
        this.yComputerTarget = yComputerTarget;
    }

    public Map<Integer, Integer> getUserShipCoordinate() {
        return userShipCoordinate;
    }

    public void setUserShipCoordinate(Map<Integer, Integer> userShipCoordinate) {
        this.userShipCoordinate = userShipCoordinate;
    }

    public Map<Integer, Integer> getComputerShipCoordinate() {
        return computerShipCoordinate;
    }

    public void setComputerShipCoordinate(Map<Integer, Integer> computerShipCoordinate) {
        this.computerShipCoordinate = computerShipCoordinate;
    }

    public int getUserScore() {
        return userScore;
    }

    public void incrementUserScore() {
        this.userScore++;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void incrementComputerScore() {
        this.computerScore++;
    }
}
