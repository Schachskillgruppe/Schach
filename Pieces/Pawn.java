public class Pawn extends Piece {

    Position startPosition;

    public Pawn(Owner owner, Position pos, Board board) {
        super(owner, pos, board);
        this.startPosition = pos;
    }

    @Override
    public void viewMoves() {

        Position tmp = new Position(this.pos);

        //Piece moves up or down depending if it's Black(down) or White(up)
        int BW = 1;
        if (this.owner == Owner.White) BW = -1;

        //checks the three moves that might always work
        tmp.setyPos(this.pos.getyPos() + BW);
        if (tmp.inRange() && this.board.getPiece(tmp) == null) {
            this.possibleMoves.add(tmp);
        }
        tmp.setxPos(this.pos.getxPos() - 1);
        if (tmp.inRange() && tmp.getxPos() >= 0 && this.board.getPiece(tmp) != null && board.getPiece(tmp).owner != this.owner) {
            this.possibleMoves.add(tmp);
        }
        tmp.setxPos(this.pos.getxPos() + 1);
        if (tmp.inRange() && board.getPiece(tmp) != null && board.getPiece(tmp).owner != this.owner) {
            this.possibleMoves.add(tmp);
        }

        //checks the move that's only possible ass the first one
        if (tmp.getxPos() >= 0 && this.pos == this.startPosition) {
            tmp.setyPos(this.pos.getyPos() + (2 * BW));
            if (tmp.inRange() && board.getPiece(tmp) == null) {
                this.possibleMoves.add(tmp);
            }
        }
    }
}
