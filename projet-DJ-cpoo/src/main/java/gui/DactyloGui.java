package gui;

import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.io.File;

import gui.views.Window;
import gui.views.SettingsView;
import principal.Joueur;
import principal.DactyloFactory;
import principal.DactyloGame;
import java.awt.EventQueue;

public class DactyloGui {

	DactyloGame dactyloGui;
	File texteFile = new File("src/main/java/static/dictionnaire.txt");
	ArrayList<Joueur> joueurs;

	public DactyloGame initializeDactylo(SettingsView form) {
		setPlayers(form);
		if (form.modePanel(). isSelected()) {//Il faut accéder au bouton et voir si il est cliqué peut-être avec addActionListener ?
			this.dactyloGui = DactyloFactory.getDactyloGame(1, texteFile, joueurs);
		} else if(form.SoloMode.isSelected()){
			this.dactyloGui = DactyloFactory.getDactyloGame(2, texteFile, joueurs);
		} else 
			this.dactyloGui = DactyloFactory.getDactyloGame(3, texteFile, joueurs);
		return this.dactyloGui;
	}


	private void setPlayers(SettingsView form) {
		joueurs.add(createJoueur(form.playerOneName));
		if (form.TwoPlayers.isSelected()) {
			joueurs.add(createJoueur(form.playerTwoName));
		}
		if (form.ThreePlayers.isSelected()) {
			joueurs.add(createJoueur(form.playerTwoName));
			joueurs.add(createJoueur(form.playerThreeName));
		}
	}

	private Joueur createJoueur(JTextField name) {
		Joueur j = new Joueur(name.getText());
		return j;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()-> {
			new Window();
		});			
	}

}