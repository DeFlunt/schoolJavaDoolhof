//Rutger Le Jeune

import java.awt.*;

import javax.swing.*;

public class DoolhofV extends JPanel {
	
	private TegelV[][] lijstTegels;
	
	public DoolhofV(int n,Doolhof d)
	{
		this.setLayout(new GridLayout(n,n));
		lijstTegels = new TegelV[n][n];
		int x = 0;
		int y = 0;
		Positie pos;
		
		while (x < n)
		{
			while (y < n)
			{
				pos = new Positie(x,y);
				lijstTegels[x][y] = new TegelV(d, pos);
				this.add(lijstTegels[x][y]);
				y++;
			}
			y = 0;
			x++;
		}
		this.setSize(75*n,75*n);
		
	}
	
	public void updateDoolhofV(Doolhof d)
	{
		lijstTegels[d.getPosVentjeTegel().getX()][d.getPosVentjeTegel().getY()].updateTegelV(d,d.getPosVentjeTegel(),d.getPosVentjeVakje());				
		lijstTegels[d.getPosVentjeTegel0().getX()][d.getPosVentjeTegel0().getY()].updateTegelV(d,d.getPosVentjeTegel0(),d.getPosVentjeVakje0());
	}

}
