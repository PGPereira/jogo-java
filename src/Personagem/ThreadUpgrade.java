/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagem;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */

//Thread de teste do sistema de nivelamento.
public class ThreadUpgrade implements Runnable{
    private final Personagem personagem;
    private final static int umSegundo = 1000;
    private int i;
    
    public ThreadUpgrade(Personagem personagem) {
        this.personagem = personagem;
    }
    
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        for ( ; ; i++ ){
            personagem.GanhaXP(i);
            try {
                Thread.sleep(umSegundo);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
