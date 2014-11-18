/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itens;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public abstract class Item {
    private final String nome;
    private final String tipo;
    private final float peso;
    private final int valorMonetario;

    public Item(String nome, String tipo, float peso, int valorMonetario) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.valorMonetario = valorMonetario;
    }
    
    public float getPeso() {
        return peso;
    }
    
    public int getValorMonetario(){
        return valorMonetario;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
