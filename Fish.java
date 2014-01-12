public class Fish
{
	private int poison;
	private int xPos,yPos;
	public Fish(int x, int y)
	{
		xPos=x;
		yPos=y;
		poison = (int)(Math.random()*10);
	}
	public boolean isPoison()
	{
		if(poison < 2)
			return true;
		else
			return false;
	}
	public int getXpos()
	{
		return xPos;
	}
	public int getYpos()
	{
		return yPos;
	}
	public void incrementYpos(int y)
	{
		yPos+=y;
	}
	public String toString()
	{
		return xPos+" "+yPos+" "+ isPoison() + " " ;
	}
}