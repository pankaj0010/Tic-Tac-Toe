import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameInterface
{
    Board board;
    IOHandler IOhandler;
    private static JButton button[][]=new JButton[3][3];
    JButton textButton=new JButton();
    public GameInterface() 
    {
        board = new BoardImpl();
        IOhandler = new IOHandler(board,textButton);
    }
    public static void deactivateGame()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                button[i][j].setEnabled(false);
    }
    private void init()
    {
        JFrame frame=new JFrame("Tic Tac Toe");
        JPanel boardPanel=new JPanel();
        JPanel textPanel=new JPanel();

        JPanel mainPanel=new JPanel();
        boardPanel.setSize(new Dimension(300,240));
        textPanel.setSize(new Dimension(300,60));

        mainPanel.setLayout(new BorderLayout());
        boardPanel.setLayout(new GridLayout(3,3));
        textPanel.setLayout(new BorderLayout());  

        
        textButton.setText("X's turn");
        textButton.setContentAreaFilled(false);
        textButton.setFocusPainted(false);
        textButton.setRolloverEnabled(false);
        textButton.setOpaque(true);
        textPanel.add(textButton);

        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(textPanel, BorderLayout.SOUTH);

              
        frame.setSize(300,300);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IOHandler actions = new IOHandler(board,textButton); 
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j]=new JButton();
                Color color=new Color(244,164,96);
                button[i][j].setContentAreaFilled(false);
                button[i][j].setOpaque(true);
                button[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                button[i][j].setBackground(color);
                button[i][j].setFocusPainted(false);
                button[i][j].setRolloverEnabled(false);
                button[i][j].putClientProperty("row",i);
                button[i][j].putClientProperty("column",j);
                boardPanel.add(button[i][j]);
                button[i][j].addActionListener(IOhandler);
            }
        }
        frame.setVisible(true);
    }

    public void run() 
    {
        init();
    }
    
    public static void main(String[] args){
        new GameInterface().run();
    }
}
