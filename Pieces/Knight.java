import java.util.LinkedList;

public class Knight extends Piece {
    public Knight(Owner owner, Position pos, Board board) {
        super(owner, pos, board);
    }

    @Override
    public void viewMoves() {
        //creates a list of all positions to check
        LinkedList<Position> tmpPositions = new LinkedList<>();
        tmpPositions.add(new Position(this.pos.getxPos() + 2, this.pos.getyPos() + 1));
        tmpPositions.add(new Position(this.pos.getxPos() + 2, this.pos.getyPos() - 1));
        tmpPositions.add(new Position(this.pos.getxPos() - 2, this.pos.getyPos() + 1));
        tmpPositions.add(new Position(this.pos.getxPos() - 2, this.pos.getyPos() - 1));
        tmpPositions.add(new Position(this.pos.getxPos() + 1, this.pos.getyPos() + 2));
        tmpPositions.add(new Position(this.pos.getxPos() + 1, this.pos.getyPos() - 1));
        tmpPositions.add(new Position(this.pos.getxPos() - 1, this.pos.getyPos() + 1));
        tmpPositions.add(new Position(this.pos.getxPos() - 1, this.pos.getyPos() - 1));

        //checks all of them
        for(Position position : tmpPositions){
            if(position.inRange() && (board.getPiece(position) == null || board.getPiece(position).owner != this.owner)){
                this.possibleMoves.add(position);
            }
        }
    }
}
