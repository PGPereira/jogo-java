/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import SimuladorDeDados.Dice;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author pedro_000
 */
public class Batalha extends BasicGameState {

    private static boolean novo;
    private int mobs;

    public static void novaBatalha() {
        novo = true;
    }

    private Image wagon;
    private Image creep;
    private Image sky;
    private Image valparaiso;
    private Image link;

    private int valparaisoLenght;
    private int valparaisoX;
    private int valparaisoY;
    private int containerLenght;
    private int linkHeight;
    private int containerHeight;
    private int wagonHeight;
    private int wagonLenght;
    private int linkX;
    private int valparaiso2x;

    Batalha(int batalha) {
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        novo = true;
        mobs = Dice.rolagem(3);

        containerLenght = 1280;
        containerHeight = 640;

        wagonLenght = 417;
        wagonHeight = 125;

        linkHeight = 150;
        linkX = 50;

        valparaisoY = 400;
        valparaisoX = 0;
        valparaiso2x = 500;
        valparaisoLenght = 2048;

        link = new Image("images/link.png");
        wagon = new Image("images/wagon.png");
        creep = new Image("images/mob.png");
        sky = new Image("images/sky.png");
        valparaiso = new Image("images/valparaiso.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.black);
        sky.draw(0, 0, 2.89f);

        valparaiso.draw(valparaiso2x, valparaisoY, Color.darkGray);
        if (valparaiso2x + valparaisoLenght <= containerLenght) {
            valparaiso.draw(valparaiso2x + valparaisoLenght, valparaisoY);
        }

        valparaiso.draw(valparaisoX, valparaisoY);
        if (valparaisoX + valparaisoLenght <= containerLenght) {
            valparaiso.draw(valparaisoX + valparaisoLenght, valparaisoY);
        }

        for (int i = 0; i < 4; i++) {
            wagon.draw(i * wagonLenght, containerHeight - wagonHeight);
        }

        link.draw(linkX, containerHeight - (wagonHeight + linkHeight - 10), linkHeight, linkHeight);
        g.drawRect(linkX, containerHeight - (wagonHeight + linkHeight + 30),
                linkHeight, 20);

        for (int i = 0; i < mobs; i++) {
            creep.draw(containerLenght - linkHeight * (i + 1) - linkX * (i + 1),
                    containerHeight - (wagonHeight + linkHeight - 10),
                    linkHeight, linkHeight);
            g.drawRect(containerLenght - linkHeight * (i + 1) - linkX * (i + 1),
                    containerHeight - (wagonHeight + linkHeight + 30),
                    linkHeight, 20);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        valparaiso2x -= delta / 3;
        valparaisoX -= delta / 4;
        if (valparaisoX <= -valparaisoLenght) {
            valparaisoX += valparaisoLenght;
        }
        if (valparaiso2x <= -valparaisoLenght) {
            valparaiso2x += valparaisoLenght;
        }

        if (!novo) {
            mobs = Dice.rolagem(3);
            Batalha.novo = true;
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            Batalha.novo = false;
            Container.getPersonagem().GanhaXP(delta 
                    * Container.getPersonagem().getNivel() 
                    * Container.getPontoDeRetorno());
            game.enterState(Container.getPontoDeRetorno());
        }
    }
}
