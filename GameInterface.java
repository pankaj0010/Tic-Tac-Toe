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
public class GameInterface implements ActionListener
{
    private Board board;
    private static IOHandler IOhandler;
    private static JButton button[][]=new JButton[3][3];
    JButton textButton=new JButton();
    public GameInterface() 
    {
        board = new BoardImpl();
        IOhandler = new IOHandler(board,textButton);
    }
    public void actionPerformed(ActionEvent e)
    {
        startNewGame();
    }
    private void startNewGame()
    {
        deactivateGame();
        board=new BoardImpl();
        textButton.setText("X's turn");
        IOhandler = new IOHandler(board,textButton);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setEnabled(true);
                button[i][j].setText("");
                button[i][j].addActionListener(IOhandler);
            }
        }
    }
    public static void deactivateGame()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                button[i][j].removeActionListener(IOhandler);
    }
    private void init()
    {
        JFrame frame=new JFrame("Tic Tac Toe");
        JPanel boardPanel=new JPanel();
        JPanel textPanel=new JPanel();
        JButton newButton=new JButton("New Game");

        JPanel mainPanel=new JPanel();
        boardPanel.setSize(new Dimension(300,240));
        textPanel.setSize(new Dimension(300,60));

        //textButton.setEnabled(false);
        textButton.setBackground(new Color(100,50,90));
        textButton.setForeground(Color.white);
        newButton.setBackground(new Color(100,50,90));
        newButton.setForeground(Color.white);
        newButton.addActionListener(this);
        newButton.setContentAreaFilled(false);
        newButton.setOpaque(true);
        newButton.setFocusPainted(false);
        newButton.setRolloverEnabled(false);
        
        mainPanel.setLayout(new BorderLayout());
        boardPanel.setLayout(new GridLayout(3,3));
        textPanel.setLayout(new GridLayout(1,2));  

        
        textButton.setText("X's turn");
        textButton.setContentAreaFilled(false);
        textButton.setFocusPainted(false);
        textButton.setRolloverEnabled(false);
        textButton.setOpaque(true);
        textPanel.add(textButton);
        textPanel.add(newButton);

        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(textPanel, BorderLayout.SOUTH);

              
        frame.setSize(300,300);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
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
