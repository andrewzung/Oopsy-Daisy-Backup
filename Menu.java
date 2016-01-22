/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//import javax.swing.JCheckBoxMenuItem;
//import javax.swing.JRadioButtonMenuItem;
//import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
//import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import javax.swing.JScrollPane;
//import javax.swing.JFrame;

/* MenuDemo.java requires images/middle.gif. */

/*
 * This class is just like MenuLookDemo, except the menu items
 * actually do something, thanks to event listeners.
 */
public class Menu implements ActionListener, ItemListener {
//    JTextArea output;
//    JScrollPane scrollPane;
//    String newline = "\n";
  
  public JMenuBar createMenuBar() {
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
//    JRadioButtonMenuItem rbMenuItem;
//    JCheckBoxMenuItem cbMenuItem;
    
    //Create the menu bar.
    menuBar = new JMenuBar();
    
    //Build the first menu.
    menu = new JMenu("File");
//        menu.setMnemonic(KeyEvent.VK_A);
//        menu.getAccessibleContext().setAccessibleDescription(
//                "The only menu in this program that has menu items");
    menuBar.add(menu);
    
    //a group of JMenuItems
//        menuItem = new JMenuItem("A text-only menu item",
//                                 KeyEvent.VK_T);
    //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
//        menuItem.getAccessibleContext().setAccessibleDescription(
//                "This doesn't really do anything");
//        menuItem.addActionListener(this);
//        menu.add(menuItem);
    
    ImageIcon icon = createImageIcon("exit.png");
    menuItem = new JMenuItem("Exit Game", icon);
    menuItem.addActionListener(new ExitButton());
    menu.add(menuItem);
    
    icon = createImageIcon("supportUs.png");
    menuItem = new JMenuItem("Support Us", icon);
    menuItem.addActionListener(new BrowseURL());
    menu.add(menuItem);
    
//    if(Main.musicON==true)
//    {
//      icon = createImageIcon("pause.png");
//      menuItem = new JMenuItem("Pause Music", icon);
//      menuItem.addActionListener(new PauseButton());
//      menu.add(menuItem);
//    }
//    
//    if(Main.musicON==false)
//    {
//      icon = createImageIcon("play.png");
//      menuItem = new JMenuItem("Play Music", icon);
//      menuItem.addActionListener(new PlayButton());
//      menu.add(menuItem);
//    }
    
    //Build second menu in the menu bar.
    menu = new JMenu("Typing");
    menuBar.add(menu);
    
    icon = createImageIcon("lessons.png");
    menuItem = new JMenuItem("Lessons", icon);
    menuItem.addActionListener(new TypingButton());
    menu.add(menuItem);
    
    //Build third menu in the menu bar.
    menu = new JMenu("Garden & Shop");
    menuBar.add(menu);
    
    icon = createImageIcon("garden.png");
    menuItem = new JMenuItem("Garden", icon);
    menuItem.addActionListener(this);
    menu.add(menuItem);
    
    icon = createImageIcon("shop.png");
    menuItem = new JMenuItem("Shop", icon);
    menuItem.addActionListener(new AccessShop());
    menu.add(menuItem);
    
    menu = new JMenu("Help");
    menuBar.add(menu);
    
    icon = createImageIcon("help.png");
    menuItem = new JMenuItem("Help", icon);
    menuItem.addActionListener(new HelpButton());
    menu.add(menuItem);
    
    return menuBar;
  }
  
  public void actionPerformed(ActionEvent e) {
  }
  
  public void itemStateChanged(ItemEvent e) {
  }
  
  public Container createContentPane() {
    JPanel contentPane = new JPanel(new BorderLayout());
    return contentPane;
  }

  /** Returns an ImageIcon, or null if the path was invalid. */
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = Menu.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}

class AccessShop implements ActionListener {
  public AccessShop() {
    
  }
  public void actionPerformed(ActionEvent e) {
    if(Main.challengeON!=true)
    {
      Main.shopON=true;
      Main.lessonsON=false;
      Main.challengeON=false;
    }
  }
}
class ExitButton implements ActionListener {
  public ExitButton() {
    
  }
  public void actionPerformed(ActionEvent e) {
    if(Main.challengeON!=true)
    {
      System.exit(0);
    }
  }
}

//class PauseButton implements ActionListener {
//  public PauseButton() {
//    
//  }
//  public void actionPerformed(ActionEvent e) {
//    System.out.println("Song Paused");
//    Main.musicON=false;
//  }
//}
//
//class PlayButton implements ActionListener {
//  public PlayButton() {
//  }
//  public void actionPerformed(ActionEvent e) {
//    Main.musicON=true;
//    
//  }
//}

class TypingButton implements ActionListener {
  public TypingButton() {
    
  }
  public void actionPerformed(ActionEvent e) {
    if(Main.challengeON!=true)
    {
      Main.lessonsON=true;
      Main.challengeON=false;
      Main.shopON=false;
    }
  }
}

class HelpButton implements ActionListener {
  public HelpButton() {
    
  }
  public void actionPerformed(ActionEvent e) {
    Main.handGuideON=true;
  }
}

class BrowseURL implements ActionListener {
  public BrowseURL() {
  } 
  
  public void actionPerformed(ActionEvent e)
  {
    // Browse a URL, say google.com
    Desktop d=Desktop.getDesktop();
    try {
      d.browse(new URI("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=YZZQ2NCD8UBKS"));
    }
    catch (Exception f){
      f.printStackTrace();
    }
  }
}

