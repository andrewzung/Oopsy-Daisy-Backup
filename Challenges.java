import java.awt.*;
//import javax.swing.*;
//import javax.imageio.*;
import java.io.*;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
//import java.util.Timer;
//import java.util.TimerTask;

public class Challenges
{
  //Variables
  //Method to run challenge; creates typing challenge including corresponding graphics for user
  //Timer timer;
  String line;
  boolean shiftPressed=false;
  private Main ba;
  int charNumb=0;
  boolean typed=false;
  String typedChar="kjsfdhsg";
  int x=25;
  ArrayList<String>challenges=new ArrayList<String>(); 
  ArrayList<ColourChar> colourChars = new ArrayList<ColourChar>();
  long startTime;
  long endTime=0;
  long elapsedTime = 0;
  double correctChars=0;
  double incorrectChars=0;
  double acc=0;
  boolean challengeDone=false;
  int randChall=-1;
  
  public Challenges(Main ba)
  {
    this.ba=ba;
    try
    {
      //Create a new instance of the FileReader and pass it the
      //file that needs to be read
      FileReader fr = new FileReader("Word List.txt");
      //Create a new instance of the BufferedReader and
      //add the FileReader to it
      BufferedReader br = new BufferedReader(fr);
      //A string variable that will temporarily what youÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â¢re reading
      
      //A dual purpose line! First it reads the next line and then
      //it checks to see if that line was null. If itÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â¢s null, then
      //that means youÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â¢re at the end of the file.
      while ((line=br.readLine()) != null)
      {
        challenges.add(line);
      }
      //close the file when youÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â¢re done
      br.close();
    }
    catch(IOException e)
    {
      //Error message
    }
    randChall=(int)(Math.random()*(challenges.size()-1));
  }
  
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_SHIFT)
    {shiftPressed=false;}
    if(e.getKeyCode()==KeyEvent.VK_SPACE)
    {typedChar=" ";typed=true;}
// LOWER CASE LETTERS
    if (e.getKeyCode()==KeyEvent.VK_A && shiftPressed==false)
    {typedChar="a";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_B && shiftPressed==false)
    {typedChar="b";typed=true;}  
    if (e.getKeyCode()==KeyEvent.VK_C && shiftPressed==false)
    {typedChar="c";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_D && shiftPressed==false)
    {typedChar="d";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_E && shiftPressed==false)
    {typedChar="e";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_F && shiftPressed==false)
    {typedChar="f";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_G && shiftPressed==false)
    {typedChar="g";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_H && shiftPressed==false)
    {typedChar="h";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_I && shiftPressed==false)
    {typedChar="i";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_J && shiftPressed==false)
    {typedChar="j";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_K && shiftPressed==false)
    {typedChar="k";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_L && shiftPressed==false)
    {typedChar="l";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_M && shiftPressed==false)
    {typedChar="m";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_N && shiftPressed==false)
    {typedChar="n";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_O && shiftPressed==false)
    {typedChar="o";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_P && shiftPressed==false)
    {typedChar="p";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_Q && shiftPressed==false)
    {typedChar="q";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_R && shiftPressed==false)
    {typedChar="r";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_S && shiftPressed==false)
    {typedChar="s";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_T && shiftPressed==false)
    {typedChar="t";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_U && shiftPressed==false)
    {typedChar="u";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_V && shiftPressed==false)
    {typedChar="v";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_W && shiftPressed==false)
    {typedChar="w";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_X && shiftPressed==false)
    {typedChar="x";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_Y && shiftPressed==false)
    {typedChar="y";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_Z && shiftPressed==false)
    {typedChar="z";typed=true;}
    
// UPPER CASE LETTERS
    if (e.getKeyCode()==KeyEvent.VK_A && shiftPressed==true)
    {typedChar="A";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_B && shiftPressed==true)
    {typedChar="B";typed=true;}  
    if (e.getKeyCode()==KeyEvent.VK_C && shiftPressed==true)
    {typedChar="C";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_D && shiftPressed==true)
    {typedChar="D";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_E && shiftPressed==true)
    {typedChar="E";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_F && shiftPressed==true)
    {typedChar="F";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_G && shiftPressed==true)
    {typedChar="G";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_H && shiftPressed==true)
    {typedChar="H";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_I && shiftPressed==true)
    {typedChar="I";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_J && shiftPressed==true)
    {typedChar="J";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_K && shiftPressed==true)
    {typedChar="K";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_L && shiftPressed==true)
    {typedChar="L";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_M && shiftPressed==true)
    {typedChar="M";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_N && shiftPressed==true)
    {typedChar="N";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_O && shiftPressed==true)
    {typedChar="O";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_P && shiftPressed==true)
    {typedChar="P";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_Q && shiftPressed==true)
    {typedChar="Q";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_R && shiftPressed==true)
    {typedChar="R";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_S && shiftPressed==true)
    {typedChar="S";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_T && shiftPressed==true)
    {typedChar="T";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_U && shiftPressed==true)
    {typedChar="U";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_V && shiftPressed==true)
    {typedChar="V";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_W && shiftPressed==true)
    {typedChar="W";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_X && shiftPressed==true)
    {typedChar="X";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_Y && shiftPressed==true)
    {typedChar="Y";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_Z && shiftPressed==true)
    {typedChar="Z";typed=true;}
    
// NUMBERS
    if (e.getKeyCode()==KeyEvent.VK_0 && shiftPressed==false)
    {typedChar="0";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_1 && shiftPressed==false)
    {typedChar="1";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_2 && shiftPressed==false)
    {typedChar="2";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_3 && shiftPressed==false)
    {typedChar="3";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_4 && shiftPressed==false)
    {typedChar="4";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_5 && shiftPressed==false)
    {typedChar="5";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_6 && shiftPressed==false)
    {typedChar="6";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_7 && shiftPressed==false)
    {typedChar="7";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_8 && shiftPressed==false)
    {typedChar="8";typed=true;}
    if (e.getKeyCode()==KeyEvent.VK_9 && shiftPressed==false)
    {typedChar="9";typed=true;}
// PUNCTUATION AND OTHER CHARARATERS
    if (e.getKeyCode()==KeyEvent.VK_BACK_QUOTE && shiftPressed==false)
    {typedChar="`";typed=true;}//`
    if (e.getKeyCode()==KeyEvent.VK_MINUS && shiftPressed==false)
    {typedChar="-";typed=true;}//-
    if (e.getKeyCode()==KeyEvent.VK_EQUALS && shiftPressed==false)
    {typedChar="=";typed=true;}//=
    if (e.getKeyCode()==KeyEvent.VK_BACK_QUOTE && shiftPressed==true)
    {typedChar="~";typed=true;}//~
    if (e.getKeyCode()==KeyEvent.VK_1 && shiftPressed==true)
    {typedChar="!";typed=true;}//!
    if (e.getKeyCode()==KeyEvent.VK_2 && shiftPressed==true)
    {typedChar="@";typed=true;}//@
    if (e.getKeyCode()==KeyEvent.VK_3 && shiftPressed==true)
    {typedChar="#";typed=true;}//#
    if (e.getKeyCode()==KeyEvent.VK_4 && shiftPressed==true)
    {typedChar="$";typed=true;}//$
    if (e.getKeyCode()==KeyEvent.VK_5 && shiftPressed==true)
    {typedChar="%";typed=true;}//%
    if (e.getKeyCode()==KeyEvent.VK_6 && shiftPressed==true)
    {typedChar="^";typed=true;}//^
    if (e.getKeyCode()==KeyEvent.VK_7 && shiftPressed==true)
    {typedChar="&";typed=true;}//&
    if (e.getKeyCode()==KeyEvent.VK_8 && shiftPressed==true)
    {typedChar="*";typed=true;}//*
    if (e.getKeyCode()==KeyEvent.VK_9 && shiftPressed==true)
    {typedChar="(";typed=true;}//(
    if (e.getKeyCode()==KeyEvent.VK_0 && shiftPressed==true)
    {typedChar=")";typed=true;}//)
    if (e.getKeyCode()==KeyEvent.VK_MINUS && shiftPressed==true)
    {typedChar="_";typed=true;}//_
    if (e.getKeyCode()==KeyEvent.VK_EQUALS && shiftPressed==true)
    {typedChar="+";typed=true;}//+
    if (e.getKeyCode()==KeyEvent.VK_OPEN_BRACKET && shiftPressed==false)
    {typedChar="[";typed=true;}//[
    if (e.getKeyCode()==KeyEvent.VK_CLOSE_BRACKET && shiftPressed==false)
    {typedChar="]";typed=true;}//]
    if (e.getKeyCode()==KeyEvent.VK_BACK_SLASH && shiftPressed==false)
    {typedChar="\\";typed=true;}//\
    if (e.getKeyCode()==KeyEvent.VK_OPEN_BRACKET && shiftPressed==true)
    {typedChar="{";typed=true;}//{
    if (e.getKeyCode()==KeyEvent.VK_CLOSE_BRACKET && shiftPressed==true)
    {typedChar="}";typed=true;}//}
    if (e.getKeyCode()==KeyEvent.VK_BACK_SLASH && shiftPressed==true)
    {typedChar="|";typed=true;}//|
    if (e.getKeyCode()==KeyEvent.VK_SEMICOLON && shiftPressed==false)
    {typedChar=";";typed=true;}//;
    if (e.getKeyCode()==KeyEvent.VK_SEMICOLON && shiftPressed==true)
    {typedChar=":";typed=true;}//:
    if (e.getKeyCode()==KeyEvent.VK_QUOTE && shiftPressed==false)
    {typedChar="'";typed=true;}//'
    if (e.getKeyCode()==KeyEvent.VK_QUOTE && shiftPressed==true)
    {typedChar="\"";typed=true;}//"
    if (e.getKeyCode()==KeyEvent.VK_COMMA && shiftPressed==false)
    {typedChar=",";typed=true;}//,
    if (e.getKeyCode()==KeyEvent.VK_COMMA && shiftPressed==true)
    {typedChar="<";typed=true;}//<
    if (e.getKeyCode()==KeyEvent.VK_PERIOD && shiftPressed==false)
    {typedChar=".";typed=true;}//.
    if (e.getKeyCode()==KeyEvent.VK_PERIOD && shiftPressed==true)
    {typedChar=">";typed=true;}//>
    if (e.getKeyCode()==KeyEvent.VK_SLASH && shiftPressed==false)
    {typedChar="/";typed=true;}///
    if (e.getKeyCode()==KeyEvent.VK_SLASH && shiftPressed==true)
    {typedChar="?";typed=true;}//?
  }
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_SHIFT)
    {
      shiftPressed=true;
    }
  }
  public void keyTyped(KeyEvent e) {
  }
  
  public void resetChallenge(){
    shiftPressed=false;
    charNumb=0;
    typed=false;
    typedChar="kjsfdhsg";
    x=25;
    colourChars = new ArrayList<ColourChar>();
    correctChars=0;
    incorrectChars=0;
    acc=0;
    randChall=-1;
    challengeDone=false;
    randChall=(int)(Math.random()*(challenges.size()-1));
  }
  
  public double getAcc()
  {
    return (int)acc;
  }
  
  public void paint(Graphics2D g) {
    if (charNumb==0)
    {
      startTime=System.currentTimeMillis();
    }
    g.setColor(Color.white);
    g.fillRect (0, 5, 1280, 50);
    g.setColor(Color.black);
    int i=25;
    int fontSize = 11;
    g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
    if (randChall==-1)
    {
      g.drawString("",0,0);
    }
    else
    {
      g.drawString(challenges.get(randChall), 3, i);
      i+=14;
      
      if (charNumb<challenges.get(randChall).length())
      {
        if (typedChar.equals(challenges.get(randChall).substring(charNumb,charNumb+1))==true && typed==true)
        {
//          g.setColor(Color.GREEN);
//          g.drawString(lessons.get(1).substring(charNumb,charNumb+1), x, 500);
//          x+=8;
          charNumb++;
          typed=false;
          correctChars++;
          if (challenges.get(randChall).substring(charNumb-1,charNumb).equals(" "))
          {
            colourChars.add(new ColourChar('_', Color.BLUE));
          }
          else
          { 
            colourChars.add(new ColourChar(challenges.get(randChall).charAt(charNumb-1), Color.BLUE));
          }
        }
        if (typedChar.equals(challenges.get(randChall).substring(charNumb,charNumb+1))==false && typed==true)
        {
//          g.setColor(Color.RED);
//          g.drawString(lessons.get(1).substring(charNumb,charNumb+1), x, 500);
//          x+=8;
          charNumb++;
          typed=false;
          incorrectChars++;
          if (challenges.get(randChall).substring(charNumb-1,charNumb).equals(" "))
          {
            colourChars.add(new ColourChar('_', Color.RED));
          }
          else
          {
            colourChars.add(new ColourChar(challenges.get(randChall).charAt(charNumb-1), Color.RED));
          }
        }
      }
      else if (challengeDone==false)
      {
        endTime=System.currentTimeMillis();
        challengeDone=true;
        acc = Math.floor(correctChars/(correctChars+incorrectChars)*100);
        if (acc>=80)
        {
          ba.coins++;
        }
      }
      x=2;
      g.setColor(Color.white);
      g.fillRect (0, 475, 1280, 50);
      for (int i1 = 0; i1 < colourChars.size(); i1++)
      {
        fontSize = 11;
        g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        g.setColor(colourChars.get(i1).theColour);
        g.drawString(""+colourChars.get(i1).theChar, x, 500);
        x+=7;
      }
      g.setColor(Color.BLACK);
      if (incorrectChars+correctChars==0)
      {
        acc=0;
      }
      else
      {
        acc = Math.floor(correctChars/(correctChars+incorrectChars)*100);
      }
      fontSize = 20;
      g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
      g.drawString(""+(int)acc+"%",1000, 450); 
      if (endTime!=0)
      {
        elapsedTime=(endTime - startTime)/1000;
        g.drawString(""+(int)elapsedTime,1000, 600); 
      }
    } 
  }
}
