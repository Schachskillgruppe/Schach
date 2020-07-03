import java.util.LinkedList;

public abstract class Piece {

    Owner owner;
    Position pos;
    Board board;
    LinkedList<Position> possibleMoves;

    public Piece(Owner owner, Position pos, Board board) {
        this.owner = owner;
        this.pos = pos;
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
        if(this.possibleMoves.contains(pos)){
            this.pos = pos;
        }
    }

    enum Owner {
        Black,
        White
    }
}
