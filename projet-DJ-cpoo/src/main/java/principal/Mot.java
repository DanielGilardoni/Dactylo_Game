package principal;

public class Mot {
    private String mot;
    private char couleur = 'w'; //couleur = specificité dans le mode jeu (On met w pour white par defaut)
    
    public Mot(String mot) {
        if (mot == null) {
            throw new IllegalArgumentException("Le mot ne peut pas être null.");
        }
        else {
            this.mot = mot;
        }
    }
    
    public char getCouleur() {
        return couleur;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    public String getMot() {
        return this.mot;
    }

    public int compareMots(Mot a, Mot b){
        return 0;
    }

    
}
