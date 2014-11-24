/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Excecoes.ItemNaoGeradoException;
import Personagem.Personagem;

/**
 *
 * @author pedro_000
 */
public class Container {
    private static int pontoDeRetorno;
    private static Personagem personagem;

    public Container(String nome, String tipo) {
        pontoDeRetorno = 3;
        personagem = new Personagem(nome, tipo);
        
        for (int i = 0; i <= 32; i++){
            try {
                personagem.getInventario().recebeItem(Itens.GeradorDeItems.geraItem(10));
            } catch (ItemNaoGeradoException ex) {
                i++;
            }
        }
        
        personagem.adicionaComida(0);
    }

    public static int getPontoDeRetorno() {
        return pontoDeRetorno;
    }

    public static void setPontoDeRetorno(int pontoDeRetorno) {
        Container.pontoDeRetorno = pontoDeRetorno;
    }

    public static Personagem getPersonagem() {
        return personagem;
    }
}
