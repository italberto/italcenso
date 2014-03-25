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
public class ValorInvalidoException extends Exception{
//    public ValorInvalidoException(){
//        super("Valor de campo inválido.");
//    }
//    
    public ValorInvalidoException(String campo, String valoresValidos){
        super("Os valores válidos para o campo " + campo + " são: " + valoresValidos);
    }
}
