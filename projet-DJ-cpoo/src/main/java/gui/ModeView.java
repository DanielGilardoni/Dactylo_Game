package gui;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModeView extends JPanel{
    public ModeView(Gui gui) {
		this.setBackground(Gui.MINT_COLOR);
		this.setLayout(new GridLayout(3, 1));

		JPanel tmp = new JPanel();
		tmp.setBackground(Gui.MINT_COLOR);
		tmp.setLayout(new GridLayout(1, 3));
		JPanel color1 = new JPanel();
		color1.setBackground(Gui.MINT_COLOR);
		tmp.add(color1);
		
		JLabel name = new JLabel("Choix du mode : ");
		name.setFont(new Font("Verdana", Font.PLAIN, 25));
		name.setForeground(Gui.BLACK_COLOR);
		
		name.setHorizontalAlignment(0);
		tmp.add(name);

		JPanel color2 = new JPanel();
		color2.setBackground(Gui.MINT_COLOR);
		tmp.add(color2);
		this.add(tmp);

		JPanel options = new JPanel();
		options.setLayout(new GridLayout(1, 3));
		options.setBackground(Gui.MINT_COLOR);


		JPanel color4 = new JPanel();
		color4.setBackground(Gui.MINT_COLOR);
		options.add(color4);


		JPanel optionbuttons = new JPanel();
		optionbuttons.setLayout(new GridLayout(3, 1));
		optionbuttons.setBackground(Gui.MINT_COLOR);

		JButton training = new JButton("NORMAL");
		training.addActionListener(e -> {
			gui.setSettingsView();
		});
		optionbuttons.add(training);
		JButton play = new JButton("JEU");
		play.addActionListener(e -> {
			//pas encore implémentée
		});
		optionbuttons.add(play);
		JButton home = new JButton("ACCUEIL");
		home.addActionListener(e -> {
			gui.setHomeView();
		});
		optionbuttons.add(home);

		options.add(optionbuttons);

		JPanel color5 = new JPanel();
		color5.setBackground(Gui.MINT_COLOR);
		options.add(color5);

		this.add(options);

		
		JPanel color3 = new JPanel();
		color3.setBackground(Gui.MINT_COLOR);
		this.add(color3);
    }
}
