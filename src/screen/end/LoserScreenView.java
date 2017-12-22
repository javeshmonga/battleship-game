package screen.end;

import javax.swing.*;

// LoserScreenView is responsible for generating the
// GUI of the lost screen of the game
public class LoserScreenView extends JFrame {

    //properties containing various components
    private JLabel backgroundImageLabel;

    // constant strings representing relative paths to images used
    private final String BACKGROUND_IMAGE = "resources/background_lost.png";

    public LoserScreenView(){

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
