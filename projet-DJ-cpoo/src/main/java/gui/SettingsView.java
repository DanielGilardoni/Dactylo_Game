package gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;

public class SettingsView extends JPanel {
    GUI gui;
    JLabel title;

    public SettingsView(GUI gui){
        this.gui = gui;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlePanel());
        this.add

        JTextArea typed = new JTextArea("");
        typed.setFont(getFont());
        this.add(typed);
        this.add(titlePanel());
    }
    
    public JPanel titlePanel() {
        JPanel panel = new JPanel();

        this.title = new JLabel("Page de Configuration");
        this.title.setForeground(Color.WHITE);

        this.title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(this.title);
        panel.setOpaque(false);
        return panel;
    }
}
