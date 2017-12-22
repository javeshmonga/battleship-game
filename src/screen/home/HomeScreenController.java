package screen.home;

import screen.rules.Rules;
import screen.select.Select;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// HomeScreenController manages the navigation triggered
// by buttons on home screen
public class HomeScreenController {

    HomeScreenView view;

    //constructor to initialize the view
    public HomeScreenController(HomeScreenView view){

        this.view = view;
        this.view.addListeners(new HomeListener());
    }

    // inner class to implement Action Listener
    class HomeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == view.getExitButton()){

                System.exit(0);
            }

            if (e.getSource() == view.getRulesButton()){

                view.setVisible(false);
                Rules.main();
            }

            if (e.getSource() == view.getStartButton()){

                view.setVisible(false);
                Select.main();
            }
        }
    }
}
