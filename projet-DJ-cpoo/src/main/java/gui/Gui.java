package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import principal.DactyloFactory;
import principal.DactyloGame;

public class Gui extends JFrame {

	private JPanel lastPanel;
	private DactyloGame dactylo;
	private int width;
	private int height;

	public static Color BLACK_COLOR = new Color(19, 17, 35);
	public static Color WHITE_COLOR = new Color(233, 241, 247);
	public static Color BEIGE_COLOR = new Color(235, 224, 179);
	public static Color MINT_COLOR = new Color(179, 235, 186);

	public Gui(int w, int h) {
		this.width = w;
		this.height = h;
		this.pack();
		this.setTitle("Dactylo");
		this.setBackground(Gui.MINT_COLOR);
		this.setSize(w, h);
		this.setVisible(true);
		this.setResizable(true);
		this.setFocusable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setHomeView() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		lastPanel = new HomeView(width, height, this);
			
		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public void setGameView() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		lastPanel = new GameView(this, dactylo);

		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public void setFinishView(DactyloGame dactylo) {
		this.removeKeyListener(this.getKeyListeners()[0]);
		this.getContentPane().removeAll();
		this.setResizable(true);
		lastPanel = new FinishView(this);

		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public void setModeView() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		lastPanel = new ModeView(this);

		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public void setSettingsView() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		lastPanel = new SettingsView(dactylo, this);

		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public DactyloGame getDactylo() {
		return this.dactylo;
	}

	public void initDactylo() {
		File file = new File("src/static/dictionnaire.txt");
		this.dactylo = DactyloFactory.getDactyloGame(1, file, null);
	}

}