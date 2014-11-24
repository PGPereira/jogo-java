/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import SimuladorDeDados.Dice;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.VerticalSplitTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author pedro_000
 */
public class Fase2 extends BasicGameState {

    private final int spriteSize = 80;
    private final int tileSize = 32;

    private TiledMap mapaAtual;
    private final String mapa2 = "images/mapa2.tmx";

    private SpriteSheet spriteSheet;
    private Animation link, movingUp, movingDown, movingLeft, movingRight;
    private Sound enterStage;
    private Sound enterMenu;

    private int linkX, linkY;

    Fase2(int play) {
    }

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapaAtual = new TiledMap(mapa2);
        spriteSheet = new SpriteSheet("images/oorjG.png", 90, 90);
        enterStage = new Sound("sound/enterstage.wav");
        enterMenu = new Sound("sound/entermenu.wav");

        linkX = 38 * tileSize;
        linkY = 2 * tileSize;

        Image[] walkLeft = {
            spriteSheet.getSubImage(0, 0),
            spriteSheet.getSubImage(1, 0),
            spriteSheet.getSubImage(2, 0),
            spriteSheet.getSubImage(3, 0),
            spriteSheet.getSubImage(4, 0),};

        Image[] walkRight = {
            spriteSheet.getSubImage(0, 1),
            spriteSheet.getSubImage(1, 1),
            spriteSheet.getSubImage(2, 1),
            spriteSheet.getSubImage(3, 1),
            spriteSheet.getSubImage(4, 1),};

        Image[] walkUp = {
            spriteSheet.getSubImage(0, 2),
            spriteSheet.getSubImage(1, 2),
            spriteSheet.getSubImage(2, 2),
            spriteSheet.getSubImage(3, 2),
            spriteSheet.getSubImage(4, 2),};

        Image[] walkDown = {
            spriteSheet.getSubImage(0, 3),
            spriteSheet.getSubImage(1, 3),
            spriteSheet.getSubImage(2, 3),
            spriteSheet.getSubImage(3, 3),
            spriteSheet.getSubImage(4, 3),};

        movingUp = new Animation(walkUp, 150, false);
        movingDown = new Animation(walkDown, 150, false);
        movingLeft = new Animation(walkLeft, 150, false);
        movingRight = new Animation(walkRight, 150, false);

        link = movingUp;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        mapaAtual.render(0, 0);
        link.draw(linkX - (spriteSize - tileSize) / 2,
                linkY - (spriteSize - tileSize),
                spriteSize,
                spriteSize);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();

        int objectLayer = mapaAtual.getLayerIndex("Objetos");
        int transitionLayer = mapaAtual.getLayerIndex("Transicao");
        mapaAtual.getTileId(0, 0, objectLayer);

        if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
            link = movingUp;
            link.update(delta);

            if (mapaAtual.getTileId((int) ((linkX + 24) / 32),
                    (int) ((linkY - delta * 0.5f) / 32),
                    objectLayer) == 0) {
                linkY -= delta * 0.5f;
                this.trocaMapa(mapaAtual, transitionLayer, game);
            }
        }

        if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S)) {
            link = movingDown;
            link.update(delta);

            if (mapaAtual.getTileId(((linkX + 24) / 32),
                    (int) ((linkY + delta * 0.5f + 16) / 32),
                    objectLayer) == 0) {
                linkY += delta * 0.5f;
                this.trocaMapa(mapaAtual, transitionLayer, game);
            }
        }

        if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
            link = movingLeft;
            link.update(delta);

            if (mapaAtual.getTileId((int) ((linkX - delta * 0.5f) / 32),
                    (int) (linkY / 32),
                    objectLayer) == 0) {
                linkX -= delta * 0.5f;
                this.trocaMapa(mapaAtual, transitionLayer, game);
            }
        }

        if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
            link = movingRight;
            link.update(delta);

            if (mapaAtual.getTileId((int) ((linkX + delta * 0.5f + 24) / 32),
                    (linkY / 32),
                    objectLayer) == 0) {
                linkX += delta * 0.5f;
            }
            this.trocaMapa(mapaAtual, transitionLayer, game);
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            enterMenu.play();
            Container.setPontoDeRetorno(this.getID());
            game.enterState(0);
        }

        if (input.isKeyPressed(Input.KEY_C)) {
            enterMenu.play();
            Container.setPontoDeRetorno(this.getID());
            game.enterState(7);
        }

        if (input.isKeyPressed(Input.KEY_I)) {
            enterMenu.play();
            Container.setPontoDeRetorno(this.getID());
            game.enterState(1);
        }
    }

    private void trocaMapa(TiledMap mapaAtual, int transitionLayer, StateBasedGame game)
            throws SlickException {
        if (mapaAtual.getTileId((int) ((linkX) / 32), (int) ((linkY) / 32), transitionLayer) != 0) {
            if (linkX / 32 == 38 && linkY / 32 == 1) {
                enterStage.play();
                game.enterState(3, new FadeOutTransition(Color.gray),
                        new FadeInTransition(Color.white));
            } else if (linkX / 32 == 9 && linkY / 32 == 16) {
                enterStage.play();
                game.enterState(5, new EmptyTransition(),
                        new VerticalSplitTransition());
            } else {
                if (Dice.rolagem(32) == 1) {
                    enterMenu.play();
                    Container.setPontoDeRetorno(this.getID());
                    game.enterState(2);
                }
            }
        }
    }
}
