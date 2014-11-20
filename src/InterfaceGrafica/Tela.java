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
    public static final int play = 1;
    //
    public Tela(String gamename) {
        super(gamename);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.getState(menu).init(container, this);
        this.getState(play).init(container, this);
        this.enterState(menu);
    }
    
    public static void main(String[] args){
        AppGameContainer appgc; 
        try {
            appgc = new AppGameContainer(new Tela(gamename));
            appgc.setDisplayMode(640, 320, false);
            appgc.start();
        } catch (SlickException e){
        
        }
        
    }
}
