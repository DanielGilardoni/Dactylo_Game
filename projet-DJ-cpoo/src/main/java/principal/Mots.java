package principal;

public class Mots {
    private String texte;
    public Mots(String texte) {
        if (texte == null) {
            throw new IllegalArgumentException("Il doit y avoir du texte pour le logiciel!!");
        }
        else {
            this.texte = texte;
        }
    }
}
