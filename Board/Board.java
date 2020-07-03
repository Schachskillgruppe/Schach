import java.util.LinkedList;

public class Board {
    private LinkedList<Piece> allPieces;

    public Board() {
        this.allPieces = new LinkedList<>();
    }

    public void addPiece(Piece piece) {
        this.allPieces.add(piece);
    }

    public Piece getPiece(Position position) {
        for (Piece piece : allPieces) {
            if (piece.pos == position) {
                return piece;
            }
        }
        return null;
    }
}
