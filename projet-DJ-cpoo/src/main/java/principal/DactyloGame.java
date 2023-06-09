package principal;

import java.io.File;
import java.util.ArrayList;
/**
 * @authors [Cortial Jade, Gilardoni Daniel]
 */
public abstract sealed class DactyloGame permits NormalMode, SoloMode, MultiPlayerMode {
    //On utilise un Factory Design Pattern car il y a plusieurs modes de jeux, et qu'on voudra peut-être pouvoir en ajouter

    private ArrayList<Joueur> joueurs;
    private ListeMots texte;
    private Stats stats;
    private Mot nextWord; //designe le prochain mot que le joueur doit taper
    private int gameMode; //le mode de jeu choisi : 1 pour NormalMode, 2 pour SoloMode, 3 pour MultiPlayerMode, sinon NormalMode
    private int max;//Le nombre de mot max qu'on veut dans la partie
    private int time;//Le temps que dure la partie en seconde

    /**
    * @param joueurs list de Joueur
    * @param texteFile fichier contenant la liste de mot du jeu
    * @param gameMode mode choisi : 1 pour NormalMode, 2 pour SoloMode, 3 pour MultiPlayerMode, sinon NormalMode
    */
    public DactyloGame(ArrayList<Joueur> joueurs, File texteFile, int gameMode){
        if(joueurs == null || joueurs.size() == 0)
            throw new IllegalArgumentException("Il faut au moins un joueur.");
        this.joueurs = copy(joueurs);
        this.texte = new ListeMots(texteFile);
        this.nextWord = texte.getListe().peek();
        this.gameMode = gameMode;
        this.time = 30;//30 secondes par defaut
        this.max = 100;//100 mots max par defaut

    }

    private ArrayList<Joueur> copy(ArrayList<Joueur> joueurs){
        ArrayList<Joueur> new_joueurs = new ArrayList<Joueur>();
        for(Joueur j : joueurs){
            Joueur new_joueur = new Joueur(j.getNom(), j.getVies());
            new_joueurs.add(new_joueur);
        }

        return new_joueurs;
    }

    public ArrayList<Joueur> getJoueurs(){
            return copy(this.joueurs);
    }

    public void setJoueurs(ArrayList<Joueur> players){
        if(joueurs == null || joueurs.size() == 0)
            throw new IllegalArgumentException("Il faut au moins un joueur.");
        this.joueurs = copy(players);
    }

    public void addJoueur(Joueur j) {
        if(j != null)
            this.joueurs.add(j);
    }

    public int getMax(){
        return max;
    }

    public void setMax(int m){
        if(m > 0 && m < 10000)
            this.max = m;
    }

    public int getTime(){
        return time;
    }

    public void setEndTime(int timer){
        if(timer > 0 && timer < 10000)
            this.time = timer;
    }

    public ListeMots getText() {
        return this.texte;
    } 

    public String getNextWordStr(){
        return this.nextWord.getMot();
    }



}
