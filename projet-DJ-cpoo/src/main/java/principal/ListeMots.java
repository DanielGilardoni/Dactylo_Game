package principal;

import java.io.File;
import java.util.LinkedList;

public class ListeMots {
    //private File texte;
    private LinkedList<Mot> liste;

    public ListeMots(File texte){

    }
    //Utiliser getAllLine pour recuperer un tableau de String à partir de texte
    //Puis avec stream et forEach faire split sur chaque ligne sur " " et transformer chaque 
    //String split en Mot.java
    //Utiliser String[] mots = String.split(" "); pour separer le texte en mot
    //for(String s : mots)

    //fct static, ou non
    //void ou renvoie nvlle instance 
    //Patron constructeur ??
    public void add(Mot a){
        liste.add(a);//Ajoute à la fin
    }
    //Si on crée une liste avec les mots tapés, on ajoute à la fin. (Pour comparer facilement avec Liste de depart)
    //Si on veut comparer à la fin, alors il faut garder la liste du texte de depart 
    //quelque part, donc c'est peut-être mieux de comparer au fur et à mesure (on a juste à afficher les 15 premiers
    // et supprimer quand un mot est tapé)

    public void remove(){
        liste.removeFirst();
    }

    public void creerTampon(){}//Est-ce qu'on affiche juste les 15 premiers Mot de liste ou est-ce qu'on crée une autre 
    //liste ou autre structure ?
}
