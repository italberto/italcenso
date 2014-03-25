/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.domain;

import com.ital.censo.file.elements.Elemento;
import com.ital.censo.file.exceptions.ArquivoNaoEncontradoException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italberto
 */
public class NormalFile extends File{

    private BufferedWriter buffWrite;
    
    public NormalFile(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public Scanner openFileToRead() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(getCaminhoArquivo()));
            
        } catch (FileNotFoundException ex) {
            
        }
        
    return scanner;
    }

    @Override
    public void writeFile(String s) {
        
        try {
            
            buffWrite = new BufferedWriter(new FileWriter(getCaminhoArquivo()));
            buffWrite.append(s);
            buffWrite.close();
            
        } catch (IOException ex) {
            
        }
        
    }

   
    
    
}
