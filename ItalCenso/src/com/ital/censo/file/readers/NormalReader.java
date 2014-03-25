/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.readers;

import com.ital.censo.file.elements.Elemento;
import com.ital.censo.file.domain.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author italberto
 */
public class NormalReader implements Reader<Elemento>{

    private File file;

    
    public List<Elemento> getElements(File file) {
        this.file = file;
        return executaLeitura();
        
    }

    private List<Elemento> executaLeitura() {
        List<Elemento> retorno = new ArrayList<>();
        Scanner s = file.openFileToRead();
        
        while (s.hasNextLine()){
            retorno.add(new Elemento(s.nextLine()));
        }
        
        return retorno;
    }
    
}
