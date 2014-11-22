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
public class Play extends BasicGameState {

    private int alturaDaTela = 640;
    private String mouse = "";
    private TiledMap mapaAtual;

    private int x, y;

    Play(int play) {
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapaAtual = new TiledMap("images/mapa1.tmx");
        x = 1;
        y = 18;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawString(mouse, 50, 50);
        mapaAtual.render(0, 0);

        g.fillRect(x * 32, y * 32, 32, 32);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();

        int objectLayer = mapaAtual.getLayerIndex("Objetos");
        mapaAtual.getTileId(0, 0, objectLayer);

        if (input.isKeyPressed(Input.KEY_UP) || input.isKeyPressed(Input.KEY_W)) {
            if (mapaAtual.getTileId(x, y-1, objectLayer) == 0){
                y--;
            }
        }
        
        if (input.isKeyPressed(Input.KEY_DOWN) || input.isKeyPressed(Input.KEY_S)) {
            if (mapaAtual.getTileId(x, y+1, objectLayer) == 0){
                y++;
            }
        }
        
        if (input.isKeyPressed(Input.KEY_LEFT) || input.isKeyPressed(Input.KEY_A)) {
            if (mapaAtual.getTileId(x-1, y, objectLayer) == 0){
                x--;
            }
        }
        
        if (input.isKeyPressed(Input.KEY_RIGHT) || input.isKeyPressed(Input.KEY_D)) {
            if (mapaAtual.getTileId(x+1, y, objectLayer) == 0){
                x++;
            }
        }
        
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
        }
    }
}
