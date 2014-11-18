package Equipamento;

import Itens.AdicionalNaoGeradoException;
import Itens.Item;
import SimuladorDeDados.Dice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */
public abstract class Equipamento extends Item{
    private final int Nivel;
    
    /* 
    * Atributos base
    */
    private int AtaqueFisicoMin;
    private int AtaqueFisicoMax;
    private int AtaqueMagicoMin;
    private int AtaqueMagicoMax;

    private float DefesaFisica;
    private float DefesaMagica;
    private float Esquiva;
    private float HealthPoints;
    private float ManaPoints;
    
    /*
     * Outros adicionais 
     */
    private int adicionalIni;   // Iniciativa
    private int adicionalMan;   // Mana Points
    private int adicionalHP;    // Health Points
    private int adicionalDF;    // Defesa Física
    private int adicionalDM;    // Defesa Mágica
    private int adicionalAtkF;  // Ataque Físico
    private int adicionalAtkM;  // Ataque Mágico
    private int adicionalEsq;   // Esquiva
    
    /* 
     * Status adicionais;
     * Apenas level 5+;
     */
    private int adicionalCon;   //Adicional de Constituição
    private int adicionalDex;   //Adicional de Destreza
    private int adicionalInt;   //Adicional de Inteligência
    private int adicionalStr;   //Adicional de Força
    private int adicionalXP;    //Adicional de XP em porcentagem
    private int adicionalCrit;  //Adicional de Porcentagem de Crítico.
    private int adicionalCrDmg; //Adicional de Dano de Crítico
    
    public Equipamento(int Nivel, String nome, String tipo, float peso, int valorMonetario) {
        super(nome, tipo, peso, valorMonetario);
        this.Nivel = Nivel;
    }

    public int getAdicionalCrDmg() {
        return adicionalCrDmg;
    }

    public void setAdicionalCrDmg(int adicionalCrDmg) {
        this.adicionalCrDmg = adicionalCrDmg;
    }
    
    public int getAdicionalCrit() {
        return adicionalCrit;
    }

    public void setAdicionalCrit(int adicionalCrit) {
        this.adicionalCrit = adicionalCrit;
    }

    public int getNivel() {
        return Nivel;
    }

    public float getDefesaFisica() {
        return DefesaFisica;
    }

    public void setDefesaFisica(int DefesaFisica) {
        this.DefesaFisica = DefesaFisica;
    }

    public float getDefesaMagica() {
        return DefesaMagica;
    }

    public void setDefesaMagica(int DefesaMagica) {
        this.DefesaMagica = DefesaMagica;
    }

    public int getAtaqueFisicoMin() {
        return AtaqueFisicoMin;
    }

    public void setAtaqueFisicoMin(int AtaqueFisicoMin) {
        this.AtaqueFisicoMin = AtaqueFisicoMin;
    }

    public int getAtaqueFisicoMax() {
        return AtaqueFisicoMax;
    }

    public void setAtaqueFisicoMax(int AtaqueFisicoMax) {
        this.AtaqueFisicoMax = AtaqueFisicoMax;
    }

    public int getAtaqueMagicoMin() {
        return AtaqueMagicoMin;
    }

    public void setAtaqueMagicoMin(int AtaqueMagicoMin) {
        this.AtaqueMagicoMin = AtaqueMagicoMin;
    }

    public int getAtaqueMagicoMax() {
        return AtaqueMagicoMax;
    }

    public void setAtaqueMagicoMax(int AtaqueMagicoMax) {
        this.AtaqueMagicoMax = AtaqueMagicoMax;
    }
    
    /*Multiplicadores de peso*/
    public void modificaDefesaFisica(float Multiplicador){
        this.DefesaFisica *= Multiplicador;
    }
    
    public void modificaDefesaMagica(float Multiplicador){
        this.DefesaMagica *= Multiplicador;
    }
    
    public void modificaEsquiva(float Multiplicador){
        this.Esquiva *= Multiplicador;
    }
    
    public void modificaHealthPoints(float Multiplicador){
        this.HealthPoints *= Multiplicador;
    }
    
    public void modificaManaPoints(float Multiplicador){
        this.ManaPoints *= Multiplicador;
    }
    
    /*Adicionais*/
    public int getAdicionalIni() {
        return adicionalIni;
    }

    public void setAdicionalIni(int adicionalIni) {
        this.adicionalIni = adicionalIni;
    }

    public int getAdicionalMan() {
        return adicionalMan;
    }

    public void setAdicionalMan(int adicionalMan) {
        this.adicionalMan = adicionalMan;
    }

    public float getEsquiva() {
        return Esquiva;
    }

    public void setEsquiva(int Esquiva) {
        this.Esquiva = Esquiva;
    }

    public float getHealthPoints() {
        return HealthPoints;
    }

    public void setHealthPoints(int HealthPoints) {
        this.HealthPoints = HealthPoints;
    }

    public float getManaPoints() {
        return ManaPoints;
    }

    public void setManaPoints(int ManaPoints) {
        this.ManaPoints = ManaPoints;
    }

    public int getAdicionalCon() {
        return adicionalCon;
    }

    public void setAdicionalCon(int adicionalCon) {
        this.adicionalCon = adicionalCon;
    }

    public int getAdicionalDex() {
        return adicionalDex;
    }

    public void setAdicionalDex(int adicionalDex) {
        this.adicionalDex = adicionalDex;
    }

    public int getAdicionalInt() {
        return adicionalInt;
    }

    public void setAdicionalInt(int adicionalInt) {
        this.adicionalInt = adicionalInt;
    }

    public int getAdicionalStr() {
        return adicionalStr;
    }

    public void setAdicionalStr(int adicionalStr) {
        this.adicionalStr = adicionalStr;
    }

    public int getAdicionalXP() {
        return adicionalXP;
    }
    
    public void setAdicionalXP(int adicionalXP) {
        this.adicionalXP = adicionalXP;
    }

    public int getAdicionalDF() {
        return adicionalDF;
    }

    public void setAdicionalDF(int adicionalDF) {
        this.adicionalDF = adicionalDF;
    }

    public int getAdicionalDM() {
        return adicionalDM;
    }

    public void setAdicionalDM(int adicionalDM) {
        this.adicionalDM = adicionalDM;
    }

    public int getAdicionalAtkF() {
        return adicionalAtkF;
    }

    public void setAdicionalAtkF(int adicionalAtkF) {
        this.adicionalAtkF = adicionalAtkF;
    }

    public int getAdicionalAtkM() {
        return adicionalAtkM;
    }

    public void setAdicionalAtkM(int adicionalAtkM) {
        this.adicionalAtkM = adicionalAtkM;
    }

    public int getAdicionalEsq() {
        return adicionalEsq;
    }

    public void setAdicionalEsq(int adicionalEsq) {
        this.adicionalEsq = adicionalEsq;
    }

    public int getAdicionalHP() {
        return adicionalHP;
    }

    public void setAdicionalHP(int adicionalHP) {
        this.adicionalHP = adicionalHP;
    }
    
    public static void geraAdicionalComum(Equipamento equip) 
            throws AdicionalNaoGeradoException {
        switch(Dice.rolagem(8)){
                case 1:
                    equip.setAdicionalIni(equip.getAdicionalIni() 
                            + Dice.multiplaRolagem(equip.getNivel(), 3));
                    break;
                    
                case 2: 
                    equip.setAdicionalMan(equip.getAdicionalMan()
                            + Dice.multiplaRolagem(equip.getNivel(), 3));
                    break;
                    
                case 3:
                    equip.setAdicionalHP(equip.getAdicionalHP()
                            + Dice.multiplaRolagem(equip.getNivel(), 3));
                    break;
                    
                case 4:
                    equip.setAdicionalDF(equip.getAdicionalDF()
                            + Dice.multiplaRolagem(equip.getNivel(), 3));
                    break;
                    
                case 5:
                    equip.setAdicionalDM(equip.getAdicionalDM()
                            + Dice.multiplaRolagem(equip.getNivel(), 4));
                    break;
                    
                case 6:
                    equip.setAdicionalAtkF(equip.getAdicionalAtkF()
                            + Dice.multiplaRolagem(equip.getNivel(), 4));
                    break;
                    
                case 7:
                    equip.setAdicionalAtkM(equip.getAdicionalAtkM()
                            + Dice.multiplaRolagem(equip.getNivel(), 4));
                    break;
                    
                case 8:
                    equip.setAdicionalEsq(equip.getAdicionalEsq() 
                            + Dice.multiplaRolagem(equip.getNivel(), 3));
                    break;
                    
                default:
                    throw new AdicionalNaoGeradoException();
            }
    }
    
    public static void geraAdicionalRaro(Equipamento equip) 
            throws AdicionalNaoGeradoException{
        switch(Dice.rolagem(7)){
                case 1:
                    equip.setAdicionalCon(equip.getAdicionalCon() 
                            + Dice.multiplaRolagem(equip.getNivel()/4, 3));
                    break;
                    
                case 2: 
                    equip.setAdicionalDex(equip.getAdicionalDex() 
                            + Dice.multiplaRolagem(equip.getNivel()/4, 3));
                    break;
                    
                case 3:
                    equip.setAdicionalInt(equip.getAdicionalInt() 
                            + Dice.multiplaRolagem(equip.getNivel()/4, 3));
                    break;
                    
                case 4:
                    equip.setAdicionalStr(equip.getAdicionalStr() 
                            + Dice.multiplaRolagem(equip.getNivel()/4, 3));
                    break;
                    
                case 5:
                    equip.setAdicionalXP(equip.getAdicionalXP()
                            + Dice.multiplaRolagem((equip.getNivel())/3, 4));
                    break;
                             
                case 6: 
                    equip.setAdicionalCrit(Dice.multiplaRolagem(((equip.getNivel()-5)/3) + 1, 5));
                    break;
                case 7:
                    equip.setAdicionalCrDmg(Dice.multiplaRolagem((equip.getNivel()+1)/3, 6));
                    break;
                default:
                    throw new AdicionalNaoGeradoException();
            }
    }
    
    public static void printEquipamento(Equipamento e){
        System.out.printf("\n");
        System.out.printf("|-------------------------------------------------------------\n");
        System.out.printf("|\n");
        System.out.printf("|\tNome:\t%s \n", e.getNome());
        System.out.printf("|\tTipo:\t%s\tNivel:\t%d \n", e.getTipo(), e.getNivel());
        System.out.printf("|\n");
        System.out.printf("|-------------------------------------------------------------\n");
        System.out.printf("|\n");
        
        if (e.getAtaqueFisicoMin() != 0 ){
            System.out.printf("|\tAtaque Físico:\t%d ~ %d\n", e.getAtaqueFisicoMin(), e.getAtaqueFisicoMax());
        }
        
        if (e.getAtaqueMagicoMin() != 0){
            System.out.printf("|\tAtaque Mágico:\t%d ~ %d\n", e.getAtaqueMagicoMin(), e.getAtaqueMagicoMax());
        }
        
        if (e.getDefesaFisica() != 0 ){
            System.out.printf("|\tDefesa Física:\t%.1f\n", e.getDefesaFisica());
        }
        
        if (e.getDefesaMagica() != 0){
            System.out.printf("|\tDefesa Mágica:\t%.1f \n", e.getDefesaMagica());
        }
        
        if (e.getEsquiva() != 0){
            System.out.printf("|\tEsquiva:\t%.1f \n", e.getEsquiva());
        }
        
        if (e.getHealthPoints() != 0){
            System.out.printf("|\tVida:\t\t%.1f \n", e.getHealthPoints());
        }
        
        if (e.getManaPoints() != 0){
            System.out.printf("|\tMana:\t\t%.1f \n", e.getManaPoints());
        }
        
        if(e.getAdicionalIni() != 0 || e.getAdicionalMan() != 0
                || e.getAdicionalHP() != 0 || e.getAdicionalAtkF() != 0 
                || e.getAdicionalAtkM() != 0 || e.getAdicionalDF() != 0
                || e.getAdicionalDM() != 0 || e.getAdicionalEsq() != 0){
            System.out.printf("|\n");
            System.out.printf("|------------------------------------------------------------\n");
            System.out.printf("|\n");
            System.out.printf("|\tAdicionais Comuns:\n");
            System.out.printf("|\n");

            //TODO
            if (e.getAdicionalIni() != 0){
                System.out.printf("|\tIniciativa:\t%d\n", e.getAdicionalIni());
            }

            if (e.getAdicionalMan() != 0){
                System.out.printf("|\tMana:\t\t%d\n", e.getAdicionalMan());
            }

            if (e.getAdicionalHP() != 0){
                System.out.printf("|\tVida:\t\t%d\n", e.getAdicionalHP());
            }

            if (e.getAdicionalAtkF() != 0){
                System.out.printf("|\tAtaque Físico:\t%d\n", e.getAdicionalAtkF());
            }

            if (e.getAdicionalAtkM() != 0){
                System.out.printf("|\tAtaque Mágico:\t%d\n", e.getAdicionalAtkM());
            }

            if (e.getAdicionalDF() != 0){
                System.out.printf("|\tDefesa Física:\t%d\n", e.getAdicionalDF());
            }

            if (e.getAdicionalDM() != 0){
                System.out.printf("|\tDefesa Mágica:\t%d\n", e.getAdicionalDM());
            }

            if (e.getAdicionalEsq() != 0){
                System.out.printf("|\tEsquiva:\t%d\n", e.getAdicionalEsq());
            }
        }
        
        //Adicionais comuns
        if (e.getAdicionalCon() != 0 || e.getAdicionalDex() != 0 
                || e.getAdicionalInt() != 0 || e.getAdicionalStr() != 0 
                || e.getAdicionalXP() != 0 || e.getAdicionalCrit() != 0){
            System.out.printf("|\n");
            System.out.printf("|------------------------------------------------------------\n");
            System.out.printf("|\n");
            System.out.printf("|\tAdicionais Incomuns:\n");
            System.out.printf("|\n");

            if (e.getAdicionalCon() != 0){
                System.out.printf("|\tConstituição:\t%d\n", e.getAdicionalCon());
            }

            if (e.getAdicionalDex() != 0){
                System.out.printf("|\tDestreza:\t%d\n", e.getAdicionalDex());
            }

            if (e.getAdicionalInt() != 0){
                System.out.printf("|\tInteligência:\t%d\n", e.getAdicionalInt());
            }
            
            if (e.getAdicionalStr() != 0){
                System.out.printf("|\tForça:\t\t%d\n", e.getAdicionalStr());
            }

            if (e.getAdicionalXP() != 0 ){
                System.out.printf("|\tExperiência:\t%d%%\n", e.getAdicionalXP());
            }
            
            if (e.getAdicionalCrit() != 0){
                System.out.printf("|\tCrítico:\t%d%%\n", e.getAdicionalCrit());
            }
            
            if (e.getAdicionalCrDmg() != 0){
                System.out.printf("|\tDano Crítico:\t%d%%\n", e.getAdicionalCrDmg());
            }
            
        }
        System.out.printf("|\n");
        System.out.printf("|------------------------------------------------------------\n");
    }
}
