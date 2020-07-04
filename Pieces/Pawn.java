public class Pawn extends Piece {

    Position startPosition;

    public Pawn(Owner owner, Position position, Board board) {
        super(owner, position, board);
        this.startPosition = position;
    }

    @Override
    public void viewMoves() {
        this.possibleMoves.clear();
        Position tmp = new Position(this.position);

        //Piece moves up or down depending if it's Black(down) or White(up)
        int BW = 1;
        if (this.owner == Owner.White) BW = -1;
        //checks the three moves that always might work
        tmp.setyPos(this.position.getyPos() + BW);
        if (tmp.inRange() && this.board.getPiece(tmp) == null) {
            this.possibleMoves.add(new Position(tmp));
        }
        tmp.setxPos(this.position.getxPos() - 1);
        if (tmp.inRange() && tmp.getxPos() >= 0 && this.board.getPiece(tmp) != null && board.getPiece(tmp).owner != this.owner) {
            this.possibleMoves.add(new Position(tmp));
        }
        tmp.setxPos(this.position.getxPos() + 1);
        if (tmp.inRange() && board.getPiece(tmp) != null && board.getPiece(tmp).owner != this.owner) {
            this.possibleMoves.add(new Position(tmp));
        }
        //checks the move that's only possible ass the first one
        tmp.setyPos(this.position.getyPos() + (2 * BW));
        tmp.setxPos(this.position.getxPos());
        if (this.position.equals(this.startPosition) && tmp.inRange() && board.getPiece(tmp) == null) {
            this.possibleMoves.add(new Position(tmp));
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}
