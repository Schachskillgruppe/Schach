public class Rook extends Piece {

    public Rook(Owner owner, Position position, Board board) {
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
        Position tmpTL = new Position(this.position);
        Position tmpTR = new Position(this.position);
        Position tmpBL = new Position(this.position);
        Position tmpBR = new Position(this.position);

        //checks all 4 directions
        for (int i = 1; i <= 7; i++) {
            tmpTL.setxPos(this.position.getxPos() - i);
            tmpTL.setyPos(this.position.getyPos() + i);
            tmpTR.setxPos(this.position.getxPos() + i);
            tmpTR.setyPos(this.position.getyPos() + i);
            tmpBL.setxPos(this.position.getxPos() - i);
            tmpBL.setyPos(this.position.getyPos() - i);
            tmpBR.setxPos(this.position.getxPos() + i);
            tmpBR.setyPos(this.position.getyPos() - i);

            topleft = canWalk(topleft, tmpTL);
            topright = canWalk(topright, tmpTR);
            bottomleft = canWalk(bottomleft, tmpBL);
            bottomright = canWalk(bottomright, tmpBR);

            if (!(topleft || topright || bottomleft || bottomright)) return;
        }
    }

    @Override
    public String toString() {
        return "R";
    }
}
