/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Equipamento.*;
import Itens.Inventario;
import Itens.Item;
import Personagem.Personagem;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author pedro_000
 */
public class Inventory extends BasicGameState {

    private Image elmo;
    private Image calcao;
    private Image manoplas;
    private Image peitoral;
    private Image botas;
    private Image teia;

    private Sound select;
    private Image background;

    private Personagem personagem;
    private Inventario inventario;

    private int itemAtualIndex = 0;
    private Item itemAtual;

    private int mouseX = 0;
    private int mouseY = 0;

    private final int tamanhoDaTela = 640;

    private final ArrayList<Ponto> pontos = new ArrayList<>();
    private final int tamanhoItem = 63;

    private final int inicio = 960;
    private final int margemLateral = 30;
    private final int margemEntreItens = 10;

    private final int itemZoom = 290;
    private Image arma;
    private Sound itemSelect;

    Inventory(int invetario) {
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        elmo = new Image("images/Elmo.png");
        calcao = new Image("images/Calcao.png");
        manoplas = new Image("images/Manoplas.png");
        peitoral = new Image("images/Peitoral.png");
        botas = new Image("images/Botas.png");
        arma = new Image("images/Arma.png");
        teia = new Image("images/Web.png");

        select = new Sound("sound/select.wav");
        itemSelect = new Sound("sound/item.wav");

        background = new Image("images/png.png");
        personagem = Container.getPersonagem();

        inventario = personagem.getInventario();

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 4; i++) {
                pontos.add(new Ponto(inicio + i * (tamanhoItem + margemEntreItens),
                        margemLateral + j * (tamanhoItem + margemEntreItens)));
            }
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        background.draw(0, 0, 1280, 640);

        /* Caixas dos itens */
        g.setColor(Color.black);
        g.fillRect(margemLateral, margemLateral, itemZoom, itemZoom);
        for (int i = 0; i < 32; i++) {
            g.fillRect(pontos.get(i).getX(), pontos.get(i).getY(),
                    tamanhoItem, tamanhoItem);
        }

        /* Itens e afins */
        g.setColor(Color.white);
        try {
            g.drawString("Nome: " + itemAtual.getNome(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 1);
            g.drawString("Tipo: " + itemAtual.getTipo(),
                    margemLateral * 10 + itemZoom,
                    margemLateral * 1);

            g.drawString("Peso: " + itemAtual.getPeso() + " Kg",
                    margemLateral * 2 + itemZoom,
                    margemLateral * 2);
            g.drawString("Preço: " + itemAtual.getValorMonetario() + " R$",
                    margemLateral * 10 + itemZoom,
                    margemLateral * 2);

            if ("Arma".equals(itemAtual.getTipo())) {
                arma.draw(margemLateral, margemLateral, itemZoom, itemZoom);
                Arma a = (Arma) itemAtual;
                this.desenhaAtributos(g, a);
            }

            if ("Botas".equals(itemAtual.getTipo())) {
                botas.draw(margemLateral, margemLateral, itemZoom, itemZoom);
                Botas a = (Botas) itemAtual;
                this.desenhaAtributos(g, a);
            }

            if ("Calção".equals(itemAtual.getTipo())) {
                calcao.draw(margemLateral, margemLateral, itemZoom, itemZoom);
                Calcao a = (Calcao) itemAtual;
                this.desenhaAtributos(g, a);
            }

            if ("Elmo".equals(itemAtual.getTipo())) {
                elmo.draw(margemLateral, margemLateral, itemZoom, itemZoom);
                Elmo a = (Elmo) itemAtual;
                this.desenhaAtributos(g, a);
            }

            if ("Manoplas".equals(itemAtual.getTipo())) {
                manoplas.draw(margemLateral, margemLateral, itemZoom, itemZoom);
                Manoplas a = (Manoplas) itemAtual;
                this.desenhaAtributos(g, a);
            }

            if ("Peitoral".equals(itemAtual.getTipo())) {
                peitoral.draw(margemLateral, margemLateral, itemZoom, itemZoom);
                Peitoral a = (Peitoral) itemAtual;
                this.desenhaAtributos(g, a);
            }
        } catch (Exception e) {
            g.drawString("Nome: " + "404 Error Not Found",
                    margemLateral * 2 + itemZoom,
                    margemLateral * 1);
            g.drawString("Tipo: " + "404 Error Not Found",
                    margemLateral * 10 + itemZoom,
                    margemLateral * 1);
            g.drawString("Peso: " + "404 Error Not Found",
                    margemLateral * 2 + itemZoom,
                    margemLateral * 2);
            g.drawString("Preço: " + "404 Error Not Found",
                    margemLateral * 10 + itemZoom,
                    margemLateral * 2);
        }

        g.drawLine(itemZoom + margemLateral * 2, margemLateral * 3,
                inicio - margemLateral, margemLateral * 3);

        for (int i = 0; i < 32; i++) {
            try {
                Item item = inventario.recebeReferenciaItem(i);

                if (null != item.getTipo()) {
                    switch (item.getTipo()) {
                        case "Arma":
                            arma.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                                    tamanhoItem, tamanhoItem);
                            break;
                        case "Botas":
                            botas.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                                    tamanhoItem, tamanhoItem);
                            break;
                        case "Calção":
                            calcao.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                                    tamanhoItem, tamanhoItem);
                            break;
                        case "Elmo":
                            elmo.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                                    tamanhoItem, tamanhoItem);
                            break;
                        case "Manoplas":
                            manoplas.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                                    tamanhoItem, tamanhoItem);
                            break;
                        case "Peitoral":
                            peitoral.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                                    tamanhoItem, tamanhoItem);
                            break;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                teia.draw(pontos.get(i).getX(), pontos.get(i).getY(),
                        tamanhoItem, tamanhoItem);
            }
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();

        personagem = Container.getPersonagem();
        inventario = personagem.getInventario();

        mouseX = Mouse.getX();
        mouseY = tamanhoDaTela - Mouse.getY();

        try {
            itemAtual = inventario.recebeReferenciaItem(itemAtualIndex);
        } catch (Exception e) {
            itemAtual = null;
        }

        if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_I)) {
            select.play();
            game.enterState(Container.getPontoDeRetorno());
        }

        if ((mouseX >= margemLateral * 2 + itemZoom && mouseX <= inicio - margemLateral)
                && (mouseY >= margemLateral * 9 && mouseY <= itemZoom)) {
            if (Mouse.isButtonDown(0)) {
                select.play();
                personagem.equipa(itemAtualIndex);
            }
        }

        for (int i = 0; i < 32; i++) {
            if ((mouseX >= pontos.get(i).getX()
                    && mouseX <= pontos.get(i).getX() + tamanhoItem)
                    && (mouseY >= pontos.get(i).getY()
                    && mouseY <= pontos.get(i).getY() + tamanhoItem)) {
                if (Mouse.isButtonDown(0)) {
                    itemSelect.play();
                    itemAtualIndex = i;
                    break;
                }
            }
        }
    }

    public void desenhaAtributos(Graphics g, Equipamento a) {
        //Arrumar isso aqui:
        if ("Arma".equals(a.getTipo())) {
            g.drawString("Nível: " + a.getNivel(),
                    margemLateral * 15 + itemZoom,
                    margemLateral * 1);

            g.drawString("Ataque Físico: "
                    + a.getAtaqueFisicoMin() + " ~ " + a.getAtaqueFisicoMax(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 4);
            g.drawString("Ataque Mágico: "
                    + a.getAtaqueMagicoMin() + " ~ " + a.getAtaqueMagicoMax(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 5);
        } else {
            g.drawString("Nível: " + a.getNivel(),
                    margemLateral * 15 + itemZoom,
                    margemLateral * 1);

            g.drawString("Defesa Física: " + a.getDefesaFisica(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 4);
            g.drawString("Defesa Mágica: " + a.getDefesaMagica(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 5);
            g.drawString("Esquiva: " + a.getEsquiva(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 6);
            g.drawString("Vida: " + a.getHealthPoints(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 7);
            g.drawString("Mana Points: " + a.getManaPoints(),
                    margemLateral * 2 + itemZoom,
                    margemLateral * 8);
        }

        g.setColor(Color.red);
        g.fillRect(margemLateral * 2 + itemZoom,
                margemLateral * 9,
                inicio - (margemLateral * 3 + itemZoom),
                itemZoom - margemLateral * 9);
        g.setColor(Color.white);
        g.drawString("Equipar", margemLateral * 2 + itemZoom, margemLateral * 9);

        //linha horizontal
        g.drawLine(margemLateral, itemZoom + margemLateral + 1,
                inicio - margemLateral, itemZoom + margemLateral + 1);

        //linha vertical
        g.drawLine(inicio / 2, itemZoom + margemLateral + 1,
                inicio / 2, tamanhoDaTela - margemLateral);

        desenhaAdicionaisComuns(g, a);
        desenhaAdicionaisRaros(g, a);
    }

    private void desenhaAdicionaisComuns(Graphics g, Equipamento a) {
        g.drawString("Adicionais comuns:", margemLateral,
                itemZoom + 2 * margemLateral);

        g.drawString("Iniciativa: ", margemLateral,
                itemZoom + 3 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalIni()), margemLateral * 6,
                itemZoom + 3 * margemLateral);

        g.drawString("Mana: ", margemLateral,
                itemZoom + 4 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalMan()), margemLateral * 6,
                itemZoom + 4 * margemLateral);

        g.drawString("Vida: ", margemLateral,
                itemZoom + 5 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalHP()), margemLateral * 6,
                itemZoom + 5 * margemLateral);

        g.drawString("Ataque Físico: ", margemLateral,
                itemZoom + 6 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalAtkF()), margemLateral * 6,
                itemZoom + 6 * margemLateral);

        g.drawString("Ataque Mágico: ", margemLateral,
                itemZoom + 7 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalAtkM()), margemLateral * 6,
                itemZoom + 7 * margemLateral);

        g.drawString("Defesa Física: ", margemLateral,
                itemZoom + 8 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalDF()), margemLateral * 6,
                itemZoom + 8 * margemLateral);

        g.drawString("Defesa Mágica: ", margemLateral,
                itemZoom + 9 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalDF()), margemLateral * 6,
                itemZoom + 9 * margemLateral);

        g.drawString("Esquiva: ", margemLateral,
                itemZoom + 10 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalEsq()), margemLateral * 6,
                itemZoom + 10 * margemLateral);
    }

    private void desenhaAdicionaisRaros(Graphics g, Equipamento a) {
        g.drawString("Adicionais Raros:", inicio / 2 + margemLateral,
                itemZoom + 2 * margemLateral);

        g.drawString("Força: ", inicio / 2 + margemLateral,
                itemZoom + 3 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalStr()),
                inicio / 2 + margemLateral * 6,
                itemZoom + 3 * margemLateral);

        g.drawString("Inteligência: ", inicio / 2 + margemLateral,
                itemZoom + 4 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalInt()),
                inicio / 2 + margemLateral * 6,
                itemZoom + 4 * margemLateral);

        g.drawString("Destreza: ", inicio / 2 + margemLateral,
                itemZoom + 5 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalStr()),
                inicio / 2 + margemLateral * 6,
                itemZoom + 5 * margemLateral);

        g.drawString("Constituição: ", inicio / 2 + margemLateral,
                itemZoom + 6 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalStr()),
                inicio / 2 + margemLateral * 6,
                itemZoom + 6 * margemLateral);

        g.drawString("Experiência: ", inicio / 2 + margemLateral,
                itemZoom + 7 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalXP()) + "%",
                inicio / 2 + margemLateral * 6,
                itemZoom + 7 * margemLateral);

        g.drawString("Crítico: ", inicio / 2 + margemLateral,
                itemZoom + 8 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalCrit()) + "%",
                inicio / 2 + margemLateral * 6,
                itemZoom + 8 * margemLateral);

        g.drawString("Dano Critico: ", inicio / 2 + margemLateral,
                itemZoom + 9 * margemLateral);
        g.drawString(Integer.toString(a.getAdicionalCrDmg()) + "%",
                inicio / 2 + margemLateral * 6,
                itemZoom + 9 * margemLateral);
    }
}
