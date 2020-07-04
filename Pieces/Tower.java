public class Tower extends Piece {

    public Tower(Owner owner, Position pos, Board board) {
        super(owner, pos, board);
    }

    @Override
    public void viewMoves() {
        //sets a few needed temporary variables
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Position tmpL = new Position(this.pos);
        Position tmpR = new Position(this.pos);
        Position tmpU = new Position(this.pos);
        Position tmpD = new Position(this.pos);

        //checks all 4 directions
        for (int i = 0; i <= 7; i++) {
            tmpL.setxPos(this.pos.getxPos() - i);
            tmpR.setxPos(this.pos.getxPos() + i);
            tmpU.setyPos(this.pos.getyPos() + i);
            tmpD.setyPos(this.pos.getyPos() - i);

            left = canWalk(left, tmpL);
            right = canWalk(right, tmpR);
            up = canWalk(up, tmpU);
            down = canWalk(down, tmpD);

            if(!(left||right||up||down)) return;
        }
    }
}
