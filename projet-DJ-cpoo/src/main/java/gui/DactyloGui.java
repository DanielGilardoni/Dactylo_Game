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

	public DactyloGame initializeDactylo(SettingsView form) {
		if (form.ModeNormal.isSelected()) {
			dactyloGui = getDactyloGame(1, texteFile, joueurs);
		}
		setPlayers(form);
		this.dactyloGui = new Dactylo(joueurs);
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