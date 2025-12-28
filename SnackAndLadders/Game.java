import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Queue<Player> playersQueue;
    Board board;
    Dice dice;
    GameStatus gameStatus;
    private Player winner;

    Game(Builder builder) {
        board = builder.board;
        dice = builder.dice;
        playersQueue = builder.players;
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void play() {
        if (playersQueue.size() < 2) {
            throw new IllegalStateException("Atleast 2 players required for start the game");
        }

        gameStatus = GameStatus.RUNNING;

        while (gameStatus == GameStatus.RUNNING) {
            Player curPlayer = playersQueue.poll();
            takeTurn(curPlayer);

            if (gameStatus == GameStatus.RUNNING) {
                playersQueue.add(curPlayer);
            }

        }
        System.out.println("Game Finished");
        if (winner != null) {
            System.out.println(winner.getName() + " Won the Game");
        }

    }

    public void takeTurn(Player player) {
        int curPostion = player.getPosition();
        int roll = dice.rollDice();
        int newPosition = curPostion + roll;
        System.out.println(player.getName() + " have got " + roll + " on dice");
        if (newPosition > board.getSize()) {
            int rem_steps = board.getSize() - curPostion;
            System.out.println(player.getName() + " You need " + rem_steps + "to win, Turn skipped");
            return;
        }

        if (newPosition == board.getSize()) {
            winner = player;
            gameStatus = GameStatus.FINISHED;
            return;
        }

        int finalPosition = board.getFinalPosition(newPosition);

        if (finalPosition > newPosition) {
            System.out.println(player.getName() + " You've got ladder");
        } else if (finalPosition < newPosition) {
            System.out.println(player.getName() + " You've got Snake");
        } else {
            System.out.println(player.getName() + " moved from" + curPostion + " to " + finalPosition);
        }

        player.setPosition(finalPosition);
        if (roll == 6) {
            System.out.println(player.getName() + " You've got 6 and get another chance");
            takeTurn(player);
        }
    }

    public static class Builder {
        Board board;
        Queue<Player> players;
        Dice dice;

        public Builder setBoard(int size, List<BoardEntity> boardEntities) {
            this.board = new Board(size, boardEntities);
            return this;

        }

        public Builder setPlayers(List<Player> playersList) {
            players = new LinkedList<>();

            for (Player player : playersList) {
                players.add(player);
            }
            return this;
        }

        public Builder setDice(int maxSize, int minSize) {
            dice = new Dice(minSize, maxSize);
            return this;
        }

        public Game build() {
            if (board == null || players == null || dice == null) {
                throw new IllegalArgumentException("Board, players, dice must be set");
            }
            return new Game(this);
        }

    }

}
