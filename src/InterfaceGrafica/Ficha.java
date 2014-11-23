/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Personagem.Personagem;
import java.text.DecimalFormat;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author pedro_000
 */
public class Ficha extends BasicGameState{
    Ficha(int ficha) {}
    private Image foto;
    
    private Image elmo;
    private Image calcao;
    private Image manoplas;
    private Image peitoral;
    private Image botas;
    private Image teia;
    
    
    private int equipSize;
    private Image background;
    private Personagem personagem;

    @Override
    public int getID() {
        return 7;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        equipSize = 220;
        foto = new Image("images/linkPixel.png");
        elmo = new Image("images/Elmo.png");
        calcao = new Image("images/Calcao.png");
        manoplas = new Image("images/Manoplas.png");
        peitoral = new Image("images/Peitoral.png");
        botas = new Image("images/Botas.png");
        teia = new Image("images/Web.png");
        
        background = new Image("images/png.png");
        personagem = Container.getPersonagem();
        personagem.adicionaComida(0);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        DecimalFormat fmt = new DecimalFormat("+#,##0;-#");
        DecimalFormat df = new DecimalFormat("#.##");
        g.setColor(Color.white);
        
        background.draw(0, 0, 1280, 640);
        g.fillRect(30, 30, 300, 300);
        foto.draw(30, 30, 300, 300);
        g.drawString("Nome: " + personagem.getNome(), 360, 30);
        g.drawString("Classe: " + personagem.getClasse(), 600, 30);
        
        
        g.drawString("Nível: " + personagem.getNivel(), 360, 60);
        g.drawString("Experiência: " + personagem.getXpAtual() + " / " + personagem.getNextLevelXP(), 600, 60);
        
        g.drawString("Moedas: " + personagem.getMoedasNoInventario(), 360, 90);
        g.drawString("Provisões: " + personagem.getQuantidadeProvisoes(), 600, 90);
        g.drawString("Peso: " + personagem.getPesoDoInventario() +" Kg", 840, 90);
        
        g.drawLine(360, 120, 1250, 120);
        
        g.drawString("Status:", 360, 150);
        g.drawString("Força:", 360, 180);
        g.drawString(Integer.toString(personagem.getStrenght()), 500, 180);
        g.drawString("Modificador: ", 600, 180);
        g.drawString(Integer.toString(personagem.getStrenghtModifier()), 780, 180);
        
        g.drawString("Inteligência:", 360, 210);
        g.drawString(Integer.toString(personagem.getIntelligence()), 500, 210);
        g.drawString("Modificador: ", 600, 210);
        g.drawString(Integer.toString(personagem.getIntelligenceModifier()), 780, 210);
        
        g.drawString("Destreza:", 360, 240);
        g.drawString(Integer.toString(personagem.getDexterity()), 500, 240);
        g.drawString("Modificador: ", 600, 240);
        g.drawString(Integer.toString(personagem.getDexterityModifier()), 780, 240);
        
        g.drawString("Constituição:", 360, 270);
        g.drawString(Integer.toString(personagem.getConstitution()), 500, 270);
        g.drawString("Modificador: ", 600, 270);
        g.drawString(Integer.toString(personagem.getConstitutionModifier()), 780, 270);
        
        g.drawLine(360, 330, 1250, 330);
        
        g.drawString("Calcao", 30, 360);
        g.drawString("Elmo", 280, 360);
        g.drawString("Manoplas", 530, 360);
        g.drawString("Peitoral", 780, 360);
        g.drawString("Botas", 1030, 360);
        
        g.fillRect(30, 390, equipSize, equipSize);
        g.fillRect(280, 390, equipSize, equipSize);
        g.fillRect(530, 390, equipSize, equipSize);
        g.fillRect(780, 390, equipSize, equipSize);
        g.fillRect(1030, 390, equipSize, equipSize);
        
        if (personagem.getCalcao() == null){
            teia.draw(30, 390, equipSize, equipSize);
        } else {
            calcao.draw(30, 390, equipSize, equipSize);
        }
        
        if (personagem.getElmo() == null){
            teia.draw(280, 390, equipSize, equipSize);
        } else {
            elmo.draw(280, 390, equipSize, equipSize);
        }
        
        if (personagem.getManoplas() == null){
            teia.draw(530, 390, equipSize, equipSize);
        } else {
            manoplas.draw(530, 390, equipSize, equipSize);
        }
        
        if (personagem.getPeitoral()== null){
            teia.draw(780, 390, equipSize, equipSize);
        } else {
            peitoral.draw(30, 390, equipSize, equipSize);
        }
        
        if (personagem.getBotas() == null){
            teia.draw(1030, 390, equipSize, equipSize);
        } else {
            peitoral.draw(1030, 390, equipSize, equipSize);
        }
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }
}
