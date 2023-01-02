package gui.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;
import java.awt.event.WindowEvent;

import gui.views.SettingsView;
import gui.controllers.HomeController;
import principal.DactyloGame;
import principal.Joueur;
import principal.ListeMots;

public class Window extends JFrame{
    static final String TITLE = "Dactylo";
    static final int WIDTH = 1100;
    static final int HEIGHT = 700;

    // Models
    public DactyloGame currentDactylo;
    ListeMots listeMotsModel;
    public static List<Joueur> joueurs;
    public static int numberOfPlayers;

    public Window() {

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(true);
		this.setLocationRelativeTo(null);
        // Initialiaze GUI  
        // openBoard();
        openHomePage();
        Image icon = Toolkit.getDefaultToolkit().getImage("projet-DJ-cpoo/src/static/normal-mode.png");    
        this.setIconImage(icon);
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // this.setUndecorated(true);

    }

    public void openHomePage() {
        // This will quick start as the landing page 
        // User clicks either play or quit
        // If play, this method calls openGameForm
        this.getContentPane().removeAll();
        HomeView homeView = new HomeView(this);
        HomeController controller = new HomeController();
        homeView.setController(controller);

        this.getContentPane().removeAll();

		this.getContentPane().add(homeView);
		
        this.revalidate();
		this.repaint();
    }

    public void openGameForm() {
        // This method renders the form and get all the data from form and intialize the dactylo
        // Send all data inside a class like DactyloGame to OpenBoard 
        // e.g. DactyloGame dactylogame = new DactyloGame(form.data);
        // e.g.  openBoard(game)

        SettingsView form = new SettingsView(this);
        this.getContentPane().removeAll();
		this.getContentPane().add(form);
        this.revalidate();
		this.repaint();
    }

    public void setGame(DactyloGame game) {
        this.currentDactylo = game;
    }

}
/*
package gui.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

// import gui.CataneGui;
import gui.controllers.AireDeJeuController;
import gui.controllers.HomeController;
import gui.controllers.SubMenuController;
import principal.AireDeJeu;
import principal.Jeu;
import principal.Joueur;
import utils.De6Faces;

public class Window extends JFrame{
    static final String TITLE = "Catane";
    static final int WIDTH = 1100;
    static final int HEIGHT = 700;

    // Models
    public Jeu currentJeu;
    AireDeJeu aireDeJeuModel;
    public static List<Joueur> joueurs;
    De6Faces de1;
    public static int numberOfPlayers;


    // Views
    BoardView boardView;
    AireDeJeuView aireDeJeuView;
    PlayerHeaderView playerHeaderView;
    SubMenuView subMenuView;

    // Aux Panels
    JPanel widerPanel = new JPanel();
    JPanel menuHolderView = new JPanel();

    // Controllers
    AireDeJeuController aireDeJeuController;
    SubMenuController subMenuController;


    // Aux variables
    boolean villageStatus = false;
    boolean routeStatus = false;
    public static int[] preparePartiePlayers3 = {0, 1, 2, 2, 1, 0};
    public static int[] preparePartiePlayers4 = {0, 1, 2, 3, 3, 2, 1, 0};
    public static int[] threePlayersList = {0, 1, 2};
    public static int[] fourPlayersList = {0, 1, 2, 4};
    public static int currentPosInList = 0;
    public static String gameStatus;

    public Window() {

        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(true);
		this.setLocationRelativeTo(null);
        // Initialiaze GUI  
        // openBoard();
        openHomePage();
        Image icon = Toolkit.getDefaultToolkit().getImage("catane/src/static/colline.png");    
        this.setIconImage(icon);
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // this.setUndecorated(true);

    }

    public void openHomePage() {
        // This will quick start as the landing page 
        // User clicks either play or quit
        // If play, this method calls openGameForm
        this.getContentPane().removeAll();
        HomeView homeView = new HomeView(this);
        HomeController controller = new HomeController();
        homeView.setController(controller);

        this.getContentPane().removeAll();

		this.getContentPane().add(homeView);
		
        this.revalidate();
		this.repaint();
    }

    public void openGameForm() {
        // This method renders the form and get all the data from from and intialize the game
        // Send all data inside a class like Game to OpenBoard 
        // e.g. Game game = new Game(form.data);
        // e.g.  openBoard(game)

        StartGameFormView form = new StartGameFormView(this);
        this.getContentPane().removeAll();
        // this.setJMenuBar(null);
		this.getContentPane().add(form);
        this.revalidate();
		this.repaint();
    }

    public void setGame(Jeu jeu) {
        
            After Form receive Jeu Object -> Set basic visuals on the GameBoard
            1. Get all players information and add to headers.
            2. Set Board size and configuration.
            3. Pop Up a messsage indicating that the game will start / "Tutorial"
        

        // 1. Clear panel and prepare it for new content
        this.getContentPane().removeAll();
        this.getContentPane().setBackground(new Color(39, 125, 161));

        // 2. Contents
        this.currentJeu = jeu; // Main reference for everthing.
        

        // 3. Models
        this.aireDeJeuModel = jeu.getAire();    
        Window.joueurs = jeu.getJoueurs();
        Window.numberOfPlayers = Window.joueurs.size();
        this.de1 = new De6Faces(); // FIXME 


        // 4. Views
        this.boardView = new BoardView();
        this.aireDeJeuView = new AireDeJeuView();
        this.playerHeaderView = new PlayerHeaderView(joueurs);
        this.subMenuView = new SubMenuView();

        // Controllers
        this.aireDeJeuController = new AireDeJeuController();
        this.subMenuController = new SubMenuController();

        // SubMenuView setters
        updateSubMenuView(Window.joueurs.get(0), this.de1, false, false, false, false, false);
        // aireDeJeuView Setters
        updateAireDeJeuView();
        // aireDeJeuController Setters
        updateAireDeJeuController();
        // subMenuController Setters
        updateSubMenuController();

        // SetAuxPanels config
        setAuxPanels(this.widerPanel, this.menuHolderView);
        // UpdateBordView
        updateBoardView();

        // Set Frame (window) padding
        int padding = 15;
		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(padding, padding, padding, padding));

        this.getContentPane().add(boardView, BorderLayout.CENTER);
        
        String firstMessage = "Nous allons d'abord prépare la partie! Dans ce premier tour et dans le deuxième tour, chaque joueur devra placer une route et une colonie sur le plateau";
        String secondMessage = "Pour effectuer une action sélectionnez l'action souhaitée dans le menu action, pour passer votre tour cliquez sur la flèche à droite. Bon jeu! ";
    
        JOptionPane.showMessageDialog(this,
        firstMessage);

        JOptionPane.showMessageDialog(this,
        secondMessage);

        this.revalidate();
		this.repaint();
        this.preparePartie();

        // if(n == 1) {
        //     this.preparePartie();
        // }

        // else if (n == 0) {
        //     this.openGameForm();
        // }
        
    }

    
    public void lancePartie() {
        // Change game status
        Window.gameStatus = "LANCE_PARTIE";
        Window.currentPosInList = 0;
        int[] playerList = Window.joueurs.size() == 3 ? Window.threePlayersList : Window.fourPlayersList;
        nextPlayerTurn(playerList);
        // Update current player
    }


    public void preparePartie() {

        
            1. For each player in joueurs (from first to last)
                a. Add Board
                b. Add SubMenuView(current joeueur)
                c. Add Header
                d. Force current joueur to add a route
                e. Update Board/header/subMenu
                f. Force current joueur to add Village

            2. Repeat 1. from last to first.
        
        
        int[] playerList = Window.joueurs.size() == 3 ? Window.preparePartiePlayers3 : Window.preparePartiePlayers4;
        Window.gameStatus = "PREPARE_PARTIE";
        nextPlayerTurn(playerList);
    }


    public void nextPlayerTurn(int[] playerList) {
        if(Window.gameStatus.equals("PREPARE_PARTIE")) {
            if(Window.currentPosInList>=2*Window.numberOfPlayers) {
                // System.out.println("Prepare Partie est fini");
                updateGame(playerList, 0, this.de1, false, false, false, false, false);
                String firstMessage = "Tous les joueurs ont déjà placé 2 routes et 2 colonies sur le plateau, nous allons maintenant commencer le jeu. Bonne chance!";
                JOptionPane.showMessageDialog(this,
                firstMessage);
                lancePartie();
            }else {
                // System.out.println("here");
                // System.out.println(playerList[Window.currentPosInList]);
                updateGame(playerList, Window.currentPosInList, this.de1, false, false, false, true, true);
            }
        }else if(Window.gameStatus.equals("LANCE_PARTIE")) {
            if(this.currentJeu.joueurVainqueur() == null) {
                if(Window.currentPosInList > Window.numberOfPlayers-1) {
                    Window.currentPosInList = 0;
                }
                // System.out.println("INSIDE LANCE PARTIE");
                updateGame(playerList, Window.currentPosInList, this.de1, false, true, false, false, false);
            }else {
                Joueur j = this.currentJeu.joueurVainqueur();
                System.out.println("game over");
                String firstMessage = "Félicitation au Joueur: "+j.getNom()+"! Vous avez gagné la partie!";
                JOptionPane.showMessageDialog(this,
                firstMessage);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }

    private void updateGame(int[] playerList, int currentPos, De6Faces de, boolean roober, boolean dice, boolean cancel, boolean addFreeVillage, boolean addFreeRoute) {
        updateSubMenuView(Window.joueurs.get(playerList[currentPos]), de, roober,  dice, cancel, addFreeVillage, addFreeRoute);
        // aireDeJeuView Setters
        updateAireDeJeuView();
        // aireDeJeuController Setters
        updateAireDeJeuController();
        // subMenuController Setters
        updateSubMenuController();
        // SetAuxPanels config
        setAuxPanels(widerPanel, menuHolderView);
        // UpdateBordView
        updatePlayersHeader();
        updateBoardView();
        // JMenuBar menuBar = createMenuBar(createMenuOpenFolder("Start New Game"));
        this.getContentPane().removeAll();
        this.getContentPane().setBackground(new Color(39, 125, 161));
        this.getContentPane().add(boardView, BorderLayout.CENTER);
        // this.setJMenuBar(menuBar);
        this.revalidate();
        this.repaint();
    }



    private void updateBoardView() {
        // Add Content to Board
        this.boardView.removeAll();
        this.boardView.add(this.widerPanel, BorderLayout.CENTER);
        this.boardView.add(this.playerHeaderView, BorderLayout.NORTH);
        this.boardView.add(this.menuHolderView, BorderLayout.SOUTH);

        this.boardView.revalidate();
        this.boardView.repaint();
    }

    private void updateSubMenuView(Joueur joueur, De6Faces de, boolean roober, boolean dice, boolean cancel, boolean addFreeVillage, boolean addFreeRoute) {
        this.subMenuView.removeAll();
        this.subMenuView.setController(this.subMenuController);
        this.subMenuView.setSubMenuViewClass(joueur, this);
        this.subMenuView.updateActionsForPlayer(joueur, roober, dice, cancel, addFreeRoute);
        this.subMenuView.setDeModel(de);
        this.subMenuView.setAireDeJeuView(this.aireDeJeuView);

        this.subMenuView.revalidate();
        this.subMenuView.repaint();

    }

    private void updateAireDeJeuView() {

        this.aireDeJeuView.removeAll();
        this.aireDeJeuView.updateAireDeJeuView(this.aireDeJeuModel);
        this.aireDeJeuView.setControleur(this.aireDeJeuController);
        this.aireDeJeuView.setSubMenu(this.subMenuView);
        this.aireDeJeuView.revalidate();
        this.aireDeJeuView.repaint();
    }

    private void updateAireDeJeuController() {
        this.aireDeJeuController.setModel(this.aireDeJeuModel);
        this.aireDeJeuController.setView(this.aireDeJeuView);
    }

    private void updateSubMenuController() {
        this.subMenuController.setView(this.subMenuView);
    }

    private void setAuxPanels(JPanel widerPanel, JPanel menuHolderView) {
        // Add content to widerPanel

        widerPanel.setLayout(new BorderLayout());
        widerPanel.add(this.aireDeJeuView, BorderLayout.CENTER);
        widerPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
        widerPanel.setOpaque(false);
      
        // Add content to menuHomderView
        menuHolderView.setLayout(new BorderLayout());
        menuHolderView.add(this.subMenuView, BorderLayout.CENTER);
    }

    public void updatePlayersHeader() {
        this.playerHeaderView = new PlayerHeaderView(Window.joueurs);
    }

    // private JMenu createMenuOpenFolder(String title) {
	// 	JMenu menu = new JMenu("Menu");
	// 	JMenuItem menuItem = new JMenuItem(title);
	// 	menuItem.addActionListener(new ActionListener() {
	// 		@Override
	// 		public void actionPerformed(ActionEvent e) {
    //             // System.out.println("Return to home");
    //             // Window.this.openHomePage(); //FIXME
	// 		}
	// 	});
	// 	menu.add(menuItem);
	// 	return menu;
	// }

    // private static JMenuBar createMenuBar(JMenu openProject) {
    //     JMenuBar menu = new JMenuBar();
    //     menu.add(openProject);
    //     return menu;
    // }


}

 */