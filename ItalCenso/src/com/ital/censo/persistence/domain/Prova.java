/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author italberto
 */
@Entity
@Table(name="prova",schema = "ufpi_censo2013")
public class Prova implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="codigo_curso")
    private Integer codigoCurso;
    
    @Column(name="semestre_referencia")
    private Integer semestreReferencia;
    
    @Column(name = "id_vinulo_enviado")
    private Long idVinculoEnviado;

    @Column(name="seq")
    private Integer seq;
    
    public Prova(String cpf, Integer codigoCurso, Integer semestreReferencia, Long idVinculoEnviado,Integer seq) {
        this.cpf = cpf;
        this.codigoCurso = codigoCurso;
        this.semestreReferencia = semestreReferencia;
        this.idVinculoEnviado = idVinculoEnviado;
        this.seq = seq;
    }

    public Prova() {
    }

    public Prova(Long idVinculoEnviado) {
        this.idVinculoEnviado = idVinculoEnviado;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    
    
    
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIdVinculoEnviado() {
        return idVinculoEnviado;
    }

    public void setIdVinculoEnviado(Long idVinculoEnviado) {
        this.idVinculoEnviado = idVinculoEnviado;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getSemestreReferencia() {
        return semestreReferencia;
    }

    public void setSemestreReferencia(Integer semestreReferencia) {
        this.semestreReferencia = semestreReferencia;
    }

    
}
