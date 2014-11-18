/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Personagem;

import Excecoes.NoMoreFoodException;
/**
 * @author Pedro Gabriel Drumond Pereira
 */
public class Metabolismo implements Runnable{
    private static final int umSegundo = 1000;
    private static final int umMinuto  = 60;
    
    private float totalPoints;
    private float constanteMetabolica;
    
    private final Personagem personagem;
    
    public Metabolismo(Personagem personagem) {
        //Valor provisório
        constanteMetabolica = umMinuto*umSegundo;
        this.personagem = personagem;
    }
    
    public void atualizaConstanteMetabolica(){
        //Provisório, vira mais código aqui
        constanteMetabolica = 0;
    }
    
    public void recebeEnergiaDaComida() throws NoMoreFoodException{
        this.totalPoints += this.personagem.comeProvisao().getEnergia();
        System.out.println(personagem.getNome() + " recebeu energia.");
    }

    @Override
    @SuppressWarnings({"WaitWhileNotSynced", "SleepWhileInLoop"})
    public void run() {
        while(true){
            totalPoints -= constanteMetabolica;
            if(totalPoints <= 0){
                try {
                    this.recebeEnergiaDaComida();
                } catch (NoMoreFoodException ex) {
                    System.out.println("Acabou o estoque de comida de " + personagem.getNome() + ", agora morto de fome. \n");
                    return;
                }
            } try {
                Thread.sleep(umSegundo);
            } catch (InterruptedException ex) {
                System.out.println("Algo ruim aconteceu");
            }
        }
    }
}
