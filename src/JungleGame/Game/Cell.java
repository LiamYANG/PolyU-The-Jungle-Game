package JungleGame.Game;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public abstract class Cell {
    public Cell(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    void setAnimal(Animal animal) {
        this.animal = animal;
    }

    protected Animal animal;
}
