package hu.nye.game.torpedo.services;

import hu.nye.game.torpedo.domain.Position;
import hu.nye.game.torpedo.domain.Table;
import hu.nye.game.torpedo.interfaces.XmlGameSave;

import java.io.IOException;
import java.util.Random;

public class NewGame {

    private final UIService us = new UIService();
    private final UserInput ui = new UserInput();
    private final MainService ms;
    
    static final int X = 10;
    static final int Y = 10;
    
    private Table playerTable = new Table(X, Y);
    private Table computerTable = new Table(X, Y);
    private Table ownShot = new Table(10, 10);
    private Table board;
    private Random random = new Random();

    private Position hit;

    private boolean playerHit;
    private boolean computerHit;

    public NewGame(MainService ms) {
        this.ms = ms;
    }
    
    public void setSajatLoves(Table ownShot) {
        this.ownShot = ownShot;
    }

    public void jatekInditas() throws IOException {
        int x1, y1;

        us.tablaKirajzolas(playerTable, computerTable);
        hit = ui.koordinataBe();
        if (hit == null) {
            System.out.println("Save before exit??");
            if (ui.kiLepesValasz() == 'y') {
                new XmlGameSave().save(playerTable, "jatekosTabla.xml");
                new XmlGameSave().save(computerTable, "aiTabla.xml");
            }

        }
        while (hit != null) {

            if (!computerTable.getMezo(hit.getX(), hit.getY()).isSzabad()) {
                ownShot.getMezo(hit.getX(), hit.getY()).setTalalt();
                playerHit = true;
            } else {
                ownShot.getMezo(hit.getX(), hit.getY()).setLovesHelye();
                playerHit = false;
            }
            x1 = random.nextInt(10);
            y1 = random.nextInt(10);
            if (!playerTable.getMezo(x1, y1).isSzabad()) {
                playerTable.getMezo(x1, y1).setTalalt();
                computerHit = true;
            } else {
                playerTable.getMezo(x1, y1).setLovesHelye();
                computerHit = false;
            }
            us.tablaKirajzolas(playerTable, ownShot);

            System.out.print(us.gepTalalat(computerHit));
            System.out.println(us.jatekosTalalat(playerHit));

            hit = ui.koordinataBe();
            System.out.println(hit);
            if (hit == null) {
                System.out.println("Save before exit??");
                if (ui.kiLepesValasz() == 'y') {
                    new XmlGameSave().save(playerTable, "playerTable.xml");
                    new XmlGameSave().save(computerTable, "computerTable.xml");
                    new XmlGameSave().save(ownShot, "ownShot.xml");
                }

            }

        }
    }

    public void setJatekosTabla(Table jatekosTabla) {
        this.playerTable = jatekosTabla;
    }

    public void setAiTabla(Table aiTabla) {
        this.computerTable = aiTabla;
    }
}
