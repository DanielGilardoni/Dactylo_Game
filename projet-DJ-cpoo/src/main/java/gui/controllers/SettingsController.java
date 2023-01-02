package gui.controllers;

import javax.swing.JButton;
import java.awt.event.*;

import gui.DactyloGui;
import gui.views.SettingsView;
import gui.views.Window;
import principal.DactyloGame;

public class SettingsController {
    SettingsView form;

    public void setView(SettingsView form) {
        this.form = form;
    }

    public void playPressed(SettingsView form, Window window) {
        // Handle Form and Start game (call backend Method and initialize board...etc)
        setView(form);
        // System.out.println("Start Game!");
        DactyloGui dactyloGui = new DactyloGui();
        DactyloGame dactylo = dactyloGui.initializeDactylo(form);
        window.setGame(dactylo);
    }

    public class Selection extends MouseAdapter {
        JButton jButton;
        int iconWidth;
        int iconHeight;
        String iconPath;    
 
        public Selection(JButton jButton, String path) {
            this.jButton = jButton;
            this.iconPath = path;
        }
        public void mouseEntered(MouseEvent evt) {
            this.iconHeight = jButton.getIcon().getIconWidth();
            this.iconWidth = jButton.getIcon().getIconHeight();
            this.jButton.setIcon(SettingsView.createIcon(this.iconPath, 155, 155));

        }
        public void mouseExited(MouseEvent evt) {
            this.jButton.setIcon(SettingsView.createIcon(this.iconPath, this.iconWidth, this.iconHeight));
        }

    }
    
}
