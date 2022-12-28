package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;

public class NormalMode extends JPanel {
    GUI gui;
    JLabel title;

    public NormalMode(GUI gui){
        this.gui = gui;
        JTextArea typed = new JTextArea("");
        typed.setFont(getFont());
        this.add(typed);
        this.add(titlePanel());
    }
    
    public JPanel titlePanel() {
        JPanel panel = new JPanel();

        this.title = new JLabel("Mode Normal");
        this.title.setForeground(Color.WHITE);

        this.title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(this.title);
        panel.setOpaque(false);
        return panel;
    }
    


}
