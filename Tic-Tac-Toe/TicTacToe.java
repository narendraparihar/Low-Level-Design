import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Player Name");
        String p1name = sc.nextLine();
        System.out.println("Enter Second Player Name");
        String p2name = sc.nextLine();

        Game game = new Game(p1name, p2name);
        GameState curGameState = GameState.InProgress;
        while (curGameState == GameState.InProgress) {
            curGameState = game.makeMove();
        }

    }
}
