package hu.nye.game.torpedo.controllers;


import hu.nye.game.torpedo.domain.Table;
import hu.nye.game.torpedo.interfaces.XmlGameSave;
import jakarta.xml.bind.JAXBException;
import hu.nye.game.torpedo.services.MainService;
import hu.nye.game.torpedo.services.NewGame;

import java.io.IOException;
import java.util.Scanner;


public class MainController {
    private MainService ms = new MainService();


    private NewGame ujJatek;
    static final int x = 10;
    static final int y = 10;


    static private Table jatekosTabla = new Table(x,y);
    static private Table aiTabla = new Table(x,y);
    static private Table sajatLoves = new Table(x,y);

    public MainController() throws IOException, JAXBException {

        System.out.println("Resume game??(y/n)");
        Scanner sc=new Scanner(System.in);
        char c = (char) System.in.read();
        System.in.read();
        if (c=='n') {
            jatekosTabla =ms.getTabla();
            aiTabla = ms.getTabla();
            }
            else{
            if (c=='y'){
                jatekosTabla =new XmlGameSave().load("playerTable.xml");
                aiTabla = new XmlGameSave().load("computerTable.xml");
                sajatLoves = new XmlGameSave().load("ownShot.xml");
            }
        }
        ujJatek = new NewGame(ms);
        ujJatek.setAiTabla(aiTabla);
        ujJatek.setSajatLoves(sajatLoves);
        ujJatek.setJatekosTabla(jatekosTabla);
        ujJatek.jatekInditas();
    }


}
