package screen.end;

import javax.swing.*;

// WinnerScreenView is responsible for generating the
// GUI of the win screen of the game
public class WinnerScreenView extends JFrame{

    //properties containing various components
    private JLabel backgroundImageLabel;

    // constant strings representing relative paths to images used
    private final String BACKGROUND_IMAGE = "resources/background_won.png";

    public WinnerScreenView(){

        this.setBackgroundImageLabel();

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
}
