package screen.select;

import screen.play.Play;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// SelectScreenController sends the user data
//entered in the view to the model
public class SelectScreenController {

    SelectScreenModel model;
    SelectScreenView view;

    //constructor to initialize the view
    public SelectScreenController(SelectScreenModel model, SelectScreenView view){

        this.model = model;
        this.view = view;
        this.view.addListeners(new selectListener());
    }

    // inner class to implement Action Listener
    class selectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                model.setShipCoordinates(view.getShipCoordinatesTextField());
                view.setVisible(false);
                Play.main();
            }

            catch (Exception e1) {

                view.errorPopUp("Please check that no field is empty and all values are between 0 and 9 inclusive");
            }
        }
    }
}
