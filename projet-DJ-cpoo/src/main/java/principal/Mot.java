package principal;

public class Mot {
    private String texte;
    private char couleur = 'w'; //Permet de connaitre la couleur du mot et sa specificité dans le mode jeu
                                //On met w pour white par defaut
    public Mot(String texte) {
        if (texte == null) {
            throw new IllegalArgumentException("Il doit y avoir du texte pour le logiciel!!");
        }
        else {
            this.texte = texte;
        }
    }

    public int compareMots(Mot a, Mot b){
        return 0;
    }

    
}
