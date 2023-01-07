package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import principal.DactyloGame;

public class GameView extends JPanel{
    private DactyloGame dactylo = null;
    private RetourView retour;
//    private ModeNormalView mots;
//    private EtatView etat;

    public GameView(Gui gui, DactyloGame dactylo) {
        this.setBackground(Gui.MINT_COLOR);
        this.dactylo = dactylo;

        this.setLayout(new BorderLayout());
        retour = new RetourView(gui);
        this.add(retour, BorderLayout.NORTH);

//        mots = new ModeNormalView(dactylo.getList(), this);
//
//        this.add(mots.getPanel(), BorderLayout.CENTER);
//
//        etat = new EtatView(dactylo);
//        this.add(etat.getPanel(), BorderLayout.SOUTH);
//
//        GameView.this.dactylo.getEtat().startTimer();
        KeyAdapter keyAdapter = new KeyAdapter()
        {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                DactyloGame courant = GameView.this.dactylo;
                boolean end = /*courant.Finish(e.getKeyChar());*/ true;
                if (end == true) {
                    gui.setFinishView(courant);
                }
//                else {
//                    newWord(Gamepanel.this.oldcurrent);
//                    newStatus();
//                }
            }
        };
        gui.addKeyListener(keyAdapter);
    }
    /*
		this.setBackground(Gui.BLACK_COLOR);
		this.jeu = jeu;

		this.setLayout(new BorderLayout());
		top = new Toppanel(gui);
		this.add(top, BorderLayout.NORTH);

		words = new WordPanel(jeu.getList(), this);

		this.add(words.getPanel(), BorderLayout.CENTER);

		status = new Statuspanel(jeu);
		this.add(status.getPanel(), BorderLayout.SOUTH);

		Gamepanel.this.jeu.getEtat().startTimer();
		KeyAdapter keyAdapter = new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				Jeu current = Gamepanel.this.jeu;
 				boolean end = current.Finish(e.getKeyChar());
				
				if (end == true)
					gui.setLostpage(current);
				else
				{
					newWord(Gamepanel.this.oldcurrent);
					newStatus();
				}
            }
		};
		gui.addKeyListener(keyAdapter);
	}
	
	public void newWord(String oldString)
	{

		this.remove(words);
		this.words = new WordPanel(this.jeu.getList(), this);
		this.add(this.words, BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
	}

	public void newStatus()
	{
		this.remove(status);
		this.status = new Statuspanel(this.jeu);
		this.add(this.status, BorderLayout.SOUTH);
		this.repaint();
		this.revalidate();
	}

	public void setoldString(String oldString)
	{
		this.oldcurrent = oldString;
	}

	public String getoldString()
	{
		return this.oldcurrent;
	}

     */
}
