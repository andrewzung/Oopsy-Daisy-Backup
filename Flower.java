import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.awt.Graphics2D;

public class Flower extends JPanel
{
  //Flower variables including the colour height and health
  private String img;
  public int plotX;
  public int plotY;
  private boolean isAlive = false;
  private int currentF = 0; //updates everytime a new flower is planted or dies
  Flower[] flowers = new Flower[5];//colour depends on seeds
  private Main ba;
  private Challenges chall;
  
  public Flower(int plotX,int plotY,boolean isAlive, Challenges chall, Main ba){
    this.ba=ba;
    this.chall=chall;
    flowers[0] = new Flower (10,10,false,chall,ba);
    flowers[1] = new Flower (20,10,false,chall,ba);
    flowers[2] = new Flower (30,10,false,chall,ba);
  }
  
  
  public void die(){
    //set isAlive to false, checks the accuracy of the challenge; if below 50%, kill flower
    if (chall.getAcc()<50){
      if(ba.fertilizerCount<=0){
        isAlive = false;
        //stop printing
        currentF--;
      }
      else{
        ba.fertilizerCount--;
      }
    }
  }
}


