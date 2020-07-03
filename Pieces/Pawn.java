public class Pawn extends Piece {

    Position startPosition;

    public Pawn(Owner owner, Position pos, Board board) {
        super(owner, pos, board);
        this.startPosition = pos;
    }

    @Override
    public void viewMoves() {
        Position tmp = new Position(this.pos.getxPos(), this.pos.getyPos() + 1);
        if (this.board.getPiece(tmp) == null) {
            this.possibleMoves.add(tmp);
        }
        tmp.setxPos(this.pos.getxPos() - 1);
        if (this.board.getPiece(tmp) != null && board.getPiece(tmp).owner != this.owner) {
            this.possibleMoves.add(tmp);
        }
        tmp.setxPos(this.pos.getxPos() + 1);
        if (board.getPiece(tmp) != null && board.getPiece(tmp).owner != this.owner) {
            this.possibleMoves.add(tmp);
        }
        if (this.pos == this.startPosition) {
            tmp.setyPos(this.pos.getyPos() + 2);
            if (board.getPiece(tmp) == null) {
                this.possibleMoves.add(tmp);
            }
        }
    }
}
