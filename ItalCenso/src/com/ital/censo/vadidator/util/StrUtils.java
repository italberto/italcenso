/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.vadidator.util;

/**
 *
 * @author italberto
 * @description Classe para realizar diversas oeprações em objetos do tipo
 * String.
 */
public class StrUtils {

    /**
     * Capitaliza uma string, deixando as outras letras minúsculas.
     * @param String
     * @return String
     */
    public static String capitalizeString(String str) {
        String out = "";
        
        if (str!=null && !str.equals("")){
            String first = str.charAt(0)+"";
            first = first.toUpperCase();
            out = out.concat(first).concat(str.substring(1, str.length()));
        }
        
        return out;
    }
    
    public static String arrayToString(String[] array){
        String result = "{";
        for (String string : array) {
            result += string + ","; 
        }
        result += "}";
        
        return result.replace(",}", "}");
    }
}
