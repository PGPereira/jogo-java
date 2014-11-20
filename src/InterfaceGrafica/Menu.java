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
public class Menu extends BasicGameState{
    private static int algumnumero = 0;
    
    // tira esses trow 
    Menu(int menu) {
    }

    @Override
    public int getID() {
        return algumnumero;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }
    
}
