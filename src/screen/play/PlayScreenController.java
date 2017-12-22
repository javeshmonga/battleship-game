package screen.play;

import screen.end.End;
import screen.select.SelectScreenModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// PlayScreenController hands all interactions between
// the models and views
public class PlayScreenController {

    PlayScreenModel model;
    PlayScreenView view;

    // constructor to initialize values
    public PlayScreenController(PlayScreenModel model, PlayScreenView view){

        this.model = model;
        this.view = view;

        this.model.setUserShipCoordinate(SelectScreenModel.userShipCoordinates);
        this.model.setComputerShipCoordinate(Utility.generateComputerShipCoordinates());

        this.view.placeUserShips(this.model.getUserShipCoordinate());

        this.view.addListeners(new playListener());
    }

    // inner class to implement Action Listener
    class playListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

            int x = Integer.parseInt(view.getRowTextField().getText());
            int y = Integer.parseInt(view.getColumnTextField().getText());

                if (x < 0 || x > 9 || y < 0 || y > 9)
                    throw new Exception(); //caught in caller

            model.setxUserTarget(x);
            model.setyUserTarget(y);

            model.setxComputerTarget(Utility.randomValueGenerator());
            model.setyComputerTarget(Utility.randomValueGenerator());

            //user's turn

            x = model.getxUserTarget();
            y = model.getyUserTarget();

            if (Utility.hit(x, y, model.getComputerShipCoordinate())){

                view.destroyComputerShip(x, y, true);
                model.incrementUserScore();
                view.getUserScoreLabel().setText("Score : "+model.getUserScore());
            }

            else {

                view.destroyComputerShip(x, y, false);
                model.incrementComputerScore();
                view.getComputerScoreLabel().setText("Score : "+model.getComputerScore());
            }

            //time gap between user and computer's turn

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            // computer's turn

            x = model.getxComputerTarget();
            y = model.getyComputerTarget();

            if (Utility.hit(x, y, model.getUserShipCoordinate())){

                view.destroyUserShip(x, y, true);
                model.incrementComputerScore();
                view.getComputerScoreLabel().setText("Score : "+model.getComputerScore());
            }

            else {

                view.destroyUserShip(x, y, false);
                model.incrementUserScore();
                view.getUserScoreLabel().setText("Score : "+model.getUserScore());
            }

            //check if game over

            if (Utility.gameOver(model.getUserScore(), model.getComputerScore())){

                view.setVisible(false);
                End.main(model.getUserScore(),model.getComputerScore());
            }

            }

            catch (Exception e1) {

                view.errorPopUp("Please check that no field is empty and all values are between 0 and 9 inclusive");
            }
        }
    }
}
