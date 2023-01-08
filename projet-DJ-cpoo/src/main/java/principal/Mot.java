package principal;

public class Mot {
    private String mot;
    private char couleur;
    
    private Mot(Builder builder) {
        this.mot = builder.mot;
        couleur = builder.couleur;
    }

    public static Builder builder(){
        return new Builder();
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


    public boolean compareMots(Mot b){
        return this.getMot().equals(b.getMot());
    }

    public int countUtils(int nbCharTyped){//A appeler si le mot tapé est valide
        int size = this.getMot().length();
        if(nbCharTyped < size){
            throw new IllegalArgumentException("Le nombre de caractéres tapés ne peut pas être inferieur à la longueur du mot. Verifiez avant si le mot tapé est bien valide.");
        }
        return (2*size - nbCharTyped);//la taille du mot - le nombre de char qu'on aura tapé puis effacé est le nombre de char utiles
    }

    public static class Builder {
        private String mot;
        private char couleur = 'w'; //couleur = specificité dans le mode jeu (On met w pour white par defaut)

        public Mot build(){
            if(isCorrect())
                return new Mot(this);
            else
                throw new IllegalArgumentException("Le mot ne peut pas être null.");
        }

        public Builder mot(String mot){
            this.mot = mot;
            return this;
        }

        public Builder couleur(char couleur){
            this.couleur = couleur;
            return this;
        }

        public boolean isCorrect() {
            return (mot != null);
        }
    }

    
}
