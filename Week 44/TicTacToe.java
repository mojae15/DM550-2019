/**
 * First implementation: the board is an array of chars ('X', 'O' or EMPTY), and
 * the next player is stored as an attribute for efficiency.
 */
public class TicTacToe {

    private char[] board;
    private char nextPlayer;
    private static final char EMPTY = '-';

    /**
     * Creates an empty board where the next player is 'X'.
     */
    public TicTacToe() {
        board = new char[10];
        for (int i=0; i<10; i++)
            board[i] = EMPTY;
        nextPlayer = 'X';
    }

    /**
     * Checks whether a given cell is free.<br>
     * <b>Precondition:</b> 1&le;cell&le;9.
     * @param cell the number of the cell
     * @return true if the cell is currently unoccupied
     */
    public boolean isFree(int cell) {
        return (board[cell] == EMPTY);
    }

    /**
     * Returns the char for the player who has played in the given cell.<br>
     * <b>Precondition:</b> 1&le;cell&le;9 &amp;&amp; !isFree(cell)
     * @param cell the number of the cell
     * @return the char for the player who has played in cell
     */
    public char value(int cell) {
        return board[cell];
    }

    /**
     * Returns the char of the player whose turn it is.
     * @return the char of the next player
     */
    public char nextPlayer() {
        return nextPlayer;
    }

    /**
     * Checks whether all cells are occupied.
     * @return true if the board has no empty cells
     */
    public boolean isFull() {
        boolean isFull = true;
        int i=1;
        while ((i<10) && isFull)
            if (board[i] == EMPTY)
                isFull = false;
            else
                i++;
        return isFull;
    }

    /**
     * Plays the next move in the given cell.<br>
     * <b>Precondition:</b> 1&le;cell&le;9 &amp;&amp; isFree(cell)
     * @param cell the cell to play in
     */
    public void play(int cell) {
        board[cell] = nextPlayer;
        nextPlayer = (nextPlayer == 'X' ? 'O' : 'X');
    }

    /**
     * Checks whether the player with a given char has won.<br>
     * <b>Precondition:</b> player == 'O' || player == 'X'
     * @param player the char corresponding to a player
     * @return true if player has won
     */
    public boolean hasWon(char player) {
        boolean hasWon = false;
        // rows and columns
        for (int i=0; i<3; i++)
            if ((board[i+1] == player) && (board[i+4] == player) && (board[i+7] == player))
                hasWon = true;
            else if ((board[3*i+1] == player) && (board[3*i+2] == player) && (board[3*i+3] == player))
                hasWon = true;
        if ((board[1] == player) && (board[5] == player) && (board[9] == player))
            hasWon = true;
        else if ((board[3] == player) && (board[5] == player) && (board[7] == player))
            hasWon = true;
        return hasWon;
    }

    /*
     * Auxiliary method for printing a cell.
     */
    private String cellToString(int cell) {
        if (board[cell] == EMPTY)
            return " "+cell+" ";
        else
            return " "+board[cell]+" ";
    }
    
    /**
     * Returns a textual representation of this board.
     * @return a textual representation of this board
     */
    public String toString() {
        String result = "";
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                result = result + cellToString(3*i+j+1);
                if (j<2)
                    result = result + "|";
                else
                    result = result + "\n";
            }
            if (i<2)
                result = result + "---+---+---\n";
        }
        return result;
    }
    
}
