
public class GameStatus {
    Board board;

    GameStatus(Board board) {
        this.board = board;
    }

    public GameState checkStatus(Player player) {
        // column win check
        for (int i = 0; i < 3; i++) {
            if (board.getCell(0, i).getSymbol() == player.getSymbol() &&
                    board.getCell(1, i).getSymbol() == player.getSymbol() &&
                    board.getCell(2, i).getSymbol() == player.getSymbol()) {
                return player.symbol == Symbol.X ? GameState.XWon : GameState.OWon;
            }
        }

        // row win check
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0).getSymbol() == player.getSymbol() &&
                    board.getCell(i, 1).getSymbol() == player.getSymbol() &&
                    board.getCell(i, 2).getSymbol() == player.getSymbol()) {
                return player.symbol == Symbol.X ? GameState.XWon : GameState.OWon;
            }
        }

        // Diagonal check
        if ((board.getCell(0, 0).getSymbol() == player.getSymbol() &&
                board.getCell(1, 1).getSymbol() == player.getSymbol() &&
                board.getCell(2, 2).getSymbol() == player.getSymbol()) ||
                board.getCell(0, 2).getSymbol() == player.getSymbol() &&
                        board.getCell(1, 1).getSymbol() == player.getSymbol() &&
                        board.getCell(2, 0).getSymbol() == player.getSymbol()) {
            return player.symbol == Symbol.X ? GameState.XWon : GameState.OWon;
        }

        if (board.isFull()) {
            return GameState.Draw;
        }

        return GameState.InProgress;
    }

}
