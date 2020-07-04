import java.util.LinkedList;

public abstract class Piece {

    Owner owner;
    Position position;
    Board board;
    LinkedList<Position> possibleMoves;

    public Piece(Owner owner, Position position, Board board) {
        this.owner = owner;
        this.position = position;
        this.board = board;
        this.possibleMoves = new LinkedList<>();
    }

    /**
     * Fills the List possibleMoves with ll currently possible  Moves of this Piece
     */
    public abstract void viewMoves();

    /**
     * Move a piece to the specified Position and slays the piece add the destination
     */
    public boolean Move(Position pos) {
        board.removePiece(pos);
        if(this.possibleMoves.contains(pos)){
            this.position = pos;
            return true;
        }
        return false;
    }

    /**
     * @param toCheck : has this position to be checked
     * @param position : position for which it is checked if it can be filled
     * @return if there could be another position beyond this one
     */
    public boolean canWalk(boolean toCheck, Position position) {
        if (toCheck) {
            if (position.inRange() && board.getPiece(position) == null) {
                this.possibleMoves.add(new Position(position));
            } else if (position.inRange() && board.getPiece(position).owner != this.owner) {
                this.possibleMoves.add(new Position(position));
                return false;
            } else return false;
        }
        return toCheck;
    }

    @Override
    public abstract String toString();

    enum Owner {
        Black,
        White
    }
}
