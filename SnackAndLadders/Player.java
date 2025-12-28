public class Player {
    String name;
    int position;

    Player(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

}
