import java.util.Scanner;
public class Questions {

    public void askQuestionPlus() {
        int score = 0;
        for (int i = 0; i < 3; i++) {
            int number1 = (int) (Math.random() * 10) + 10;
            int number2 = (int) (Math.random() * 10) + 10;
            Scanner input = new Scanner(System.in);
            System.out.println("What is " + number1 + "+" + number2 + "?"); //Shouldn't be a SOUT, but instead show on screen
            int answer = input.nextInt();

            if ((number1 + number2) != answer) {
                System.out.println("Incorrect. Next question ...");
            }
            if ((number1 + number2) == answer) {
                System.out.println("That is correct!");
                score++;
                System.out.println("Your new score is: " + score);
            }
        }
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












