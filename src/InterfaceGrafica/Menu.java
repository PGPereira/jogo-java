/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import SimuladorDeDados.Dice;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author pedro_000
 */
public class Menu extends BasicGameState {
    private final int alturaDaTela = 640;
    
    private int mouseX;
    private int mouseY;
    
    private int musicVolume = 5;
    private int musicNumber;
    
    private Music music;
    private Sound select;
    
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
        container.setUpdateOnlyWhenVisible(true);
        container.setVSync(true);
        container.setSmoothDeltas(true);
        
        container.setClearEachFrame(false);
        //container.setShowFPS(false);
        container.setMusicOn(false);
        container.setForceExit(false);
        
        play = new Image("images/play.png");
        exit = new Image("images/exit.png");
        Background = new Image("images/26-mona-bazooka-banksy.jpg");
        
        musicNumber = Dice.rolagem(22);
        music = new Music("music/" + musicNumber + ".ogg");
        music.setVolume(musicVolume / 100);
        select = new Sound("sound/select.wav");
        music.loop();
        
        //container.setMusicOn(true);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(new Color(0xFF, 0x00, 0x00));
        g.setAntiAlias(true);
        
        Background.draw(0, 0, 0.77f);
        
        g.drawString("Do you like to hurt people?", 100, 50);
        play.draw(100, 100, 50, 50);
        exit.draw(100, 200, 50, 50);
        
        g.drawString("Utilize as setas cima e baixo para controlar o volume da música", 100, 300);
        g.drawString("Volume: " + musicVolume, 100, 350);
        
        g.drawString("Utilize as setas direita e esquerda para trocar de música", 100, 400);
        g.drawString("Música atual: " + musicNumber, 100, 450);
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        mouseX = Mouse.getX();
        mouseY = alturaDaTela - Mouse.getY();
        
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            select.play();
            game.enterState(3);
        }
        
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            select.play();
            System.exit(0);
        }
        
        if (input.isKeyPressed(Input.KEY_UP)) {
            if (musicVolume < 100) {
                float tempo = music.getPosition();
                musicVolume += 5;
                music.play(tempo, (float) (musicVolume / 100));
                music.loop();
            }
        }
        
        if (input.isKeyPressed(Input.KEY_DOWN)) {
            if (musicVolume > 0) {
                float tempo = music.getPosition();
                musicVolume -= 5;
                music.play(tempo, (float) (musicVolume / 100));
                music.loop();
            }
        }
        
        if (input.isKeyPressed(Input.KEY_LEFT)) {
            if (musicNumber == 1) {
                musicNumber = 22;
            } else {
                musicNumber--;
            }
            
            music.stop();
            music = new Music("music/" + musicNumber + ".ogg");
            music.play();
        }
        
        if (input.isKeyPressed(Input.KEY_RIGHT)) {
            if (musicNumber == 22) {
                musicNumber = 1;
            } else {
                musicNumber++;
            }
            
            music.stop();
            music = new Music("music/" + musicNumber + ".ogg");
            music.loop();
        }
        
        if ((mouseX >= 100 && mouseX <= 150) && (mouseY <= 150 && mouseY >= 100)) {
            if (Mouse.isButtonDown(0)) {
                select.play();
                game.enterState(3);
            }
        }
        
        if ((mouseX >= 100 && mouseX <= 150) && (mouseY <= 250 && mouseY >= 200)) {
            if (Mouse.isButtonDown(0)) {
                select.play();
                System.exit(0);
            }
        }
    }
}
