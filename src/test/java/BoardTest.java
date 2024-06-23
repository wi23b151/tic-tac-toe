import com.technikum.slt.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {


    @Test
    void testPlaceEmpty() {

        Board board = new Board();

        Assertions.assertEquals(Boolean.TRUE, board.isCellEmpty(1,1));
    }

    @Test
    void testPlace() {

        Board board = new Board();

        Assertions.assertEquals(Boolean.TRUE, board.place(1,1, 'X'));
        Assertions.assertEquals(Boolean.FALSE, board.place(1,1, 'X'));
    }
}
