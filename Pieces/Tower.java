public class Tower extends Piece {

    public Tower(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        //sets a few needed temporary variables
        this.clearPossibleMoves();
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Position tmpL = new Position(this.getPosition());
        Position tmpR = new Position(this.getPosition());
        Position tmpU = new Position(this.getPosition());
        Position tmpD = new Position(this.getPosition());

        //checks all 4 directions
        for (int i = 1; i <= 7; i++) {
            tmpL.setxPos(this.getPosition().getxPos() - i);
            tmpR.setxPos(this.getPosition().getxPos() + i);
            tmpU.setyPos(this.getPosition().getyPos() + i);
            tmpD.setyPos(this.getPosition().getyPos() - i);

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
