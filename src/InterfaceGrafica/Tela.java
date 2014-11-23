/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author pedro_000
 */
public class Tela extends StateBasedGame {

    public static final String gamename = "Trabalho Final: O Jogo";
        
    public static final int menu = 0;
    public static final int inventario = 1;
    public static final int batalha = 2;
    public static final int fase1 = 3;
    public static final int fase2 = 4;
    public static final int fase3 = 5;
    public static final int fase4 = 6;
    public static final int ficha = 7;

    //
    public Tela(String gamename) {
        super(gamename);
            
        this.addState(new Menu(menu));
        this.addState(new Inventario(inventario));
        this.addState(new Batalha(batalha));
        this.addState(new Fase1(fase1));
        this.addState(new Fase2(fase2));
        this.addState(new Fase3(fase3));
        this.addState(new Fase4(fase4));
        this.addState(new Ficha(ficha));

        this.enterState(menu);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {        
        this.getState(inventario).init(container, this);
        this.getState(batalha).init(container, this);
        this.getState(fase1).init(container, this);
        this.getState(fase2).init(container, this);
        this.getState(fase3).init(container, this);
        this.getState(fase4).init(container, this);
        this.getState(menu).init(container, this);
        
        this.enterState(menu);
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        Container c = new Container("Link", "Não-Zelda");
        try {
            appgc = new AppGameContainer(new Tela(gamename));
            appgc.setDisplayMode(1280, 640, false);
            appgc.start();
        } catch (SlickException e) {

        }

    }
}
