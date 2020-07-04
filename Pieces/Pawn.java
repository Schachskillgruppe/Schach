public class Pawn extends Piece {

    private final Position startPosition;

    public Pawn(Owner owner, Position position, Board board) {
        super(owner, position, board);
        this.startPosition = position;
    }

    @Override
    public void viewMoves() {
        this.getPossibleMoves().clear();
        Position tmp = new Position(this.getPosition());

        //Piece moves up or down depending if it's Black(down) or White(up)
        int BW = 1;
        if (this.getOwner() == Owner.White) BW = -1;
        //checks the three moves that always might work
        tmp.setyPos(this.getPosition().getyPos() + BW);
        if (tmp.inRange() && this.getBoard().getPiece(tmp) == null) {
            this.getPossibleMoves().add(new Position(tmp));
        }
        tmp.setxPos(this.getPosition().getxPos() - 1);
        if (tmp.inRange() && tmp.getxPos() >= 0 && this.getBoard().getPiece(tmp) != null && getBoard().getPiece(tmp).getOwner() != this.getOwner()) {
            this.addPossibleMove(new Position(tmp));
        }
        tmp.setxPos(this.getPosition().getxPos() + 1);
        if (tmp.inRange() && getBoard().getPiece(tmp) != null && getBoard().getPiece(tmp).getOwner() != this.getOwner()) {
            this.addPossibleMove(new Position(tmp));
        }
        //checks the move that's only possible ass the first one
        tmp.setyPos(this.getPosition().getyPos() + (2 * BW));
        tmp.setxPos(this.getPosition().getxPos());
        if (this.getPosition().equals(this.startPosition) && tmp.inRange() && getBoard().getPiece(tmp) == null) {
            this.addPossibleMove(new Position(tmp));
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}
