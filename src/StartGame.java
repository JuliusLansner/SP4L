import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StartGame implements ActionListener {
  String sql = "INSERT INTO users (users)" + "VALUES(?)";

private static JPanel panel = new JPanel();
private static JLabel Alabel;
private static JLabel Blabel;
private static JTextField AuserText = new JTextField(20);
private static JTextField BuserText = new JTextField(20);
private static JButton Continue = new JButton("Continue");
MainMenu screen = new MainMenu();

 ScreenDisplay sd = new ScreenDisplay();

  int pointsuserA;
  int pointsuserB;

    StartGame()  {
      sd.sd1.setSize(300,250);
      sd.sd1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      sd.sd1.setVisible(true);
      sd.sd1.add(panel);

      panel.setLayout(null);
      Alabel = new JLabel("Player 1:");
      Alabel.setBounds(10,20,80,25);
      panel.add(Alabel);
      AuserText.setBounds(100,20,165,25);
      panel.add(AuserText);

      Blabel = new JLabel("Player 2");
      Blabel.setBounds(10,50,80,25);
      panel.add(Blabel);
      BuserText.setBounds(100,50,165,25);
      panel.add(BuserText);

      Continue.setBounds(10,80,100,25);
      Continue.addActionListener(this);
      panel.add(Continue);
      String userA = AuserText.getText();
      String userB = BuserText.getText();

    }

  @Override
  public void actionPerformed(ActionEvent e) {

      //TODO -- if usernames already used, contiue as normal, if NOT - add to DB.
      //TODO -- ADD Score to DB.
      // none of this is super important but fun to do ._.
   //dbinsert();
    String userA = AuserText.getText();
    String userB = BuserText.getText();
    //TODO -- Go to GAME AFTER THIS
    System.out.println("players: "+ userA + " and " + userB+" are playing against eachother");
    System.out.println("both start at 0 points");


    sd.sd1.setVisible(false);
    sd.sd1.dispose();
    //ScreenDisplay screen = new ScreenDisplay();
    //screen.screen();
    //screen.runGameThread();

  }
  /*public void points(){
    String userA = AuserText.getText();
    String userB = BuserText.getText();

    System.out.println(userA+" "+pointsuserA);
    System.out.println(userB+" "+pointsuserB);
    pointsuserA = 0;
    pointsuserB = 0;
    //psuedokode
    if(playerAhealth = 0){
      pointsuserB =+1;
      System.out.println(userA+" "+pointsuserA);
      System.out.println(userB+" "+pointsuserB);
    }
    if(playerBhealth=0){
      pointsuserA =+1;
      System.out.println(userA+" "+pointsuserA);
      System.out.println(userB+" "+pointsuserB);
    }


  }*/


  public void dbinsert(){
    //TODO -- MAYBE CHECK CREDENTIALS HERE?
      String userA = AuserText.getText();
      String userB = BuserText.getText();
      userDB con = new userDB();
    con.connect();
    try {
      PreparedStatement prep = con.connection.prepareStatement(sql);
      prep.setString(1, userA);
      prep.execute();

    }
    catch (Exception e)
    {
      System.err.println("Exception:");
      // printStackTrace method
      // prints line numbers + call stack
      e.printStackTrace();
      // Prints what exception has been thrown
      System.out.println(e);
    }
    try {
      PreparedStatement prep = con.connection.prepareStatement(sql);
      prep.setString(1, userB);
      prep.execute();
      con.connection.close();
    }
    catch (Exception e)
    {
      System.err.println("Exception:");
      // printStackTrace method
      // prints line numbers + call stack
      e.printStackTrace();
      // Prints what exception has been thrown
      System.out.println(e);
    }
  }


}


