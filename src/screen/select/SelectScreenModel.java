package screen.select;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

// SelectScreenModel contains the data entered by user
// in the select screen
public class SelectScreenModel {

    // property containing the x and y coordinates of
    // each user ship., the key is the x coordinate
    // of the ship and value is the y coordinate of the ship
    private Map<Integer, Integer> shipCoordinates;

    public static Map<Integer,Integer> userShipCoordinates;// static field for use by PlayScreenController

    // constructor tio initialize property
    public SelectScreenModel(){

        this.shipCoordinates = new HashMap<>();
    }

    // getter for the data
    public Map<Integer, Integer> getShipCoordinates() {
        return shipCoordinates;
    }

    // setter for the data
    public void setShipCoordinates(JTextField[][] shipCoordinates) throws Exception {

        int x;
        int y;

        for (int i = 0; i < 9; i++){

            x = Integer.parseInt(shipCoordinates[i][0].getText());
            y = Integer.parseInt(shipCoordinates[i][1].getText());

            if (x < 0 || x > 9 || y < 0 || y > 9)
                throw new Exception(); //caught in caller

            this.getShipCoordinates().put(x, y);
        }

        SelectScreenModel.userShipCoordinates = this.getShipCoordinates();
    }
}
