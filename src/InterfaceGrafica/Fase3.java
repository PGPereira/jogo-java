/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author pedro_000
 */
public class Fase3 extends BasicGameState {
    private final int spriteSize = 80;
    private final int tileSize = 32;
    
    private TiledMap mapaAtual;
    private final String mapa3 = "images/mapa3.tmx";
    
    private SpriteSheet spriteSheet;
    private Animation link, movingUp, movingDown, movingLeft, movingRight;
    private Sound enterStage;
    
    private int x, y;
    
    Fase3(int play) {
    }

    @Override
    public int getID() {
        return 5;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapaAtual = new TiledMap(mapa3);
        spriteSheet = new SpriteSheet("images/oorjG.png", 90, 90);
        enterStage = new Sound("sound/enterstage.wav");
                
        x = 38;
        y = 1;
        
        Image[] walkLeft = {
            //spriteSheet.getSubImage(0, 0),
            spriteSheet.getSubImage(1, 0),
            spriteSheet.getSubImage(2, 0),
            spriteSheet.getSubImage(3, 0),
            spriteSheet.getSubImage(4, 0),
        };
        
        Image[] walkRight = {
            spriteSheet.getSubImage(0, 1),
            spriteSheet.getSubImage(1, 1),
            spriteSheet.getSubImage(2, 1),
            spriteSheet.getSubImage(3, 1),
            spriteSheet.getSubImage(4, 1),
        };
        
        Image[] walkUp = {
            spriteSheet.getSubImage(0, 2),
            spriteSheet.getSubImage(1, 2),
            spriteSheet.getSubImage(2, 2),
            spriteSheet.getSubImage(3, 2),
            spriteSheet.getSubImage(4, 2),
        };
        
        Image[] walkDown = {
            spriteSheet.getSubImage(0, 3),
            spriteSheet.getSubImage(1, 3),
            spriteSheet.getSubImage(2, 3),
            spriteSheet.getSubImage(3, 3),
            spriteSheet.getSubImage(4, 3),
        };
        
        movingUp = new Animation(walkUp, 250, false);
        movingDown = new Animation(walkDown, 250, false);
        movingLeft = new Animation(walkLeft, 250, false);
        movingRight = new Animation(walkRight, 250, false);
        
        link = movingUp;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        mapaAtual.render(0, 0);
        link.draw(x * tileSize - (spriteSize - tileSize)/2,
                y * tileSize - (spriteSize - tileSize),
                spriteSize,
                spriteSize);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();

        int objectLayer = mapaAtual.getLayerIndex("Objetos");
        int transitionLayer = mapaAtual.getLayerIndex("Transicao");
        mapaAtual.getTileId(0, 0, objectLayer);

        if (input.isKeyPressed(Input.KEY_UP) || input.isKeyPressed(Input.KEY_W)) {
            link = movingUp;
            if (mapaAtual.getTileId(x, y-1, objectLayer) == 0){
                y--;
                link.update(delta);
            }
            this.trocaMapa(mapaAtual, transitionLayer, game);
        }
        
        if (input.isKeyPressed(Input.KEY_DOWN) || input.isKeyPressed(Input.KEY_S)) {
            link = movingDown;
            if (mapaAtual.getTileId(x, y+1, objectLayer) == 0){
                y++;
                link.update(delta);
            }
            this.trocaMapa(mapaAtual, transitionLayer, game);
        }
        
        if (input.isKeyPressed(Input.KEY_LEFT) || input.isKeyPressed(Input.KEY_A)) {
            link = movingLeft;
            if (mapaAtual.getTileId(x-1, y, objectLayer) == 0){
                x--;
                link.update(delta);
            }
            this.trocaMapa(mapaAtual, transitionLayer, game);
        }
        
        if (input.isKeyPressed(Input.KEY_RIGHT) || input.isKeyPressed(Input.KEY_D)) {
            link = movingRight;
            if (mapaAtual.getTileId(x+1, y, objectLayer) == 0){
                x++;
                link.update(delta);
            }
            this.trocaMapa(mapaAtual, transitionLayer, game);
        }
        
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            game.enterState(0);
        }
    }
    
    private void trocaMapa(TiledMap mapaAtual, int transitionLayer, StateBasedGame game)
            throws SlickException{
        if (mapaAtual.getTileId(x, y, transitionLayer) != 0){
            if(x == 38 && y == 1){
                enterStage.play();
                game.enterState(4);
            } else if (x == 7 && y == 19){
                enterStage.play();
                game.enterState(6);
            }
        } 
    }
}
