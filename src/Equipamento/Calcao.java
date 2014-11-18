/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipamento;

import Itens.Item;
import SimuladorDeDados.Dice;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public class Calcao extends Equipamento {

    public Calcao(int Nivel, String nome, float peso, int valorMonetario) {
        super(Nivel, nome, "Calção\t", peso, valorMonetario);
        
        this.setDefesaFisica(Dice.multiplaRolagem(1 + Nivel/3, 10));
        this.setDefesaMagica(Dice.multiplaRolagem(1 + Nivel/3, 10));
        this.setEsquiva(Dice.multiplaRolagem(1 + Nivel/3, 12));
        this.setHealthPoints(Dice.multiplaRolagem(1 + Nivel/5, 8));
        this.setManaPoints(Dice.multiplaRolagem(1 + Nivel/5, 8));
    }
}
