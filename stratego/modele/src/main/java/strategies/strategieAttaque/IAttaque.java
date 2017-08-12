package strategies.strategieAttaque;

import pieces.Piece;

public interface IAttaque {
    /**
     *
     * @param xS int
     * @param yS int
     * @param xCible int
     * @param yCible int
     * @param plateau Piece
     *
     * @return Piece[][]
     */
    Piece[][] attaquer(int xS, int yS, int xCible, int yCible, Piece[][] plateau);
}
