package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JoueurTest {
    
    @Test
    public void testJoueurNegVie() {
        assertThatThrownBy(() -> new Joueur(null)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void testJoueurCreation() {
        Joueur j1 = new Joueur("j1");
        assertThat(j1.getVies()).isEqualTo(5);
        assertThat(j1.getNom()).isEqualTo("j1");
    }

    @Test
    public void testJoueurModifierVie() {
        Joueur j1 = new Joueur("j1");
        assertThat(j1.getVies()).isEqualTo(5);
        j1 = j1.perdVie();
        assertThat(j1.getVies()).isEqualTo(4);
        j1 = j1.perdVie();
        assertThat(j1.getVies()).isEqualTo(3);
        j1 = j1.perdVie();
        assertThat(j1.getVies()).isEqualTo(2);
        j1 = j1.perdVie();
        j1 = j1.gagneVie();
        assertThat(j1.getVies()).isEqualTo(2);
        j1 = j1.perdVie();
        assertThat(j1.getVies()).isEqualTo(1);
        j1 = j1.perdVie();
        assertThat(j1.getVies()).isEqualTo(0);
        j1 = j1.perdVie();
        assertThat(j1.getVies()).isNotEqualTo(-1);        
    }

    @Test
    public void testJoueurSetNom() {
        Joueur j1 = new Joueur("j1");
        assertThatThrownBy(() -> j1.setNom(null)).isInstanceOf(IllegalArgumentException.class);
        j1.setNom("j2");
        assertThat(j1.getNom()).isEqualTo("j2");
    }
}
