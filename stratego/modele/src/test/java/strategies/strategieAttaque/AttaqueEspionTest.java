package strategies.strategieAttaque;

import config.ConfigJeu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pieces.Capitaine;
import pieces.Espion;
import pieces.Marechal;
import pieces.Piece;



public class AttaqueEspionTest {
    private  int xS;
    private  int yS;
    private  int xCible;
    private  int yCible;
    private Piece[][] plateau;
    private AttaqueEspion attaqueEspion;

    @Before
    public void setUp() throws Exception {
        plateau = new Piece[10][10];
        xS = 2;
        yS= 3;
        xCible= 4;
        yCible = 5;
       attaqueEspion = new AttaqueEspion();
    }

    /**
     * Cas 1:
     * l'espion attaque le marechal
     *
     * @throws Exception testException
     */
    @Test
    public void attaquer() throws Exception {
        plateau[xS][yS] = new Espion();
        plateau[xCible][yCible] = new Marechal();

        attaqueEspion.attaquer(xS,yS,xCible,yCible,plateau);

       Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.ESPION_F &&
                                  plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
                        );
    }
    /**
     * Cas 2:
     * l'espion attaque une piece
     * plus forte qu'elle autre qu'un
     * marechal
     *
     * RA: l'espion est neutralisé
     * @throws Exception testException
     */
    @Test
    public void attaquer1() throws Exception {
        plateau[xS][yS] = new Espion();
        plateau[xCible][yCible] = new Capitaine();

        attaqueEspion.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.CAPITAINE_F &&
                plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
        );
    }

    /**
     * Cas 2:
     * l'espion attaque une piece
     * ayant la meme force
     *
     * RA: les deux sont neutralisées
     *
     * @throws Exception testException
     */
    @Test
    public void attaquer2() throws Exception {
        plateau[xS][yS] = new Espion();
        plateau[xCible][yCible] = new Espion();

        attaqueEspion.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.NEUTRE_F &&
                plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
        );
    }


}