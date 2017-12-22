package screen.rules;

import screen.home.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// RulesScreenController manages the navigation triggered
// by buttons on rules screen
public class RulesScreenController {

    RulesScreenView view;

    //constructor to initialize the view
    public RulesScreenController(RulesScreenView view){

        this.view = view;
        this.view.addListeners(new RulesListener());
    }

    // inner class to implement Action Listener
    class RulesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == view.getBackButton()){

                view.setVisible(false);
                Home.main();
            }
        }
    }
}
