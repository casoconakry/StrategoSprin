package strategies.strategieDep;

import exception.DeplacementNonAutoriseException;
import pieces.Piece;

public class NormalDep extends AbDeplacement {

    Piece[][] deplacer(int xS, int yS, int xDest, int yDest, Piece[][] plateau) throws DeplacementNonAutoriseException {

        if (vaSurDiagonale(xS,yS,xDest,yDest) || !(autoriser(xS,yS,xDest,yDest))) throw new DeplacementNonAutoriseException();

        return permuter(xS,yS,xDest,yDest,plateau);
    }

    boolean autoriser(int xS, int yS, int xDest, int yDest) throws DeplacementNonAutoriseException {

        return (
                (xDest == xS - 1 && yDest == xDest) ||  // haut
                (xDest == xS + 1 && yDest == xDest) || // bas
                (xDest == xS && yDest == yS + 1) || // gauche
                (xDest == xS && yDest == yS - 1)  // droite
               ) ;
    }
}
