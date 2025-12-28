import java.util.HashMap;
import java.util.List;

public class Board {
    int size;
    HashMap<Integer, Integer> snakesAndLadders;

    Board(int size, List<BoardEntity> boardEntities) {
        this.size = size;
        snakesAndLadders = new HashMap<>();
        for (BoardEntity boardEntity : boardEntities) {
            snakesAndLadders.put(boardEntity.getStart(), boardEntity.getEnd());
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getFinalPosition(int curPostion) {
        return snakesAndLadders.getOrDefault(curPostion, curPostion);
    }
}
