package screen.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

// SelectScreenView is responsible for generating the
// GUI of the play screen of the game
public class PlayScreenView extends JFrame{

    //properties containing various components
    private JLabel backgroundImageLabel;

    // all the labels in the screen
    private JLabel titleLabel;
    private JLabel userNameLabel;
    private JLabel computerNameLabel;
    private JLabel rowLabel;
    private JLabel columnLabel;

    // labels keeping score for the game
    private JLabel userScoreLabel;
    private JLabel computerScoreLabel;

    // text fields that take in the user input
    private JTextField rowTextField;
    private JTextField columnTextField;

    //the fire button and both player grids are made of buttons
    private JButton fireButton; // button to submit the x and y values of a fire
    private JButton[][] userGrid; // 11 x 11 grid
    private JButton[][] computerGrid; // 11 x 11 grid

    // constant strings representing relative paths to images used
    private final String BACKGROUND_IMAGE = "resources/background_water.jpg";
    private final String FIRE_BUTTON_IMGAE = "resources/fire_button.png";
    private final String ALIVE_SHIP_IMGAE = "resources/ship_icon.jpg";
    private final String DEAD_SHIP_IMAGE = "resources/destroyed_ship_icon.jpg";

    // constructor used to initialize components
    public PlayScreenView(){

        this.setBackgroundImageLabel();
        this.setTitleLabel();
        this.setRowLabel();
        this.setColumnLabel();
        this.setRowTextField();
        this.setColumnTextField();
        this.setFireButton();
        this.setUserGrid();
        this.setComputerGrid();
        this.setComputerNameLabel();
        this.setUserNameLabel();
        this.setGridMarginLabel();
        this.setUserScoreLabel();
        this.setComputerScoreLabel();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1350,750);
        this.setVisible(true);

    }

    // setting values for background label
    private void setBackgroundImageLabel() {

        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setBounds(0,0,1350,750);
        backgroundImageLabel.setIcon(new ImageIcon(BACKGROUND_IMAGE));
        this.add(backgroundImageLabel);
    }

    // setting value for title
    private void setTitleLabel() {

        titleLabel = new JLabel("Enter value");
        titleLabel.setBounds(610,150,140,100);
        titleLabel.setFont(new Font("serif",Font.BOLD,24));
        backgroundImageLabel.add(titleLabel);
    }

    // setting value for label containing name of user
    private void setUserNameLabel() {

        userNameLabel = new JLabel("Home Field");
        userNameLabel.setBounds(200,550,600,100);
        userNameLabel.setFont(new Font("serif",Font.BOLD,32));
        backgroundImageLabel.add(userNameLabel);
    }

    // setting value for label containing name of computer
    private void setComputerNameLabel() {

        computerNameLabel = new JLabel("Opponent Field");
        computerNameLabel.setBounds(900,550,600,100);
        computerNameLabel.setFont(new Font("serif",Font.BOLD,32));
        backgroundImageLabel.add(computerNameLabel);
    }

    // setting value of row label
    private void setRowLabel() {

        rowLabel = new JLabel("X");
        rowLabel.setBounds(620,230,50,30);
        rowLabel.setFont(new Font("serif",Font.BOLD,18));
        backgroundImageLabel.add(rowLabel);
    }

    // setting values of column label
    private void setColumnLabel() {

        columnLabel = new JLabel("Y");
        columnLabel.setBounds(670,230,90,30);
        columnLabel.setFont(new Font("serif",Font.BOLD,18));
        backgroundImageLabel.add(columnLabel);
    }

    // setting value of row text field
    private void setRowTextField() {

        rowTextField = new JTextField();
        getRowTextField().setBounds(620,260,50,20);
        backgroundImageLabel.add(getRowTextField());
    }

    // setting values of column text field
    private void setColumnTextField() {

        columnTextField = new JTextField();
        getColumnTextField().setBounds(680,260,50,20);
        backgroundImageLabel.add(getColumnTextField());
    }

    // setting values for fire button
    private void setFireButton() {

        fireButton = new JButton();
        getFireButton().setBounds(620,320,100,30);
        getFireButton().setIcon(new ImageIcon(FIRE_BUTTON_IMGAE));
        backgroundImageLabel.add(getFireButton());

    }

    // building the users battle grid
    private void setUserGrid() {

        userGrid = new JButton[11][11];

        int x;
        int y = -30;

        for (int i = 0; i < 11; i++){

            x = 50;
            y = y + 50;

            for (int j = 0; j < 11; j++){

                userGrid[i][j] = new JButton();
                userGrid[i][j].setBounds(x, y, 50, 50);
                x = x + 50;
                backgroundImageLabel.add(userGrid[i][j]);
            }
        }
    }

    // building the computer's battle grid
    private void setComputerGrid() {

        computerGrid = new JButton[11][11];

        computerGrid = new JButton[11][11];

        int x;
        int y = -30;

        for (int i = 0; i < 11; i++){

            x = 750;
            y = y + 50;

            for (int j = 0; j < 11; j++){

                computerGrid[i][j] = new JButton();
                computerGrid[i][j].setBounds(x, y, 50, 50);
                x = x + 50;
                backgroundImageLabel.add(computerGrid[i][j]);
            }
        }
    }

    // setting grid's margin labels as 1,2,3,4 ..
    private void setGridMarginLabel(){

        for (int i = 0; i < 10; i++){

            userGrid[i][10].setText(String.valueOf(i));
            userGrid[10][i].setText(String.valueOf(i));

            computerGrid[10][i].setText((String.valueOf(i)));
            computerGrid[i][10].setText((String.valueOf(i)));
        }
    }

    // method to place ships on user's grid
    // takes in a 9 x 2 matrix containing ship x and y coordinates
    public void placeUserShips(Map<Integer, Integer> shipCoordinate){

        for (Integer i : shipCoordinate.keySet()){

            userGrid[i][shipCoordinate.get(i)].setIcon(new ImageIcon(ALIVE_SHIP_IMGAE));
        }
    }

    // method to change image of user grid element
    // takes in the coordinate of the ship to destroy
    // and a flag to denote if it was a hit or miss
    public void destroyUserShip(int x, int y, boolean flag){

        if (flag)
            userGrid[x][y].setIcon(new ImageIcon(DEAD_SHIP_IMAGE));

        else
            userGrid[x][y].setIcon(new ImageIcon(BACKGROUND_IMAGE));
    }

    // method to change image of computer grid element
    // takes in the coordinate of the ship to destroy
    // and a flag to denote if it was a hit or miss
    public void destroyComputerShip(int x, int y, boolean flag){

        if (flag)
            computerGrid[x][y].setIcon(new ImageIcon(DEAD_SHIP_IMAGE));

        else
            computerGrid[x][y].setIcon(new ImageIcon(BACKGROUND_IMAGE));
    }

    // adding listeners to buttons
    public void addListeners(ActionListener playListener){

        getFireButton().addActionListener(playListener);
    }

    // getter for fire button
    public JButton getFireButton() {
        return fireButton;
    }

    // getter for x coordinate of target
    public JTextField getRowTextField() {
        return rowTextField;
    }

    //getter for y coordinate of target
    public JTextField getColumnTextField() {
        return columnTextField;
    }

    public JLabel getUserScoreLabel() {
        return userScoreLabel;
    }

    // getter setter for score labels

    public void setUserScoreLabel() {

        userScoreLabel = new JLabel("Score : 0");
        userScoreLabel.setBounds(200,580,600,100);
        userScoreLabel.setFont(new Font("serif",Font.BOLD,32));
        userScoreLabel.setForeground(Color.RED);
        backgroundImageLabel.add(userScoreLabel);
    }

    public JLabel getComputerScoreLabel() {
        return computerScoreLabel;
    }

    public void setComputerScoreLabel() {

        computerScoreLabel = new JLabel("Score : 0");
        computerScoreLabel.setBounds(900,580,600,100);
        computerScoreLabel.setFont(new Font("serif",Font.BOLD,32));
        computerScoreLabel.setForeground(Color.RED);
        backgroundImageLabel.add(computerScoreLabel);
    }

    // display error if data not consistent in the fields
    // i.e value of coordinate between 0 and 9
    public void errorPopUp(String message){

        JOptionPane.showMessageDialog(this, message);
    }
}
