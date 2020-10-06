//Rutger Le Jeune

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;

public class JDoolhofElement extends JComponent {
	
	private int inhoud;
	
	public JDoolhofElement(int i)
	{
		super();
		inhoud = i;
	}

	public void setInhoud(int i)
	{
		inhoud = i;
	}
	
	public int getInhoud()
	{
		return inhoud;
	}
	
	public void paintComponent(Graphics g) {
		
		try
		{
			BufferedImage im;
			if (inhoud == Tegel.LEEG)
			{
				 im = ImageIO.read(new java.io.File("src/Leeg.png"));
			}
			
			else if (inhoud == Tegel.MUUR)
			{
				im = ImageIO.read(new java.io.File("src/Muur.jpg"));
			}
			
			else if (inhoud == Tegel.VENTJE)
			{
				im = ImageIO.read(new java.io.File("src/Ventje.png"));
			}
			
			else
			{
				im = ImageIO.read(new java.io.File("src/Goud.png"));
			}
			super.paintComponent(g);
			g.drawImage(im,0,0,25,25,null);
		}
		
		catch (IOException fout)
		{
			System.out.println("Geen Afbeelding Gevonden");
		}
		
	    }
}
