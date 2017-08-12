package strategies.strategieAttaque;

import config.ConfigJeu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pieces.*;

import static org.junit.Assert.*;

public class AttaqueNormaleTest {

    private int xS;
    private int yS;
    private int xCible;
    private int yCible;
    private Piece[][] plateau;
    private AttaqueNormale attaqueNormale ;
    @Before
    public void setUp() throws Exception {
        plateau = new Piece[10][10];
        xS = 2;
        yS= 3;
        xCible= 4;
        yCible = 5;
        attaqueNormale = new AttaqueNormale();
    }

    /**
     * Cas une piece plus forte
     * attaque une autre plus faible
     *
     * @throws Exception exception
     */
    @Test
    public void attaquer() throws Exception {
        plateau[xS][yS] = new Marechal();
        plateau[xCible][yCible] = new Colonel();

       plateau = attaqueNormale.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue( (plateau[xCible][yCible].getForce() == ConfigJeu.MARECHAL_F) &&
                                     (plateau[xS][yS].getForce() ==ConfigJeu.NEUTRE_F)
                         );

    }
    /**
     * Cas une piece
     * attaque une autre ayant la meme
     * force
     *
     * @throws Exception exception
     */
    @Test
    public void attaquer1() throws Exception {
        plateau[xS][yS] = new Espion();
        plateau[xCible][yCible] = new Espion();

        plateau = attaqueNormale.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue( (plateau[xCible][yCible].getForce() == ConfigJeu.NEUTRE_F) &&
                (plateau[xS][yS].getForce() ==ConfigJeu.NEUTRE_F)
        );

    }

    /**
     * Cas une piece
     * attaque une autre piece
     * plus forte
     *
     * @throws Exception exception
     */
    @Test
    public void attaquer2() throws Exception {
        plateau[xS][yS] = new Commandant();
        plateau[xCible][yCible] = new General();

        plateau = attaqueNormale.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue( (plateau[xCible][yCible].getForce() == ConfigJeu.GENERAL_F) &&
                (plateau[xS][yS].getForce() ==ConfigJeu.NEUTRE_F)
        );

    }

}