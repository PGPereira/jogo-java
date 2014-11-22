/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author pedro_000
 */
public class Menu extends BasicGameState {
    private String mouse = "";
    private final int alturaDaTela = 640;

    private Image play;
    private Image exit;
    private Image Background;

    Menu(int menu) {
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        play = new Image("images/play.png");
        exit = new Image("images/exit.png");
        Background = new Image("images/26-mona-bazooka-banksy.jpg");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Background.draw(0, 0, 0.77f);
        g.drawString("Bem vindo ao Trabalho Final!", 100, 50);
        play.draw(100, 100, 50, 50);
        exit.draw(100, 200, 50, 50);
        g.drawString(mouse, 100, 300);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        this.keyboardInput(input, game);
        this.mouseInput(input, game);
    }

    private void mouseInput(Input input, StateBasedGame game) {
        int xpos = Mouse.getX();
        int ypos = alturaDaTela - Mouse.getY();
        
        //Botão de Jogar
        if ((xpos >= 100 && xpos <= 150) && (ypos >= 100 && ypos <= 150)) {
            if (input.isMouseButtonDown(0)) {
                game.enterState(1);
            }
        }
        
        if ((xpos >= 100 && xpos <= 150) && (ypos >= 200 && ypos <= 250)) {
            if (input.isMouseButtonDown(0)){
                System.exit(0);
            }
        }
        
        //Botão de Sair
        mouse = xpos + ", " + ypos;

    }

    private void keyboardInput(Input input, StateBasedGame game) {
        /*if (input.isKeyPressed(Input.KEY_UP) || input.isKeyPressed(Input.KEY_W)){
         faceY -= 50;
         }
         if (input.isKeyPressed(Input.KEY_DOWN) || input.isKeyPressed(Input.KEY_S)){
         faceY += 50;
         }
         if (input.isKeyPressed(Input.KEY_LEFT) || input.isKeyPressed(Input.KEY_A)){
         faceX -= 50;
         }
         if (input.isKeyPressed(Input.KEY_RIGHT) || input.isKeyPressed(Input.KEY_D)){
         faceX += 50;
         }*/
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            game.enterState(1);
        }
    }
}
