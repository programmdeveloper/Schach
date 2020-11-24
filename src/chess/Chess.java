package chess;

public interface Chess {

    /**
     * Pick a symbol
     * @param user user name
     * @param color user asks for this symbol, it can be a race condition
     * @return selected color
     * @throws GameException both symbols are already taken - it is at least the 3rd attempt in a two person game
     * @throws StatusException can only be called if game hasn't started yet
     */
    public ChessColor pick(String user, ChessColor color) throws GameException, StatusException;

    /**
     * set a piece on the board
     * @param color user color
     * @param from start position of the figure
     * @param to where to set the piece on the board
     * @return true if won, false otherwise
     * @throws GameException position outside board - or position not empty
     * @throws StatusException not in status play
     */
    boolean move(ChessColor color, ChessBoardPosition from, ChessBoardPosition to) throws GameException, StatusException;

}
