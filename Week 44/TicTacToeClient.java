import java.util.Scanner;

public class TicTacToeClient {

    private static TicTacToe board;
    private static String nameX, nameO;
    private static Scanner input;

    /*
     * Initialization.
     */
    private static void init() {
        board = new TicTacToe();
        System.out.print("Who is playing X? ");
        nameX = input.nextLine().trim();
        System.out.print("Who is playing O? ");
        nameO = input.nextLine().trim();
    }

    /*
     * Main program.
     */
    public static void main(String[] args) {
        
        input = new Scanner(System.in);
        init();
        boolean goOn = true;
        while (goOn) {
            // play
            System.out.println("It is "+(board.nextPlayer()=='X' ? nameX : nameO)+"'s turn.");
            System.out.println("Current board state:");
            System.out.println(board);
            int cell;
            do {
                System.out.print("Where do you want to play? ");
                cell = input.nextInt();
                if ((cell < 1) || (cell > 9))
                    System.out.println("Invalid cell number.");
                else if (!board.isFree(cell))
                    System.out.println("That cell is not free.");
            } while ((cell < 1) || (cell > 9) || !board.isFree(cell));
            board.play(cell);
            goOn = false;
            if (board.hasWon('X'))
                System.out.println(nameX + " has won.");
            else if (board.hasWon('O'))
                System.out.println(nameO + " has won.");
            else if (board.isFull())
                System.out.println("We have a draw :-(");
            else
                goOn = true;
        }
        input.close();
    }
    
}
