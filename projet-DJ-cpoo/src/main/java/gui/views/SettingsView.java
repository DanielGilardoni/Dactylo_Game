package gui.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.controllers.SettingsController;

import java.awt.*;
import java.io.File;

public class SettingsView extends JPanel {
    JLabel title;
    public JRadioButton onePlayer;
    public JRadioButton twoPlayers;
    public JRadioButton threePlayers;

    public JRadioButton sizeOptionOne;
    public JRadioButton sizeOptionTwo;
    public JRadioButton sizeOptionThree;

    public JTextField playerOneName;
    public JTextField playerTwoName;
    public JTextField playerThreeName;

    SettingsController formController = new SettingsController();

    public JTextField playerThreeAge;
    public JRadioButton typeChoiceThreeHuman;

    public JTextField playerTwoAge;
    public JRadioButton typeChoiceFourHuman;

    Window window;

    public SettingsView(Window window) {
        // This panel config
        this.window = window;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlePanel());
        this.add(numberPlayersPanel());
        this.add(modePanel());
        this.add(playerNamesPanel());
        this.add(startButtonPanel());
        this.setBackground(new Color(39, 125, 161));
    }


    public JPanel titlePanel() {
        JPanel panel = new JPanel();

        this.title = new JLabel("Configuration du jeu");
        this.title.setFont(getNewFont(40));
        this.title.setForeground(Color.WHITE);

        this.title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(this.title, BorderLayout.CENTER);
        panel.setOpaque(false);
        return panel;
    }

    public JPanel numberPlayersPanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Nombre de joueurs: ");
        title.setForeground(Color.WHITE);

        title.setFont(getNewFont(25));

        this.threePlayers = new JRadioButton("1");
        this.threePlayers.setFont(getNewFont(20));
        this.threePlayers.setFocusPainted(false); 
        this.threePlayers.setOpaque(false);
        this.threePlayers.setForeground(Color.BLACK);

        this.onePlayer.setSelected(true);

        this.threePlayers = new JRadioButton("2");
        this.threePlayers.setFont(getNewFont(20));
        this.threePlayers.setFocusPainted(false); 
        this.threePlayers.setOpaque(false);
        this.threePlayers.setForeground(Color.BLACK);

        this.threePlayers = new JRadioButton("3");
        this.threePlayers.setFont(getNewFont(20));
        this.threePlayers.setFocusPainted(false); 
        this.threePlayers.setOpaque(false);
        this.threePlayers.setForeground(Color.BLACK);
        
        ButtonGroup gengp = new ButtonGroup();
        gengp.add(onePlayer);
        gengp.add(twoPlayers);
        gengp.add(threePlayers);

        panel.add(title);
        panel.add(onePlayer);
        panel.add(twoPlayers);
        panel.add(threePlayers);
        panel.setOpaque(false);

        return panel;

    }

    public JPanel modePanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Mode de dactylo: ");
        title.setForeground(Color.WHITE);

        title.setFont(getNewFont(25));

        this.sizeOptionOne = new JRadioButton("Normal");
        this.sizeOptionOne.setFont(getNewFont(20));
        this.sizeOptionOne.setFocusPainted(false); 
        this.sizeOptionOne.setOpaque(false);
        this.sizeOptionOne.setForeground(Color.BLACK);

        this.sizeOptionOne.setSelected(true);

        this.sizeOptionTwo = new JRadioButton("Jeu");
        this.sizeOptionTwo.setFont(getNewFont(20));
        this.sizeOptionTwo.setFocusPainted(false); 
        this.sizeOptionTwo.setOpaque(false);
        this.sizeOptionTwo.setForeground(Color.BLACK);

        this.sizeOptionTwo = new JRadioButton("Multijoueur");
        this.sizeOptionTwo.setFont(getNewFont(20));
        this.sizeOptionTwo.setFocusPainted(false); 
        this.sizeOptionTwo.setOpaque(false);
        this.sizeOptionTwo.setForeground(Color.BLACK);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(sizeOptionOne);
        gengp.add(sizeOptionTwo);
        gengp.add(sizeOptionThree);

        panel.add(title);
        panel.add(sizeOptionOne);
        panel.add(sizeOptionTwo);
        panel.add(sizeOptionThree);
        panel.setOpaque(false);

        return panel;

    }

    public JPanel playerNamesPanel() {
        // Players Name
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout();
        layout.setHgap(5);
        panel.setLayout(layout);
        JLabel title = new JLabel("Joueurs: ");
        title.setFont(getNewFont(25));
        title.setForeground(Color.WHITE);

        JPanel playerOneQuestions = playerOneQuestions();
        JPanel playerTwoQuestions = playerTwoQuestions();
        JPanel playerThreeQuestions = playerThreeQuestions();

        panel.add(playerOneQuestions);
        panel.add(playerTwoQuestions);
        panel.add(playerThreeQuestions);
        panel.setOpaque(false);

        return panel;
    }

    private JPanel playerOneQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerOneName = new JTextField(" Joueur 1 ");
        this.playerOneName.setFont(getNewFont(15));
        this.playerOneName.setOpaque(false);
        this.playerOneName.setForeground(Color.BLACK);
        this.playerOneName.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.playerOneName.setHorizontalAlignment(JTextField.CENTER);

        playerQuestions.add(this.playerOneName);
        return playerQuestions;
    }

    private JPanel playerTwoQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerTwoName = new JTextField(" Joueur 2 ");
        this.playerTwoName.setFont(getNewFont(15));
        this.playerTwoName.setOpaque(false);
        this.playerTwoName.setForeground(Color.BLACK);
        this.playerTwoName.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.playerTwoName.setHorizontalAlignment(JTextField.CENTER);

        playerQuestions.add(this.playerTwoName);
        return playerQuestions;
    }

    private JPanel playerThreeQuestions() {

        JPanel playerQuestions = new JPanel();
        playerQuestions.setLayout(new BoxLayout(playerQuestions, BoxLayout.Y_AXIS));
        playerQuestions.setOpaque(false);

        this.playerThreeName = new JTextField(" Joueur 3 ");
        this.playerThreeName.setFont(getNewFont(15));
        this.playerThreeName.setOpaque(false);
        this.playerThreeName.setForeground(Color.BLACK);
        this.playerThreeName.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.playerThreeName.setHorizontalAlignment(JTextField.CENTER);

        playerQuestions.add(this.playerThreeName);
        return playerQuestions;
    }

    public static Icon createIcon(String icon_path, int x, int y) {
        Icon icon = new ImageIcon(icon_path);
        Image image = ((ImageIcon) icon).getImage(); 
        Image newimg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); 
        icon = new ImageIcon(newimg); 
        return icon;
    }

    public JPanel startButtonPanel() {
        JButton play = new JButton(createIcon("projet-DJ-cpoo/src/static/start.png", 150, 150));
        play.setPreferredSize(new Dimension(155, 155));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setFocusPainted(false); 
        play.addMouseListener(formController.new Selection(play, "projet-DJ-cpoo/src/static/start.png"));
        play.addActionListener((event) -> this.formController.playPressed(this, this.window));

        JPanel panel = new JPanel();
        panel.add(play);
        panel.setOpaque(false);

        return panel;
    }
    
    public Font getNewFont(int size) {
        float f = (float)size;
        try {

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("projet-DJ-cpoo/src/static/Poppins-Bold.ttf")).deriveFont(f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;

        } catch (Exception e) {

            Font customFont = new Font(Font.SERIF, Font.PLAIN,  10);
            return customFont;
        }
       
    }

}
