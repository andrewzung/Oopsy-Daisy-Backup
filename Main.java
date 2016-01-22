import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.*;
import javax.swing.JOptionPane;
//import javax.swing.JDialog;
//import javax.swing.JButton;
//import javax.swing.JRadioButton;
//import javax.swing.ButtonGroup;
//import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import javax.swing.BoxLayout;
//import javax.swing.Box;
//import javax.swing.BorderFactory;
//import javax.swing.border.Border;
//import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
//import java.beans.*; //Property change stuff
//import java.util.Timer;
//import java.util.TimerTask;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.ArrayList;

public class Main extends JPanel
{   
  //Overall Variables from Class Diagram
  private Typing type = new Typing(this);
  public static int lessonNumb=0;
  public static int lessonsDone=0;
  public static Boolean typingDone = false;
  private Challenges challenge = new Challenges(this);
  public static boolean lessonsON=false;
  public static boolean challengeON=false;
  private Shop shop = new Shop();
  public static boolean shopON=false;
  public static int successfullChall=0;
  public static ArrayList<Item> currentInventory = new ArrayList<Item>();
  public static int coins = 0;
  public static int fertilizerInventory = 0;
  private static PlayMusic playMusic = new PlayMusic();
  public static boolean handGuideON=false;
  private UserHandGuide guide = new UserHandGuide();
  public static boolean musicON=true;
  
  public Main ()
  {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }
      @Override
      public void keyReleased(KeyEvent e) {
        type.keyReleased(e);
        challenge.keyReleased(e);
      }
      @Override
      public void keyPressed(KeyEvent e) {
        type.keyPressed(e);
        challenge.keyPressed(e);
      }
    });
    setFocusable(true); 
    addMouseListener(new MouseListener(){
      public void mousePressed(MouseEvent e) {
      }
      
      public void mouseReleased(MouseEvent e) {
        if(shopON==true)
        {
          Shop.clickMade(e.getX(), e.getY());
        }
        if (((e.getX()>=450&&e.getX()<=745)&&(e.getY()>=800&&e.getY()<=893)) && challengeON==false)
        {
          if(lessonsON==false && shopON==false && challengeON==false)
          {
            lessonsON=true;
          }
        }  
        if (((e.getX()>=25&&e.getX()<=175)&&(e.getY()>=775&&e.getY()<=899)) && challengeON==false)
        {
          lessonsON=false;
          shopON=false;
          handGuideON=false;
        }
      }
      
      public void mouseEntered(MouseEvent e) {
      }
      
      public void mouseExited(MouseEvent e) {
      }
      
      public void mouseClicked(MouseEvent e) {
      }
    });
    setFocusable(true); 
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    BufferedImage bg = null;
    try {
      bg = ImageIO.read(new File("gameBG.png"));
    } catch (IOException e) {
    }
    BufferedImage back = null;
    try {
      back = ImageIO.read(new File("BackButton.png"));
    } catch (IOException e) {
    }
    g.drawImage(bg,0,0,null);
    BufferedImage lesson = null;
    try {
      lesson = ImageIO.read(new File("lessonButton.png"));
    } catch (IOException e){
    }
    
    if (lessonsON==true)
    {
      type.paint(g2d,lessonNumb);
    }
    if (shopON==true)
    {
      shop.paint(g2d);  
    }
    if (challengeON==true)
    {
      challenge.paint(g2d);
    }
    if (handGuideON==true)
    {
      guide.paint(g2d);
    }
    if (lessonsON==false && shopON==false && challengeON==false && handGuideON==false)
    {
      g.drawImage(back,25,775,null);
      g.drawImage(lesson,450, 800, null);
    }
    else
    {
      if(challengeON==false)
      {
        g.drawImage(back,25,775,null);
      }
    }
    
  }
  
  //Option Methods
  //Methods for the interaction of sub methods; final integration step
  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Animation");
    Menu demo = new Menu();
    Main ba = new Main();
    frame.setJMenuBar(demo.createMenuBar());
    frame.setContentPane(demo.createContentPane());
    frame.add(ba);
    frame.setSize(1280, 984);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    playMusic.playSong();
    while (true)
    {
      ba.doAll(frame);
    }
  }
  
  public void doAll(JFrame frame)
  {
    while(lessonsON)
    {
      String s=null;
      while (s==null)
      {
        Object[] possibilities = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
        s = (String)JOptionPane.showInputDialog(frame,"Please select a lesson.","Select a Lesson", JOptionPane.PLAIN_MESSAGE,null,possibilities,"1");
      }
      lessonNumb=Integer.parseInt(s);
      while (!typingDone) {
        this.repaint();
        try {
          Thread.sleep(10);
        }
        catch (Exception e){
          e.printStackTrace();
        }
      }
      typingDone = false;
      type.resetTyping();
      if (lessonsDone!=0&&lessonsDone%5==0)
      {
        lessonsON=false;
        challengeON=true;
        JOptionPane.showMessageDialog(frame, "WARNING THIS IS A CHALLENGE! TYPE QUICKLY", "CHALLENGE!!!", JOptionPane.WARNING_MESSAGE);
      }
    }
    while(challengeON==true&&challenge.challengeDone==false)
    {
      this.repaint();
      try {
        Thread.sleep(10);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    while(shopON==true)
    {
      this.repaint();
      try {
        Thread.sleep(10);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    while(handGuideON==true)
    {
      this.repaint();
      try {
        Thread.sleep(10);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    if (challenge.challengeDone==true)
    {
      lessonsON=true;
      challengeON=false;
      challenge.resetChallenge();
    }
    try {
      Thread.sleep(10);
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
  
}

