package strategies.strategieAttaque;

import pieces.Piece;
import pieces.PieceNeutre;

public class AttaqueNormale implements IAttaque {


    @Override
    public Piece[][] attaquer(int xS, int yS, int xCible, int yCible, Piece[][] plateau) {

        Piece source = plateau[xS][yS];
        Piece cible = plateau[xCible][yCible];

        // Celui qui attaque est plus fort
        if(source.getForce() > cible.getForce())
        {
            // prend la place de la cible
            plateau[xCible][yCible] = plateau[xS][yS];

        }
        // Attaque force égale avec la cible
       if(source.getForce() == cible.getForce())
       {
           plateau[xCible][yCible] = new PieceNeutre();
       }

         plateau[xS][yS] = new PieceNeutre();

        return plateau;
    }
}
