package principal;

import java.io.File;
import java.util.ArrayList;

public class DactyloFactory {
    
    public static DactyloGame getDactyloGame(int mode, File texteFile, ArrayList<Joueur> joueurs){
        switch(mode){
            case 1 : return new NormalMode(joueurs, texteFile);//Inutile mais on laisse cette ligne pour clareté
            case 2 : return new SoloMode(joueurs, texteFile);
            case 3 : return new MultiPlayerMode(joueurs, texteFile);
            default : return new NormalMode(joueurs, texteFile);
        }
    }
}
