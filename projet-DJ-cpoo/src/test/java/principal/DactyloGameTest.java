package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.File;
import java.util.ArrayList;

public class DactyloGameTest {
    
    @Test
    public void testDactyloGameCreation(){
        File f = new File("src/static/mots1.txt");
        ArrayList<Joueur> players = new ArrayList<>();
        players.add(new Joueur("j1"));
        assertThatThrownBy(() -> DactyloFactory.getDactyloGame(-11, null, players)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> DactyloFactory.getDactyloGame(-11, f, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> DactyloFactory.getDactyloGame(-11, new File("mauvais.txt"), players)).isInstanceOf(IllegalArgumentException.class);
        DactyloGame game = DactyloFactory.getDactyloGame(-11, f, players);
        DactyloGame Normalgame = DactyloFactory.getDactyloGame(1, f, players);
        DactyloGame Sologame = DactyloFactory.getDactyloGame(2, f, players);
        DactyloGame Multigame = DactyloFactory.getDactyloGame(3, f, players);
        assertThat(game).isInstanceOf(Normalgame.getClass());
        assertThat(game).isNotInstanceOf(Sologame.getClass());
        assertThat(game).isNotInstanceOf(Multigame.getClass());
        assertThat(Multigame).isNotInstanceOf(Sologame.getClass());
    }

    @Test
    public void testGetters(){
        File f = new File("src/static/mots1.txt");
        ArrayList<Joueur> players = new ArrayList<>();
        players.add(new Joueur("j1"));
        DactyloGame game = DactyloFactory.getDactyloGame(1, f, players);
        assertThat(game.getJoueurs().get(0).getNom()).isEqualTo("j1");
        game.addJoueur(new Joueur("j2"));
        assertThat(game.getJoueurs().get(1).getNom()).isEqualTo("j2");

        assertThat(game.getMax()).isEqualTo(100);
        game.setMax(-5);
        assertThat(game.getMax()).isNotEqualTo(-5);
        game.setMax(0);
        assertThat(game.getMax()).isNotEqualTo(0);
        game.setMax(20);
        assertThat(game.getMax()).isEqualTo(20);
        game.setMax(2000000);
        assertThat(game.getMax()).isEqualTo(20);

        assertThat(game.getTime()).isEqualTo(30);
        game.setEndTime(10);
        assertThat(game.getTime()).isEqualTo(10);
        game.setEndTime(0);
        assertThat(game.getTime()).isNotEqualTo(0);
        game.setEndTime(1000000);
        assertThat(game.getTime()).isEqualTo(10);

        assertThat(game.getText()).isNotNull();
        assertThat(game.getNextWordStr()).isNotNull();
    }

}
