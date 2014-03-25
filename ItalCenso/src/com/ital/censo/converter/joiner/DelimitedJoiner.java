/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.converter.joiner;

/**
 *
 * @author italberto
 */
public class DelimitedJoiner implements Joiner{

    private String delimiter;
    
    public DelimitedJoiner(String delimiter){
        this.delimiter = delimiter;
    }
    
    @Override
    public String join(String[] s) {
        StringBuilder retorno = new StringBuilder();
        
        for (int i=0;i<s.length;i++){
            
            retorno.append(s[i]);
        
            if (i<s.length-1){
                retorno.append(delimiter);
            }
        }
        
        return retorno.toString();
    }
    
}
