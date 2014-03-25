/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.converter.spliter;

/**
 *
 * @author italberto
 */
public class DelimitedSpliter implements Spliter {

    private String delimiter;

    public DelimitedSpliter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String[] split(String s) {

        String[] retorno = null;
        if (s!=null) {
            retorno = s.split(delimiter);
        }

        return retorno;
    }

}
