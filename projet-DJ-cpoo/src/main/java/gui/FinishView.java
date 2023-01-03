package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FinishView extends JPanel{
    public FinishView(Gui gui) {
		this.setBackground(Gui.BLACK_COLOR);
		this.setLayout(new GridLayout(1, 2));

//		this.add(new Statistiquespanel(gui.getJeu()));

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3, 1));
		buttons.setBackground(Gui.BLACK_COLOR);
		
		JPanel color1 = new JPanel();
		color1.setBackground(Gui.BLACK_COLOR);
		buttons.add(color1);


		JPanel lost = new JPanel();
		lost.setLayout(new GridLayout(3, 1));
		JButton retry = new JButton("NOUVELLE PARTIE ?");
		retry.addActionListener(e -> {
			gui.setModeView();
		});
		retry.setBackground(Gui.BLACK_COLOR);
		lost.add(retry);

		JButton settings = new JButton("PARAMETRES");
		retry.addActionListener(e -> {
			gui.setSettingsView();
		});
		settings.setBackground(Gui.BLACK_COLOR);
		lost.add(settings);

		JButton quit = new JButton("QUITTER");
		quit.addActionListener(e -> 
		{
			System.exit(0);		
		});
		quit.setBackground(Gui.BLACK_COLOR);
		lost.setBackground(Gui.BLACK_COLOR);
		lost.add(quit);
		buttons.add(lost);
				
		JPanel color2 = new JPanel();
		color2.setBackground(Gui.BLACK_COLOR);
		buttons.add(color2);
		
		this.add(buttons);

    }
}
