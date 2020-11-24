package chess;

import org.junit.Assert;
import org.junit.Test;

public class UsageTests {

    private static final String ALICE = "Alice";
    private static final String BOB = "Bob";
    private static final String CLARA = "Clara";

    private Chess getChess(){
        return new ChessImpl();
    }

    @Test
    public void goodPickColor() throws GameException, StatusException {
         Chess chess = this.getChess();
         ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        Assert.assertEquals(ChessColor.WHITE, aliceColor);
    }

    @Test
    public void goodPickColor2() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);
        Assert.assertEquals(ChessColor.WHITE, aliceColor);
        Assert.assertEquals(ChessColor.BLACK, bobColor);
    }

    @Test
    public void goodPickColor3() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.WHITE);
        Assert.assertEquals(ChessColor.WHITE, aliceColor);
        Assert.assertEquals(ChessColor.BLACK, bobColor);
    }

    @Test
    public void goodPickColor4() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor bobColor = chess.pick(BOB, ChessColor.WHITE);
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        Assert.assertEquals(ChessColor.BLACK, aliceColor);
        Assert.assertEquals(ChessColor.WHITE, bobColor);
    }

    @Test
    public void goodPickColor5() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        aliceColor = chess.pick(ALICE, ChessColor.BLACK);
        ChessColor bobColor = chess.pick(BOB, ChessColor.WHITE);
        Assert.assertEquals(ChessColor.BLACK, aliceColor);
        Assert.assertEquals(ChessColor.WHITE, bobColor);
    }

    @Test(expected = GameException.class)
    public void failurePickColor3times() throws GameException, StatusException {
        Chess chess = this.getChess();
        chess.pick(ALICE, ChessColor.WHITE);
        chess.pick(BOB, ChessColor.WHITE);
        chess.pick(CLARA, ChessColor.WHITE);
    }

    @Test
    public void goodMove1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);

        ChessBoardPosition startPosition = new ChessBoardPosition("A", 2);
        ChessBoardPosition targetPosition = new ChessBoardPosition("D", 2);
        Assert.assertFalse(chess.move(aliceColor, startPosition, targetPosition));
    }

    @Test(expected = GameException.class)
    public void badMove1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);

        ChessBoardPosition startPosition = new ChessBoardPosition("A", 2);
        ChessBoardPosition targetPosition = new ChessBoardPosition("I", 2);
        Assert.assertFalse(chess.move(aliceColor, startPosition, targetPosition));
    }

    @Test(expected = GameException.class)
    public void badMove2() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);

        ChessBoardPosition startPosition = new ChessBoardPosition("A", 2);
        ChessBoardPosition targetPosition = new ChessBoardPosition("D", 9);
        Assert.assertFalse(chess.move(aliceColor, startPosition, targetPosition));
    }

    @Test(expected = GameException.class)
    public void badMove3() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);

        ChessBoardPosition startPosition = new ChessBoardPosition("J", 2);
        ChessBoardPosition targetPosition = new ChessBoardPosition("D", 3);
        Assert.assertFalse(chess.move(aliceColor, startPosition, targetPosition));
    }

    @Test(expected = GameException.class)
    public void badMove4() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);

        ChessBoardPosition startPosition = new ChessBoardPosition("A", 10);
        ChessBoardPosition targetPosition = new ChessBoardPosition("D", 2);
        Assert.assertFalse(chess.move(aliceColor, startPosition, targetPosition));
    }

    @Test(expected = StatusException.class)
    public void failureStatus() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessBoardPosition p = new ChessBoardPosition("A",2);
        chess.move(ChessColor.BLACK, p, p);
    }

    @Test(expected = StatusException.class)
    public void failureStatus2() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor aliceColor = chess.pick(ALICE, ChessColor.WHITE);
        ChessColor bobColor = chess.pick(BOB, ChessColor.BLACK);
        ChessBoardPosition p = new ChessBoardPosition("A",2);
        chess.move(aliceColor, p, p);
        ChessColor claraColor = chess.pick(CLARA, ChessColor.WHITE);
    }

}
