package hu.nye.game.torpedo.interfaces;

import hu.nye.game.torpedo.domain.Table;
import jakarta.xml.bind.JAXBException;

public interface GameSave {
    void save(Table tabla, String tablaNev);
    Table load(String tablaNev) throws JAXBException;
}
