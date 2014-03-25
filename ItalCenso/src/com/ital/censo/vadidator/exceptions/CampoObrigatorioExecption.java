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
public class CampoObrigatorioExecption extends Exception{
    
    public CampoObrigatorioExecption(){
        super("Campo obrigatório não preenchido.");
    }
    
    public CampoObrigatorioExecption(String campo){
        super("O campo "+ campo +" é de preencimento obrigatório.");
    }
}
