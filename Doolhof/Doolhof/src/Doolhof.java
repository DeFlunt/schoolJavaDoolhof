//Rutger Le Jeune

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Doolhof {

	public static final int LINKS = 4;
	public static final int BOVEN = 5;
	public static final int RECHTS = 6;
	public static final int ONDER = 7;
	
	private Tegel[][] tegels;
	private int grootte;
	private ArrayList<Tegel> lijst = new ArrayList<Tegel>();
	private Positie posVentjeTegel;
	private Positie posVentjeTegel0;
	private Positie posVentjeVakje;
	private Positie posVentjeVakje0;
	
	public Doolhof(int n)
	{
		tegels = new Tegel[2*n][2*n];
		grootte = 2*n;
		int teller = 0;
		while(teller < n*n)
		{
			lijst.add(new T());
			teller++;
		}
		teller = 0;
		
		while(teller < n*n)
		{
			lijst.add(new Cross());
			teller++;
		}
		teller = 0;
		
		while(teller < n*n)
		{
			lijst.add(new Straight());
			teller++;
		}
		teller = 0;
		
		while(teller < n*n)
		{
			lijst.add(new Bend());
			teller++;
		}
		teller = 0;
		
		Collections.shuffle(lijst);
		
		int x = 0;
		int y = 0;
		
		while(x < 2*n)
		{
			while(y < 2*n)
			{
				lijst.get(teller).draai((int) (Math.random()*4));
				tegels[x][y] = lijst.get(teller);
				
				teller ++;
				y++;
			}
			y = 0;
			x++;
		}
	
		
	Positie posVentje = new Positie((int) (Math.random()*grootte),(int) (Math.random()*grootte));
	Positie posGoud = new Positie((int) (Math.random()*grootte),(int) (Math.random()*grootte));
	while(posVentje.vergelijk(posGoud) == true)
	{
		posGoud = new Positie((int) (Math.random()*grootte),(int) (Math.random()*grootte));
	}
	tegels[posVentje.getX()][posVentje.getY()].initVentje();
	tegels[posGoud.getX()][posGoud.getY()].initGoud();
	
	}
	
	public Tegel[][] getTegels()
	{
		return tegels;
	}
	
	public void setTegels(Tegel[][] t)
	{
		tegels = t;
	}
	
	public int getGrootte()
	{
		return grootte;
	}
	
	public void setGrootte(int g)
	{
		grootte = g;
	}
	
	public Tegel getTegel(Positie pos)
	{
		return tegels[pos.getX()][pos.getY()];
	}
	
	public void setTegel(Positie pos, Tegel t)
	{
		tegels[pos.getX()][pos.getY()] = t;
	}
	
	public Positie getPosVentje()
	{		
		int x;
		int y;
		Positie pos=null;
				
		x = 0;
		while (x != grootte)
		{
			y = 0;
			while (y != grootte)
			{
				if (tegels[x][y].getPosVentje() != null)
				{
					pos = new Positie(x,y);
					return pos;
				}
				y++;
			}
			x++;
		}
		
		return pos;
	}
	
	public void setPosVentjeTegel0(Positie pos)
	{
		posVentjeTegel0 = pos;
	}
	
	public void setPosVentjeTegel(Positie pos)
	{
		posVentjeTegel = pos;
	}
	
	public void setPosVentjeVakje0(Positie pos)
	{
		posVentjeVakje = pos;
	}
	
	public void setPosVentjeVakje(Positie pos)
	{
		posVentjeVakje0 = pos;
	}
	
	public Positie getPosVentjeTegel0()
	{
		return posVentjeTegel0;
	}
	
	public Positie getPosVentjeTegel()
	{
		return posVentjeTegel;
	}
	
	public Positie getPosVentjeVakje0()
	{
		return posVentjeVakje;
	}
	
	public Positie getPosVentjeVakje()
	{
		return posVentjeVakje0;
	}
	
	public void moveVentje(int richting)  throws PositieError,GoudGevonden // Links = 4; Boven = 5; Rechts = 6; Onder = 7;
	{
		
		this.setPosVentjeTegel(this.getPosVentje());
		this.setPosVentjeVakje(this.getTegel(posVentjeTegel).getPosVentje());
		this.setPosVentjeTegel0(this.getPosVentjeTegel());
		this.setPosVentjeVakje0(this.getPosVentjeVakje());
		
		if (richting == Doolhof.LINKS)
		{
			if(this.getPosVentjeVakje().getX() == 1 && this.getPosVentjeVakje().getY() == 0)
			{
				this.setPosVentjeTegel(new Positie(this.getPosVentjeTegel().getXLinks(),this.getPosVentjeTegel().getYLinks()));
				this.setPosVentjeVakje(new Positie(1,2));
			}
			
			else
			{
				this.setPosVentjeVakje(new Positie(this.getPosVentjeVakje().getXLinks(),this.getPosVentjeVakje().getYLinks()));
			}
		}
		
		if (richting == Doolhof.RECHTS)
		{
			if(this.getPosVentjeVakje().getX() == 1 && this.getPosVentjeVakje().getY() == 2)
			{
				this.setPosVentjeTegel(new Positie(this.getPosVentjeTegel().getXRechts(),this.getPosVentjeTegel().getYRechts()));
				this.setPosVentjeVakje(new Positie(1,0));
			}
			
			else
			{
				this.setPosVentjeVakje(new Positie(this.getPosVentjeVakje().getXRechts(),this.getPosVentjeVakje().getYRechts()));
			}
		}
		
		if (richting == Doolhof.BOVEN)
		{
			if(this.getPosVentjeVakje().getX() == 0 && this.getPosVentjeVakje().getY() == 1)
			{
				this.setPosVentjeTegel(new Positie(this.getPosVentjeTegel().getXBoven(),this.getPosVentjeTegel().getYBoven()));
				this.setPosVentjeVakje(new Positie(2,1));
			}
			
			else
			{
				this.setPosVentjeVakje(new Positie(this.getPosVentjeVakje().getXBoven(),this.getPosVentjeVakje().getYBoven()));
			}
		}
		
		if (richting == Doolhof.ONDER)
		{
			if(posVentjeVakje.getX() == 2 && posVentjeVakje.getY() == 1)
			{
				this.setPosVentjeTegel(new Positie(this.getPosVentjeTegel().getXOnder(),this.getPosVentjeTegel().getYOnder()));
				this.setPosVentjeVakje(new Positie(0,1));
			}
			
			else
			{
				this.setPosVentjeVakje(new Positie(this.getPosVentjeVakje().getXOnder(),this.getPosVentjeVakje().getYOnder()));
			}
		}
		
		if(this.getPosVentjeTegel().getX() < 0 || this.getPosVentjeTegel().getY() < 0 || this.getPosVentjeTegel().getX() >= grootte || this.getPosVentjeTegel().getY() >= grootte)
		{
			throw new PositieError("Buiten het spel");
		}
		
		else if (this.getTegel(this.getPosVentjeTegel()).getVakje(this.getPosVentjeVakje()).isLeeg() == true)
		{
			this.getTegel(this.getPosVentjeTegel0()).getVakje(this.getPosVentjeVakje0()).setInhoud(Tegel.LEEG);
			this.getTegel(this.getPosVentjeTegel()).getVakje(this.getPosVentjeVakje()).setInhoud(Tegel.VENTJE);		
		}
		
		else if (this.getTegel(posVentjeTegel).getVakje(posVentjeVakje).isGoud() == true)
		{
			this.getTegel(this.getPosVentjeTegel0()).getVakje(this.getPosVentjeVakje0()).setInhoud(Tegel.LEEG);
			this.getTegel(this.getPosVentjeTegel()).getVakje(this.getPosVentjeVakje()).setInhoud(Tegel.VENTJE);	
			throw new GoudGevonden("Joepie!");
		}
		
		else
		{
			throw new PositieError("MUUR");
		}
		
		
	}
	
	public String toString()
	{
		System.out.println("Begint met de toString");
		
		String woord = "";
		int tellerHorizontaal = 0;
		int tellerVerticaal = 0;
		
		while (tellerVerticaal < grootte)
		{
			//System.out.println("Begint met het maken van de eerste rij");
			
			while (tellerHorizontaal < grootte)
			{
				woord += tegels[tellerHorizontaal][tellerVerticaal].toStringBoven();
				tellerHorizontaal ++;
			}
			tellerHorizontaal = 0;
			woord += "\n";
			
			//System.out.println("Begint met het maken van de tweede rij");
			
			while (tellerHorizontaal < grootte)
			{
				woord += tegels[tellerHorizontaal][tellerVerticaal].toStringMidden();
				tellerHorizontaal ++;
			}
			tellerHorizontaal = 0;
			woord += "\n";
			
			//System.out.println("Begint met het maken van de derde rij");
			
			while (tellerHorizontaal < grootte)
			{
				woord += tegels[tellerHorizontaal][tellerVerticaal].toStringOnder();
				tellerHorizontaal ++;
			}
			
			tellerHorizontaal = 0;
			woord += "\n";
			tellerVerticaal ++;
			
		}
		
		return woord;
		
	}
	
}
