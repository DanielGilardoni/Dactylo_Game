package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartView extends JPanel{
        
    public StartView(Gui gui) {

        this.setBackground(Gui.BEIGE_COLOR);
        this.setLayout(new GridLayout(1, 3));

        JPanel color1 = new JPanel();

        color1.setBackground(Gui.MINT_COLOR);
        this.add(color1);            

        JPanel allButton = new JPanel();

        allButton.setLayout(new GridLayout(3, 1));
        allButton.setBackground(Gui.MINT_COLOR);
        JButton start = new JButton("COMMENCER");
        start.setBackground(Gui.WHITE_COLOR);

        start.addActionListener(e -> {
            //gui.initJeu();
            gui.setModeView();
        });
        allButton.add(start);            

        JButton quit = new JButton("QUITTER");
		quit.setBackground(Gui.WHITE_COLOR);

        quit.addActionListener(e -> {
			System.exit(0);
		});
		allButton.add(quit);
		this.setOpaque(false);
		this.add(allButton);

		JPanel color2 = new JPanel();
		color2.setBackground(Gui.MINT_COLOR);
		this.add(color2);
    }    
}
