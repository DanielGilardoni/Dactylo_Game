package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.File;

public class ListeMotsTest {

    @Test
    public void testListeMotsPasDeFichier() {
        assertThatThrownBy(() -> new ListeMots(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testListeMotsCreation() {
        File f = new File("projet-DJ-cpoo/src/main/static/mots1.txt");
        ListeMots lm = new ListeMots(f);
        lm.chargerTexte();
        assertThat(lm).isNotNull();
    }

    @Test
    public void testListeMotsRemove() {
        File f = new File("projet-DJ-cpoo/src/main/static/mots1.txt");
        ListeMots lm = new ListeMots(f);
        assertThat(lm.getListe().size()).isEqualTo(0);
        lm.chargerTexte();
        assertThat(lm.getListe().size()).isEqualTo(2);        
        lm.remove();
        assertThat(lm.getListe().size()).isEqualTo(1);        
        lm.remove();
        assertThat(lm.getListe().size()).isEqualTo(0);        
        lm.remove();
        assertThat(lm.getListe().size()).isNotEqualTo(-1);        
    } 
    
}
