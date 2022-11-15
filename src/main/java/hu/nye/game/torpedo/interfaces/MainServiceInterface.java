package hu.nye.game.torpedo.interfaces;


import hu.nye.game.torpedo.domain.Position;
import hu.nye.game.torpedo.domain.Table;

public interface MainServiceInterface {
    void hajoLerakas(Table tabla, Position poz, int hossz, boolean orinet);
    Table getTabla();
    boolean intToBool(int i);
}
