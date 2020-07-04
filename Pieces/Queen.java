public class Queen extends Piece {

    public Queen(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        this.clearPossibleMoves();
        //sets a few needed temporary variables
        boolean topleft = true;
        boolean topright = true;
        boolean bottomleft = true;
        boolean bottomright = true;
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Position tmpTL = new Position(this.getPosition());
        Position tmpTR = new Position(this.getPosition());
        Position tmpBL = new Position(this.getPosition());
        Position tmpBR = new Position(this.getPosition());
        Position tmpL = new Position(this.getPosition());
        Position tmpR = new Position(this.getPosition());
        Position tmpU = new Position(this.getPosition());
        Position tmpD = new Position(this.getPosition());

        //checks all 8 directions
        for (int i = 1; i <= 7; i++) {
            tmpTL.setxPos(this.getPosition().getxPos() - i);
            tmpTL.setyPos(this.getPosition().getyPos() + i);
            tmpTR.setxPos(this.getPosition().getxPos() + i);
            tmpTR.setyPos(this.getPosition().getyPos() + i);
            tmpBL.setxPos(this.getPosition().getxPos() - i);
            tmpBL.setyPos(this.getPosition().getyPos() - i);
            tmpBR.setxPos(this.getPosition().getxPos() + i);
            tmpBR.setyPos(this.getPosition().getyPos() - i);
            tmpL.setxPos(this.getPosition().getxPos() - i);
            tmpR.setxPos(this.getPosition().getxPos() + i);
            tmpU.setyPos(this.getPosition().getyPos() + i);
            tmpD.setyPos(this.getPosition().getyPos() - i);

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
