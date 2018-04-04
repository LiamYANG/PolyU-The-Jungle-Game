package JungleGame.Game;

/**
 * Created by Douglas Liu on 4/4/2018.
 */
public class Cell {
    public Cell(Animal animal, CellProperty  property) {
        this.animal = animal;
        this.property = property;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public CellProperty getProperty() {
        return property;
    }

    private Animal animal;
    private CellProperty property;
}

enum CellProperty {
    LAND, DEN, RIVER, TRAP
}
