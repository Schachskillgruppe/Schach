import java.util.LinkedList;

public class Knight extends Piece {

    public Knight(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        //creates a list of all positions to check
        this.clearPossibleMoves();
        LinkedList<Position> tmpPositions = new LinkedList<>();
        tmpPositions.add(new Position(this.getPosition().getxPos() + 2, this.getPosition().getyPos() + 1)); //two up one right
        tmpPositions.add(new Position(this.getPosition().getxPos() + 2, this.getPosition().getyPos() - 1)); //two up one left
        tmpPositions.add(new Position(this.getPosition().getxPos() - 2, this.getPosition().getyPos() + 1)); //two down one right
        tmpPositions.add(new Position(this.getPosition().getxPos() - 2, this.getPosition().getyPos() - 1)); //two down one left
        tmpPositions.add(new Position(this.getPosition().getxPos() + 1, this.getPosition().getyPos() + 2)); //one up two right
        tmpPositions.add(new Position(this.getPosition().getxPos() + 1, this.getPosition().getyPos() - 2)); //one up two left
        tmpPositions.add(new Position(this.getPosition().getxPos() - 1, this.getPosition().getyPos() + 2)); //one down two right
        tmpPositions.add(new Position(this.getPosition().getxPos() - 1, this.getPosition().getyPos() - 2)); //one down two left

        //checks all of them
        for (Position position : tmpPositions) {
            if (position.inRange() && (getBoard().getPiece(position) == null || getBoard().getPiece(position).getOwner() != this.getOwner())) {
                this.addPossibleMove(position);
            }
        }
    }

    @Override
    public String toString() {
        return "K";
    }
}
