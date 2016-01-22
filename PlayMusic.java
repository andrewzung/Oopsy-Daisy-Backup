import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;
import java.net.URL;

public class PlayMusic
{  
  public void playMusic()
  {
  }
  
  public void playSong()
  {
    try{
      URL s = this.getClass().getResource("seal.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(s);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
      if(Main.musicON == false)
      {
        clip.stop();
      } 
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }
}