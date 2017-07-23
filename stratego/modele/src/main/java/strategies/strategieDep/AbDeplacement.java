package strategies.strategieDep;

import exception.DeplacementNonAutoriseException;
import pieces.Piece;

public abstract class AbDeplacement {

    /**
     *
     * @param xS int
     * @param yS int
     * @param xDest int
     * @param yDest int
     * @param plateau Piece[][]
     *
     * @return Piece[][]
     * @throws exception.DeplacementNonAutoriseException dep
     */

   abstract Piece[][] deplacer(int xS, int yS, int xDest, int yDest, Piece[][] plateau) throws DeplacementNonAutoriseException;

    /**
     * Indique si le deplacement est autorise
     *
     * @param xS int
     * @param yS int
     * @param xDest int
     * @param yDest int
     * @return boolen Boolean
     * @throws DeplacementNonAutoriseException
     */
   abstract boolean autoriser(int xS,int yS,int xDest,int yDest) throws DeplacementNonAutoriseException;

    /**
     * Effectue la permutation
     *
     * @param xS int
     * @param yS int
     * @param xDest int
     * @param yDest int
     * @param plateau Piece[][]
     * @return Piece[][] plateau
     */
   Piece[][] permuter(int xS,int yS,int xDest,int yDest,Piece[][] plateau )
   {
       Piece tmp ;
       tmp = plateau[xS][yS];
       plateau[xS][yS] = plateau[xDest][yDest];
       plateau[xDest][yDest] = tmp;

       return plateau;
   }

    /**
     * Indique si le deplacement
     * est entrain de s'effectuer sur la diagonale
     *
     * @param xS      int
     * @param yS      int
     * @param xDest   int
     * @param yDest   int
     * @return bool   Boolean
     */
    boolean vaSurDiagonale(int xS, int yS, int xDest, int yDest ) {

      return (
               (xDest == xS - 1  && yDest== yS-1) || // Diagonale sup gauche
               (xDest == xS - 1  && yDest== yS+1) || // Diagonale sup droit
               (xDest == xS + 1  && yDest== yS-1) || // Diagonale inf  gauche
               (xDest == xS + 1  && yDest== yS+1)    // Diagonale inf droit
            );
    }

}
