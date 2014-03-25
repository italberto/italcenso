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
public class ReaderSeletivo implements Reader<Elemento> {

    private String regex;
    private File file;

    public ReaderSeletivo(String regex) {
        this.regex = regex;
    }

    @Override
    public List<Elemento> getElements(File file) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.file = file;

        return executa();
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private List<Elemento> executa() {
        List<Elemento> retorno = new ArrayList<Elemento>();
        Scanner s = this.file.openFileToRead();

        while (s.hasNextLine()) {
            String linha = s.nextLine();
            if (linha.matches(this.regex)) {
                retorno.add(new Elemento(linha));
            }
        }

        return retorno;
    }

}
