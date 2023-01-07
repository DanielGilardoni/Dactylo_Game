package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RetourView extends JPanel {
    public RetourView(Gui gui) {
        this.setLayout(new GridLayout(1, 1));
        JButton retour = new JButton("RETOUR");
        retour.setBackground(Gui.BEIGE_COLOR);
        retour.addActionListener(e -> gui.setSettingsView());
        this.add(retour);
    }
}
