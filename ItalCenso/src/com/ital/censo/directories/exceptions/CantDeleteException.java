/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.directories.exceptions;

/**
 *
 * @author italberto
 */
public class CantDeleteException extends Exception{

    public CantDeleteException() {
        super("Não foi possível apagar o arquivo desejado.");
    }
    
    
}
