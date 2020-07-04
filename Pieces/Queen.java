public class Queen extends Piece {
    public Queen(Owner owner, Position pos, Board board) {
        super(owner, pos, board);
    }

    @Override
    public void viewMoves() {
        //sets a few needed temporary variables
        boolean topleft = true;
        boolean topright = true;
        boolean bottomleft = true;
        boolean bottomright = true;
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;
        Position tmpTL = new Position(this.pos);
        Position tmpTR = new Position(this.pos);
        Position tmpBL = new Position(this.pos);
        Position tmpBR = new Position(this.pos);
        Position tmpL = new Position(this.pos);
        Position tmpR = new Position(this.pos);
        Position tmpU = new Position(this.pos);
        Position tmpD = new Position(this.pos);


        //checks all 8 directions
        for (int i = 0; i <= 7; i++) {
            tmpTL.setxPos(this.pos.getxPos() - i); tmpTL.setyPos(this.pos.getyPos() + i);
            tmpTR.setxPos(this.pos.getxPos() + i); tmpTR.setyPos(this.pos.getyPos() + i);
            tmpBL.setxPos(this.pos.getxPos() - i); tmpBL.setyPos(this.pos.getyPos() - i);
            tmpBR.setxPos(this.pos.getxPos() + i); tmpBR.setyPos(this.pos.getyPos() - i);
            tmpL.setxPos(this.pos.getxPos() - i);
            tmpR.setxPos(this.pos.getxPos() + i);
            tmpU.setyPos(this.pos.getyPos() + i);
            tmpD.setyPos(this.pos.getyPos() - i);

            topleft = canWalk(topleft, tmpTL);
            topright = canWalk(topright, tmpTR);
            bottomleft = canWalk(bottomleft, tmpBL);
            bottomright = canWalk(bottomright, tmpBR);
            left = canWalk(left, tmpL);
            right = canWalk(right, tmpR);
            up = canWalk(up, tmpU);
            down = canWalk(down, tmpD);

            if(!(topleft||topright||bottomleft||bottomright||left||right||up||down)) return;
        }

    }
}
