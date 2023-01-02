package principal;

import java.io.File;
import java.util.ArrayList;

public final class MultiPlayerMode extends DactyloGame {
    
    public MultiPlayerMode(ArrayList<Joueur> joueurs, File texte){
        super(joueurs, texte, 2);
    }
}
