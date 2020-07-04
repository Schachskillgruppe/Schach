public class Position {
    private int xPos;
    private int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    //copy Constructor
    public Position(Position that) {
        this.xPos = that.getxPos();
        this.yPos = that.getyPos();
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

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Position){
            return this.xPos == ((Position) obj).getxPos() && this.yPos == ((Position) obj).getyPos();
        }
        return false;
    }
}