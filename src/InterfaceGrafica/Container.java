/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Excecoes.ItemNaoGeradoException;
import Personagem.Personagem;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                personagem.getInventario().RecebeItem(Itens.GeradorDeItems.geraEquipamento(2));
            } catch (ItemNaoGeradoException ex) {
                i++;
            }
        }
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
