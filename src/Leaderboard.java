import javax.swing.*;
import java.awt.*;

public class Leaderboard extends MainMenu{

    Leaderboard(){


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setForeground(new Color(255,255,255));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Leaderboard");

    }
}
