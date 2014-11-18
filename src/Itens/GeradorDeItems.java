/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itens;

import Equipamento.*;
import Excecoes.ItemNaoGeradoException;
import SimuladorDeDados.Dice;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public class GeradorDeItems {
    public static Item geraItem(int nivel) throws ItemNaoGeradoException{
        switch(Dice.rolagem(3)){
            case 1:
                return new Provisao();
            case 2:
                return GeradorDeItems.geraEquipamento(nivel);
            case 3: 
                return GeradorDeItems.geraArma(nivel);
        }
        throw new ItemNaoGeradoException();
    }
    
    public static Equipamento geraEquipamento(int nivel) throws ItemNaoGeradoException{
        Equipamento equip = null;
        
        int tipo = Dice.rolagem(5);
        int peso = Dice.rolagem(3);
        int adicionais = Dice.rolagem(5) - 1;           //Máximo de 4 adicionais, mínimo 0;
        int itemLevel = nivel + Dice.rolagem(3) - 2;    //O nível pode ser maior ou 
                                                        //menor que o monstro morto;
        
        String massa;
        
        float multiplicadorHP;
        float multiplicadorMP;
        float multiplicadorDF;
        float multiplicadorDM;
        float multiplicadorEsq;
        
        switch (peso){
            case 1:
                massa = "Mágic@";
                multiplicadorDF = 0.3f;
                multiplicadorDM = 1.2f;
                multiplicadorEsq = 0.7f;
                multiplicadorHP = 0;
                multiplicadorMP = 1.2f;
                break;
                
            case 2:
                massa = "Leve";
                multiplicadorDF = 0.6f;
                multiplicadorDM = 0.6f;
                multiplicadorEsq = 1f;
                multiplicadorHP = 0.4f;
                multiplicadorMP = 0.3f;
                break;
                
            case 3:
                massa = "Pesad@";
                multiplicadorDF = 1.7f;
                multiplicadorDM = 0.2f;
                multiplicadorEsq = 0;
                multiplicadorHP = 1f;
                multiplicadorMP = 0;
                peso *= 2;
                break;
                
            default:
                throw new ItemNaoGeradoException();
        }
        
        if (itemLevel <= 0){
            itemLevel = 1;
        }
        
        int preço = adicionais * itemLevel;
        
        switch(tipo){
            case 1:
                equip = new Botas(itemLevel, "Botas " + massa+"s", peso, preço);
                break;
            case 2:
                equip = new Calcao(itemLevel, "Calções " + massa+"s", peso * 2, preço);
                break;
            case 3:
                equip = new Elmo(itemLevel, "Elmo " + massa, peso, preço);
                break;
            case 4:
                equip = new Manoplas(itemLevel, "Manoplas " + massa+"s" , peso, preço);
                break;
            case 5:
                equip = new Peitoral(itemLevel, "Peitoral " + massa, peso * 3, preço);
                break;
            default:
                throw new ItemNaoGeradoException();
        }
        
        /* Utiliza os modificadores para os valores ficarem mais condizentes
            com o tipo de equipamento, ex: Equipamentos pesados fornecem mais 
            defesa porém menos esquiva.
        */
        equip.modificaDefesaFisica(multiplicadorDF);
        equip.modificaDefesaMagica(multiplicadorDM);
        equip.modificaEsquiva(multiplicadorEsq);
        equip.modificaHealthPoints(multiplicadorHP);
        equip.modificaManaPoints(multiplicadorMP);
        
        for ( ; adicionais > 0; adicionais--){
            try {
                GeradorDeItems.geraAtributos(equip);
            } catch (AdicionalNaoGeradoException ex) {
                adicionais++;
            }
        }
        
        Equipamento.printEquipamento(equip);
        return equip;
    }
    
    public static Arma geraArma(int nivel) throws ItemNaoGeradoException{
        int tipo = Dice.rolagem(3);
        int peso = Dice.rolagem(2);
        int adicionais = Dice.rolagem(5) - 1;           //Máximo de 4 adicionais, mínimo 0;
        int itemLevel = nivel + Dice.rolagem(3) - 2;    //O nível pode ser maior ou 
        
        if (itemLevel <= 0) {
            itemLevel = 1;
        }
        
        float multiplicadorAtaqueF = 0;
        float multiplicadorAtaqueM = 0;
        
        String nome = null;
        
        switch (tipo){
            case 1:
                nome = "Brutal";
                multiplicadorAtaqueF = 2;
                multiplicadorAtaqueM = 0;
                break;
                
            case 2:
                nome = "Sagrad@";
                multiplicadorAtaqueF = 1;
                multiplicadorAtaqueM = 1;
                break;
                
            case 3:
                nome = "Encantad@";
                multiplicadorAtaqueF = 0.5f;
                multiplicadorAtaqueM = 1.5f;
                break;
        }
        
        int preço = adicionais * itemLevel;
        
        Arma equip = new Arma(itemLevel, nome, "Arma", peso, preço);
        equip.modificaAtaqueFisico(multiplicadorAtaqueF);
        equip.modificaAtaqueMagico(multiplicadorAtaqueM);
        
        for (  ; adicionais > 0; adicionais--){
            try {
                GeradorDeItems.geraAtributos(equip);
            } catch (AdicionalNaoGeradoException ex) {
                adicionais++;
            }
        }
        
        Equipamento.printEquipamento(equip);
        return equip;
    }
    
    
    private static void geraAtributos(Equipamento equip) throws AdicionalNaoGeradoException{
        if (equip.getNivel() <= 5){
            Equipamento.geraAdicionalComum(equip);
        } else {
            switch(Dice.rolagem(3)){
                case 3: 
                    Equipamento.geraAdicionalRaro(equip);
                    break;
                default:
                    Equipamento.geraAdicionalComum(equip);
                    break;
            }
        }
    }
}
