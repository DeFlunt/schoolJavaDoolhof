// Rutger Le Jeune

import java.awt.*;

import javax.swing.*;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.*;

public class TegelV extends JPanel {
	
	private JDoolhofElement[][] lijstVakjes;
	
	public TegelV(Doolhof d, Positie pos)
	{
		this.setLayout(new GridLayout(3,3));
		lijstVakjes = new JDoolhofElement[3][3];
		int x = 0;
		int y = 0;
		Positie pos2;
		
		while (x < 3)
		{
			while (y < 3)
			{
				pos2 = new Positie(x,y);
				if(d.getTegel(pos).getVakje(pos2).isMuur() == true)
				{
					//System.out.println("Implementeerd een afbeelding");
					lijstVakjes[x][y] = new JDoolhofElement(Tegel.MUUR);
				}
				else if (d.getTegel(pos).getVakje(pos2).isLeeg() == true)
				{
					lijstVakjes[x][y] = new JDoolhofElement(Tegel.LEEG);
				}
				else if (d.getTegel(pos).getVakje(pos2).isVentje() == true)
				{
					lijstVakjes[x][y] = new JDoolhofElement(Tegel.VENTJE);
				}
				else
				{
					lijstVakjes[x][y] = new JDoolhofElement(Tegel.GOUD);
				}
				this.add(lijstVakjes[x][y]);
				y++;
			}
			y = 0;
			x++;
		}
	}
	
	public void updateTegelV(Doolhof d, Positie pos, Positie pos2)
	{
		
		if(d.getTegel(pos).getVakje(pos2).isMuur() == true)
		{
			lijstVakjes[pos2.getX()][pos2.getY()].setInhoud(Tegel.MUUR);
		}
		else if (d.getTegel(pos).getVakje(pos2).isLeeg() == true)
		{
			lijstVakjes[pos2.getX()][pos2.getY()].setInhoud(Tegel.LEEG);
		}
		else if (d.getTegel(pos).getVakje(pos2).isVentje() == true)
		{
			lijstVakjes[pos2.getX()][pos2.getY()].setInhoud(Tegel.VENTJE);
		}
		else
		{
			lijstVakjes[pos2.getX()][pos2.getY()].setInhoud(Tegel.GOUD);
		}
		
		revalidate();
		repaint();
	}
	
}
