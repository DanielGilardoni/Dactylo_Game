package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.assertj.core.api.Assertions.assertThat;

public class MotTest {

    @Test
    public void creationDuTexte(){
        assertThatThrownBy(() -> new Mot(null)).isInstanceOf(IllegalArgumentException.class);
    }

}
