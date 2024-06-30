import com.technikum.slt.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Counter;

public class BoardTest {


    Board board ;
    @BeforeEach
    public void setUp() {
        board = new Board();
    }
    @Test
    void testPlaceEmpty() {

        Assertions.assertEquals(Boolean.TRUE, board.isCellEmpty(1,1));
        board.place(1,1,'X');
        Assertions.assertEquals(Boolean.FALSE, board.isCellEmpty(1,1));
    }

    @Test
    void testPlace() {
        Assertions.assertEquals(Boolean.TRUE, board.place(1,1, 'X'));
        Assertions.assertEquals(Boolean.FALSE, board.place(1,1, 'X'));

        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.place(5,5, 'X'));
        Assertions.assertEquals("Index 5 out of bounds for length 3", exception.getMessage());
    }

    @Test
    void testPSize() {

        Assertions.assertTrue(board.getColSize() > 0 && board.getColSize() <= 3, "Size cols nok");
        Assertions.assertTrue(board.getRowSize() > 0 && board.getRowSize() <= 3, "Size row nok");
    }

    @Test
    void testBoardClear() {

        board.place(1,1,'X');
        Assertions.assertEquals(Boolean.FALSE, board.isCellEmpty(1,1));
        board.clear();
        Assertions.assertEquals(Boolean.TRUE, board.isCellEmpty(1,1));

    }


    @Test
    void testBoardFull() {
        Assertions.assertEquals(Boolean.FALSE, board.isFull());

        for (int i = 0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i,j,'X');
            }
        }

        Assertions.assertEquals(Boolean.TRUE, board.isFull());
    }

    @Test
    void testCheckWin() {
        Assertions.assertEquals(Boolean.FALSE, board.isFull());

        for (int i = 0; i< 3; i++) {

                board.place(i,i,'X');
         }

        Assertions.assertEquals(Boolean.TRUE, board.checkWin('X'));
    }
}
