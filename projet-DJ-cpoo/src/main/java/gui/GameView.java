package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import principal.DactyloGame;

public class GameView extends JPanel{
    private DactyloGame dactylo = null;
    private RetourView retour;
    private ModeNormalView mots;
	private long startTime;
    private int pos = 0;

    public GameView(Gui gui, DactyloGame dactylo) {
        this.setBackground(Gui.MINT_COLOR);
        this.dactylo = dactylo;
        
        this.setLayout(new BorderLayout());
        retour = new RetourView(gui);
        this.add(retour, BorderLayout.NORTH);

        mots = new ModeNormalView(dactylo.getText(), this, dactylo, pos);
        this.add(mots.getPanel(), BorderLayout.CENTER);

        KeyAdapter keyAdapter = new KeyAdapter()
        {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                DactyloGame courant = GameView.this.dactylo;
				startTime = System.currentTimeMillis();
                if (startTime == dactylo.getTime()) {
                    gui.setFinishView(courant);
                }
                else {
                    newWord(GameView.this.dactylo.getText().getListe().peek().getMot(), pos);
                }
            }
        };
        gui.addKeyListener(keyAdapter);
    }
    
	public void newWord(String oldString, int pos) {
		this.dactylo.getText().remove();
        pos++;
		this.mots = new ModeNormalView(this.dactylo.getText(), this, this.dactylo, pos);
		this.add(this.mots, BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
	}
}
