import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;
import java.util.*;
import java.lang.Object.*;
import java.net.URL;
import java.io.*;

public class MenuGui extends JFrame
{
 Image menu;
 Image playGame;
 private int xPos, yPos;

 public MenuGui()
 {
  super("FishGame");

  ClassLoader cldr = this.getClass().getClassLoader();

    try {
   URL menuURL   = cldr.getResource("Graphics/menu.gif");
   ImageIcon menu1 = new ImageIcon(menuURL);
   menu = menu1.getImage();
   URL playGameURL = cldr.getResource("Graphics/playGame.gif");
   ImageIcon play = new ImageIcon(playGameURL);
   playGame = play.getImage();

    }
      catch (Exception e){
   try{
    PrintStream p = new PrintStream(
       new FileOutputStream(new File("trace.txt")));
    p.println("got here"); // sample output to file
    e.printStackTrace(p); // print stack trace to output file
   }
   catch(Exception e1) // need this empty section for PrintStream
   {
   }
     }

        addMouseListener( new MouseClickHandler() );
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }

        });
        setSize( 1200,800);
        setVisible(true);
    }
    public void paint(Graphics g)
 {
  Image offImage = createImage(1200,800);
  Graphics buffer = offImage.getGraphics();
  paintOffScreen(buffer);
  g.drawImage(offImage, 0, 0, null);
 }

 public void paintOffScreen(Graphics g)
 {
     super.paint(g);
     g.drawImage(menu, 0, 0, 1200, 900,this);
     g.drawImage(playGame, 100, 700, 1000, 100, this);
     g.setColor(Color.red);
     g.drawRect(100,700,1000,100);
    }

    private class MouseClickHandler extends MouseAdapter
    {
        public void mouseClicked ( MouseEvent event )
        {
            xPos = event.getX();
            yPos = event.getY();
            if(xPos > 100 && 1100 > xPos && yPos < 800 && 700 < yPos )
            {
             GameGui gooey = new GameGui();
             dispose();
            }
            repaint();
        }
    }

    public static void main(String[] args)
    {
        MenuGui menu = new MenuGui();
    }
}
