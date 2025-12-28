public class Snakes extends BoardEntity {
    int start;
    int end;

    Snakes(int start, int end) {
        super(start, end);
        if (start <= end) {
            throw new IllegalArgumentException("Start should be greater than end for snake");
        }
    }

}
