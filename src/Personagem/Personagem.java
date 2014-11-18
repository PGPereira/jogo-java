/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagem;

import Equipamento.*;
import SimuladorDeDados.Dice;
import Ficha.Ficha;
import Inventario.Inventario;
import Excecoes.NoMoreFoodException;
import Itens.Provisao;
import Persona.Persona;
import java.text.DecimalFormat;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public class Personagem implements Persona{
    private final Ficha ficha;
    private final Inventario inventario;
    private final Metabolismo metabolismo;
    
    private int hpAtual;
    private static final int criticoBase = 5;
    private static final int multiplicadorCriticoBase = 200;
    
    private static final int atkFisBase = 5;
    private static final int atkMagBase = 5;
    
    private static final int defFisBase = 5;
    private static final int defMagBase = 5;
    
    private static final int esquiva = 5;
    private static final int pontaria = 5;
    private static final int iniciativa = 3;
    
    public Personagem(String nome, String classe) {
        ficha = new Ficha(nome, classe);
        inventario = new Inventario();
        metabolismo = new Metabolismo(this);
    }
    
    private int nivel = 1;
    private int xpAtual = 0;
    private int nextLevelXP = 50;
    private int pontosParaDistribuir;
    
    public void GanhaXP(int Experiencia){
        xpAtual += Experiencia;
        if (xpAtual >= nextLevelXP){
            levelUp();
        }
    }
    
    public Elmo elmo;
    public Calcao calcao;
    public Botas botas;
    public Manoplas manoplas;
    public Peitoral peitoral;

    public Elmo getElmo() {
        return elmo;
    }

    public void setElmo(Elmo elmo) {
        this.inventario.RecebeItem(this.elmo);
        this.elmo = elmo;
    }

    public Calcao getCalcao() {
        return calcao;
    }

    public void setCalcao(Calcao calcao) {
        this.inventario.RecebeItem(this.calcao);
        this.calcao = calcao;
    }

    public Botas getBotas() {
        this.inventario.RecebeItem(this.botas);
        return botas;
    }

    public void setBotas(Botas botas) {
        this.botas = botas;
    }

    public Manoplas getManoplas() {
        return manoplas;
    }

    public void setManoplas(Manoplas manoplas) {
        this.inventario.RecebeItem(this.manoplas);
        this.manoplas = manoplas;
    }

    public Peitoral getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(Peitoral peitoral) {
        this.inventario.RecebeItem(this.peitoral);
        this.peitoral = peitoral;
    }
    
    private void levelUp(){
        xpAtual -= nextLevelXP;
        nivel++;
        nextLevelXP *= nivel;
        
        pontosParaDistribuir += Dice.multiplaRolagem(2, 3);
        
        //Testa level up
        while (pontosParaDistribuir > 0){
            metodoDeTesteLevelUP(Dice.rolagem(4));
            pontosParaDistribuir--;
        }
        
        this.ImprimePersonagem();
    }
    
    private void metodoDeTesteLevelUP(int i){
        switch (i){
            case 1:
                adicionaPontoConstitution();
                break;
            case 2:
                adicionaPontoDexterity();
                break;
            case 3:
                adicionaPontoIntelligence();
                break;
            case 4:
                adicionaPontoStrenght();
                break;
            default:
                System.out.println("Deu problema!");
        }
    }
    
    public void adicionaComida(int i){
        this.inventario.defineQuantidadeInicialDeComida(i);
    }
    
    //Pontos adicionados no level up - Escolhidos pelo jogador
    public void adicionaPontoConstitution(){
        this.ficha.adicionaPontoConstitution();
    }
    public void adicionaPontoDexterity(){
        this.ficha.adicionaPontoDexterity();
    }
    public void adicionaPontoIntelligence(){
        this.ficha.adicionaPontoIntelligence();
    }
    public void adicionaPontoStrenght(){
        this.ficha.adicionaPontoStrenght();
    }
    
    //Caracteristicas da ficha.
    
    public int getNivel() {
        return nivel;
    }
    
    @Override
    public String getNome(){
        return ficha.getNome();
    }
    
    public String getClasse(){
        return ficha.getClasse();
    }
    
    public int getMoedasNoInventario(){
        return inventario.getMoedas();
    }
    
    public int getQuantidadeProvisoes(){
        return inventario.getQuantidadeProvisoes();
    }
    
    
    //Ficha + itens
    public int getCharisma(){
        return ficha.getCharisma();
    }

    public int getConstitution(){
        return ficha.getConstitution();
    }
    
    public int getConstitutionModifier(){
        return ficha.getConstitutionModifier();
    }
    
    public int getDexterity(){
        return ficha.getDexterity();
    }
    
    public int getDexterityModifier(){
        return ficha.getDexterityModifier();
    }
    
    public int getIntelligence(){
        return ficha.getIntelligence();
    }
    
    public int getIntelligenceModifier(){
        return ficha.getIntelligenceModifier();
    }
    
    public int getStrenght(){
        return ficha.getStrenght();
    }
    
    public int getStrenghtModifier(){
        return ficha.getStrenghtModifier();
    }
        
    public float getPesoDoInventario(){
        return inventario.getPesoTotalInventario();
    }
    
    //Provisao
    public Provisao comeProvisao() throws NoMoreFoodException {
        return inventario.pegaProvisaoParaComer();
    }

    public Metabolismo getMetabolismo() {
        return metabolismo;
    }
    
    private void ImprimePersonagem(){
        DecimalFormat fmt = new DecimalFormat("+#,##0;-#");
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("\n");
        System.out.println(" -------------------------------------------------------------");
        System.out.println("|\t");
        
        System.out.println("|\tNome:\t" + this.getNome());
        System.out.println("|\tClasse:\t" + this.getClasse());
        System.out.println("|\tNível:\t"  + this.getNivel() 
                + "\tMoedas: " + this.getMoedasNoInventario() 
                + "\tProvisões: " +  this.getQuantidadeProvisoes());
        System.out.println("|\tPeso carregado:\t" + df.format(this.getPesoDoInventario()) +"Kg");
        
        System.out.println("|\t");
        System.out.println("|-------------------------------------------------------------");
        System.out.println("|\t");
        
        System.out.println("|\tStatus:");
        System.out.println("|\tForça:\t\t"      + this.getStrenght()     
                + "\tModificador: " + fmt.format(this.getStrenghtModifier()));
        System.out.println("|\tDestreza:\t"     + this.getDexterity()    
                + "\tModificador: " + fmt.format(this.getDexterityModifier()));
        System.out.println("|\tConstituição:\t" + this.getConstitution() 
                + "\tModificador: " + fmt.format(this.getConstitutionModifier()));
        System.out.println("|\tInteligência:\t" + this.getIntelligence() 
                + "\tModificador: " + fmt.format(this.getIntelligenceModifier()));
        
        System.out.println("|\t");
        System.out.println(" -------------------------------------------------------------\n");
    }

    @Override
    public String getTipo() {
        return "Jogador";
    }

    @Override
    public int getHP() {
        return this.hpAtual;
    }

    @Override
    public int getDefesaFisica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDefesaMagica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAtaqueFisicoMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAtaqueFisicoMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDanoFisico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAtaqueMagicoMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAtaqueMagicoMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDanoMagico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIniciativa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEsquiva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPontaria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCritico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMultiplicadorDeCritico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sofreDano(int dano) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void morre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
