package strategies.strategieDep;

import exception.DeplacementNonAutoriseException;
import pieces.Piece;

public class EclaireurDep extends AbDeplacement {

    Piece[][] deplacer(int xS, int yS, int xDest, int yDest, Piece[][] plateau) throws DeplacementNonAutoriseException {

        if(vaSurDiagonale(xS,yS,xDest,yDest) || !(autoriser(xS,yS,xDest,yDest))) throw new DeplacementNonAutoriseException();
        Piece temp;

        return  super.permuter(xS,yS,xDest,yDest,plateau);
    }

    boolean autoriser(int xS, int yS, int xDest, int yDest) throws DeplacementNonAutoriseException {

        return(
                 (xS != xDest && yDest == yS ) ||  //change de ligne
                 (yDest != yS && xS == xDest)     // changement de colonne
              );
    }


}
