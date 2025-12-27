public class Board {
    Cell[][] board;
    int size;
    int moveCount;

    Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        initializeBoard();
        moveCount = 0;
    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int r, int c) {
        return board[r][c];
    }

    public void makeMove(Player player, int row, int col) throws Exception {
        if (row > size || row < 0 || col > size || col < 0) {
            System.out.println("Invalid move: Out of bound");
            throw new Exception("Invalid move: Out of bound");
        }
        if (board[row][col].getSymbol() != Symbol.EMPTY) {
            System.out.println("Invalid move: already added");
            throw new Exception("Invalid move :already added");
        }
        moveCount++;
        board[row][col].setSymbol(player.getSymbol());
    }

    public boolean isFull() {
        return moveCount == size * size;
    }

    public void printBoard() {
        System.out.println("--------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getSymbol() == Symbol.X) {
                    System.out.print("X ");
                } else if (board[i][j].getSymbol() == Symbol.O) {
                    System.out.print("O ");
                } else {
                    System.out.print(". ");
                }
                System.out.print("| ");
            }
            System.out.println();
        }
    }

}
