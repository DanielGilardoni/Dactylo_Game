package gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import gui.views.Window;
import gui.views.SettingsView;
import principal.Joueur;
import principal.Dactylo;
import java.awt.EventQueue;

public class DactyloGui {

	Dactylo dactyloGui;
	List<Joueur> joueurs = new LinkedList<>();

	public Dactylo initializeDactylo(SettingsView form) {
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