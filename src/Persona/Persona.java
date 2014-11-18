/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

/**
 *
 * @author pedro_000
 */
public interface Persona {
    public String getNome();
    public String getTipo();
    
    public int getHP();
    public void sofreDano(int dano);
    
    public int getDefesaFisica();
    public int getDefesaMagica();
    
    public int getAtaqueFisicoMin();
    public int getAtaqueFisicoMax();
    public int getDanoFisico();
    
    public int getAtaqueMagicoMin();
    public int getAtaqueMagicoMax();
    public int getDanoMagico();
    
    public int getIniciativa();
    public int getEsquiva();
    public int getPontaria();
    
    public int getCritico();
    public int getMultiplicadorDeCritico();
    
    public void morre();
}
