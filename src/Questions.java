import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class Questions {

    public void askQuestionPlus(int counter) {

        counter=0;
        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 10) + 10;
            int number2 = (int) (Math.random() * 10) + 10;
            Scanner input = new Scanner(System.in);
            String question ="What is " + number1 + "+" + number2 + "?"; //Shouldn't be a SOUT, but instead show on screen
            int answer = input.nextInt();

            if ((number1 + number2) != answer) {
                System.out.println("Incorrect. Next question ...");
            }
            if ((number1 + number2) == answer) {
                System.out.println("That is correct!");
                counter++;
                System.out.println("Your new score is: " + counter);
            }
        }
    }
public void questionpopup(int counter){
    ScreenDisplay sd = new ScreenDisplay();
    JButton button = new JButton("Continue");
    JTextField answerbox= new JTextField(20);



    for (int i = 0; i < 3; i++) {
        JLabel label;
        JPanel panel = new JPanel();

        sd.screen.setSize(300,300);
        sd.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sd.screen.setVisible(true);
        sd.screen.add(panel);
        panel.add(button);
        answerbox.setBounds(100,20,165,25);
        panel.add(answerbox);
        int number1 = (int) (Math.random() * 10) + 10;
        int number2 = (int) (Math.random() * 10) + 10;

        String question ="What is " + number1 + "+" + number2 + "?";
        int answer  = 1;
        label = new JLabel(question);
        label.setBounds(10,20,80,25);
        panel.add(label);

        if ((number1 + number2) != answer) {


        }
        if ((number1 + number2) == answer) {
            counter++;
        }
    }


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



}







/*
    public void askQuestionMinus() {
        int score = 0;
        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 10) + 10;
            int number2 = (int) (Math.random() * 10) + 5;
            Scanner input = new Scanner(System.in);
            System.out.println("What is " + number1 + "-" + number2 + "?"); //Shouldn't be a SOUT, but instead show on screen
            int answer = input.nextInt();

            if ((number1 - number2) != answer) {
                System.out.println("Incorrect. Next question ...");
            }
            if ((number1 - number2) == answer) {
                System.out.println("That is correct!");
                score++;
                System.out.println("Your new score is: " + score);
            }
        }
    }


    public void askQuestionMultiply() {
      int score = 0;
        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 5) + 5;
            int number2 = (int) (Math.random() * 2) + 2;
            Scanner input = new Scanner(System.in);
            System.out.println("What is " + number1 + "*" + number2 + "?"); //Shouldn't be a SOUT, but instead show on screen
            int answer = input.nextInt();

            if ((number1 * number2) != answer) {
                System.out.println("Incorrect. Next question ...");
            }
            if ((number1 * number2) == answer) {
                System.out.println("That is correct!");
                score++;
                System.out.println("Your new score is: " + score);
            }
        }

    }
    public void askQuestionDivide() { //Probably shouldn't be used at all - right now numbers are decimal numbers, and kinda hard for beginners.
        int score = 0;
        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 10) + 10;
            int number2 = (int) (Math.random() * 10) + 10;
            Scanner input = new Scanner(System.in);
            System.out.println("What is " + number1 + "/" + number2 + "?"); //Shouldn't be a SOUT, but instead show on screen
            int answer = input.nextInt();

            if ((number1 / number2) != answer) {
                System.out.println("Incorrect. Next question ...");
            }
            if ((number1 / number2) == answer) {
                System.out.println("That is correct!");
                score++;
                System.out.println("Your new score is: " + score);
            }
        }
    }
 */
}












