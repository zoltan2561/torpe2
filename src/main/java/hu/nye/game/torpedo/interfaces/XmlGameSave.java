package hu.nye.game.torpedo.interfaces;

import hu.nye.game.torpedo.domain.Table;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlGameSave implements GameSave{

    @Override
    public void save(Table tabla, String tablaNev) {

        try {
            JAXBContext context = JAXBContext.newInstance((Table.class));
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            marshaller.marshal(tabla,new File (tablaNev));
        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }

    @Override
    public Table load(String tablaNev) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance((Table.class));
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Table) unmarshaller.unmarshal(new File(tablaNev));

    }
}
