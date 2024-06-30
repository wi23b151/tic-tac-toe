import com.technikum.slt.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void testPlayer() {

        Player player = new Player('X');
        Assertions.assertEquals('X', player.getMarker());

        Assertions.assertNotEquals('O', player.getMarker());
    }
}
