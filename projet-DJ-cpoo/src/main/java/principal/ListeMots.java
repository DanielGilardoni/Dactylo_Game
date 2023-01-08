package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
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
        if(liste.size() == 0)
            throw new IllegalArgumentException("Le fichier ne peut pas être vide");
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
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Erreur le fichier est vide.");
        }
    }

    public void remove(){
        if(!liste.isEmpty()){
            liste.removeFirst();
        }
    }
}
