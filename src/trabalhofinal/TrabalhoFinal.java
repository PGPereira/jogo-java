/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import Equipamento.Arma;
import Equipamento.Equipamento;
import Itens.GeradorDeItems;
import Excecoes.ItemNaoGeradoException;
import SimuladorDeDados.Dice;
import Personagem.Personagem;
import Personagem.ThreadUpgrade;
import java.util.ArrayList;

/**
 *
 * @author pedro_000
 */
public class TrabalhoFinal {
    
    //Método de teste da mecânica.
    public static void entraNoPalco(Personagem p){
        
        System.out.println(p.getNome() + " entrou no palco");
        p.adicionaComida(0);
        
        ThreadUpgrade classeTesteLevelUp = new ThreadUpgrade(p);
        
        Thread comida = new Thread(p.getMetabolismo());
        Thread levelUp = new Thread(classeTesteLevelUp);
       
        comida.start();
        levelUp.start();
        while(comida.isAlive()){ }
        levelUp.interrupt();
    }

    /**
     * @param args the command line arguments
     * @throws Excecoes.ItemNaoGeradoException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws ItemNaoGeradoException, InterruptedException {
        ArrayList<Personagem> listaDePersonagem = new ArrayList<>();
        
        listaDePersonagem.add(new Personagem("Carina", "Prima do Dultra"));
        listaDePersonagem.add(new Personagem("Celitto","Jabinha Hutt"));
        listaDePersonagem.add(new Personagem("Gabriel","Xuxinha"));
        listaDePersonagem.add(new Personagem("Gustavo.exe", "C'est nest a Montagne d'oil"));
        listaDePersonagem.add(new Personagem("Lorena", "Miranda"));
        listaDePersonagem.add(new Personagem("Matios", "Ex-eleitor do Lula"));
        listaDePersonagem.add(new Personagem("Japa", "<GM da porra toda>"));
        listaDePersonagem.add(new Personagem("Pedrinho Gama.tar.gz.bz2", "Warlord do Sertão"));
        listaDePersonagem.add(new Personagem("Papa Nicolau", "John Carmack das texturas"));
        listaDePersonagem.add(new Personagem("Pedro Otavio","P.Otável"));
        listaDePersonagem.add(new Personagem("JThassiPane", "Lendário 17º Colosso"));
        listaDePersonagem.add(new Personagem("Torugo", "Programador mais rápido da Savassi"));
        listaDePersonagem.add(new Personagem("Batuquinho", "Blindão Neo-nazista"));
        
        listaDePersonagem.add(new Personagem("Fantini","Ladino de Pontos"));
        listaDePersonagem.add(new Personagem("Virginia","Canela de Ferro"));
        
        while(true){
        int pessoasPresentes = listaDePersonagem.size();
        int PessoaPega = Dice.rolagem(pessoasPresentes) - 1;
        entraNoPalco(listaDePersonagem.get(PessoaPega));
        }
        
       /* while(true){
            Equipamento equip = GeradorDeItems.geraEquipamento(Dice.rolagem(110));
            Arma arma = GeradorDeItems.geraArma(Dice.rolagem(110));
            Thread.sleep(1000);
        }*/
    }
}
