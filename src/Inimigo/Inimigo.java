package Inimigo;

import Persona.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public abstract class Inimigo implements Persona {
    private final String nome;
    private final String tipo;
    private static final int critico = 5;
    private static final int multiplicadorDeCritico = 2;
    
    private int HPAtual;
    private final int HP;
    private final int DefesaFisica;
    private final int DefesaMagica;
    
    private final int AtaqueFisicoMin;
    private final int AtaqueFisicoMax;
    private final int AtaqueMagicoMin;
    private final int AtaqueMagicoMax;
    
    private final int Iniciativa;
    private final int Esquiva;
    private final int Pontaria;

    public Inimigo(String nome, String tipo, int HP, 
            int DefesaFisica, int DefesaMagica, 
            int AtaqueFisicoMin, int AtaqueFisicoMax, int AtaqueMagicoMin, int AtaqueMagicoMax,
            int Iniciativa, int Esquiva, int Pontaria) {
        this.nome = nome;
        this.tipo = tipo;
        this.HPAtual = HP;
        this.HP = HP;
        
        this.DefesaFisica = DefesaFisica;
        this.DefesaMagica = DefesaMagica;
        
        this.AtaqueFisicoMin = AtaqueFisicoMin;
        this.AtaqueFisicoMax = AtaqueFisicoMax;
        this.AtaqueMagicoMin = AtaqueMagicoMin;
        this.AtaqueMagicoMax = AtaqueMagicoMax;
        
        this.Iniciativa = Iniciativa;
        this.Esquiva = Esquiva;
        this.Pontaria = Pontaria;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public int getHP() {
        return HP;
    }
    
    @Override
    public int getDefesaFisica() {
        return DefesaFisica;
    }

    @Override
    public int getDefesaMagica() {
        return DefesaMagica;
    }

    @Override
    public int getAtaqueFisicoMin() {
        return AtaqueFisicoMin;
    }

    @Override
    public int getAtaqueFisicoMax() {
        return AtaqueFisicoMax;
    }

    @Override
    public int getAtaqueMagicoMin() {
        return AtaqueMagicoMin;
    }

    @Override
    public int getAtaqueMagicoMax() {
        return AtaqueMagicoMax;
    }

    @Override
    public int getIniciativa() {
        return Iniciativa;
    }

    @Override
    public int getEsquiva() {
        return Esquiva;
    }

    @Override
    public int getPontaria() {
        return Pontaria;
    }

    public int getHPAtual() {
        return HPAtual;
    }

    @Override
    public void sofreDano(int dano){
        this.HPAtual -= dano;
        if (HPAtual <= 0){
            this.morre();
        }
    }

    @Override
    public void morre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCritico() {
        return Inimigo.critico;
    }

    @Override
    public int getMultiplicadorDeCritico() {
        return Inimigo.multiplicadorDeCritico;
    }
}
