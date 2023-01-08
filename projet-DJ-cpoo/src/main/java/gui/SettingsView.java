package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.util.ArrayList;

import principal.DactyloGame;
import principal.Joueur;

public class SettingsView extends JPanel {

	private JSlider health;
	private JTextField name;
	private JSlider max;
	private JSlider time;

    public SettingsView(DactyloGame dactylo, Gui gui) {
		this.setLayout(new GridLayout(10, 1));   
		initJSliderHeatlth();
		initJTextFieldName();
		initJSliderMax();
		initJSliderTime();
		this.add(createNameofSlider("Nom Joueur : "));
		this.add(this.name);
		this.add(createNameofSlider("Nombre de vie : "));
		this.add(this.health);
		this.add(createNameofSlider("Temps de Jeu : "));
		this.add(this.time);
		this.add(createNameofSlider("Nombre de Mots : "));
		this.add(this.max);
		JButton home = initHomeButton(gui);
		JButton confirm = initConfirmButton(gui);
		this.add(confirm);
		this.add(home);
    }

	public JPanel createNameofSlider(String str) {
		JPanel tmp = new JPanel();
		tmp.setLayout(new GridLayout(1, 3));
		JPanel color = new JPanel();
		tmp.add(color);
		JLabel name = new JLabel(str);
		name.setHorizontalAlignment(0); // CENTER
		name.setBackground(Gui.WHITE_COLOR);
		tmp.add(name);
		JPanel color2 = new JPanel();
		tmp.add(color2);
		return (tmp);
	}

	public void initJTextFieldName() {
		JTextField name = new JTextField("Joueur");
		name.setHorizontalAlignment(0); // CENTER
		name.setBackground(Gui.BEIGE_COLOR);
		this.name = name;
	}

	public void initJSliderHeatlth() {
		JSlider health = new JSlider(JSlider.HORIZONTAL, 0, 5, 3);
		health.setMajorTickSpacing(1);
		health.setMinorTickSpacing(1);
		health.setPaintLabels(true);
		health.setPaintTicks(true);
		health.setBackground(Gui.BEIGE_COLOR);
		this.health = health;
	}

	public void initJSliderMax() {
		this.max = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		max.setMajorTickSpacing(10);
		max.setMinorTickSpacing(1);
		max.setBackground(Gui.BEIGE_COLOR);
		max.setPaintLabels(true);
		max.setPaintTicks(true);
	}

	public void initJSliderTime() {
		this.time = new JSlider(JSlider.HORIZONTAL, 0, 240, 30);
		time.setMajorTickSpacing(30);
		time.setMinorTickSpacing(10);
		time.setBackground(Gui.BEIGE_COLOR);
		time.setPaintLabels(true);
		time.setPaintTicks(true);
	}

	public JButton initHomeButton(Gui gui) {
		JButton home = new JButton("ACCUEIL");
		home.addActionListener(e -> {
			gui.setHomeView();
		});
		return (home);
	}

	public JButton initConfirmButton(Gui gui){
		JButton confirm = new JButton("CONFIRMER");
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		Joueur joueur = new Joueur(this.getName(), this.gethealth());
		joueurs.add(joueur);
		gui.initDactylo(joueurs);
		DactyloGame dactylo = gui.getDactylo();
		confirm.addActionListener(e -> {
			dactylo.setEndTime(this.getTime());
			dactylo.setMax(this.getMax());
			gui.setGameView();
		});
		return (confirm);
	}


	public String getName(){
		return this.name.getText();
	}

	public int gethealth(){
		return this.health.getValue();
	}

	public int getTime(){
		return this.time.getValue();
	}

	public int getMax(){
		return this.max.getValue();
	}
}