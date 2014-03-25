/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author italberto
 */
public class ElementoComposto extends Elemento{
    
    private List<Elemento> elementos;

    
    public ElementoComposto(){
        super();
        elementos = new ArrayList<>();
    }
    
    public ElementoComposto(String conteudo){
        super(conteudo);
        elementos = new ArrayList<>();
    }
    
    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder("");
        retorno.append(this.getConteudo()).append("\n");
        for (Elemento elemento : elementos) {
            retorno.append(elemento).append("\n");
        }
        return retorno.toString();
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.elementos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ElementoComposto other = (ElementoComposto) obj;
        if (!Objects.equals(this.elementos, other.elementos)) {
            return false;
        }
        return true;
    }
    
    
    
}
