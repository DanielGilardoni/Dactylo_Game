package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JoueurTest {
    
    @Test
    public void testJoueurNegVie() {
        assertThatThrownBy(() -> new Joueur(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Joueur(-2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Joueur(-3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Joueur(-4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Joueur(-100)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void testJoueurCreation() {
        Joueur j1 = new Joueur();
        assertThat(j1.getVies()).isEqualTo(5);
    }

    @Test
    public void testJoueurModifierVie() {
        Joueur j1 = new Joueur(5);
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
}
