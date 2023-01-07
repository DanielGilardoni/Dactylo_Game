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

    // public static int compareMots(Mot a, Mot b){ //compareMots(attendu, tapé)
    //     int countError = 0;
    //     String motA = a.getMot();
    //     String motB = b.getMot();
    //     int sizeA = motA.length();
    //     int sizeB = motB.length();
    //     int sizeMin = 0;

    //     if(sizeA < sizeB)
    //         sizeMin = sizeA;
    //     else 
    //         sizeMin = sizeB;
    //     for(int i=0;i<sizeMin;i++){//On va compter le nombres de caractéres différents
    //         if(motA.charAt(i) != motB.charAt(i))
    //             countError += 1;
    //     } 
    //     countError += Math.abs((sizeA - sizeB));//Il y a |sizeA - sizeB| caractéres non tapés ou tapés en trop 

    //     return countError;
    // }

    public boolean compareMots(Mot a, Mot b){
        return a.getMot().equals(b.getMot());
    }

    public int countUtils(Mot a, int nbCharTyped){//A appeler si le mot tapé est valide
        int size = a.getMot().length();
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
            return (mot == null);
        }
    }

    
}
