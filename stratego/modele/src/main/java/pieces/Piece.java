package pieces;

import strategies.strategieDep.AbDeplacement;

/**
 * Classe Abstraite re
 */
public abstract class Piece {
    private  int force;
    private AbDeplacement deplacement;

    public Piece(int force) {
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }


}


