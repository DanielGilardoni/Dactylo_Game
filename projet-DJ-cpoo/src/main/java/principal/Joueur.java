package principal;

public class Joueur {
    private int nbVie;
    private String nom;

    public Joueur(String nom){
        if (nbVie < 0 || nom == null) {
            throw new IllegalArgumentException("Erreur lors de la création du joueur.");
        }
        this.setVies(5);
        this.setNom(nom);
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public int getVies(){
        return this.nbVie;
    }    

    public void setVies(int nbVie){
        this.nbVie = nbVie;
    }

    public void setViesPerdue(int nbVie){
        this.nbVie = nbVie - 1;
    }

    public void setViesGagne(int nbVie){
        this.nbVie = nbVie + 1;
    }

    public Joueur perdVie(){
        if (nbVie == 0) {
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
