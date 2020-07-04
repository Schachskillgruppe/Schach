public class Queen extends Piece {

    public Queen(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        this.possibleMoves.clear();
        //sets a few needed temporary variables
        boolean topleft = true;
        boolean topright = true;
        boolean bottomleft = true;
        boolean bottomright = true;
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Position tmpTL = new Position(this.position);
        Position tmpTR = new Position(this.position);
        Position tmpBL = new Position(this.position);
        Position tmpBR = new Position(this.position);
        Position tmpL = new Position(this.position);
        Position tmpR = new Position(this.position);
        Position tmpU = new Position(this.position);
        Position tmpD = new Position(this.position);

        //checks all 8 directions
        for (int i = 1; i <= 7; i++) {
            tmpTL.setxPos(this.position.getxPos() - i);
            tmpTL.setyPos(this.position.getyPos() + i);
            tmpTR.setxPos(this.position.getxPos() + i);
            tmpTR.setyPos(this.position.getyPos() + i);
            tmpBL.setxPos(this.position.getxPos() - i);
            tmpBL.setyPos(this.position.getyPos() - i);
            tmpBR.setxPos(this.position.getxPos() + i);
            tmpBR.setyPos(this.position.getyPos() - i);
            tmpL.setxPos(this.position.getxPos() - i);
            tmpR.setxPos(this.position.getxPos() + i);
            tmpU.setyPos(this.position.getyPos() + i);
            tmpD.setyPos(this.position.getyPos() - i);

            topleft = canWalk(topleft, tmpTL);
            topright = canWalk(topright, tmpTR);
            bottomleft = canWalk(bottomleft, tmpBL);
            bottomright = canWalk(bottomright, tmpBR);
            left = canWalk(left, tmpL);
            right = canWalk(right, tmpR);
            up = canWalk(up, tmpU);
            down = canWalk(down, tmpD);

            if (!(topleft || topright || bottomleft || bottomright || left || right || up || down)) return;
        }
    }

    @Override
    public String toString() {
        return "Q";
    }
}
