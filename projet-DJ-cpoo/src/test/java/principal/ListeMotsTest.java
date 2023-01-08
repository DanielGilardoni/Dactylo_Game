package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.File;

public class ListeMotsTest {

    @Test
    public void testListeMotsPasDeFichier() {
        assertThatThrownBy(() -> new ListeMots(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ListeMots(new File("mauvaise/reference.txt"))).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new ListeMots(new File("src/static/vide.txt"))).isInstanceOf(IllegalArgumentException.class);//Si il n'y a pas de texte dans le fichier
    }

    @Test
    public void testListeMotsCreation() {
        File f = new File("src/static/mots1.txt");
        ListeMots lm = new ListeMots(f);
        assertThat(lm).isNotNull();
    }

    @Test
    public void testListeMotsRemove() {
        File f = new File("src/static/mots1.txt");
        ListeMots lm = new ListeMots(f);
        assertThat(lm.getListe().size()).isNotEqualTo(0);
        assertThat(lm.getListe().size()).isEqualTo(2);        
        lm.remove();
        assertThat(lm.getListe().size()).isEqualTo(1);        
        lm.remove();
        assertThat(lm.getListe().size()).isEqualTo(0);        
        lm.remove();
        assertThat(lm.getListe().size()).isNotEqualTo(-1);        
    } 
    
}
