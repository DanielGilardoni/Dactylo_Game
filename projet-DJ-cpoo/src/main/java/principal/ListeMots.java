package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ListeMots {
    private File texte;
    private LinkedList<Mot> liste;

    public ListeMots(File texte){
        if (texte == null) {
            throw new IllegalArgumentException("Le fichier ne peut pas être null");
        }
        this.texte = texte;
        liste = new LinkedList<Mot>();
        chargerTexte();
    }

    public LinkedList<Mot> getListe(){
        return this.liste;
    }

    public void chargerTexte() {
        try {
            Scanner sc = new Scanner(texte);
            sc.useDelimiter("\\Z"); //Pour lire le fichier en entier
            String contenu = sc.next();
            sc.close();

            String[] lignes = contenu.split("\n"); //Séparation en lignes

            for (String ligne : lignes) {
                String[] mots = ligne.split(" "); //Séparation des mots pour chaque ligne
                for (String mot : mots) {
                    Mot motNouveau = Mot.builder().mot(mot).build();//new Mot(mot);
                    liste.add(motNouveau);
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Erreur le fichier n'a pas été trouvé.");
        }
    }

    //Si on crée une liste avec les mots tapés, on ajoute à la fin. (Pour comparer facilement avec Liste de depart)
    //Si on veut comparer à la fin, alors il faut garder la liste du texte de depart 
    //quelque part, donc c'est peut-être mieux de comparer au fur et à mesure (on a juste à afficher les 15 premiers
    // et supprimer quand un mot est tapé)

    public void remove(){
        if(!liste.isEmpty()){
            liste.removeFirst();
        }
    }

    public void creerTampon(){
        int compteur = 0;
        Iterator<Mot> it = liste.iterator();
        while (it.hasNext() && compteur < 15) {
            Mot mot = it.next();
            System.out.println(mot.getMot());
            compteur++;
        }
    }
}
