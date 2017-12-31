import java.util.Scanner;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
public class IOHandler implements ActionListener
{
    private Board board;
    private JButton displayButton; 
    public IOHandler(Board board, JButton displayButton) 
    {
        this.board=board;
        this.displayButton=displayButton;
    }
    
    public void actionPerformed(ActionEvent e)
    {      
        JButton button=(JButton)e.getSource();
        int positionX=(int)button.getClientProperty("row");
        int positionY=(int)button.getClientProperty("column"); 
        int entry = board.numberOfEntries();
        if(board.getData(positionX, positionY) == 0) {
            if(entry % 2 == 0){
                board.addX(positionX, positionY);
                button.setForeground(Color.red);
                button.setText("X");
            }
            else{
                board.addO(positionX, positionY);
                button.setForeground(Color.black);
                button.setText("O");
            }
        }
        currentGameState();
    }

    public int currentGameState() 
    {
        int result = new CheckerImpl().check(board);
        if (result == 0) {
            if(board.numberOfEntries() % 2 == 0)
                displayButton.setText("X's turn");
            else 
                displayButton.setText("O's turn");
        }
        else {
            if (result == 1) {
                displayButton.setText("X wins");
            }
            else if (result == 2) {
                displayButton.setText("O wins");
            }
            else{
                displayButton.setText("Game Drawn");
            }
            GameInterface.deactivateGame();
        }
        return result;
    }
}

