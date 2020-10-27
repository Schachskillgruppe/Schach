public class Bishop extends Piece {

    public Bishop(Owner owner, Position position, Board board) {
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
        Position tmpTL = new Position(this.getPosition());
        Position tmpTR = new Position(this.getPosition());
        Position tmpBL = new Position(this.getPosition());
        Position tmpBR = new Position(this.getPosition());

        //checks all 4 directions
        for (int i = 1; i <= 7; i++) {
            tmpTL.setxPos(this.getPosition().getxPos() - i);
            tmpTL.setyPos(this.getPosition().getyPos() + i);
            tmpTR.setxPos(this.getPosition().getxPos() + i);
            tmpTR.setyPos(this.getPosition().getyPos() + i);
            tmpBL.setxPos(this.getPosition().getxPos() - i);
            tmpBL.setyPos(this.getPosition().getyPos() - i);
            tmpBR.setxPos(this.getPosition().getxPos() + i);
            tmpBR.setyPos(this.getPosition().getyPos() - i);

            topleft = canWalk(topleft, tmpTL);
            topright = canWalk(topright, tmpTR);
            bottomleft = canWalk(bottomleft, tmpBL);
            bottomright = canWalk(bottomright, tmpBR);

            if (!(topleft || topright || bottomleft || bottomright)) return;
        }
    }

    @Override
    public String toString() {
        return "B";
    }
}
