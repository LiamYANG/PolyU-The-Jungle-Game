package JungleGame.Game;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public abstract class Animal {
    public Animal(String name, int rank, Player owner) {
        this.name = name;
        this.rank = rank;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public Player getOwner() {
        return owner;
    }

    private String name;
    private int rank;
    private Player owner;
}
