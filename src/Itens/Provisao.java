/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itens;

import Itens.Item;
import SimuladorDeDados.Dice;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */

public class Provisao extends Item{
    private final int EnergiaASerAdicionada;
    private final static int EnergiaMinuto = 60;
    private final static int EnergiaSegundo = 1000;
    private final static float pesoMinimo = 0.5f;

    public Provisao() {
        // A comida pesa entre 500 gramas e 1,5 kg;
        // Ter muitas provisões não necessariamente ajudará o jogador;
        super("Provisao", "Comida", (pesoMinimo + (Dice.rolagem(1000)/1000)), 40);
        
        // Define a quandidade de energia a ser adicionada ao ingerir o alimento
        // A energia é utilizada para limitar o tempo do jogador no palco e para 
        // curar ferimentos do personagem.
        this.EnergiaASerAdicionada = Dice.multiplaRolagem(1, 6) * EnergiaMinuto * EnergiaSegundo;
    }

    public int getEnergia() {
        return EnergiaASerAdicionada;
    }
}
