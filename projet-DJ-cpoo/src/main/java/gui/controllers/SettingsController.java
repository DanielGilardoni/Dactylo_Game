package gui.controllers;

import javax.swing.JButton;
import java.awt.event.*;

import gui.DactyloGui;
import gui.views.SettingsView;
import gui.views.Window;
import principal.Dactylo;

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
        Dactylo dactylo = dactyloGui.initializeDactylo(form);
        window.setGame(dactylo);
    }
    
}
