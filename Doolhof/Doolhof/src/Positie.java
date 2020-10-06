//Rutger Le Jeune

public class Positie {

	private int x;
	private int y;
	
	public Positie(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
	
	public String toString()
	{
		String woord = "";
		
		woord += "X = " + x + "\nY = " + y;
		
		return woord;
	}
	
	public void setX(int x2)
	{
		x = x2;
	}
	
	public void setY(int y2)
	{
		y = y2;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	public int getXLinks()
	{
		return x;
	}
	
	public int getYLinks()
	{
		return y-1;
	}
	
	public int getXBoven()
	{
		return x-1;
	}
	
	public int getYBoven()
	{
		return y;
	}
	
	public int getXRechts()
	{
		return x;
	}
	
	public int getYRechts()
	{
		return y+1;
	}
	
	public int getXOnder()
	{
		return x+1;
	}
	
	public int getYOnder()
	{
		return y;
	}
	
	public boolean vergelijk(Positie pos)
	{
		if(x == pos.getX())
		{
			if(y == pos.getY())
			{
				return true;
			}
		}
		else
			return false;
	return false;
	}
}
