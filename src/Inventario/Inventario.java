/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import Excecoes.NoMoreFoodException;
import Itens.Provisao;
import Itens.Item;
import SimuladorDeDados.Dice;
import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public class Inventario {
    private int Moedas;
    private short QuantidadeInicialDeComida;
    private final ArrayList<Provisao> Comida = new ArrayList<>();
    private final ArrayList<Item> Inventario = new ArrayList<>(30);

    public Inventario() {
        Moedas = Dice.multiplaRolagem(50, 4);        
    }
    
    //Toda vez que entrar no jogo a quantidade de provisões é iniciada.
    public void defineQuantidadeInicialDeComida(int adicional){
        this.QuantidadeInicialDeComida = (short)(Dice.multiplaRolagem(3, 4) + adicional);
        this.adicionaProvisoes(QuantidadeInicialDeComida);
    }
    
    public void RecebeItem(Item item){
        this.Inventario.add(item);
    }

    public int getMoedas() {
        return Moedas;
    }

    public int getQuantidadeProvisoes() {
        return Comida.size();
    }
    
    public void adicionaMoedas(int novasMoedas){
        Moedas += novasMoedas;
    }
    
    public void dispendeMoedas (int gasto){
        Moedas -= gasto;
    }
    
    public final void adicionaProvisoes(int quantidadeDeNovasProvisoes){
        for (  ; quantidadeDeNovasProvisoes > 0 ; quantidadeDeNovasProvisoes--){
            Comida.add(new Provisao());
        }
    }
    
    public Provisao pegaProvisaoParaComer() throws NoMoreFoodException{
        if (Comida.size() > 0){
            return Comida.remove(0);
        } else {
            throw new NoMoreFoodException();
        }
    }
    
    public float getPesoDoInventario(){
        float pesoTotal = 0;
        //Netbeans fez para mim.
        pesoTotal = Inventario.stream().map((Inventario1) -> Inventario1.getPeso()).reduce(pesoTotal, (accumulator, _item) -> accumulator + _item);
        return pesoTotal;
    }
    
    public float getPesoMoedas(){
        /* 
         * 2.96g é o peso de uma moeda de 0.01R$
         * produzida entre 1994-1997, segundo o Wikipédia 
         * eu divido por mil pois quero o peso em quilos. 
         */
        return (float)(this.getMoedas() * 2.96/1000);
    }
    
    public float getPesoProvisoes(){
        float pesoProvisoes = 0;
        pesoProvisoes = this.Comida.stream().map((Comida1) -> Comida1.getPeso()).reduce(pesoProvisoes, (accumulator, _item) -> accumulator + _item);
        return pesoProvisoes;
    }
    
    public float getPesoTotalInventario(){
        return (this.getPesoDoInventario() 
                + this.getPesoMoedas() 
                + this.getPesoProvisoes());
    }
}
