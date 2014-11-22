/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;
import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author pedro_000
 */
public class Play extends BasicGameState{
    private int alturaDaTela = 640;
    private String mouse = "";
    private TiledMap mapa1;
    
    Play(int play) {
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa1 = new TiledMap("images/mapa1.tmx");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString(mouse, 50, 50);
        mapa1.render(0, 0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        
        int objectLayer = mapa1.getLayerIndex("Objetos");
        mapa1.getTileId(0, 0, objectLayer);
        
        
        keyboardInput(input, game);
    }
    
    public void keyboardInput(Input input, StateBasedGame game){
        if (input.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(0);
        }
    }
    
    private void mouseInput(Input input, StateBasedGame game) {
        int xpos = Mouse.getX();
        int ypos = alturaDaTela - Mouse.getY();
        
        mouse = xpos + ", " + ypos;
    }
}
