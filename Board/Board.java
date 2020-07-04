import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Scanner;

public class Board {
    private final LinkedList<Piece> allPieces;
    Piece.Owner activePlayer;
    Scanner input;

    public Board() {
        this.allPieces = new LinkedList<>();
        this.activePlayer = Piece.Owner.White;
        this.input = new Scanner(System.in);
    }

    public Board(Board that){
        this.activePlayer = that.activePlayer;
        this.allPieces  = new LinkedList<>(that.allPieces);
        this.input = that.input;
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
                        board.addPiece(new King(Piece.Owner.Black, new Position(x, y), board));
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
                        board.addPiece(new King(Piece.Owner.White, new Position(x, y), board));
                    }
                } else board.addPiece(new Pawn(Piece.Owner.White, new Position(x, y), board));
            }
        }

        //System.out.println(board.getPiece(new Position(1,0)).toString());

        board.printBoard();

        for (; ; ) {
            System.out.println(board.activePlayer + " Select a piece [xPos yPos]");
            boolean first = true;
            Position target;
            Piece piece = null;
            while (true) {
                try {
                    if(first) {
                        target = board.readTarget();
                        piece = board.selectPiece(board.activePlayer, target);
                        first = false;
                    }

                    if (piece == null) {
                        System.out.println("Select a piece again [xPos yPos]");
                        target = board.readTarget();
                        piece = board.selectPiece(board.activePlayer, target);
                        continue;
                    }

                    System.out.println("Select a possible move (marked with 'X') or a different piece of yours [xPos yPos]");
                    target = board.readTarget();
                    if (board.movePiece(piece, new Position(target))) {
                        break;
                    }
                    piece = board.selectPiece(board.activePlayer, target);
                } catch (NumberFormatException nfe) {
                    System.err.println("not a number try again");
                }
            }
            board.nextPlayer();
        }
    }

    private void nextPlayer() {
        if (this.activePlayer == Piece.Owner.White) {
            this.activePlayer = Piece.Owner.Black;
            return;
        }
        this.activePlayer = Piece.Owner.White;
    }

    private @NotNull Position readTarget() throws NumberFormatException {
        String pos = this.input.nextLine();
        String[] XY = pos.split(" ");
        if (XY.length != 2) return new Position(-1, -1);
        int x = Integer.parseInt(XY[0]);
        int y = Integer.parseInt(XY[1]);
        return new Position(x, y);
    }

    private void addPiece(Piece piece) {
        this.allPieces.add(piece);
    }

    public Piece getPiece(Position position) {
        for (Piece piece : allPieces) {
            if (piece.getPosition().equals(position)) {
                return piece;
            }
        }
        return null;
    }

    public void removePiece(Position position) {
        this.allPieces.remove(this.getPiece(position));
    }

    private Piece selectPiece(Piece.Owner owner, Position position) {
        for (Piece piece : this.allPieces) {
            if (piece.getPosition().equals(position) && piece.getOwner() == owner) {
                piece.viewMoves();
                this.printBoard(piece);
                return piece;
            }
        }
        return null;
    }

    private boolean movePiece(@NotNull Piece piece, Position position) {
        if (piece.getPossibleMoves().contains(position)) {
            this.removePiece(position);
            piece.Move(position);
            this.printBoard();
            return true;
        }
        return false;
    }

    private void printBoard() {
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

    private void printBoard(Piece piece) {
        //iterating over the y-Axis
        System.out.println("__|0__1__2__3__4__5__6__7");
        for (int y = 0; y <= 7; y++) {
            //iterating over the x-Axis
            for (int x = -1; x <= 7; x++) {
                if (x == -1) System.out.print(y + " |");
                else if (piece.getPossibleMoves().contains(new Position(x, y))) {
                    System.out.print("X  ");
                } else if (this.getPiece(new Position(x, y)) == null) {
                    System.out.print("0  ");
                } else System.out.print(getPiece(new Position(x, y)).toString().charAt(0) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public LinkedList<Piece> getAllPieces() {
        return allPieces;
    }
}
