import java.util.LinkedList;

public abstract class Piece {

    private final Owner owner;
    private Position position;
    private final Board board;
    private final LinkedList<Position> possibleMoves;

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
     * Move a piece to the specified Position
     */
    public void Move(Position pos) {
        this.position = pos;
    }

    /**
     * @param toCheck : has this position to be checked
     * @param position : position for which it is checked if it can be filled
     * @return if there could be another position beyond this one
     */
    public boolean canWalk(boolean toCheck, Position position) {
        if (toCheck) {
            if (this.position.inRange() && this.board.getPiece(position) == null) {
                this.possibleMoves.add(new Position(position));
            } else if (this.position.inRange() && this.board.getPiece(position).owner != this.owner) {
                this.possibleMoves.add(new Position(position));
                return false;
            } else return false;
        }
        return toCheck;
    }

    @Override
    public abstract String toString();

    public Owner getOwner() {
        return owner;
    }

    public Position getPosition() {
        return position;
    }

    public Board getBoard() {
        return board;
    }

    public LinkedList<Position> getPossibleMoves() {
        return possibleMoves;
    }
    public void addPossibleMove(Position position){
        this.possibleMoves.add(position);
    }

    public void clearPossibleMoves(){
        this.possibleMoves.clear();
    }

    enum Owner {
        Black,
        White
    }
}
