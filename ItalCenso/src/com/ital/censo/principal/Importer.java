/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.principal;

import com.ital.censo.converter.spliter.DelimitedSpliter;
import com.ital.censo.converter.spliter.Spliter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italberto
 */
public abstract class Importer<Type> {

    private String delimitadorMaster;
    private String delimitadorDetalhe;

    public Importer() {
    }

    public Importer(String delimitadorMaster, String delimitadorDetalhe) {
        this.delimitadorMaster = delimitadorMaster;
        this.delimitadorDetalhe = delimitadorDetalhe;
    }

    public abstract List<Type> executar(String caminhoArquivo);

    protected List<String> desmembrarLinhas(String str) {
        List<String> retorno = new ArrayList<>();

        if (str!=null) {
            Spliter spliter = new DelimitedSpliter("\\|");
            String[] campos = spliter.split(str);

            for (String campo : campos) {
                retorno.add(campo);
            }
        }
        return retorno;
    }

    public String getDelimitadorMaster() {
        return delimitadorMaster;
    }

    public void setDelimitadorMaster(String delimitadorMaster) {
        this.delimitadorMaster = delimitadorMaster;
    }

    public String getDelimitadorDetalhe() {
        return delimitadorDetalhe;
    }

    public void setDelimitadorDetalhe(String delimitadorDetalhe) {
        this.delimitadorDetalhe = delimitadorDetalhe;
    }

}
