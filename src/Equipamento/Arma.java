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
public class Arma extends Equipamento{
    public Arma(int Nivel, String nome, float peso, int valorMonetario) {
        super(Nivel, nome, "Arma", peso, valorMonetario);
        
        /** O ataque máximo é a base mais um valor aleatório num range de 20% **/
        this.setAtaqueFisicoMin(Dice.multiplaRolagem(1 + Nivel/3, 9));
        this.setAtaqueFisicoMax(this.getAtaqueFisicoMin() + Dice.rolagem((int)(this.getAtaqueFisicoMin()/5 + 1)));
        
        this.setAtaqueMagicoMin(Dice.multiplaRolagem(1 + Nivel/3, 9));
        this.setAtaqueMagicoMax(this.getAtaqueMagicoMin() + Dice.rolagem((int)(this.getAtaqueMagicoMin()/5 + 1)));
    }
    
    public void modificaAtaqueFisico(float modificador){
        this.setAtaqueFisicoMin((int) (this.getAtaqueFisicoMin()*modificador));
        this.setAtaqueFisicoMax((int) (this.getAtaqueFisicoMax()*modificador));
    }
    
    public void modificaAtaqueMagico(float modificador){
        this.setAtaqueMagicoMin((int) (this.getAtaqueMagicoMin()*modificador));
        this.setAtaqueMagicoMax((int) (this.getAtaqueMagicoMax()*modificador));
    }
}
