package screen.select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// SelectScreenView is responsible for generating the
// GUI of the select screen of the game
public class SelectScreenView extends JFrame {

    //properties containing various components
    private JLabel backgroundImageLabel;
    private JLabel titleLabel;
    private JLabel rowTitleLabel;
    private JLabel columnTitleLabel;
    private JLabel[] shipNumberLabel; // array of size 9 to display ship number
    private JTextField[][] shipCoordinatesTextField; // 9 x 2 matrix to input x and y coordinates of 9 user ships
    private JButton submitButton;

    // constant strings representing relative paths to images used
    private final String BACKGROUND_IMAGE = "resources/background_battleship.png";
    private final String PLAY_BUTTON_IMAGE = "resources/play_button.png";

    //constructor used to initialize components
    public SelectScreenView(){

        this.setBackgroundImageLabel();
        this.setTitleLabel();
        this.setRowTitleLabel();
        this.setColumnTitleLabel();
        this.setShipNumberLabel();
        this.setShipCoordinatesTextField();
        this.setSubmitButton();

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

    // setting values for title label
    public void setTitleLabel() {

        titleLabel = new JLabel("PLace Your Fleet");
        titleLabel.setBounds(150,10,500,50);
        titleLabel.setFont(new Font("serif", Font.BOLD,36));
        backgroundImageLabel.add(titleLabel);
    }

    // setting values for row label
    public void setRowTitleLabel() {

        rowTitleLabel = new JLabel("ROW");
        rowTitleLabel.setBounds(300,50,100,30);
        rowTitleLabel.setFont(new Font("serif",Font.BOLD,32));
        backgroundImageLabel.add(rowTitleLabel);
    }

    // setting values for column label
    public void setColumnTitleLabel() {

        columnTitleLabel = new JLabel("COLUMN");
        columnTitleLabel.setBounds(400,50,200,30);
        columnTitleLabel.setFont(new Font("serif",Font.BOLD,32));
        backgroundImageLabel.add(columnTitleLabel);
    }

    // setting values for ship number label
    public void setShipNumberLabel() {

        shipNumberLabel = new JLabel[9];
        int y = 100;

        for (int i = 0; i < 9; i++){

            shipNumberLabel[i] = new JLabel();
            shipNumberLabel[i].setText("Ship " + (i + 1));
            shipNumberLabel[i].setBounds(100, y,100,30);
            y = y + 50;
            shipNumberLabel[i].setFont(new Font("serif",Font.BOLD,32));
            backgroundImageLabel.add(shipNumberLabel[i]);
        }
    }

    // setting values for input fields
    public void setShipCoordinatesTextField() {

        shipCoordinatesTextField = new JTextField[9][2];
        int x;
        int y = 100;

        for (int i = 0; i < 9; i++){

            x = 300;

            for (int j = 0; j < 2; j++){

                getShipCoordinatesTextField()[i][j] = new JTextField();
                getShipCoordinatesTextField()[i][j].setBounds(x, y, 50,20);
                backgroundImageLabel.add(getShipCoordinatesTextField()[i][j]);
                x = 400;
            }

            y = y + 50;
        }
    }

    // setting values for submit button
    public void setSubmitButton() {

        submitButton = new JButton();
        submitButton.setBounds(200,580,100,50);
        submitButton.setIcon(new ImageIcon(PLAY_BUTTON_IMAGE));
        backgroundImageLabel.add(submitButton);
    }

    // adding listeners to buttons
    public void addListeners(ActionListener selectListener){

        getSubmitButton().addActionListener(selectListener);
    }

    // getter for submit button
    public JButton getSubmitButton() {
        return submitButton;
    }

    // getter for ser ship coordinates
    public JTextField[][] getShipCoordinatesTextField() {
        return shipCoordinatesTextField;
    }

    // display error if data not consistent in the fields
    // i.e value of coordinate between 0 and 9
    public void errorPopUp(String message){

        JOptionPane.showMessageDialog(this, message);
    }
}
