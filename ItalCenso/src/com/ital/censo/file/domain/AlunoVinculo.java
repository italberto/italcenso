/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.file.domain;

import com.ital.censo.vadidator.annotations.CampoDependente;
import com.ital.censo.vadidator.annotations.CampoObrigatorio;
import com.ital.censo.vadidator.annotations.ValoresPossiveis;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author italberto
 */
public class AlunoVinculo extends Validable {

    private Aluno aluno;

    @CampoObrigatorio
    @ValoresPossiveis(valores = {"42"})
    private Integer tipoRegistro;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"1","2"})
    private Integer semestreReferencia;
    
    @CampoObrigatorio
    private Integer codigoCurso;
    
    private Integer codigoPoloEad;
    
    @ValoresPossiveis(valores = {"1","2","3","4"})
    private Integer turno;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"2","3","4","5","6","7"})
    private Integer situacaoVinculo;
    
    @CampoDependente(campoForte = "situacaoVinculo",valorForteNecessario = "5")
    private Integer cursoOrigem;
    
    
    @CampoDependente(campoForte = "situacaoVinculo",valorForteNecessario = "6")
    private Integer semestreConclusao;
    
    private Integer alunoParfor;
    
    @CampoObrigatorio
    private String  dataIngressoCurso;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1","2"})
    private Integer tipoEscolaEnsinoMedio;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoVestibular;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoEnem;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoSeriada;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoOutraSelecao;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoPECG;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoEXOfficio;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoJudicial;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoOutra;
    
    @CampoDependente(campoForte = "situacaoVinculo",valorForteNecessario = "2",valorFracoObrigatorio = {"0","1"})
    private Integer mobilidadeAcademica;
    
    @CampoDependente(campoForte = "mobilidadeAcademica",valorForteNecessario = "1",valorFracoObrigatorio = {"1","2"})
    private Integer tipoMobilidadeAcademica;
    
    @CampoDependente(campoForte = "tipoMobilidadeAcademica",valorForteNecessario = "1")
    private Integer iesDestino;
    
    @CampoDependente(campoForte = "tipoMobilidadeAcademica",valorForteNecessario = "2",valorFracoObrigatorio = {"1","2"})
    private Integer tipoMobilidadeAcademicaInternacional;
    
    @CampoDependente(campoForte = "tipoMobilidadeAcademica",valorForteNecessario = "2")
    private String  paisDestino;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer programaReservaVagas;
    
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaEtnico;
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaDeficiencia;
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaEscolaPublica;
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaSocial;
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaOutros;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0"})//esse valor é fixo pois trata-se de instituição federal.
    private Integer financiamentoEstudantil;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoFIES;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoEstadual;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoMunicipal;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoIES;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoEntidadesExternas;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoProUniIntegralNR;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoProUniParcialNR;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoEntidadesExternasNR;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoEstadualNR;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoIesNR;
    
    @CampoDependente(campoForte = "financiamentoEstudantil",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer financiamentoMunicipalNR;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer apoioSocial;
    
    @CampoDependente(campoForte = "apoioSocial",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer tipoApoioSocialAlimentacao;
    
    @CampoDependente(campoForte = "apoioSocial",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer tipoApoioSocialMoradia;
    
    @CampoDependente(campoForte = "apoioSocial",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer tipoApoioSocialTransporte;
    
    @CampoDependente(campoForte = "apoioSocial",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer tipoApoioSocialMaterialDidatico;
    
    @CampoDependente(campoForte = "apoioSocial",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer tipoApoioSocialBolsaTrabalho;
    
    @CampoDependente(campoForte = "apoioSocial",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer tipoApoioSocialBolsaPermanencia;
    
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer atividadeExtracurricular;
    
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeExtracurricularPesquisa;
    
    @CampoDependente(campoForte = "atividadeExtracurricularPesquisa",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaPesquisa;
    
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeExtensao;
    
    @CampoDependente(campoForte = "atividadeExtensao",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaExtensao;
    
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeMonitoria;
    
    @CampoDependente(campoForte = "atividadeMonitoria",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaMonitoria;
    
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeEstagioObrigatorio;
    
    @CampoDependente(campoForte = "atividadeEstagioObrigatorio",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaEstagioObrigatorio;

    public AlunoVinculo() {

    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Integer getSemestreReferencia() {
        return semestreReferencia;
    }

    public void setSemestreReferencia(Integer semestreReferencia) {
        this.semestreReferencia = semestreReferencia;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getCodigoPoloEad() {
        return codigoPoloEad;
    }

    public void setCodigoPoloEad(Integer codigoPoloEad) {
        this.codigoPoloEad = codigoPoloEad;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public Integer getSituacaoVinculo() {
        return situacaoVinculo;
    }

    public void setSituacaoVinculo(Integer situacaoVinculo) {
        this.situacaoVinculo = situacaoVinculo;
    }

    public Integer getCursoOrigem() {
        return cursoOrigem;
    }

    public void setCursoOrigem(Integer cursoOrigem) {
        this.cursoOrigem = cursoOrigem;
    }

    public Integer getSemestreConclusao() {
        return semestreConclusao;
    }

    public void setSemestreConclusao(Integer semestreConclusao) {
        this.semestreConclusao = semestreConclusao;
    }

    public Integer getAlunoParfor() {
        return alunoParfor;
    }

    public void setAlunoParfor(Integer alunoParfor) {
        this.alunoParfor = alunoParfor;
    }

    public String getDataIngressoCurso() {
        return dataIngressoCurso;
    }

    public void setDataIngressoCurso(String dataIngressoCurso) {
        this.dataIngressoCurso = dataIngressoCurso;
    }

    public Integer getTipoEscolaEnsinoMedio() {
        return tipoEscolaEnsinoMedio;
    }

    public void setTipoEscolaEnsinoMedio(Integer tipoEscolaEnsinoMedio) {
        this.tipoEscolaEnsinoMedio = tipoEscolaEnsinoMedio;
    }

    public Integer getFormaIngressoVestibular() {
        return formaIngressoVestibular;
    }

    public void setFormaIngressoVestibular(Integer formaIngressoVestibular) {
        this.formaIngressoVestibular = formaIngressoVestibular;
    }

    public Integer getFormaIngressoEnem() {
        return formaIngressoEnem;
    }

    public void setFormaIngressoEnem(Integer formaIngressoEnem) {
        this.formaIngressoEnem = formaIngressoEnem;
    }

    public Integer getFormaIngressoSeriada() {
        return formaIngressoSeriada;
    }

    public void setFormaIngressoSeriada(Integer formaIngressoSeriada) {
        this.formaIngressoSeriada = formaIngressoSeriada;
    }

    public Integer getFormaIngressoOutraSelecao() {
        return formaIngressoOutraSelecao;
    }

    public void setFormaIngressoOutraSelecao(Integer formaIngressoOutraSelecao) {
        this.formaIngressoOutraSelecao = formaIngressoOutraSelecao;
    }

    public Integer getFormaIngressoPECG() {
        return formaIngressoPECG;
    }

    public void setFormaIngressoPECG(Integer formaIngressoPECG) {
        this.formaIngressoPECG = formaIngressoPECG;
    }

    public Integer getFormaIngressoEXOfficio() {
        return formaIngressoEXOfficio;
    }

    public void setFormaIngressoEXOfficio(Integer formaIngressoEXOfficio) {
        this.formaIngressoEXOfficio = formaIngressoEXOfficio;
    }

    public Integer getFormaIngressoJudicial() {
        return formaIngressoJudicial;
    }

    public void setFormaIngressoJudicial(Integer formaIngressoJudicial) {
        this.formaIngressoJudicial = formaIngressoJudicial;
    }

    public Integer getFormaIngressoOutra() {
        return formaIngressoOutra;
    }

    public void setFormaIngressoOutra(Integer formaIngressoOutra) {
        this.formaIngressoOutra = formaIngressoOutra;
    }

    public Integer getMobilidadeAcademica() {
        return mobilidadeAcademica;
    }

    public void setMobilidadeAcademica(Integer mobilidadeAcademica) {
        this.mobilidadeAcademica = mobilidadeAcademica;
    }

    public Integer getTipoMobilidadeAcademica() {
        return tipoMobilidadeAcademica;
    }

    public void setTipoMobilidadeAcademica(Integer tipoMobilidadeAcademica) {
        this.tipoMobilidadeAcademica = tipoMobilidadeAcademica;
    }

    public Integer getIesDestino() {
        return iesDestino;
    }

    public void setIesDestino(Integer iesDestino) {
        this.iesDestino = iesDestino;
    }

    public Integer getTipoMobilidadeAcademicaInternacional() {
        return tipoMobilidadeAcademicaInternacional;
    }

    public void setTipoMobilidadeAcademicaInternacional(Integer tipoMobilidadeAcademicaInternacional) {
        this.tipoMobilidadeAcademicaInternacional = tipoMobilidadeAcademicaInternacional;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public Integer getProgramaReservaVagas() {
        return programaReservaVagas;
    }

    public void setProgramaReservaVagas(Integer programaReservaVagas) {
        this.programaReservaVagas = programaReservaVagas;
    }

    public Integer getProgramaReservaEtnico() {
        return programaReservaEtnico;
    }

    public void setProgramaReservaEtnico(Integer programaReservaEtnico) {
        this.programaReservaEtnico = programaReservaEtnico;
    }

    public Integer getProgramaReservaDeficiencia() {
        return programaReservaDeficiencia;
    }

    public void setProgramaReservaDeficiencia(Integer programaReservaDeficiencia) {
        this.programaReservaDeficiencia = programaReservaDeficiencia;
    }

    public Integer getProgramaReservaEscolaPublica() {
        return programaReservaEscolaPublica;
    }

    public void setProgramaReservaEscolaPublica(Integer programaReservaEscolaPublica) {
        this.programaReservaEscolaPublica = programaReservaEscolaPublica;
    }

    public Integer getProgramaReservaSocial() {
        return programaReservaSocial;
    }

    public void setProgramaReservaSocial(Integer programaReservaSocial) {
        this.programaReservaSocial = programaReservaSocial;
    }

    public Integer getProgramaReservaOutros() {
        return programaReservaOutros;
    }

    public void setProgramaReservaOutros(Integer programaReservaOutros) {
        this.programaReservaOutros = programaReservaOutros;
    }

    public Integer getFinanciamentoEstudantil() {
        return financiamentoEstudantil;
    }

    public void setFinanciamentoEstudantil(Integer financiamentoEstudantil) {
        this.financiamentoEstudantil = financiamentoEstudantil;
    }

    public Integer getFinanciamentoFIES() {
        return financiamentoFIES;
    }

    public void setFinanciamentoFIES(Integer financiamentoFIES) {
        this.financiamentoFIES = financiamentoFIES;
    }

    public Integer getFinanciamentoEstadual() {
        return financiamentoEstadual;
    }

    public void setFinanciamentoEstadual(Integer financiamentoEstadual) {
        this.financiamentoEstadual = financiamentoEstadual;
    }

    public Integer getFinanciamentoMunicipal() {
        return financiamentoMunicipal;
    }

    public void setFinanciamentoMunicipal(Integer financiamentoMunicipal) {
        this.financiamentoMunicipal = financiamentoMunicipal;
    }

    public Integer getFinanciamentoIES() {
        return financiamentoIES;
    }

    public void setFinanciamentoIES(Integer financiamentoIES) {
        this.financiamentoIES = financiamentoIES;
    }

    public Integer getFinanciamentoEntidadesExternas() {
        return financiamentoEntidadesExternas;
    }

    public void setFinanciamentoEntidadesExternas(Integer financiamentoEntidadesExternas) {
        this.financiamentoEntidadesExternas = financiamentoEntidadesExternas;
    }

    public Integer getFinanciamentoProUniIntegralNR() {
        return financiamentoProUniIntegralNR;
    }

    public void setFinanciamentoProUniIntegralNR(Integer financiamentoProUniIntegralNR) {
        this.financiamentoProUniIntegralNR = financiamentoProUniIntegralNR;
    }

    public Integer getFinanciamentoProUniParcialNR() {
        return financiamentoProUniParcialNR;
    }

    public void setFinanciamentoProUniParcialNR(Integer financiamentoProUniParcialNR) {
        this.financiamentoProUniParcialNR = financiamentoProUniParcialNR;
    }

    public Integer getFinanciamentoEntidadesExternasNR() {
        return financiamentoEntidadesExternasNR;
    }

    public void setFinanciamentoEntidadesExternasNR(Integer financiamentoEntidadesExternasNR) {
        this.financiamentoEntidadesExternasNR = financiamentoEntidadesExternasNR;
    }

    public Integer getFinanciamentoEstadualNR() {
        return financiamentoEstadualNR;
    }

    public void setFinanciamentoEstadualNR(Integer financiamentoEstadualNR) {
        this.financiamentoEstadualNR = financiamentoEstadualNR;
    }

    public Integer getFinanciamentoIesNR() {
        return financiamentoIesNR;
    }

    public void setFinanciamentoIesNR(Integer financiamentoIesNR) {
        this.financiamentoIesNR = financiamentoIesNR;
    }

    public Integer getFinanciamentoMunicipalNR() {
        return financiamentoMunicipalNR;
    }

    public void setFinanciamentoMunicipalNR(Integer financiamentoMunicipalNR) {
        this.financiamentoMunicipalNR = financiamentoMunicipalNR;
    }

    public Integer getApoioSocial() {
        return apoioSocial;
    }

    public void setApoioSocial(Integer apoioSocial) {
        this.apoioSocial = apoioSocial;
    }

    public Integer getTipoApoioSocialAlimentacao() {
        return tipoApoioSocialAlimentacao;
    }

    public void setTipoApoioSocialAlimentacao(Integer tipoApoioSocialAlimentacao) {
        this.tipoApoioSocialAlimentacao = tipoApoioSocialAlimentacao;
    }

    public Integer getTipoApoioSocialMoradia() {
        return tipoApoioSocialMoradia;
    }

    public void setTipoApoioSocialMoradia(Integer tipoApoioSocialMoradia) {
        this.tipoApoioSocialMoradia = tipoApoioSocialMoradia;
    }

    public Integer getTipoApoioSocialTransporte() {
        return tipoApoioSocialTransporte;
    }

    public void setTipoApoioSocialTransporte(Integer tipoApoioSocialTransporte) {
        this.tipoApoioSocialTransporte = tipoApoioSocialTransporte;
    }

    public Integer getTipoApoioSocialMaterialDidatico() {
        return tipoApoioSocialMaterialDidatico;
    }

    public void setTipoApoioSocialMaterialDidatico(Integer tipoApoioSocialMaterialDidatico) {
        this.tipoApoioSocialMaterialDidatico = tipoApoioSocialMaterialDidatico;
    }

    public Integer getTipoApoioSocialBolsaTrabalho() {
        return tipoApoioSocialBolsaTrabalho;
    }

    public void setTipoApoioSocialBolsaTrabalho(Integer tipoApoioSocialBolsaTrabalho) {
        this.tipoApoioSocialBolsaTrabalho = tipoApoioSocialBolsaTrabalho;
    }

    public Integer getTipoApoioSocialBolsaPermanencia() {
        return tipoApoioSocialBolsaPermanencia;
    }

    public void setTipoApoioSocialBolsaPermanencia(Integer tipoApoioSocialBolsaPermanencia) {
        this.tipoApoioSocialBolsaPermanencia = tipoApoioSocialBolsaPermanencia;
    }

    public Integer getAtividadeExtracurricular() {
        return atividadeExtracurricular;
    }

    public void setAtividadeExtracurricular(Integer atividadeExtracurricular) {
        this.atividadeExtracurricular = atividadeExtracurricular;
    }

    public Integer getAtividadeExtracurricularPesquisa() {
        return atividadeExtracurricularPesquisa;
    }

    public void setAtividadeExtracurricularPesquisa(Integer atividadeExtracurricularPesquisa) {
        this.atividadeExtracurricularPesquisa = atividadeExtracurricularPesquisa;
    }

    public Integer getBolsaPesquisa() {
        return bolsaPesquisa;
    }

    public void setBolsaPesquisa(Integer bolsaPesquisa) {
        this.bolsaPesquisa = bolsaPesquisa;
    }

    public Integer getAtividadeExtensao() {
        return atividadeExtensao;
    }

    public void setAtividadeExtensao(Integer atividadeExtensao) {
        this.atividadeExtensao = atividadeExtensao;
    }

    public Integer getBolsaExtensao() {
        return bolsaExtensao;
    }

    public void setBolsaExtensao(Integer bolsaExtensao) {
        this.bolsaExtensao = bolsaExtensao;
    }

    public Integer getAtividadeMonitoria() {
        return atividadeMonitoria;
    }

    public void setAtividadeMonitoria(Integer atividadeMonitoria) {
        this.atividadeMonitoria = atividadeMonitoria;
    }

    public Integer getBolsaMonitoria() {
        return bolsaMonitoria;
    }

    public void setBolsaMonitoria(Integer bolsaMonitoria) {
        this.bolsaMonitoria = bolsaMonitoria;
    }

    public Integer getAtividadeEstagioObrigatorio() {
        return atividadeEstagioObrigatorio;
    }

    public void setAtividadeEstagioObrigatorio(Integer atividadeEstagioObrigatorio) {
        this.atividadeEstagioObrigatorio = atividadeEstagioObrigatorio;
    }

    public Integer getBolsaEstagioObrigatorio() {
        return bolsaEstagioObrigatorio;
    }

    public void setBolsaEstagioObrigatorio(Integer bolsaEstagioObrigatorio) {
        this.bolsaEstagioObrigatorio = bolsaEstagioObrigatorio;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.aluno);
        hash = 79 * hash + Objects.hashCode(this.tipoRegistro);
        hash = 79 * hash + Objects.hashCode(this.semestreReferencia);
        hash = 79 * hash + Objects.hashCode(this.codigoCurso);
        hash = 79 * hash + Objects.hashCode(this.codigoPoloEad);
        hash = 79 * hash + Objects.hashCode(this.turno);
        hash = 79 * hash + Objects.hashCode(this.situacaoVinculo);
        hash = 79 * hash + Objects.hashCode(this.cursoOrigem);
        hash = 79 * hash + Objects.hashCode(this.semestreConclusao);
        hash = 79 * hash + Objects.hashCode(this.alunoParfor);
        hash = 79 * hash + Objects.hashCode(this.dataIngressoCurso);
        hash = 79 * hash + Objects.hashCode(this.tipoEscolaEnsinoMedio);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoVestibular);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoEnem);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoSeriada);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoOutraSelecao);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoPECG);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoEXOfficio);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoJudicial);
        hash = 79 * hash + Objects.hashCode(this.formaIngressoOutra);
        hash = 79 * hash + Objects.hashCode(this.mobilidadeAcademica);
        hash = 79 * hash + Objects.hashCode(this.tipoMobilidadeAcademica);
        hash = 79 * hash + Objects.hashCode(this.iesDestino);
        hash = 79 * hash + Objects.hashCode(this.tipoMobilidadeAcademicaInternacional);
        hash = 79 * hash + Objects.hashCode(this.paisDestino);
        hash = 79 * hash + Objects.hashCode(this.programaReservaVagas);
        hash = 79 * hash + Objects.hashCode(this.programaReservaEtnico);
        hash = 79 * hash + Objects.hashCode(this.programaReservaDeficiencia);
        hash = 79 * hash + Objects.hashCode(this.programaReservaEscolaPublica);
        hash = 79 * hash + Objects.hashCode(this.programaReservaSocial);
        hash = 79 * hash + Objects.hashCode(this.programaReservaOutros);
        hash = 79 * hash + Objects.hashCode(this.financiamentoEstudantil);
        hash = 79 * hash + Objects.hashCode(this.financiamentoFIES);
        hash = 79 * hash + Objects.hashCode(this.financiamentoEstadual);
        hash = 79 * hash + Objects.hashCode(this.financiamentoMunicipal);
        hash = 79 * hash + Objects.hashCode(this.financiamentoIES);
        hash = 79 * hash + Objects.hashCode(this.financiamentoEntidadesExternas);
        hash = 79 * hash + Objects.hashCode(this.financiamentoProUniIntegralNR);
        hash = 79 * hash + Objects.hashCode(this.financiamentoProUniParcialNR);
        hash = 79 * hash + Objects.hashCode(this.financiamentoEntidadesExternasNR);
        hash = 79 * hash + Objects.hashCode(this.financiamentoEstadualNR);
        hash = 79 * hash + Objects.hashCode(this.financiamentoIesNR);
        hash = 79 * hash + Objects.hashCode(this.financiamentoMunicipalNR);
        hash = 79 * hash + Objects.hashCode(this.apoioSocial);
        hash = 79 * hash + Objects.hashCode(this.tipoApoioSocialAlimentacao);
        hash = 79 * hash + Objects.hashCode(this.tipoApoioSocialMoradia);
        hash = 79 * hash + Objects.hashCode(this.tipoApoioSocialTransporte);
        hash = 79 * hash + Objects.hashCode(this.tipoApoioSocialMaterialDidatico);
        hash = 79 * hash + Objects.hashCode(this.tipoApoioSocialBolsaTrabalho);
        hash = 79 * hash + Objects.hashCode(this.tipoApoioSocialBolsaPermanencia);
        hash = 79 * hash + Objects.hashCode(this.atividadeExtracurricular);
        hash = 79 * hash + Objects.hashCode(this.atividadeExtracurricularPesquisa);
        hash = 79 * hash + Objects.hashCode(this.bolsaPesquisa);
        hash = 79 * hash + Objects.hashCode(this.atividadeExtensao);
        hash = 79 * hash + Objects.hashCode(this.bolsaExtensao);
        hash = 79 * hash + Objects.hashCode(this.atividadeMonitoria);
        hash = 79 * hash + Objects.hashCode(this.bolsaMonitoria);
        hash = 79 * hash + Objects.hashCode(this.atividadeEstagioObrigatorio);
        hash = 79 * hash + Objects.hashCode(this.bolsaEstagioObrigatorio);
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
        final AlunoVinculo other = (AlunoVinculo) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.tipoRegistro, other.tipoRegistro)) {
            return false;
        }
        if (!Objects.equals(this.semestreReferencia, other.semestreReferencia)) {
            return false;
        }
        if (!Objects.equals(this.codigoCurso, other.codigoCurso)) {
            return false;
        }
        if (!Objects.equals(this.codigoPoloEad, other.codigoPoloEad)) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        if (!Objects.equals(this.situacaoVinculo, other.situacaoVinculo)) {
            return false;
        }
        if (!Objects.equals(this.cursoOrigem, other.cursoOrigem)) {
            return false;
        }
        if (!Objects.equals(this.semestreConclusao, other.semestreConclusao)) {
            return false;
        }
        if (!Objects.equals(this.alunoParfor, other.alunoParfor)) {
            return false;
        }
        if (!Objects.equals(this.dataIngressoCurso, other.dataIngressoCurso)) {
            return false;
        }
        if (!Objects.equals(this.tipoEscolaEnsinoMedio, other.tipoEscolaEnsinoMedio)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoVestibular, other.formaIngressoVestibular)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoEnem, other.formaIngressoEnem)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoSeriada, other.formaIngressoSeriada)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoOutraSelecao, other.formaIngressoOutraSelecao)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoPECG, other.formaIngressoPECG)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoEXOfficio, other.formaIngressoEXOfficio)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoJudicial, other.formaIngressoJudicial)) {
            return false;
        }
        if (!Objects.equals(this.formaIngressoOutra, other.formaIngressoOutra)) {
            return false;
        }
        if (!Objects.equals(this.mobilidadeAcademica, other.mobilidadeAcademica)) {
            return false;
        }
        if (!Objects.equals(this.tipoMobilidadeAcademica, other.tipoMobilidadeAcademica)) {
            return false;
        }
        if (!Objects.equals(this.iesDestino, other.iesDestino)) {
            return false;
        }
        if (!Objects.equals(this.tipoMobilidadeAcademicaInternacional, other.tipoMobilidadeAcademicaInternacional)) {
            return false;
        }
        if (!Objects.equals(this.paisDestino, other.paisDestino)) {
            return false;
        }
        if (!Objects.equals(this.programaReservaVagas, other.programaReservaVagas)) {
            return false;
        }
        if (!Objects.equals(this.programaReservaEtnico, other.programaReservaEtnico)) {
            return false;
        }
        if (!Objects.equals(this.programaReservaDeficiencia, other.programaReservaDeficiencia)) {
            return false;
        }
        if (!Objects.equals(this.programaReservaEscolaPublica, other.programaReservaEscolaPublica)) {
            return false;
        }
        if (!Objects.equals(this.programaReservaSocial, other.programaReservaSocial)) {
            return false;
        }
        if (!Objects.equals(this.programaReservaOutros, other.programaReservaOutros)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoEstudantil, other.financiamentoEstudantil)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoFIES, other.financiamentoFIES)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoEstadual, other.financiamentoEstadual)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoMunicipal, other.financiamentoMunicipal)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoIES, other.financiamentoIES)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoEntidadesExternas, other.financiamentoEntidadesExternas)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoProUniIntegralNR, other.financiamentoProUniIntegralNR)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoProUniParcialNR, other.financiamentoProUniParcialNR)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoEntidadesExternasNR, other.financiamentoEntidadesExternasNR)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoEstadualNR, other.financiamentoEstadualNR)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoIesNR, other.financiamentoIesNR)) {
            return false;
        }
        if (!Objects.equals(this.financiamentoMunicipalNR, other.financiamentoMunicipalNR)) {
            return false;
        }
        if (!Objects.equals(this.apoioSocial, other.apoioSocial)) {
            return false;
        }
        if (!Objects.equals(this.tipoApoioSocialAlimentacao, other.tipoApoioSocialAlimentacao)) {
            return false;
        }
        if (!Objects.equals(this.tipoApoioSocialMoradia, other.tipoApoioSocialMoradia)) {
            return false;
        }
        if (!Objects.equals(this.tipoApoioSocialTransporte, other.tipoApoioSocialTransporte)) {
            return false;
        }
        if (!Objects.equals(this.tipoApoioSocialMaterialDidatico, other.tipoApoioSocialMaterialDidatico)) {
            return false;
        }
        if (!Objects.equals(this.tipoApoioSocialBolsaTrabalho, other.tipoApoioSocialBolsaTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.tipoApoioSocialBolsaPermanencia, other.tipoApoioSocialBolsaPermanencia)) {
            return false;
        }
        if (!Objects.equals(this.atividadeExtracurricular, other.atividadeExtracurricular)) {
            return false;
        }
        if (!Objects.equals(this.atividadeExtracurricularPesquisa, other.atividadeExtracurricularPesquisa)) {
            return false;
        }
        if (!Objects.equals(this.bolsaPesquisa, other.bolsaPesquisa)) {
            return false;
        }
        if (!Objects.equals(this.atividadeExtensao, other.atividadeExtensao)) {
            return false;
        }
        if (!Objects.equals(this.bolsaExtensao, other.bolsaExtensao)) {
            return false;
        }
        if (!Objects.equals(this.atividadeMonitoria, other.atividadeMonitoria)) {
            return false;
        }
        if (!Objects.equals(this.bolsaMonitoria, other.bolsaMonitoria)) {
            return false;
        }
        if (!Objects.equals(this.atividadeEstagioObrigatorio, other.atividadeEstagioObrigatorio)) {
            return false;
        }
        if (!Objects.equals(this.bolsaEstagioObrigatorio, other.bolsaEstagioObrigatorio)) {
            return false;
        }
        return true;
    }

    
    
}
