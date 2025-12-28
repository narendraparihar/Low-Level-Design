public class Ladders extends BoardEntity {
    int start;
    int end;

    Ladders(int start, int end) {

        super(start, end);
        if (start >= end) {
            throw new IllegalArgumentException("Start should be lesser than end for ladder");
        }

    }
}
