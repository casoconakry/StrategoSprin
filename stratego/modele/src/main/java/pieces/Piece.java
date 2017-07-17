package pieces;

/**
 * Classe Abstraite re
 */
public abstract class Piece {
    private  int force;

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


