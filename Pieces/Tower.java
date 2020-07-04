public class Tower extends Piece {

    public Tower(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        //sets a few needed temporary variables
        this.possibleMoves.clear();
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Position tmpL = new Position(this.position);
        Position tmpR = new Position(this.position);
        Position tmpU = new Position(this.position);
        Position tmpD = new Position(this.position);

        //checks all 4 directions
        for (int i = 1; i <= 7; i++) {
            tmpL.setxPos(this.position.getxPos() - i);
            tmpR.setxPos(this.position.getxPos() + i);
            tmpU.setyPos(this.position.getyPos() + i);
            tmpD.setyPos(this.position.getyPos() - i);

            left = canWalk(left, tmpL);
            right = canWalk(right, tmpR);
            up = canWalk(up, tmpU);
            down = canWalk(down, tmpD);

            if (!(left || right || up || down)) return;
        }
    }

    @Override
    public String toString() {
        return "T";
    }
}
