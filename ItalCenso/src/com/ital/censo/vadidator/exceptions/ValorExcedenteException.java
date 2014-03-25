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
public class ValorExcedenteException extends Exception{
    public ValorExcedenteException(){
        super("Você está colocando valores onde não deve. Preste mais atenção sua besta!");
    }
    
    public ValorExcedenteException(String campo, String campoForte, String valorForteNecessario){
        super("O campo " + campo + " não deve ser preenchido, pois necessita que o campo " + 
                campoForte + " tenha o valor " + valorForteNecessario + ".");
        
    }
}
