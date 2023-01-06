package gui;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel{

    public HomeView(int w, int h, Gui gui) {

		this.setBackground(Gui.MINT_COLOR);
		this.setLayout(new GridLayout(3, 1));

		JPanel tmp = new JPanel();
		tmp.setBackground(Gui.MINT_COLOR);
		tmp.setLayout(new GridLayout(1, 3));
		JPanel color1 = new JPanel();
		color1.setBackground(Gui.MINT_COLOR);
		tmp.add(color1);
		
		JLabel name = new JLabel("Dactylo Game");
		name.setFont(new Font("Verdana", Font.PLAIN, 25));
		name.setForeground(Gui.BLACK_COLOR);
		
		name.setHorizontalAlignment(0);
		tmp.add(name);
		JPanel color2 = new JPanel();
		color2.setBackground(Gui.MINT_COLOR);
		tmp.add(color2);

		this.add(tmp);
		StartView start = new StartView(gui);
		this.add(start);
		JPanel color3 = new JPanel();
		color3.setBackground(Gui.MINT_COLOR);
		this.add(color3);
	}

}