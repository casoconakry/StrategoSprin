package strategies.strategieDep;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbDeplacementTest {
    private AbDeplacement abDeplacement;
    int xS,yS,xDest,yDest;

    @Before
    public void setUp() throws Exception {
        abDeplacement = new NormalDep();

    }

    /**
     * Deplacement correct differente
     * de la diagonale
     * @throws Exception xception
     */
    @Test
    public void vaSurDiaonale4() throws Exception{
        Assert.assertFalse("oups erreur",appel(4,3,5,3));
    }

    /**
     * Deplacement sur la diag sup gauche
     * @throws Exception xception
     */
    @Test
    public void vaSurDiaonale3() throws Exception{
        Assert.assertTrue("oups erreur",appel(4,3,3,2));
    }

    /**
     * Deplacement sur la diag sup droit
     * @throws Exception xception
     */
    @Test
    public void vaSurDiaonale2() throws Exception{
        Assert.assertTrue("oups erreur",appel(4,3,3,4));
    }

    /**
     * Deplacement sur la diag inf droit
     * @throws Exception xception
     */
    @Test
    public void vaSurDiagonale1() throws Exception {

        Assert.assertTrue("Oups erreur",appel(0,5,1,6));
    }

    /**
     * Deplacement sur la diag inf gauche
     * @throws Exception xception
     */
    @Test
    public void vaSurDiagonale() throws Exception {

        xS=6; yS=7; xDest=7;yDest=6;

        Assert.assertTrue("Oups erreur", appel(xS,yS,xDest,yDest));
    }

    private boolean appel(int xS,int yS,int xDest,int yDest)
    {
       return   abDeplacement.vaSurDiagonale(xS,yS,xDest,yDest);
    }
}