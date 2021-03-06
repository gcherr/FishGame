import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;
import java.net.URL.*;

public class River
{
 private int numCaught = 0;
 private int numMissed = 0;
 private GameGui myGui;
 private ArrayList<Fish> fishArray;

 public River (GameGui gui)
 {
  myGui = gui;
 }

 public void addMissed(Fish f)
 {
  fishArray.remove(f);
  numMissed ++;
 }

 public int getNumCaught()
 {
  return numCaught;
 }

 public int getNumMissed()
 {
  return numMissed;
 }

 public void generateFish()
 {
  int delay = 15;
  fishArray=new ArrayList<Fish>();
  myGui.updateFishArray(fishArray);
    ActionListener taskPerformer = new ActionListener()
    {
     int delayCounter=0;
        public void actionPerformed(ActionEvent evt)
        {
            delayCounter++;
            if(delayCounter==40)
            {
             fishArray.add(new Fish((int)(Math.random()*850)+130, 0));
             delayCounter=0;
            }
            moveFish();
            myGui.updateFishArray(fishArray);
        }
    };
    new javax.swing.Timer(delay, taskPerformer).start();

 }
 public void moveFish()
 {
  for(Fish f:fishArray)
  {
   f.incrementYpos(3);
  }
 }
 public void moveNetLeft(Net n)
 {
  n.moveLeft();
 }
 public void moveNetRight(Net n)
 {
  n.moveRight();
 }

 public void addCaught(Fish f)
 {
  fishArray.remove(f);
  numCaught ++;
 }

}
