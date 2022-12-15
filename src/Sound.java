import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    //used to open audio file
    Clip clip;

    URL soundURL[] = new URL[5]; //to store music file path

    public Sound(){
        soundURL[0] = getClass().getResource("Sound/FinalBattle.wav");
        soundURL[1] = getClass().getResource("Sound/burning.wav");
        soundURL[2] = getClass().getResource("Sound/gameover.wav");
        soundURL[3] = getClass().getResource("Sound/sword_hit.wav");
        soundURL[4] = getClass().getResource("Sound/receivedamage.wav");
    }

    public void setMusicFile (int i){

       //format to open audio file in java
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        }catch (Exception e){
        }

    }
    public void playMusic(){
        clip.start();

    }
    public void loopMusic(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void stopMusic(){
        clip.stop();
    }

}
