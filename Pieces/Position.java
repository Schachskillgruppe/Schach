public class Position {
    private int xPos;
    private int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    //copy Constructor
    public Position(Position position) {
        this.xPos = position.getxPos();
        this.yPos = position.getyPos();
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean inRange(){
        return this.xPos >= 0 && this.xPos <= 7 && this.yPos >= 0 && this.yPos <= 7;
    }
}
