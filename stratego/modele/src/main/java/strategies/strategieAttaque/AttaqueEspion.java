package strategies.strategieAttaque;

import config.ConfigJeu;
import pieces.Piece;
import pieces.PieceNeutre;
//TODO refactorer cette classe ,utiliser un décorateur les attaques de l'espion et de l'eclaireur

public class AttaqueEspion implements IAttaque {

    @Override
    public Piece[][] attaquer(int xS, int yS, int xCible, int yCible, Piece[][] plateau) {
         Piece source = plateau[xS][yS];
         Piece cible  = plateau[xCible][yCible];

         // Espion attaque le marechal et gagne donc
         if( (cible.getForce() == ConfigJeu.MARECHAL_F) ||( source.getForce() > cible.getForce()) )
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

         return plateau;
    }
}
