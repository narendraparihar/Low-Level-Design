import java.util.Scanner;

public class Game {

    Board board;
    Player winner;
    Player currentPlayer;
    Player player1;
    Player player2;
    GameStatus gameStatus;
    Scanner sc = new Scanner(System.in);

    Game(String player1Name, String player2Name) {
        board = new Board(3);
        player1 = new Player(player1Name, Symbol.X);
        player2 = new Player(player2Name, Symbol.O);
        currentPlayer = player1;
        gameStatus = new GameStatus(board);

    }

    public GameState makeMove() {

        System.out.println(currentPlayer.name + " Please enter cell for your move");
        int r = sc.nextInt();
        int c = sc.nextInt();
        GameState currentState = GameState.InProgress;
        try {
            board.makeMove(currentPlayer, r, c);
            currentState = gameStatus.checkStatus(currentPlayer);
            if (currentState != GameState.InProgress) {
                if (currentState == GameState.Draw) {
                    System.out.println("Game Draws");
                } else if (currentState == GameState.OWon) {
                    System.out.println(player2.name + " won this game");
                } else {
                    System.out.println(player1.name + " Won this game");
                }

            }

            board.printBoard();
            toggleChance();
        } catch (Exception e) {
            System.out.println(currentPlayer.name + " Please enter valid move");
        }
        return currentState;

    }

    public void toggleChance() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

}
