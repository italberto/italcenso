/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.domain;

/**
 *
 * @author italberto
 */
public class DocenteVinculo extends Validable{
    
    
    private Integer tipoRegistro;
    private Integer codigoCurso;
    
    private Aluno Docente;
    
   
    
    public DocenteVinculo(){
        
    }

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Aluno getDocente() {
        return Docente;
    }

    public void setDocente(Aluno Docente) {
        this.Docente = Docente;
    }

    
    
    @Override
    protected boolean checkContent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean checkFill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean checkDependence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
