/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author italberto
 */
@Entity
@Table(name="t_docente_ocor",schema = "ufpi_censo2013")
//@Table(name="docente_vinculo",schema = "ufpi_censo2013")
public class DocenteVinculo {
    
    @Id
//    @Column(name = "docente_vinculo_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
//    @Column(name="tipo_registro")
    private Integer tipoRegistro;
    
//    @Column(name="codigo_curso")
    private Integer codigoCurso;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_servidor")
    private Docente docente;

    public DocenteVinculo(){
        
    }
    
    public DocenteVinculo(Long id, Integer tipoRegistro, Integer codigoCurso) {
        this.id = id;
        this.tipoRegistro = tipoRegistro;
        this.codigoCurso = codigoCurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final DocenteVinculo other = (DocenteVinculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        
        retorno.append(this.getTipoRegistro()).append("|");
        retorno.append(this.getCodigoCurso());
        
        return retorno.toString();

    }

    
    
    
}
