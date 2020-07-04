public class King extends Piece{

    public King(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {

    }

    @Override
    public String toString() {
        return "*";
    }
}
