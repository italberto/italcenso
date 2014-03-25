/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.vadidator.exceptions;

/**
 *
 * @author italberto
 */
public class PreencimentoDeCampoException extends Exception{
    public PreencimentoDeCampoException(){
        super("Falta prencher alguma coisa por aqui, dá uma olhada melhor!");
    }
    
    
    public PreencimentoDeCampoException(String campo){
        super("Falta prencher o campo "+ campo +", dá uma olhada melhor!");
    }
}
