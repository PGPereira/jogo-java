/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Habilidades;

import Inimigo.Inimigo;
import Personagem.Personagem;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public interface HabilidadeInterface {
    /**
     * Toda a matemática de dano acontecera aqui dentro;
     * @param p Personagem de quem sairá o ataque;
     * @param m Personagem que sofrerá o ataque;
     */
    public void AtacaInimigo(Personagem p, Inimigo m);
    
    /**
     * Toda a matemática de dano acontecera aqui dentro;
     * @param m Personagem de quem sairá o ataque;
     * @param p Personagem que sofrerá o ataque;
     */
    public void SofreAtaque(Inimigo m, Personagem p);
    
    public boolean CalculaEsquiva(int acerto, int esquiva);
    public int CalculaCritico(int critico, float criticoDMG);
    public int CalculaDanoReducao(int ataque, int defesa);
    
    public int DanoCausado(int Dano, Inimigo m);
    public int DanoSofrido(int Dano, Personagem p );
}
