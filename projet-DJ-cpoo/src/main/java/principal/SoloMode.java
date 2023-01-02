package principal;

import java.io.File;
import java.util.ArrayList;

public final class SoloMode extends DactyloGame {
    
    public SoloMode(ArrayList<Joueur> joueurs, File texte){
        super(joueurs, texte, 3);
    }
}
