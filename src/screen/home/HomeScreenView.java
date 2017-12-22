package screen.home;

import javax.swing.*;
import java.awt.event.ActionListener;

// HomeScreenView is responsible for generating the
// GUI of the home screen of the game
public class HomeScreenView extends JFrame {

    //properties containing various components
    private JLabel backgroundImageLabel;
    private JButton startButton;
    private JButton rulesButton;
    private JButton exitButton;

    // constant strings representing relative paths to images used
    private final String BACKGROUND_IMAGE = "resources/background_battleship.png";
    private final String START_BUTTON_IMAGE = "resources/start_button.gif";
    private final String RULES_BUTTON_IMAGE = "resources/rules_button.png";
    private final String EXIT_BUTTON_IMAGE = "resources/exit_button.jpg";

    //constructor used to initialize components
    public HomeScreenView(){

        this.setBackgroundImageLabel();
        this.setStartButton();
        this.setRulesButton();
        this.setExitButton();

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

    // setting values for start button
    private void setStartButton() {

        startButton = new JButton();
        getStartButton().setBounds(150,200,200,50);
        getStartButton().setIcon(new ImageIcon(START_BUTTON_IMAGE));
        backgroundImageLabel.add(getStartButton());
    }

    // setting values for rules button
    private void setRulesButton() {

        rulesButton = new JButton();
        getRulesButton().setBounds(150,300,190,58);
        getRulesButton().setIcon(new ImageIcon(RULES_BUTTON_IMAGE));
        backgroundImageLabel.add(getRulesButton());
    }

    //setting values for exit button
    private void setExitButton() {

        exitButton = new JButton();
        getExitButton().setBounds(155, 405, 178, 64);
        getExitButton().setIcon(new ImageIcon(EXIT_BUTTON_IMAGE));
        backgroundImageLabel.add(getExitButton());
    }

    // adding listeners to buttons
    public void addListeners(ActionListener homeListener){

        getStartButton().addActionListener(homeListener);
        getRulesButton().addActionListener(homeListener);
        getExitButton().addActionListener(homeListener);
    }

    // getters for buttons

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getRulesButton() {
        return rulesButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
