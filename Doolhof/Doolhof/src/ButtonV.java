//Rutger Le Jeune

import java.awt.*;

import javax.swing.*;

public class ButtonV extends JPanel {

	private JButton btnLinks = new JButton("Links");
	private JButton btnBoven = new JButton("Boven");
	private JButton btnRechts = new JButton("Rechts");
	private JButton btnOnder = new JButton("Onder");
	
	public ButtonV()
	{
		this.setLayout(new BorderLayout());
		this.add(btnLinks, BorderLayout.WEST);
		this.add(btnBoven, BorderLayout.NORTH);
		this.add(btnRechts, BorderLayout.EAST);
		this.add(btnOnder, BorderLayout.SOUTH);
	}
	
	public JButton getLinks()
	{
		return btnLinks;
	}
	
	public JButton getBoven()
	{
		return btnBoven;
	}
	
	public JButton getRechts()
	{
		return btnRechts;
	}
	
	public JButton getOnder()
	{
		return btnOnder;
	}
}
