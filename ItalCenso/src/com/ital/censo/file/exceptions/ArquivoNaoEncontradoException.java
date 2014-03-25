/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.exceptions;

import java.io.FileNotFoundException;

/**
 *
 * @author italberto
 */
public class ArquivoNaoEncontradoException extends FileNotFoundException{

    public ArquivoNaoEncontradoException(){
        super("Não foi possível abrir o arquivo solicitado."
                + " Verifique se o caminho está correto.");
    }
    
}
