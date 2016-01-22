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

public class Garden extends JPanel
{
  public List<String> seedsAvailable = new ArrayList<String>();//each object has a colour
  private Main ba;
  private Flower F;
  
  public Garden()
  {
    this.ba=ba;
    this.F=F;
  }
  
  public void plantSeed(){
    //plant seed from available seeds in next avail plot
    if(seedsAvailable.length()>0)
    {
      if(F.currentF<=5){
        
        //plant chosen seed in next available plot point, set boolean isAlive to true for that flower, paint unbloomed flower, 
        if(ba.currentInventory[0].getName().equals("orangeFlower.png"){
          flower[F.currentF].isAlive = true;
          //paint this img in this location
          F.currentF++;
        }
           if(ba.currentInventory[0].getName().equals("blueFlower.png"){
             flower[currentF].isAlive = true;
             //paint this img in this location
             F.currentF++;
           }
              if(ba.currentInventory[0].getName().equals("greenFlower.png"){
                flower[currentF].isAlive = true;
                //paint this img in this location
                F.currentF++;
              }
                 if(ba.currentInventory[0].getName().equals("pinkFlower.png"){
                   flower[currentF].isAlive = true;
                   //paint this img in this location
                   F.currentF++;
                 }
                    
                    
                    
                    }
 }
// public void useFertilizer(Flower flower){
//   //force grow flower,must have fertilizer (purchased from shop)
// } 
 
   

