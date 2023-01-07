package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.assertj.core.api.Assertions.assertThat;

public class MotTest {

    @Test
    public void creationDuTexte(){
        assertThatThrownBy(() -> Mot.builder().mot(null).build()).isInstanceOf(IllegalArgumentException.class);        
    }

    public void testMotCreation() {
        
    }

}
