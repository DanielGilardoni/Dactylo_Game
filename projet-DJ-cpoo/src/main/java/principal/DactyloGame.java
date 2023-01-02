package principal;

import java.io.File;
import java.util.ArrayList;

public abstract sealed class DactyloGame permits NormalMode, SoloMode, MultiPlayerMode {
    //On utilise un Factory Design Pattern car il y a plusieurs modes de jeux, et qu'on voudra peut-être pouvoir en ajouter

    private ArrayList<Joueur> joueurs;//final ?
    private ListeMots texte;
    private Stats stats;
    private Mot lastWord; //designe le prochain mot que le joueur doit taper
    private int gameMode; //le mode de jeu choisi : 1 pour NormalMode, 2 pour SoloMode, 3 pour MultiPlayerMode, sinon NormalMode
    
    public DactyloGame(ArrayList<Joueur> joueurs, File texteFile, int gameMode){

        this.joueurs = copy(joueurs);
        this.texte = new ListeMots(texteFile);
        this.texte.chargerTexte();
        this.lastWord = texte.getListe().peek();
        this.gameMode = gameMode;



    }

    private ArrayList<Joueur> copy(ArrayList<Joueur> joueurs){
        ArrayList<Joueur> new_joueurs = new ArrayList<Joueur>();
        for(Joueur j : joueurs){
            Joueur new_joueur = new Joueur(j.getVies());
            new_joueurs.add(new_joueur);
        }

        return new_joueurs;
    }



}
