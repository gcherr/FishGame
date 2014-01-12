import java.awt.*;          
import java.awt.event.*;    
import javax.swing.*;       
import java.awt.Color.*;
import java.util.*;
import java.lang.Object.*;

public class Gui extends JFrame 
{
	Image background;
	final static int HORIZ_GAP = 5;
    final static int VERT_GAP = 5;
    private JTextArea textArea1, textArea2;
    private int xPos, yPos;
    private River run;
   	public Gui() 
	{
		super("Demo Graphics: Lines, Rectangles, Ovals" + "Demo of Mouse and Keyboard Input");
       	background = new ImageIcon("background.gif").getImage();
       	Container container = getContentPane();
        container.setLayout( new BorderLayout(HORIZ_GAP, VERT_GAP) );
        //container.add(new Button("North"), BorderLayout.CENTER);
        textArea1 = new JTextArea(2,10);   
        textArea1.setText("Instructions");
        textArea1.setEnabled(false);   
        textArea1.setBackground(Color.RED);       
        textArea2 = new JTextArea(3, 10);
        textArea2.setBackground(Color.RED);
        textArea2.setEnabled(false);
        container.add(textArea1, BorderLayout.NORTH);
        container.add(textArea2, BorderLayout.SOUTH);
        addKeyListener( new KeyHandler());
        addMouseListener( new MouseClickHandler() );
        addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowClosing(WindowEvent evt) 
            {
                System.exit(0);
            }
        });
        setSize( 1200,900);
        setVisible(true);
    }
    public void paint (Graphics g )
    {	
    	super.paint(g);
    	g.drawImage(background, 0, 0, 1200, 850, Color.WHITE, this);
     	g.drawString("Clicked at [" + xPos + ", " + yPos + "]", xPos, yPos);
     	
   	}

    public static void main(String[] args) 
    { 
        Gui application = new Gui();
        //run = new River(application);
    }
    private class KeyHandler implements KeyListener 
    {
        public void keyPressed ( KeyEvent event )
        {
            textArea2.setText("Key pressed: " + event.getKeyText(event.getKeyCode() ));
            if (event.getKeyCode() == KeyEvent.VK_LEFT)
              	textArea2.setText("Left arrow pressed");
            if(event.getKeyCode()== KeyEvent.VK_RIGHT)
            	textArea2.setText("Right arrowed pressed");
            	
        }
        
        public void keyReleased (KeyEvent event )
        {
           if (event.getKeyCode() == KeyEvent.VK_LEFT)
              	textArea2.setText("Left arrow released");
           if(event.getKeyCode()== KeyEvent.VK_RIGHT)
            	textArea2.setText("Right arrowed released");
        }
        
        public void keyTyped (KeyEvent event )
        {
            
        }
        
    }   
    private class MouseClickHandler extends MouseAdapter
    {
        public void mouseClicked ( MouseEvent event )
        {
            xPos = event.getX();
            yPos = event.getY();
            if(xPos < 100 && 1100 < xPos && yPos < 100 && 200 < yPos )
            {
            	textArea2.setText("Hello");
            }
            repaint();
        }
    }           
}
