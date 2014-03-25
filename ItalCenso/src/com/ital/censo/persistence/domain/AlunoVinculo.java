/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.domain;

import com.ital.censo.vadidator.annotations.CampoDependente;
import com.ital.censo.vadidator.annotations.CampoObrigatorio;
import com.ital.censo.vadidator.annotations.ValoresPossiveis;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author italberto
 */
@Entity
//@Table(name="aluno_vinculo_re", schema="ufpi_censo2013")
@Table(name="aluno_vinculo", schema="ufpi_censo2013")
public class AlunoVinculo {
    
    @Id
    @Column(name="aluno_vinculo_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="tipo_registro")
    private Integer tipoRegistro;
    
    @Column(name="semestre_referencia")
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"1","2"})
    private Integer semestreReferencia;
    
    @Column(name="codigo_curso")
    private Integer codigoCurso;
    
    @Column(name="codigo_polo_ead")
    private Integer codigoPoloEad;
    
    @Column(name="turno")
    @ValoresPossiveis(valores = {"1","2","3","4"})
    private Integer turno;
    
    @Column(name="situacao_vinculo")
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"2","3","4","5","6","7"})
    private Integer situacaoVinculo;
    
    @Column(name="curso_origem")
    private Integer cursoOrigem;
    
    @Column(name="semestre_conclusao")
    private Integer semestreConclusao;
    
    @Column(name="aluno_parfor")
    private Integer alunoParfor;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_ingresso_curso")
    private Date    dataIngressoCurso;
    
    @Column(name="tipo_escola_ensino_medio")
    @ValoresPossiveis(valores = {"0","1","2"})
    private Integer tipoEscolaEnsinoMedio;
    
    @Column(name="forma_ingresso_vestibular")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoVestibular;
    
    @Column(name="forma_ingresso_enem")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoEnem;
    
    @Column(name="forma_ingresso_seriada")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoSeriada;
    
    @Column(name="forma_ingresso_outra_selecao")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoOutraSelecao;
    
    @Column(name="forma_ingresso_pecg")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoPECG;
    
    @Column(name="forma_ingresso_exofficio")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoEXOfficio;
    
    @Column(name="forma_ingresso_judicial")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoJudicial;
    
    @Column(name="forma_ingresso_outra")
    @ValoresPossiveis(valores = {"0","1"})
    private Integer formaIngressoOutra;
    
    @Column(name="mobilidade_academica")
    @CampoDependente(campoForte = "situacaoVinculo",valorForteNecessario = "2",valorFracoObrigatorio = {"0","1"})
    private Integer mobilidadeAcademica;
    
    @Column(name="tipo_mobilidade_academica")
    @CampoDependente(campoForte = "mobilidadeAcademica",valorForteNecessario = "1",valorFracoObrigatorio = {"1","2"})
    private Integer tipoMobilidadeAcademica;
    
    @Column(name="ies_destino")
    @CampoDependente(campoForte = "tipoMobilidadeAcademica",valorForteNecessario = "1")
    private Integer iesDestino;
    
    @Column(name="tipo_mobilidade_academica_internacional")
    @CampoDependente(campoForte = "tipoMobilidadeAcademica",valorForteNecessario = "2",valorFracoObrigatorio = {"1","2"})
    private Integer tipoMobilidadeAcademicaInternacional;
    
    @Column(name="pais_destino")
    private String  paisDestino;
    
    @Column(name="programa_reserva_vagas")
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer programaReservaVagas;
    
    @Column(name="programa_reserva_etnico")
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaEtnico;
    
    @Column(name="programa_reserva_deficiencia")
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaDeficiencia;
    
    @Column(name="programa_reserva_escola_public")
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaEscolaPublica;
    
    @Column(name="programa_reserva_social")
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaSocial;
    
    @Column(name="programa_reserva_outros")
    @CampoDependente(campoForte = "programaReservaVagas",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer programaReservaOutros;
    
    @Column(name="financiamento_estudantil")
    private Integer financiamentoEstudantil;
    
    @Column(name="financiamento_fies")
    
    private Integer financiamentoFIES;
    
    @Column(name="financiamento_estadual")
    private Integer financiamentoEstadual;
    
    @Column(name="financiamento_municipal")
    private Integer financiamentoMunicipal;
    
    @Column(name="financiamento_ies")
    private Integer financiamentoIES;
    
    @Column(name="financiamento_entidades_externas")
    private Integer financiamentoEntidadesExternas;
    
    //NR significa não reembolsável
    @Column(name="financiamento_prouni_integral_nr")
    private Integer financiamentoProUniIntegralNR;
    
    @Column(name="financiamento_prouni_parcial_nr")
    private Integer financiamentoProUniParcialNR;
    
    @Column(name="financiamento_entidades_externas_nr")
    private Integer financiamentoEntidadesExternasNR;
    
    @Column(name="financiamento_estadual_nr")
    private Integer financiamentoEstadualNR;
    
    @Column(name="financiamento_ies_nr")
    
    private Integer financiamentoIesNR;
    @Column(name="financiamento_municipal_nr")
    private Integer financiamentoMunicipalNR;
    
    @Column(name="apoio_social")
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"0","1"})
    private Integer apoioSocial;
    
    @Column(name="tipo_apoio_social_alimentacao")
    private Integer tipoApoioSocialAlimentacao;
    
    @Column(name="tipo_apoio_social_moradia")
    private Integer tipoApoioSocialMoradia;
    
    @Column(name="tipo_apoio_social_transporte")
    private Integer tipoApoioSocialTransporte;
    
    @Column(name="tipo_apoio_social_material_didatico")
    private Integer tipoApoioSocialMaterialDidatico;
    
    @Column(name="tipo_apoio_social_bolsa_trabalho")
    private Integer tipoApoioSocialBolsaTrabalho;
    
    @Column(name="tipo_apoio_social_bolsa_permanencia")
    private Integer tipoApoioSocialBolsaPermanencia;
    
    @Column(name="atividade_extracurricular")
    @CampoObrigatorio
    private Integer atividadeExtracurricular;
    
    @Column(name="atividade_extracurricular_pesquisa")
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeExtracurricularPesquisa;
    
    @Column(name="bolsa_pesquisa")
    @CampoDependente(campoForte = "atividadeExtracurricularPesquisa",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaPesquisa;
    
    @Column(name="atividade_extensao")
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeExtensao;
    
    @Column(name="bolsa_extensao")
    @CampoDependente(campoForte = "atividadeExtensao",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaExtensao;
    
    @Column(name="atividade_monitoria")
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeMonitoria;
    
    @Column(name="bolsa_monitoria")
    @CampoDependente(campoForte = "atividadeMonitoria",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaMonitoria;
    
    @Column(name="atividade_estagio_obrigatorio")
    @CampoDependente(campoForte = "atividadeExtracurricular",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer atividadeEstagioObrigatorio;
    
    @Column(name="bolsa_estagio_obrigatorio")
    @CampoDependente(campoForte = "atividadeEstagioObrigatorio",valorForteNecessario = "1",valorFracoObrigatorio = {"0","1"})
    private Integer bolsaEstagioObrigatorio;
    
    @Column(name="enviado")
    private Boolean enviado;
    
    @Column(name="reenviar")
    private Boolean reenviar;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id",nullable = false)
    private Aluno aluno;

    public AlunoVinculo(){
        
    }
    
    public AlunoVinculo(Long id, Integer tipoRegistro, Integer semestreReferencia, Integer codigoCurso, Integer codigoPoloEad, Integer turno, Integer situacaoVinculo, Integer cursoOrigem, Integer semestreConclusao, Integer alunoParfor, Date dataIngressoCurso, Integer tipoEscolaEnsinoMedio, Integer formaIngressoVestibular, Integer formaIngressoEnem, Integer formaIngressoSeriada, Integer formaIngressoOutraSelecao, Integer formaIngressoPECG, Integer formaIngressoEXOfficio, Integer formaIngressoJudicial, Integer formaIngressoOutra, Integer mobilidadeAcademica, Integer tipoMobilidadeAcademica, Integer iesDestino, Integer tipoMobilidadeAcademicaInternacional, String paisDestino, Integer programaReservaVagas, Integer programaReservaEtnico, Integer programaReservaDeficiencia, Integer programaReservaEscolaPublica, Integer programaReservaSocial, Integer programaReservaOutros, Integer financiamentoEstudantil, Integer financiamentoFIES, Integer financiamentoEstadual, Integer financiamentoMunicipal, Integer financiamentoIES, Integer financiamentoEntidadesExternas, Integer financiamentoProUniIntegralNR, Integer financiamentoProUniParcialNR, Integer financiamentoEntidadesExternasNR, Integer financiamentoEstadualNR, Integer financiamentoIesNR, Integer financiamentoMunicipalNR, Integer apoioSocial, Integer tipoApoioSocialAlimentacao, Integer tipoApoioSocialMoradia, Integer tipoApoioSocialTransporte, Integer tipoApoioSocialMaterialDidatico, Integer tipoApoioSocialBolsaTrabalho, Integer tipoApoioSocialBolsaPermanencia, Integer atividadeExtracurricular, Integer atividadeExtracurricularPesquisa, Integer bolsaPesquisa, Integer atividadeExtensao, Integer bolsaExtensao, Integer atividadeMonitoria, Integer bolsaMonitoria, Integer atividadeEstagioObrigatorio, Integer bolsaEstagioObrigatorio) {
        this.id = id;
        this.tipoRegistro = tipoRegistro;
        this.semestreReferencia = semestreReferencia;
        this.codigoCurso = codigoCurso;
        this.codigoPoloEad = codigoPoloEad;
        this.turno = turno;
        this.situacaoVinculo = situacaoVinculo;
        this.cursoOrigem = cursoOrigem;
        this.semestreConclusao = semestreConclusao;
        this.alunoParfor = alunoParfor;
        this.dataIngressoCurso = dataIngressoCurso;
        this.tipoEscolaEnsinoMedio = tipoEscolaEnsinoMedio;
        this.formaIngressoVestibular = formaIngressoVestibular;
        this.formaIngressoEnem = formaIngressoEnem;
        this.formaIngressoSeriada = formaIngressoSeriada;
        this.formaIngressoOutraSelecao = formaIngressoOutraSelecao;
        this.formaIngressoPECG = formaIngressoPECG;
        this.formaIngressoEXOfficio = formaIngressoEXOfficio;
        this.formaIngressoJudicial = formaIngressoJudicial;
        this.formaIngressoOutra = formaIngressoOutra;
        this.mobilidadeAcademica = mobilidadeAcademica;
        this.tipoMobilidadeAcademica = tipoMobilidadeAcademica;
        this.iesDestino = iesDestino;
        this.tipoMobilidadeAcademicaInternacional = tipoMobilidadeAcademicaInternacional;
        this.paisDestino = paisDestino;
        this.programaReservaVagas = programaReservaVagas;
        this.programaReservaEtnico = programaReservaEtnico;
        this.programaReservaDeficiencia = programaReservaDeficiencia;
        this.programaReservaEscolaPublica = programaReservaEscolaPublica;
        this.programaReservaSocial = programaReservaSocial;
        this.programaReservaOutros = programaReservaOutros;
        this.financiamentoEstudantil = financiamentoEstudantil;
        this.financiamentoFIES = financiamentoFIES;
        this.financiamentoEstadual = financiamentoEstadual;
        this.financiamentoMunicipal = financiamentoMunicipal;
        this.financiamentoIES = financiamentoIES;
        this.financiamentoEntidadesExternas = financiamentoEntidadesExternas;
        this.financiamentoProUniIntegralNR = financiamentoProUniIntegralNR;
        this.financiamentoProUniParcialNR = financiamentoProUniParcialNR;
        this.financiamentoEntidadesExternasNR = financiamentoEntidadesExternasNR;
        this.financiamentoEstadualNR = financiamentoEstadualNR;
        this.financiamentoIesNR = financiamentoIesNR;
        this.financiamentoMunicipalNR = financiamentoMunicipalNR;
        this.apoioSocial = apoioSocial;
        this.tipoApoioSocialAlimentacao = tipoApoioSocialAlimentacao;
        this.tipoApoioSocialMoradia = tipoApoioSocialMoradia;
        this.tipoApoioSocialTransporte = tipoApoioSocialTransporte;
        this.tipoApoioSocialMaterialDidatico = tipoApoioSocialMaterialDidatico;
        this.tipoApoioSocialBolsaTrabalho = tipoApoioSocialBolsaTrabalho;
        this.tipoApoioSocialBolsaPermanencia = tipoApoioSocialBolsaPermanencia;
        this.atividadeExtracurricular = atividadeExtracurricular;
        this.atividadeExtracurricularPesquisa = atividadeExtracurricularPesquisa;
        this.bolsaPesquisa = bolsaPesquisa;
        this.atividadeExtensao = atividadeExtensao;
        this.bolsaExtensao = bolsaExtensao;
        this.atividadeMonitoria = atividadeMonitoria;
        this.bolsaMonitoria = bolsaMonitoria;
        this.atividadeEstagioObrigatorio = atividadeEstagioObrigatorio;
        this.bolsaEstagioObrigatorio = bolsaEstagioObrigatorio;
    }

    public Boolean isReenviar() {
        return reenviar;
    }

    public void setReenviar(Boolean reenviar) {
        this.reenviar = reenviar;
    }

    
    
    public Boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
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

    public Date getDataIngressoCurso() {
        return dataIngressoCurso;
    }

    public void setDataIngressoCurso(Date dataIngressoCurso) {
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

    
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
                
        retorno.append(tiraNulo(this.getTipoRegistro())).append("|");
        retorno.append(tiraNulo(this.getSemestreReferencia())).append("|");
        retorno.append(tiraNulo(this.getCodigoCurso())).append("|");
        retorno.append(tiraNulo(this.getCodigoPoloEad())).append("|");
        retorno.append(tiraNulo(this.getTurno())).append("|");
        retorno.append(tiraNulo(this.getSituacaoVinculo())).append("|");
        retorno.append(tiraNulo(this.getCursoOrigem())).append("|");
        retorno.append(tiraNulo(this.getSemestreConclusao())).append("|");
        retorno.append(tiraNulo(this.getAlunoParfor())).append("|");
        
        SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");
        String dataIngresso = formatador.format(this.getDataIngressoCurso());
        
        retorno.append(tiraNulo(dataIngresso)).append("|");
        retorno.append(tiraNulo(this.getTipoEscolaEnsinoMedio())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoVestibular())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoEnem())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoSeriada())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoOutraSelecao())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoPECG())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoEXOfficio())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoJudicial())).append("|");
        retorno.append(tiraNulo(this.getFormaIngressoOutra())).append("|");
        retorno.append(tiraNulo(this.getMobilidadeAcademica())).append("|");
        retorno.append(tiraNulo(this.getTipoMobilidadeAcademica())).append("|");
        retorno.append(tiraNulo(this.getIesDestino())).append("|");
        retorno.append(tiraNulo(this.getTipoMobilidadeAcademicaInternacional())).append("|");
        retorno.append(tiraNulo(this.getPaisDestino())).append("|");
        retorno.append(tiraNulo(this.getProgramaReservaVagas())).append("|");
        retorno.append(tiraNulo(this.getProgramaReservaEtnico())).append("|");
        retorno.append(tiraNulo(this.getProgramaReservaDeficiencia())).append("|");
        retorno.append(tiraNulo(this.getProgramaReservaEscolaPublica())).append("|");
        retorno.append(tiraNulo(this.getProgramaReservaSocial())).append("|");
        retorno.append(tiraNulo(this.getProgramaReservaOutros())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoEstudantil())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoFIES())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoEstadual())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoMunicipal())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoIES())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoEntidadesExternas())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoProUniIntegralNR())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoProUniParcialNR())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoEntidadesExternasNR())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoEstadualNR())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoIesNR())).append("|");
        retorno.append(tiraNulo(this.getFinanciamentoMunicipalNR())).append("|");
        retorno.append(tiraNulo(this.getApoioSocial())).append("|");
        retorno.append(tiraNulo(this.getTipoApoioSocialAlimentacao())).append("|");
        retorno.append(tiraNulo(this.getTipoApoioSocialMoradia())).append("|");
        retorno.append(tiraNulo(this.getTipoApoioSocialTransporte())).append("|");
        retorno.append(tiraNulo(this.getTipoApoioSocialMaterialDidatico())).append("|");
        retorno.append(tiraNulo(this.getTipoApoioSocialBolsaTrabalho())).append("|");
        retorno.append(tiraNulo(this.getTipoApoioSocialBolsaPermanencia())).append("|");
        retorno.append(tiraNulo(this.getAtividadeExtracurricular())).append("|");
        retorno.append(tiraNulo(this.getAtividadeExtracurricularPesquisa())).append("|");
        retorno.append(tiraNulo(this.getBolsaPesquisa())).append("|");
        retorno.append(tiraNulo(this.getAtividadeExtensao())).append("|");
        retorno.append(tiraNulo(this.getBolsaExtensao())).append("|");
        retorno.append(tiraNulo(this.getAtividadeMonitoria())).append("|");
        retorno.append(tiraNulo(this.getBolsaMonitoria())).append("|");
        retorno.append(tiraNulo(this.getAtividadeEstagioObrigatorio())).append("|");
        retorno.append(tiraNulo(this.getBolsaEstagioObrigatorio()));
                
        return retorno.toString();
    }

     private String tiraNulo(Object obj){
        String retorno = "";
        
        if (obj!=null)
            return obj.toString();
        
        return retorno;
    }
    
    
}
