package principal;

public class Joueur {
    private int nbVie;
    public Joueur(int nbVie){
        this.nbVie = nbVie;
    }

    public Joueur(){
        new Joueur(5);//On mets 5 par defaut mais on pourrait choisir autre chose
    }

    public int getVies(){
        return nbVie;
    }

    public Joueur perdVie(){
        return new Joueur(nbVie-1);//Ici faire juste nbVie--; serait ok je pense car on ne peut pas modifié nbVie ailleurs
    }

    public Joueur gagneVie(){
        return new Joueur(nbVie+1);
    }
}
