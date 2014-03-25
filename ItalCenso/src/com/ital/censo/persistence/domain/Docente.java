/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.domain;

import com.ital.censo.vadidator.annotations.CampoDependente;
import com.ital.censo.vadidator.annotations.CampoObrigatorio;
import com.ital.censo.vadidator.annotations.ValoresPossiveis;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author italberto
 */
@Entity
//@Table(name="docente", schema="ufpi_censo2013")
@Table(name="t_docente", schema="ufpi_censo2013")
public class Docente implements Comparable<Docente>, Serializable{
    
    @Id
    @Column(name="id_servidor")
    //@Column(name="docente_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Transient
    //@Column(name="numero_linha_arquivo")
    private Integer linhaArquivo;
    
    @Transient
//    @Column(name="numero_linha_arquivo_absoluto")
    private Integer linhaArquivoAbsoluta;
    
    
//    @Column(name="tipo_registro")
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"31"})
    private Integer tipoRegistro;
    
//    @Column(name="id_ies")
    private String idIES;
    
//    @Column(name="nome")
    @CampoObrigatorio
    private String nome;
    
//    @Column(name="cpf")
    @CampoObrigatorio
    private String cpf;
    
//    @Column(name="documento_estrangeiro")
    private String documentoEstrangeiro;
    
    @Temporal(TemporalType.DATE)
//    @Column(name="data_nascimento")
    @CampoObrigatorio
    private Date dataNascimento;
    
    @Column(name="sexo")
//    @CampoObrigatorio
    private Integer sexo;
    
//    @Column(name="raca")
    @CampoObrigatorio
    private Integer raca;
    
//    @Column(name="nome_mae")
    private String nomeMae;
    
//    @Column(name="nacionalidade")
    @CampoObrigatorio
    private Integer nacionalidade;
    
//    @Column(name="pais_origem")
    private String paisOrigem;
    
//    @Column(name="uf_nascimento")
    private Integer ufNascimento;
    
//    @Column(name="municipio_nascimento")
    private Integer municipioNascimento;
    
//    @Column(name="possui_deficiencia")
    @CampoObrigatorio
    private Integer possuiDeficiencia;
    
    @Column(name="deficiencia_cegueira")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaCegueira;
    
    @Column(name="deficiencia_baixa_visao")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaBaixaVisao;
    
    @Column(name="deficiencia_surdez")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaSurdez;
    
    @Column(name="deficiencia_auditiva")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaAuditiva;
    
    @Column(name="deficiencia_fisica")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaFisica;
    
    @Column(name="deficiencia_surdo_cegueira")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaSurdocegueira;
    
    @Column(name="deficiencia_multipla")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaMultipla;
    
    @Column(name="deficiencia_intelectual")
    @CampoDependente(campoForte = "possuiDeficiencia", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer tipoDeficienciaIntelectual;
    
//    @Column(name="escolaridade")
    @CampoObrigatorio
    private Integer escolaridade;
    
//    @Column(name="pos_graduacao")
    @CampoDependente(campoForte = "escolaridade", valorForteNecessario = "2",
            valorFracoObrigatorio = {"0","1","2","3"})
    private Integer posGraduacao;
    
//    @Column(name="situacao_ies")
    @CampoObrigatorio
    private Integer situacaoIES;
    
//    @Column(name="docente_exercicio_fim_ano")
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer docenteExercicioFimAno;
    
//    @Column(name="regime_trabalho")
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"1","2","3","4"})
    private Integer regimeTrabalho;
    
//    @Column(name="docente_substituto")
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer docenteSubstituto;
    
//    @Column(name="docente_visitante")
    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
            valorFracoObrigatorio = {"0","1"})
    private Integer docenteVisitante;
    
//    @Column(name="tipo_vinculo_docente_visitante")
    @CampoDependente(campoForte = "docenteVisitante", valorForteNecessario = "1",
            valorFracoObrigatorio = {"1","2"})
    private Integer tipoVinculoDocenteVisitante;
    
//    @Column(name="atuacao_sequencial")
    //@CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1")
    private Integer atuacaoSequencial;
    
//    @Column(name="atuacao_presencial")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoPresencial;
    
//    @Column(name="atuacao_ead")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoEAD;
    
//    @Column(name="atuacao_stricto_presencial")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoStrictoPresencial;
    
//    @Column(name="atuacao_stricto_ead")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoStrictoEAD;
    
//    @Column(name="atuacao_pesquisa")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoPesquisa;
    
//    @Column(name="atuacao_extensao")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoExtensao;
    
//    @Column(name="atuacao_gestao")
//    @CampoDependente(campoForte = "situacaoIES", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer atuacaoGestao;
    
//    @Column(name="bolsa_pesquisa")
//    @CampoDependente(campoForte = "atuacaoPesquisa", valorForteNecessario = "1",
//            valorFracoObrigatorio = {"0","1"})
    private Integer bolsaPesquisa;
    
    
    private Boolean inconsistencia;
    
    @OneToMany(mappedBy = "docente",fetch = FetchType.EAGER)
    private List<DocenteVinculo> vinculos;

    public Boolean isInconsistencia() {
        return inconsistencia;
    }

    public void setInconsistencia(Boolean inconsistencia) {
        this.inconsistencia = inconsistencia;
    }

    
    
    
    public Docente(){
        this.vinculos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLinhaArquivo() {
        return linhaArquivo;
    }

    public void setLinhaArquivo(Integer linhaArquivo) {
        this.linhaArquivo = linhaArquivo;
    }

    public Integer getLinhaArquivoAbsoluta() {
        return linhaArquivoAbsoluta;
    }

    public void setLinhaArquivoAbsoluta(Integer linhaArquivoAbsoluta) {
        this.linhaArquivoAbsoluta = linhaArquivoAbsoluta;
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
        return StringUtil.retiraCaracterEspecial(nome);
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
        return StringUtil.retiraCaracterEspecial(nomeMae);
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
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoSequencial == null ? 0 : atuacaoSequencial;
        
        return retorno;
    }

    public void setAtuacaoSequencial(Integer atuacaoSequencial) {
        this.atuacaoSequencial = atuacaoSequencial;
    }

    public Integer getAtuacaoPresencial() {
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoPresencial == null ? 0 : atuacaoPresencial;
        
        return retorno;
        
    }

    public void setAtuacaoPresencial(Integer atuacaoPresencial) {
        this.atuacaoPresencial = atuacaoPresencial;
    }

    public Integer getAtuacaoEAD() {
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoEAD == null ? 0 : atuacaoEAD;
        
        return retorno;
    }

    public void setAtuacaoEAD(Integer atuacaoEAD) {
        this.atuacaoEAD = atuacaoEAD;
    }

    public Integer getAtuacaoStrictoPresencial() {
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoStrictoPresencial == null ? 0 : atuacaoStrictoPresencial;
        
        return retorno;
     
    }

    public void setAtuacaoStrictoPresencial(Integer atuacaoStrictoPresencial) {
        this.atuacaoStrictoPresencial = atuacaoStrictoPresencial;
    }

    public Integer getAtuacaoStrictoEAD() {
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoStrictoEAD == null ? 0 : atuacaoStrictoEAD;
        
        return retorno;
    }

    public void setAtuacaoStrictoEAD(Integer atuacaoStrictoEAD) {
        this.atuacaoStrictoEAD = atuacaoStrictoEAD;
    }

    public Integer getAtuacaoPesquisa() {
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoPesquisa == null ? 0 : atuacaoPesquisa;
        
        return retorno;
    }

    public void setAtuacaoPesquisa(Integer atuacaoPesquisa) {
        this.atuacaoPesquisa = atuacaoPesquisa;
    }

    public Integer getAtuacaoExtensao() {
       Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoExtensao == null ? 0 : atuacaoExtensao;
        
        return retorno;
        
    }

    public void setAtuacaoExtensao(Integer atuacaoExtensao) {
        this.atuacaoExtensao = atuacaoExtensao;
    }

    public Integer getAtuacaoGestao() {
        Integer retorno = null;
        if (situacaoIES==1)
            retorno = atuacaoGestao == null ? 0 : atuacaoGestao;
        
        return retorno;
    }

    public void setAtuacaoGestao(Integer atuacaoGestao) {
        this.atuacaoGestao = atuacaoGestao;
    }

    public Integer getBolsaPesquisa() {
        Integer retorno = null;
        if (getAtuacaoPesquisa()!=null && getAtuacaoPesquisa()==1)
            retorno = bolsaPesquisa == null ? 0 : bolsaPesquisa;
        
        return retorno;
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
        final Docente other = (Docente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public int compareTo(Docente o) {
         if (this.getLinhaArquivo()> o.getLinhaArquivo()){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        
        out.append(tiraNulo(this.getTipoRegistro())).append("|");
        out.append(tiraNulo(this.getIdIES())).append("|");
        out.append(tiraNulo(this.getNome())).append("|");
        out.append(tiraNulo(this.getCpf())).append("|");
        out.append(tiraNulo(this.getDocumentoEstrangeiro())).append("|");
        
        SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");
        String dataNascimentoTmp = formatador.format(this.getDataNascimento());
       
        out.append(tiraNulo(dataNascimentoTmp)).append("|");
        
        out.append(tiraNulo(this.getSexo())).append("|");
        out.append(tiraNulo(this.getRaca())).append("|");
        out.append(tiraNulo(this.getNomeMae())).append("|");
        out.append(tiraNulo(this.getNacionalidade())).append("|");
        out.append(tiraNulo(this.getPaisOrigem())).append("|");
        out.append(tiraNulo(this.getUfNascimento())).append("|");
        out.append(tiraNulo(this.getMunicipioNascimento())).append("|");
        out.append(tiraNulo(this.getPossuiDeficiencia())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaCegueira())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaBaixaVisao())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaSurdez())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaAuditiva())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaFisica())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaSurdocegueira())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaMultipla())).append("|");
        out.append(tiraNulo(this.getTipoDeficienciaIntelectual())).append("|");
        out.append(tiraNulo(this.getEscolaridade())).append("|");
        out.append(tiraNulo(this.getPosGraduacao())).append("|");
        out.append(tiraNulo(this.getSituacaoIES())).append("|");
        out.append(tiraNulo(this.getDocenteExercicioFimAno())).append("|");
        out.append(tiraNulo(this.getRegimeTrabalho())).append("|");
        out.append(tiraNulo(this.getDocenteSubstituto())).append("|");
        out.append(tiraNulo(this.getDocenteVisitante())).append("|");
        out.append(tiraNulo(this.getTipoVinculoDocenteVisitante())).append("|");
        out.append(tiraNulo(this.getAtuacaoSequencial())).append("|");
        out.append(tiraNulo(this.getAtuacaoPresencial())).append("|");
        out.append(tiraNulo(this.getAtuacaoEAD())).append("|");
        out.append(tiraNulo(this.getAtuacaoStrictoPresencial())).append("|");
        out.append(tiraNulo(this.getAtuacaoStrictoEAD())).append("|");
        out.append(tiraNulo(this.getAtuacaoPesquisa())).append("|");
        out.append(tiraNulo(this.getAtuacaoExtensao())).append("|");
        out.append(tiraNulo(this.getAtuacaoGestao())).append("|");
        out.append(tiraNulo(this.getBolsaPesquisa()));
        
        out.append("\n");
        for (DocenteVinculo docenteVinculo : vinculos) {
            out.append(docenteVinculo).append("\n");
        }
               
        return out.toString();

    }
    

    
    
    private String tiraNulo(Object obj){
        String retorno = "";
        
        if (obj!=null)
            return obj.toString();
        
        return retorno;
    }
    
}
