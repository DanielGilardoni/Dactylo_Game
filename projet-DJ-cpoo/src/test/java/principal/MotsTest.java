package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.assertj.core.api.Assertions.assertThat;

public class MotsTest {

    @Test
    public void creationDuTexte(){
        assertThatThrownBy(() -> new Mots(null)).isInstanceOf(IllegalArgumentException.class);
    }

}
