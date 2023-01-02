package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.controllers.HomeController;

public class GUI extends JFrame implements ActionListener, KeyListener {

    private static final long serialVersionUID = 1L;

	public static Color BACKGROUND_COLOR = new Color(41, 50, 65),
						DARK_COLOR1 = new Color(61, 90, 128),
						DARK_COLOR2 = new Color(46, 55, 75),
						LIGHT_COLOR1 = new Color(152, 193, 217),
						LIGHT_COLOR2 = new Color(224, 251, 252),
						RED = new Color(238, 108, 77);

    private JPanel lastPanel;
    private int width;
    private int height;
                        
    public GUI(int w, int h) {
        this.setTitle("Dactylo-game");
		this.width = w;
		this.height = h;
		this.setMinimumSize(new Dimension(width+75, height));
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setDefaultLookAndFeelDecorated(true);

		this.addWindowListener(new WindowAdapter() {
            /* TODO: fix this
            @Override
            public void windowClosing(WindowEvent e)
            {
				if(MapView.sc != null)
					MapView.sc.close();
				System.exit(0);
            }
        */});
        
		this.setVisible(true);

    }

    public void setHomeView() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		HomeController controller = new HomeController();

		lastPanel = new HomeView(this);
		((HomeView) lastPanel).setController(controller);
		
	
		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public void setSettingsView() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		HomeController controller = new HomeController();

		lastPanel = new SettingsView(this);
		((HomeView) lastPanel).setController(controller);
		
	
		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

	public void openNormalMode() {
		this.getContentPane().removeAll();
		this.setResizable(true);
		lastPanel = new NormalMode(this);
	
		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
	}

    public void setLastPage() {
		if(lastPanel == null)
			return;
		this.getContentPane().removeAll();
		this.setResizable(true);
		this.getContentPane().add(lastPanel);
		revalidate();
		repaint();
        //TODO: fix this
		//if(lastPanel instanceof MapChooser)
			//lastPanel.requestFocus();
	}

	public void close() {
    	this.dispose();
        System.exit(0);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
