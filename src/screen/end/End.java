package screen.end;

public class End {

    public static void main(int userScore, int computerScore){

        if (userScore > computerScore)
            new WinnerScreenView();

        else
            new LoserScreenView();
    }
}
