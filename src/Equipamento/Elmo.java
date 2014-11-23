/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipamento;

import SimuladorDeDados.Dice;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public class Elmo extends Equipamento {

    public Elmo(int Nivel, String nome, float peso, int valorMonetario) {
        super(Nivel, nome, "Elmo", peso, valorMonetario);

        this.setDefesaFisica(Dice.multiplaRolagem(1 + Nivel / 3, 3));
        this.setDefesaMagica(Dice.multiplaRolagem(1 + Nivel / 3, 3));
        this.setEsquiva(Dice.multiplaRolagem(1 + Nivel / 3, 9));
        this.setHealthPoints(Dice.multiplaRolagem(1 + Nivel / 5, 10));
        this.setManaPoints(Dice.multiplaRolagem(1 + Nivel / 5, 10));
    }

}
