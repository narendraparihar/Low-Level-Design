public class Dice {
    int minVal;
    int maxVal;

    Dice(int minVal, int maxVal) {
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    public int rollDice() {
        return (int) ((Math.random() * (maxVal - minVal + 1)) + minVal);
    }
}
