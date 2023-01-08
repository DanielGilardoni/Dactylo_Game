package principal;

public class Joueur {
    private int nbVies;
    private String nom;

    public Joueur(String nom, int vies){
        if (nbVies < 0 || nom == null) {
            throw new IllegalArgumentException("Erreur lors de la création du joueur.");
        }
        this.nbVies = vies;
        this.nom = nom;
    }

    public Joueur(String nom){
        this(nom, 5);
    }



    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        if (nom == null) {
            throw new IllegalArgumentException("On ne peut pas set le nom à null.");
        }
        this.nom = nom;
    }

    public int getVies(){
        return this.nbVies;
    }    

    public void setVies(int nbVie){
        if (nbVie < 0) {
            throw new IllegalArgumentException("On ne peut pas set le nombre de vie à une valeur negative.");
        }
        this.nbVies = nbVie;
    }

    public void setViesPerdue(int nbVie){
        this.nbVies = nbVie - 1;
    }

    public void setViesGagne(int nbVie){
        this.nbVies = nbVie + 1;
    }

    public Joueur perdVie(){
        if (nbVies == 0) {
            return this;//On ne peut pas perdre de vie si on en a plus
        }else {
            this.setViesPerdue(getVies());
            return this;
        }
    }

    public Joueur gagneVie(){
        this.setViesGagne(getVies());
        return this;
    }
}
