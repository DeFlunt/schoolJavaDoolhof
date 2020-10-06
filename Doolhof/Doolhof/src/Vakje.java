//Rutger Le Jeune


public class Vakje {

	private int inhoud;
	
	public Vakje(int i)
	{
		//System.out.println("Maakt een nieuw vakje\n");
		inhoud = i;
	}
	
	public int getInhoud()
	{
		return inhoud;
	}
	
	public void setInhoud(int i)
	{
		//System.out.println("Inhoud is veranderd");
		inhoud = i;
	}
	
	public String toString()
	{
		String woord ="";
		
		if (this.getInhoud() == Tegel.LEEG)
			woord += " ";
		if (this.getInhoud() == Tegel.MUUR)
			woord += "X";
		if (this.getInhoud() == Tegel.VENTJE)
			woord += "*";
		if (this.getInhoud() == Tegel.GOUD)
			woord += "G";		
		
		return woord;
	}
	
	public boolean isMuur()
	{
		if (inhoud == Tegel.MUUR)
			return true;
		else
			return false;
	}
	
	public boolean isGoud()
	{
		if (inhoud == Tegel.GOUD)
			return true;
		else
			return false;
	}
	
	public boolean isVentje()
	{
		if (inhoud == Tegel.VENTJE)
			return true;
		else
			return false;
	}
	
	public boolean isLeeg()
	{
		if (inhoud == Tegel.LEEG)
			return true;
		else
			return false;
	}
	
	public boolean isToegankelijk()
	{
		//System.out.println("Controle of plaats toegankelijk is");
		
		if (isGoud() == true || isLeeg() == true)
			return true;
		else
			return false;
	}
	
}
