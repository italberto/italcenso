/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.file.domain;

import com.ital.censo.vadidator.annotations.CampoDependente;
import com.ital.censo.vadidator.annotations.CampoObrigatorio;
import com.ital.censo.vadidator.annotations.ValoresPossiveis;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author italberto
 */
public class Docente extends Validable {

    @CampoObrigatorio
    @ValoresPossiveis(valores = {"31"})
    private Integer tipoRegistro;
    private String idIES;
    
    @CampoObrigatorio
    private String nome;
    
    @CampoObrigatorio
    private String cpf;
    private String documentoEstrangeiro;
    
    @CampoObrigatorio
    private Date dataNascimento;
    
    @CampoObrigatorio
    private Integer sexo;
    
    @CampoObrigatorio
    private Integer raca;
    private String nomeMae;
    
    @CampoObrigatorio
    private Integer nacionalidade;
    
    @CampoObrigatorio
    private String paisOrigem;
    private Integer ufNascimento;
    private Integer municipioNascimento;
    
    @CampoObrigatorio
    private Integer possuiDeficiencia;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaCegueira;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaBaixaVisao;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaSurdez;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaAuditiva;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaFisica;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaSurdocegueira;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaMultipla;
    
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaIntelectual;
    
    @CampoObrigatorio
    private Integer escolaridade;
    @CampoDependente(campoForte = "escolaridade", valorForteNecessario = "2",
            valorFracoObrigatorio = {"0","1","2","3"})
    private Integer posGraduacao;
    
    @CampoObrigatorio
    private Integer situacaoIES;
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer docenteExercicioFimAno;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"1","2","3","4"})
    private Integer regimeTrabalho;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer docenteSubstituto;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer docenteVisitante;
    
    @CampoDependente(campoForte = "docenteVisitante", valorForteNecessario = "1",
            valorFracoObrigatorio = {"1","2"})
    private Integer tipoVinculoDocenteVisitante;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoSequencial;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoPresencial;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoEAD;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoStrictoPresencial;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoStrictoEAD;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoPesquisa;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoExtensao;
    
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoGestao;
    
    @CampoDependente(campoForte = "atuacaoPesquisa", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer bolsaPesquisa;

    private List<DocenteVinculo> vinculos;

    public Docente() {
        this.vinculos = new ArrayList<>();
    }

    public Docente(Integer tipoRegistro, String idIES, String nome, String cpf, String documentoEstrangeiro, Date dataNascimento, Integer sexo, Integer raca, String nomeMae, Integer nacionalidade, String paisOrigem, Integer ufNascimento, Integer municipioNascimento, Integer possuiDeficiencia, Integer tipoDeficienciaCegueira, Integer tipoDeficienciaBaixaVisao, Integer tipoDeficienciaSurdez, Integer tipoDeficienciaAuditiva, Integer tipoDeficienciaFisica, Integer tipoDeficienciaSurdocegueira, Integer tipoDeficienciaMultipla, Integer tipoDeficienciaIntelectual, Integer escolaridade, Integer posGraduacao, Integer situacaoIES, Integer docenteExercicioFimAno, Integer regimeTrabalho, Integer docenteSubstituto, Integer docenteVisitante, Integer tipoVinculoDocenteVisitante, Integer atuacaoSequencial, Integer atuacaoPresencial, Integer atuacaoEAD, Integer atuacaoStrictoPresencial, Integer atuacaoStrictoEAD, Integer atuacaoPesquisa, Integer atuacaoExtensao, Integer atuacaoGestao, Integer bolsaPesquisa, List<DocenteVinculo> vinculos) {
        this.tipoRegistro = tipoRegistro;
        this.idIES = idIES;
        this.nome = nome;
        this.cpf = cpf;
        this.documentoEstrangeiro = documentoEstrangeiro;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.raca = raca;
        this.nomeMae = nomeMae;
        this.nacionalidade = nacionalidade;
        this.paisOrigem = paisOrigem;
        this.ufNascimento = ufNascimento;
        this.municipioNascimento = municipioNascimento;
        this.possuiDeficiencia = possuiDeficiencia;
        this.tipoDeficienciaCegueira = tipoDeficienciaCegueira;
        this.tipoDeficienciaBaixaVisao = tipoDeficienciaBaixaVisao;
        this.tipoDeficienciaSurdez = tipoDeficienciaSurdez;
        this.tipoDeficienciaAuditiva = tipoDeficienciaAuditiva;
        this.tipoDeficienciaFisica = tipoDeficienciaFisica;
        this.tipoDeficienciaSurdocegueira = tipoDeficienciaSurdocegueira;
        this.tipoDeficienciaMultipla = tipoDeficienciaMultipla;
        this.tipoDeficienciaIntelectual = tipoDeficienciaIntelectual;
        this.escolaridade = escolaridade;
        this.posGraduacao = posGraduacao;
        this.situacaoIES = situacaoIES;
        this.docenteExercicioFimAno = docenteExercicioFimAno;
        this.regimeTrabalho = regimeTrabalho;
        this.docenteSubstituto = docenteSubstituto;
        this.docenteVisitante = docenteVisitante;
        this.tipoVinculoDocenteVisitante = tipoVinculoDocenteVisitante;
        this.atuacaoSequencial = atuacaoSequencial;
        this.atuacaoPresencial = atuacaoPresencial;
        this.atuacaoEAD = atuacaoEAD;
        this.atuacaoStrictoPresencial = atuacaoStrictoPresencial;
        this.atuacaoStrictoEAD = atuacaoStrictoEAD;
        this.atuacaoPesquisa = atuacaoPesquisa;
        this.atuacaoExtensao = atuacaoExtensao;
        this.atuacaoGestao = atuacaoGestao;
        this.bolsaPesquisa = bolsaPesquisa;
        this.vinculos = vinculos;
        
         this.vinculos = new ArrayList<>();
    }

    
    
    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getIdIES() {
        return idIES;
    }

    public void setIdIES(String idIES) {
        this.idIES = idIES;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDocumentoEstrangeiro() {
        return documentoEstrangeiro;
    }

    public void setDocumentoEstrangeiro(String documentoEstrangeiro) {
        this.documentoEstrangeiro = documentoEstrangeiro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getRaca() {
        return raca;
    }

    public void setRaca(Integer raca) {
        this.raca = raca;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Integer getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Integer nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Integer getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(Integer ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public Integer getMunicipioNascimento() {
        return municipioNascimento;
    }

    public void setMunicipioNascimento(Integer municipioNascimento) {
        this.municipioNascimento = municipioNascimento;
    }

    public Integer getPossuiDeficiencia() {
        return possuiDeficiencia;
    }

    public void setPossuiDeficiencia(Integer possuiDeficiencia) {
        this.possuiDeficiencia = possuiDeficiencia;
    }

    public Integer getTipoDeficienciaCegueira() {
        return tipoDeficienciaCegueira;
    }

    public void setTipoDeficienciaCegueira(Integer tipoDeficienciaCegueira) {
        this.tipoDeficienciaCegueira = tipoDeficienciaCegueira;
    }

    public Integer getTipoDeficienciaBaixaVisao() {
        return tipoDeficienciaBaixaVisao;
    }

    public void setTipoDeficienciaBaixaVisao(Integer tipoDeficienciaBaixaVisao) {
        this.tipoDeficienciaBaixaVisao = tipoDeficienciaBaixaVisao;
    }

    public Integer getTipoDeficienciaSurdez() {
        return tipoDeficienciaSurdez;
    }

    public void setTipoDeficienciaSurdez(Integer tipoDeficienciaSurdez) {
        this.tipoDeficienciaSurdez = tipoDeficienciaSurdez;
    }

    public Integer getTipoDeficienciaAuditiva() {
        return tipoDeficienciaAuditiva;
    }

    public void setTipoDeficienciaAuditiva(Integer tipoDeficienciaAuditiva) {
        this.tipoDeficienciaAuditiva = tipoDeficienciaAuditiva;
    }

    public Integer getTipoDeficienciaFisica() {
        return tipoDeficienciaFisica;
    }

    public void setTipoDeficienciaFisica(Integer tipoDeficienciaFisica) {
        this.tipoDeficienciaFisica = tipoDeficienciaFisica;
    }

    public Integer getTipoDeficienciaSurdocegueira() {
        return tipoDeficienciaSurdocegueira;
    }

    public void setTipoDeficienciaSurdocegueira(Integer tipoDeficienciaSurdocegueira) {
        this.tipoDeficienciaSurdocegueira = tipoDeficienciaSurdocegueira;
    }

    public Integer getTipoDeficienciaMultipla() {
        return tipoDeficienciaMultipla;
    }

    public void setTipoDeficienciaMultipla(Integer tipoDeficienciaMultipla) {
        this.tipoDeficienciaMultipla = tipoDeficienciaMultipla;
    }

    public Integer getTipoDeficienciaIntelectual() {
        return tipoDeficienciaIntelectual;
    }

    public void setTipoDeficienciaIntelectual(Integer tipoDeficienciaIntelectual) {
        this.tipoDeficienciaIntelectual = tipoDeficienciaIntelectual;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Integer getPosGraduacao() {
        return posGraduacao;
    }

    public void setPosGraduacao(Integer posGraduacao) {
        this.posGraduacao = posGraduacao;
    }

    public Integer getSituacaoIES() {
        return situacaoIES;
    }

    public void setSituacaoIES(Integer situacaoIES) {
        this.situacaoIES = situacaoIES;
    }

    public Integer getDocenteExercicioFimAno() {
        return docenteExercicioFimAno;
    }

    public void setDocenteExercicioFimAno(Integer docenteExercicioFimAno) {
        this.docenteExercicioFimAno = docenteExercicioFimAno;
    }

    public Integer getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(Integer regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public Integer getDocenteSubstituto() {
        return docenteSubstituto;
    }

    public void setDocenteSubstituto(Integer docenteSubstituto) {
        this.docenteSubstituto = docenteSubstituto;
    }

    public Integer getDocenteVisitante() {
        return docenteVisitante;
    }

    public void setDocenteVisitante(Integer docenteVisitante) {
        this.docenteVisitante = docenteVisitante;
    }

    public Integer getTipoVinculoDocenteVisitante() {
        return tipoVinculoDocenteVisitante;
    }

    public void setTipoVinculoDocenteVisitante(Integer tipoVinculoDocenteVisitante) {
        this.tipoVinculoDocenteVisitante = tipoVinculoDocenteVisitante;
    }

    public Integer getAtuacaoSequencial() {
        return atuacaoSequencial;
    }

    public void setAtuacaoSequencial(Integer atuacaoSequencial) {
        this.atuacaoSequencial = atuacaoSequencial;
    }

    public Integer getAtuacaoPresencial() {
        return atuacaoPresencial;
    }

    public void setAtuacaoPresencial(Integer atuacaoPresencial) {
        this.atuacaoPresencial = atuacaoPresencial;
    }

    public Integer getAtuacaoEAD() {
        return atuacaoEAD;
    }

    public void setAtuacaoEAD(Integer atuacaoEAD) {
        this.atuacaoEAD = atuacaoEAD;
    }

    public Integer getAtuacaoStrictoPresencial() {
        return atuacaoStrictoPresencial;
    }

    public void setAtuacaoStrictoPresencial(Integer atuacaoStrictoPresencial) {
        this.atuacaoStrictoPresencial = atuacaoStrictoPresencial;
    }

    public Integer getAtuacaoStrictoEAD() {
        return atuacaoStrictoEAD;
    }

    public void setAtuacaoStrictoEAD(Integer atuacaoStrictoEAD) {
        this.atuacaoStrictoEAD = atuacaoStrictoEAD;
    }

    public Integer getAtuacaoPesquisa() {
        return atuacaoPesquisa;
    }

    public void setAtuacaoPesquisa(Integer atuacaoPesquisa) {
        this.atuacaoPesquisa = atuacaoPesquisa;
    }

    public Integer getAtuacaoExtensao() {
        return atuacaoExtensao;
    }

    public void setAtuacaoExtensao(Integer atuacaoExtensao) {
        this.atuacaoExtensao = atuacaoExtensao;
    }

    public Integer getAtuacaoGestao() {
        return atuacaoGestao;
    }

    public void setAtuacaoGestao(Integer atuacaoGestao) {
        this.atuacaoGestao = atuacaoGestao;
    }

    public Integer getBolsaPesquisa() {
        return bolsaPesquisa;
    }

    public void setBolsaPesquisa(Integer bolsaPesquisa) {
        this.bolsaPesquisa = bolsaPesquisa;
    }

    public List<DocenteVinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<DocenteVinculo> vinculos) {
        this.vinculos = vinculos;
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
