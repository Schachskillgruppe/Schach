import java.util.LinkedList;

public class King extends Piece {

    public King(Owner owner, Position position, Board board) {
        super(owner, position, board);
    }

    @Override
    public void viewMoves() {
        this.clearPossibleMoves();
        LinkedList<Position> toCheck = new LinkedList<>();
        toCheck.add(new Position(this.getPosition().getxPos() - 1, this.getPosition().getyPos() - 1)); //up left
        toCheck.add(new Position(this.getPosition().getxPos() , this.getPosition().getyPos() - 1)); //up
        toCheck.add(new Position(this.getPosition().getxPos() + 1, this.getPosition().getyPos() - 1)); //up right
        toCheck.add(new Position(this.getPosition().getxPos() - 1, this.getPosition().getyPos())); //left
        toCheck.add(new Position(this.getPosition().getxPos() + 1, this.getPosition().getyPos())); //right
        toCheck.add(new Position(this.getPosition().getxPos() - 1, this.getPosition().getyPos() + 1)); //down left
        toCheck.add(new Position(this.getPosition().getxPos(), this.getPosition().getyPos() + 1)); //down
        toCheck.add(new Position(this.getPosition().getxPos() + 1, this.getPosition().getyPos() + 1)); //down right


        for (Position position : toCheck) {
            if (position.inRange() && (this.getBoard().getPiece(position) == null || this.getOwner() != this.getBoard().getPiece(position).getOwner())) {
                boolean safe = true;
                Board tmpBoard = new Board(this.getBoard());
                tmpBoard.removePiece(position);
                for (Piece piece : tmpBoard.getAllPieces()) {
                    if (this.getOwner() != piece.getOwner() && !piece.toString().equals("*")) {
                        piece.viewMoves();
                        if (piece.getPossibleMoves().contains(position)) {
                            safe = false;
                            break;
                        }
                    }
                }
                if (safe) this.addPossibleMove(position);
            }
        }

    }

    @Override
    public String toString() {
        return "*";
    }
}
