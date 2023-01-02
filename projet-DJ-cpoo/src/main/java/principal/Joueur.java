package principal;

public class Joueur {
    private int nbVie;

    public Joueur(int nbVie){
        if (nbVie < 0) {
            throw new IllegalArgumentException("Un joueur ne peut pas avoir moins de 0 vies!");
        }
        this.nbVie = nbVie;
    }

    public Joueur(){
        this(5);//On mets 5 par defaut pour le nombre de vie
    }

    public int getVies(){
        return this.nbVie;
    }

    public Joueur perdVie(){
        if (nbVie == 0) {
            return this;//On ne peut pas perdre de vie si on en a plus
        }
        return new Joueur(nbVie-1);
    }

    public Joueur gagneVie(){
        return new Joueur(nbVie+1);
    }
}
