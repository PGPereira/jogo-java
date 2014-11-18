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
public class Manoplas extends Equipamento{

    public Manoplas(int Nivel, String nome, float peso, int valorMonetario) {
        super(Nivel, nome, "Manoplas", peso, valorMonetario);
        
        this.setDefesaFisica(Dice.multiplaRolagem(1 + Nivel/3, 3));
        this.setDefesaMagica(Dice.multiplaRolagem(1 + Nivel/3, 3));
        this.setEsquiva(Dice.multiplaRolagem(1 + Nivel/3, 7));
        this.setHealthPoints(Dice.multiplaRolagem(1 + Nivel/5, 6));
        this.setManaPoints(Dice.multiplaRolagem(1 + Nivel/5, 6));
    }


}
