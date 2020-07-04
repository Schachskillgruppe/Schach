import java.util.LinkedList;

public class Knight extends Piece {

    public Knight(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        //creates a list of all positions to check
        this.possibleMoves.clear();
        LinkedList<Position> tmpPositions = new LinkedList<>();
        tmpPositions.add(new Position(this.position.getxPos() + 2, this.position.getyPos() + 1)); //two up one right
        tmpPositions.add(new Position(this.position.getxPos() + 2, this.position.getyPos() - 1)); //two up one left
        tmpPositions.add(new Position(this.position.getxPos() - 2, this.position.getyPos() + 1)); //two down one right
        tmpPositions.add(new Position(this.position.getxPos() - 2, this.position.getyPos() - 1)); //two down one left
        tmpPositions.add(new Position(this.position.getxPos() + 1, this.position.getyPos() + 2)); //one up two right
        tmpPositions.add(new Position(this.position.getxPos() + 1, this.position.getyPos() - 2)); //one up two left
        tmpPositions.add(new Position(this.position.getxPos() - 1, this.position.getyPos() + 2)); //one down two right
        tmpPositions.add(new Position(this.position.getxPos() - 1, this.position.getyPos() - 2)); //one down two left

        //checks all of them
        for (Position position : tmpPositions) {
            if (position.inRange() && (board.getPiece(position) == null || board.getPiece(position).owner != this.owner)) {
                this.possibleMoves.add(position);
            }
        }
    }

    @Override
    public String toString() {
        return "K";
    }
}
