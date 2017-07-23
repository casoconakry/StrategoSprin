package strategies.strategieDep;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EclaireurDepTest {
    private AbDeplacement deplacement;

    @Before
    public void setUp() throws Exception {
        deplacement = new EclaireurDep();
    }

    //Deplacement non autorise de l'eclaireur
    // Bouge sur diaonale superieur gauche
    @Test
    public void autoriser5() throws Exception
    {

        Assert.assertFalse(deplacement.autoriser(7,2,5,0));
    }
    //Deplacement non autorise de l'eclaireur
    // Bouge sur diaonale superieur droite
    @Test
    public void autoriser4() throws Exception
    {

        Assert.assertFalse(deplacement.autoriser(7,2,5,4));
    }

    //Deplacement tout droit vers la haut
    @Test
    public void autoriser() throws Exception {

        Assert.assertTrue(deplacement.autoriser(7,8,3,8));
    }

    //Deplacement tout droit vers le bas
    @Test
    public void autoriser1() throws Exception {

        Assert.assertTrue(deplacement.autoriser(7,8,9,8));
    }

    //Deplacement tout droit vers la droite
    @Test
    public void autoriser2() throws Exception {

        Assert.assertTrue(deplacement.autoriser(0,9,0,3));
    }

    //Deplacement tout droit vers la gauche
    @Test
    public void autoriser3() throws Exception {

        Assert.assertTrue(deplacement.autoriser(6,5,6,8));
    }

}