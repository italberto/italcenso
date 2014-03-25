/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.directories.exceptions;

/**
 *
 * @author italberto
 */
public class FileExistsException extends Exception{

    public FileExistsException(){
        super("O arquivo já existe. Tente outro nome.");
    }
    
    
}
