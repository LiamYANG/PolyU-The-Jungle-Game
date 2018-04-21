package JungleGame.Game;

/**
 * Created by Douglas Liu on 5/4/2018.
 */
public class TrapCell extends Cell{
    public TrapCell(Animal animal) {
        super(animal);
    }

    @Override
    public String getType() {
        return "TRAP";
    }
}
