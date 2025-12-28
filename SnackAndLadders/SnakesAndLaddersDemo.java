import java.util.List;

public class SnakesAndLaddersDemo {

    public static void main(String[] args) {
        List<BoardEntity> boardEntities = List.of(
                new Snakes(32, 9), new Snakes(17, 2),
                new Snakes(55, 30), new Snakes(67, 17),
                new Snakes(98, 79), new Snakes(92, 20),
                new Ladders(15, 46), new Ladders(20, 51),
                new Ladders(54, 65), new Ladders(18, 90)

        );
        List<Player> players = List.of(new Player("Alice"), new Player("Bob"), new Player("Charlie"));
        Game game = new Game.Builder()
                .setBoard(100, boardEntities)
                .setDice(1, 6)
                .setPlayers(players)
                .build();

        game.play();
    }
}
