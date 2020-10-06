//Rutger Le Jeune

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame {

	private ButtonV knoppen;
	private DoolhofV doolhof;
	
	public View(int n, Doolhof d)
	{
		doolhof = new DoolhofV(n, d);
		knoppen = new ButtonV();
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		c.add(doolhof, BorderLayout.CENTER);
		c.add(knoppen, BorderLayout.SOUTH);
		
		setSize(74*n,(73*n + 12));
		setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void updateView(Doolhof d)
	{
		doolhof.updateDoolhofV(d);
	}
	
	public JButton getLinks()
	{
		return knoppen.getLinks();
	}
	
	public JButton getBoven()
	{
		return knoppen.getBoven();
	}
	
	public JButton getRechts()
	{
		return knoppen.getRechts();
	}
	
	public JButton getOnder()
	{
		return knoppen.getOnder();
	}
	
	public void gewonnen()
	{
		JOptionPane.showMessageDialog(null,"Joepie Eve gevonden, je hebt gewonnen","Einde Spel",JOptionPane.PLAIN_MESSAGE);
	}
}
