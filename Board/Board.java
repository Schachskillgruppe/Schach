import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Scanner;

public class Board {
    private final LinkedList<Piece> allPieces;
    Piece.Owner activePlayer;
    Scanner input;

    public Board() {
        this.allPieces = new LinkedList<>();
        this.input = new Scanner(System.in);
    }

    public static void main(String[] args) {

        Board board = new Board();

        //fills the board with the initial Position of all Pieces
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 1; y++) {
                if (y == 0) {
                    if (x == 0 || x == 7) {
                        board.addPiece(new Tower(Piece.Owner.Black, new Position(x, y), board));
                    } else if (x == 1 || x == 6) {
                        board.addPiece(new Knight(Piece.Owner.Black, new Position(x, y), board));
                    } else if (x == 2 || x == 5) {
                        board.addPiece(new Rook(Piece.Owner.Black, new Position(x, y), board));
                    } else if (x == 3) {
                        board.addPiece(new Queen(Piece.Owner.Black, new Position(x, y), board));
                    } else {
                        board.addPiece(new Tower(Piece.Owner.Black, new Position(x, y), board));
                    }
                } else board.addPiece(new Pawn(Piece.Owner.Black, new Position(x, y), board));
            }
            for (int y = 6; y <= 7; y++) {
                if (y == 7) {
                    if (x == 0 || x == 7) {
                        board.addPiece(new Tower(Piece.Owner.White, new Position(x, y), board));
                    } else if (x == 1 || x == 6) {
                        board.addPiece(new Knight(Piece.Owner.White, new Position(x, y), board));
                    } else if (x == 2 || x == 5) {
                        board.addPiece(new Rook(Piece.Owner.White, new Position(x, y), board));
                    } else if (x == 3) {
                        board.addPiece(new Queen(Piece.Owner.White, new Position(x, y), board));
                    } else {
                        board.addPiece(new Tower(Piece.Owner.White, new Position(x, y), board));
                    }
                } else board.addPiece(new Pawn(Piece.Owner.White, new Position(x, y), board));
            }
        }

        //System.out.println(board.getPiece(new Position(1,0)).toString());

        board.printBoard();
        board.activePlayer = Piece.Owner.White;
        for(;;) {
            System.out.println(board.activePlayer + " Select a piece [xPos] press Enter [yPos]");
            Position target = board.readTarget();

            Piece piece = board.selectPiece(board.activePlayer, target);
            while (piece == null || piece.possibleMoves.isEmpty()) {
                System.out.println("Not a valid target. Try again [xPos] press Enter [yPos]");
                target = board.readTarget();
                piece = board.selectPiece(board.activePlayer, target);
            }

            System.out.println("Select a possible move (marked with 'X') [xPos] press Enter [yPos]");
            target = board.readTarget();
            while (!board.movePiece(piece, new Position(target))) {
                target = board.readTarget();
            }
            board.nextPlayer();
        }
    }

    private void nextPlayer(){
        if(this.activePlayer == Piece.Owner.White){
            this.activePlayer = Piece.Owner.Black;
            return;
        }
        this.activePlayer = Piece.Owner.White;
    }

    private @NotNull Position readTarget() {
        int xPos = this.input.nextInt();
        int yPos = this.input.nextInt();
        return new Position(xPos, yPos);
    }

    public void addPiece(Piece piece) {
        this.allPieces.add(piece);
    }

    public Piece getPiece(Position position) {
        for (Piece piece : allPieces) {
            if (piece.position.equals(position)) {
                return piece;
            }
        }
        return null;
    }

    public void removePiece(Position position) {
        for (int i = 0; i < this.allPieces.size(); i++) {
            if (this.allPieces.get(i).position.equals(position)) {
                this.allPieces.remove(i);
                return;
            }
        }
    }

    public Piece selectPiece(Piece.Owner owner, Position position) {
        for (Piece piece : this.allPieces) {
            if (piece.position.equals(position) && piece.owner == owner) {
                piece.viewMoves();
                this.printBoard(piece);
                return piece;
            }
        }
        return null;
    }

    public boolean movePiece(@NotNull Piece piece, Position position) {
        this.removePiece(position);
        if (piece.Move(position)) {
            this.printBoard();
            return true;
        }
        System.out.println("Not a possible move try again");
        return false;
    }

    public void printBoard() {
        //iterating over the y-Axis
        System.out.println("__|0__1__2__3__4__5__6__7");
        for (int y = 0; y <= 7; y++) {
            //iterating over the x-Axis
            for (int x = -1; x <= 7; x++) {
                if (x == -1) System.out.print(y + "| ");
                else if (this.getPiece(new Position(x, y)) == null) {
                    System.out.print("0  ");
                } else System.out.print(getPiece(new Position(x, y)).toString().charAt(0) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printBoard(Piece piece) {
        //iterating over the y-Axis
        System.out.println("__|0__1__2__3__4__5__6__7");
        for (int y = 0; y <= 7; y++) {
            //iterating over the x-Axis
            for (int x = -1; x <= 7; x++) {
                if (x == -1) System.out.print(y + " |");
                else if (piece.possibleMoves.contains(new Position(x, y))) {
                    System.out.print("X  ");
                } else if (this.getPiece(new Position(x, y)) == null) {
                    System.out.print("0  ");
                } else System.out.print(getPiece(new Position(x, y)).toString().charAt(0) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
