package screen.rules;

import javax.swing.*;
import java.awt.event.ActionListener;

// RulesScreenView is responsible for generating the
// GUI of the rules screen of the game
public class RulesScreenView extends JFrame {

    //properties containing various components
    private JLabel backgroundImageLabel;
    private JButton backButton;

    // constant strings representing relative paths to images used
    private final String BACKGROUND_IMAGE = "resources/background_rules.png";
    private final String BACK_BUTTON_IMAGE = "resources/back_button.png";

    //constructor used to initialize components
    public RulesScreenView(){

        this.setBackgroundImageLabel();
        this.setBackButton();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1350,700);
        this.setVisible(true);
    }

    // setting values for background label
    private void setBackgroundImageLabel() {

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setBounds(0,0,1350,700);
        backgroundImageLabel.setIcon(new ImageIcon(BACKGROUND_IMAGE));
        this.add(backgroundImageLabel);
    }

    //setting values for back button
    private void setBackButton() {

        backButton = new JButton();
        getBackButton().setBounds(100,500,200,50);
        getBackButton().setIcon(new ImageIcon(BACK_BUTTON_IMAGE));
        backgroundImageLabel.add(getBackButton());
    }

    // adding listener to button
    public void addListeners(ActionListener rulesListener){

        getBackButton().addActionListener(rulesListener);
    }

    // getter for button
    public JButton getBackButton() {
        return backButton;
    }
}
