package strategies.strategieAttaque;

import config.ConfigJeu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pieces.*;



public class AttaqueDemineurTest {
    private  int xS;
    private  int yS;
    private  int xCible;
    private  int yCible;
    private Piece[][] plateau;
    private AttaqueDemineur attaqueDemineur;

    @Before
    public void setUp() throws Exception {
        plateau = new Piece[10][10];
        xS = 2;
        yS= 3;
        xCible= 4;
        yCible = 5;
        attaqueDemineur = new AttaqueDemineur();
    }
    /**
     * Cas 1:
     * le demineur   attaque une bombe
     * RA: La bombe est désamorcée
     *
     * @throws Exception testException
     */
    @Test
    public void attaquer() throws Exception {
        plateau[xS][yS] = new Demineur();
        plateau[xCible][yCible] = new Bombe();

        attaqueDemineur.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.DEMINEUR_F &&
                plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
        );
    }
    /**
     * Cas 2:
     * le demineur attaque une piece
     * moins forte qu'elle
     *
     * @throws Exception testException
     */
    @Test
    public void attaquer1() throws Exception {
        plateau[xS][yS] = new Demineur();
        plateau[xCible][yCible] = new Espion();

        attaqueDemineur.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.DEMINEUR_F &&
                plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
        );
    }
    /**
     * Cas 3:
     * le demineur attaque une piece
     * plus  forte qu'elle
     *
     * RA: le démineur est tué
     * @throws Exception testException
     */
    @Test
    public void attaquer2() throws Exception {
        plateau[xS][yS] = new Demineur();
        plateau[xCible][yCible] = new Capitaine();

        attaqueDemineur.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.CAPITAINE_F &&
                plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
        );
    }
    /**
     * Cas 4:
     * le demineur attaque une piece
     *  ayant la meme force qu'elle
     *
     * RA: les deux sont neutralisés
     * @throws Exception testException
     */
    @Test
    public void attaquer3() throws Exception {

        plateau[xS][yS] = new Demineur();
        plateau[xCible][yCible] = new Demineur();

        attaqueDemineur.attaquer(xS,yS,xCible,yCible,plateau);

        Assert.assertTrue(plateau[xCible][yCible].getForce() == ConfigJeu.NEUTRE_F &&
                plateau[xS][yS].getForce() == ConfigJeu.NEUTRE_F
        );
    }

}