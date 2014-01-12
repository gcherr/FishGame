
public class Net 
{
 private int xPos, yPos;
 public Net(int x, int y)
 {
  xPos=x;
  yPos=y;
 }
 public void moveLeft()
 {
  xPos-=80;
 }
 public void moveRight()
 {
  xPos+=80;
 }
 public int getXpos()
 {
  return xPos;
 }
 public int getYpos()
 {
  return yPos;
 }
 public void setYpos(int y)
 {
  yPos=y;
 }
 public void setXpos(int x)
 {
  xPos=x;
 }
}
