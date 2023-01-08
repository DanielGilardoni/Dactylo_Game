package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MotTest {

    @Test
    public void creationDuTexte(){
        assertThatThrownBy(() -> Mot.builder().mot(null).build()).isInstanceOf(IllegalArgumentException.class);        
    }

    @Test
    public void testMotCreation() {
        Mot m1 = Mot.builder().mot("m").build();
        assertThat(m1.getMot()).isEqualTo("m");
        assertThat(m1.getCouleur()).isEqualTo('w');
        Mot m2 = Mot.builder().mot("m2").couleur('g').build();
        assertThat(m2.getCouleur()).isEqualTo('g');
        
    }

    @Test
    public void testMotSetColor(){
        Mot m1 = Mot.builder().mot("m").build();
        m1.setCouleur('r');
        assertThat(m1.getCouleur()).isEqualTo('r');
    }

    @Test
    public void testMotCompareMot(){
        Mot m1 = Mot.builder().mot("mmm").build();
        Mot m2 = Mot.builder().mot("mmm").build();
        Mot m3 = Mot.builder().mot("mmbm").build();
        assertThat(m1.compareMots(m2)).isEqualTo(true);
        assertThat(m1.compareMots(m3)).isEqualTo(false);
    }

    @Test
    public void testMotCountUtils(){
        Mot m1 = Mot.builder().mot("caracteres").build();
        assertThat(m1.countUtils(10)).isEqualTo(10);//Tous les caractéres ont bien été tapés du premier coup
        assertThat(m1.countUtils(12)).isEqualTo(8);//Le joueur s'est tromppé 2 fois
        assertThatThrownBy(() -> m1.countUtils(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> m1.countUtils(8)).isInstanceOf(IllegalArgumentException.class);
    }
}
