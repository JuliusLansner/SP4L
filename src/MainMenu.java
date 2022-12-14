import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Action;

public class MainMenu implements ActionListener{

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    //JPanel panel = new JPanel();
    JLabel textfield = new JLabel();


    JButton startGame = new JButton("Start game");
    JButton leaderboard = new JButton("Leaderboards");


    void aMainMenu() {



        //panel.setBorder(BorderFactory.createEmptyBorder(250,250,250,250));
        //panel.setLayout(new GridLayout(0,1));
        //panel.add(startGame);
        //panel.setBorder(BorderFactory.createEmptyBorder(250,250,250,250));
        //panel.setLayout(new GridLayout(0,1));
        //panel.add(leaderboard);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //Text
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setForeground(new Color(255,255,255));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Math Sorcery");

        //text background
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.setBackground(new Color(0,0,0));

        //Panel for buttons
        //button_panel.setLayout(new GridLayout(3, 3));

        //lb.setBackground(new Color(0, 0, 0));

        //panel.setLayout(new FlowLayout(FlowLayout.CENTER,200,100));

        startGame.addActionListener(this);
        /*Button Leaderboard = new Button("Leaderboard");
        button_panel2.setLayout(new FlowLayout(FlowLayout.LEFT,250,200));
        button_panel2.add(Leaderboard);*/

        //adding the text to the titel panel, making text align with where we want it according to the title panel
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        //frame.add(panel,BorderLayout.CENTER);
        //frame.add(panel,BorderLayout.CENTER);

        //panel.add(startGame);
        //frame.add(button_panel2);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        StartGame startgame = new StartGame();
       // startgame.aStartGame();
        frame.setVisible(false);
        frame.dispose();
    }
}

