/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.file.readers;

import com.ital.censo.file.elements.Elemento;
import com.ital.censo.file.elements.ElementoComposto;
import com.ital.censo.file.domain.File;
import com.ital.censo.file.exceptions.ArquivoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italberto
 */
public class MasterDetailReader implements Reader<ElementoComposto> {

    private String regexMestre;
    private String regexDetalhe;

    private File file;

    public MasterDetailReader(String regexMestre, String regexDetalhe) {
        this.regexMestre = regexMestre;
        this.regexDetalhe = regexDetalhe;
    }

    @Override
    public List<ElementoComposto> getElements(File file) {

        this.file = file;
        List<ElementoComposto> retorno = null;
        try {
            
            retorno = executa();
            
        } catch (ArquivoNaoEncontradoException ex) {
            Logger.getLogger(MasterDetailReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private List<ElementoComposto> executa() throws ArquivoNaoEncontradoException {
        List<ElementoComposto> retorno = new ArrayList<ElementoComposto>();
        Scanner s = this.file.openFileToRead();

        if (!s.equals(null)) {
            boolean isMestre = false;
            ElementoComposto tmp = new ElementoComposto();
            ElementoComposto comparable = new ElementoComposto();

            while (s.hasNextLine()) {
                String atual = s.nextLine();

                if (atual.matches(this.regexMestre) && !isMestre) { //usado para o primeiro registro
                    isMestre = true;

                    if (!tmp.equals(comparable)) {
                        retorno.add(tmp);

                        tmp = new ElementoComposto();
                    }

                    tmp.setConteudo(atual);
                } else if (atual.matches(regexDetalhe) && isMestre) {
                    isMestre = false;

                    tmp.getElementos().add(new Elemento(atual));
                } else if (atual.matches(regexDetalhe) && !isMestre) {
                    isMestre = false;

                    tmp.getElementos().add(new Elemento(atual));
                }else if (atual.matches(regexMestre) && isMestre) { //usado caso não haja um elemento detalhe
                    isMestre = true;
                    
                    retorno.add(tmp);
                    tmp = new ElementoComposto();
                    
                    tmp.setConteudo(atual);
                }

            }
        } else {
            throw new ArquivoNaoEncontradoException();
        }
        return retorno;
    }

}
