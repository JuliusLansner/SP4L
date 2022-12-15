import java.util.Timer;
import java.util.TimerTask;

public class GameTime {
    public static void main(String[] args) {

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            int counter = 5;

            @Override
            public void run() {

                if (counter > 0){
                    System.out.println( counter + " FIREBALL");
                    counter --;

                }else{
                    System.out.println("NO MORE FIREBALL");
                    timer.cancel();
                }
            }
        };

        timer.schedule(timerTask,0,500);

    }



}
