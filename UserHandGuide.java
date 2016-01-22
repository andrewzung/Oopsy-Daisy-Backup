//import java.awt.*;
//import javax.swing.*;
import javax.imageio.*;
import java.io.*;
//import java.awt.Image;
import java.awt.image.BufferedImage;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
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

public class UserHandGuide
{
  
  public UserHandGuide()
  {
  }
    public void paint(Graphics2D g) {
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(Color.white);
    g.fillRect (0, 0, 1280, 984);  
    BufferedImage handPosition = null;
    try {
      handPosition = ImageIO.read(new File("handPosition.png"));
    } catch (IOException e) {
    }
    g.drawImage(handPosition,0,0,null);

  }  
}