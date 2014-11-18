/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ficha;

import Excecoes.SumLessThenOneException;
import Excecoes.NotEvenAValueHigherThenThirteenException;
import SimuladorDeDados.Dice;
import java.text.DecimalFormat;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public class Ficha {
    private final String Nome;
    private final String Classe;
    
    //private final Inventario inventario = new Inventario();
    
    /* Atributos dos Personagens */
    private int Strenght;
    private int Dexterity;
    private int Constitution;
    private int Intelligence;
    private int Charisma;
    
    /* Modificadores de Status*/
    private int ModificadorStrenght;
    private int ModificadorDesterity;
    private int ModificadorConstitution;
    private int ModificadorIntelligence;
    
    private void CalculaModificadores(){
        this.setModificadorConstitution();
        this.setModificadorDexterity();
        this.setModificadorIntelligence();
        this.setModificadorStrenght();
    }

    //Caracteristicas do Personagem
    public String getNome() {
        return Nome;
    }

    public String getClasse() {
        return Classe;
    }

    
    // Pontos de Status
    public int getStrenght() {
        return Strenght;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public int getConstitution() {
        return Constitution;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public int getCharisma() {
        return Charisma;
    }
    
    public void adicionaPontoStrenght(){
        this.Strenght++;
        this.setModificadorStrenght();
        //System.out.println("Ponto adicionado em força: " + this.Strenght);
    }
    
    public void adicionaPontoDexterity(){
        this.Dexterity++;
        this.setModificadorDexterity();
        //System.out.println("Ponto adicionado em destreza: " + this.Dexterity);
    }
    
    public void adicionaPontoConstitution(){
        this.Constitution++;
        this.setModificadorConstitution();
        //System.out.println("Ponto adicionado em constiuição: " + this.Constitution);
    }
    
    public void adicionaPontoIntelligence(){
        this.Intelligence++;
        this.setModificadorIntelligence();
        //System.out.println("Ponto adicionado em inteligência: " + this.Intelligence);
    }
    
    //Modificadores de Status
    public static int CalculaModificador(int Status){
        return ((Status/2) -5);
    }
    
    public int getStrenghtModifier() {
        return ModificadorStrenght;
    }

    public int getDexterityModifier() {
        return ModificadorDesterity;
    }

    public int getConstitutionModifier() {
        return ModificadorConstitution;
    }

    public int getIntelligenceModifier() {
        return ModificadorIntelligence;
    }

    public void setModificadorStrenght() {
        this.ModificadorStrenght = CalculaModificador(Strenght);
    }

    public void setModificadorDexterity() {
        this.ModificadorDesterity = CalculaModificador(Dexterity);
    }

    public void setModificadorConstitution() {
        this.ModificadorConstitution = CalculaModificador(Constitution);
    }

    public void setModificadorIntelligence() {
        this.ModificadorIntelligence = CalculaModificador(Intelligence);
    }

    
    //Inicializador de personagem status
    public Ficha(String Nome, String Classe) {
        this.Nome = Nome;
        this.Classe = Classe;
        
        this.RolaDados();
        
    }
    
    public static int RolaParaFicha(){
        return Dice.multiplaRolagem(3, 6);
    }
    
    @SuppressWarnings("InfiniteRecursion")
    private void RolaDados(){
        try {
            Strenght        = RolaParaFicha();
            Dexterity       = RolaParaFicha();
            Constitution    = RolaParaFicha();
            Intelligence    = RolaParaFicha();
            Charisma        = RolaParaFicha();

            CalculaModificadores();
            this.verificaValoresRolados();
            //this.ImprimeFicha();
        } catch (NotEvenAValueHigherThenThirteenException | SumLessThenOneException ex) {
            this.RolaDados();
        }
    }
        
    private void ImprimeFicha(){
        DecimalFormat fmt = new DecimalFormat("+#,##0;-#");
        System.out.println("--------------------------------------------------");
        
        System.out.println();
        
        System.out.println("Nome:\t" + this.Nome);
        System.out.println("Classe:\t" + this.Classe);
        
        System.out.println();
        
        System.out.println("Força:\t\t"      + this.Strenght     + "\tModificador: " + fmt.format(this.ModificadorStrenght) );
        System.out.println("Destreza:\t"     + this.Dexterity    + "\tModificador: " + fmt.format(this.ModificadorDesterity) );
        System.out.println("Constituição:\t" + this.Constitution + "\tModificador: " + fmt.format(this.ModificadorConstitution) );
        System.out.println("Inteligência:\t" + this.Intelligence + "\tModificador: " + fmt.format(this.ModificadorIntelligence) );
        
        System.out.println();
        
        System.out.println("--------------------------------------------------");
        
        System.out.println("\n\n");
    }
    
    //Utilitario para gerar uma ficha justa
    private void verificaValoresRolados() throws NotEvenAValueHigherThenThirteenException, SumLessThenOneException{
        if ((Strenght     <= 13) && (Dexterity    <= 13) && (Constitution <= 13) 
                && (Intelligence <= 13) && (Charisma <= 13)) {
            throw new NotEvenAValueHigherThenThirteenException();
        } else if ((ModificadorConstitution + ModificadorDesterity +
                    ModificadorIntelligence + ModificadorStrenght) <= 0){
            throw new SumLessThenOneException();
        }
    }
}   
