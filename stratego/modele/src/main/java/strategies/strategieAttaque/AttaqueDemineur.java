package strategies.strategieAttaque;

import config.ConfigJeu;
import pieces.Piece;
import pieces.PieceNeutre;

public class AttaqueDemineur implements IAttaque {
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
    @Override
    public Piece[][] attaquer(int xS, int yS, int xCible, int yCible, Piece[][] plateau) {
        Piece source = plateau[xS][yS];
        Piece cible  = plateau[xCible][yCible];

        if(cible.getForce() == ConfigJeu.BOMBE_F || source.getForce()> cible.getForce())
        {
            plateau[xCible][yCible] = plateau[xS][yS];
        }
        // Attaque force égale avec la cible
        if(source.getForce() == cible.getForce())
        {
            plateau[xCible][yCible] = new PieceNeutre();
        }
        // Dans tous les cas la source est remplacée par une piece Neutre
        plateau[xS][yS] = new PieceNeutre();

        return  plateau;
    }
}
