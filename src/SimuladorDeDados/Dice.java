/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimuladorDeDados;

import Excecoes.NotPositiveNumberOfFacesException;
import Excecoes.NotPositiveNumberOfDicesException;
import java.util.Random;

/**
 *
 * @author Pedro Gabriel Drumond Pereira
 */

public class Dice {
    private static final Random geradorAleatorio = new Random();

    public static int rolagem(int faces){
        return (geradorAleatorio.nextInt(faces) + 1);
    }
    
    public static int multiplaRolagem (int numeroDeDados, int facesDeCadaDado) {        
        if (numeroDeDados <= 0){
            throw new NotPositiveNumberOfDicesException();
        } else if (facesDeCadaDado <= 0){
            throw new NotPositiveNumberOfFacesException();
        } else {
            int retorno = 0;
            
            for (int i = 0; i < numeroDeDados; i++){
                retorno += Dice.rolagem(facesDeCadaDado);
            }
            return retorno;
        }
    }
}
