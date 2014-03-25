/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ital.censo.vadidator.annotations.CampoDependente;
import com.ital.censo.vadidator.annotations.CampoObrigatorio;
import com.ital.censo.vadidator.annotations.ValoresPossiveis;
import java.text.SimpleDateFormat;
import javax.persistence.Transient;
/**
 *
 * @author italberto
 */
@Entity
//@Table(name = "aluno_re", schema = "ufpi_censo2013")
@Table(name = "aluno", schema = "ufpi_censo2013")
public class Aluno implements Comparable<Aluno>, Serializable{
    
    @Id
    @Column(name="aluno_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
    
    @Column(name="numero_linha_arquivo")
    private Integer linhaArquivo;
    
    @Column(name="numero_linha_arquivo_absoluto")
    private Integer linhaArquivoAbsoluta;
    
    @Column(name="tipo_registro")
    @CampoObrigatorio
    @ValoresPossiveis(valores = {"41"})
    private Integer tipoRegistro;
    
    @Column(name="codigo_inep")
    private String codigoInep;
    
    @Column(name="id_ies")
    @CampoObrigatorio
    private String idIES;
    
    @Column(name="nome")
    @CampoObrigatorio
    private String nome;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="passaporte")
    private String passaporte;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento")
    @CampoObrigatorio
    private Date dataNascimento;
    
    @Column(name="sexo")
    @CampoObrigatorio
    private Integer sexo;
    
    @Column(name="raca")
    @CampoObrigatorio
    private Integer raca;
    
    @Column(name="nome_mae")
    private String nomeMae;
    
    @Column(name="nacionalidade")
    @CampoObrigatorio
    private Integer nacionalidade;
    
    @Column(name="uf_nascimento")
    private Integer ufNascimento;
    
    @Column(name="cidade_nascimento")
    private Integer cidadeNascimento;
    
    @Column(name="pais_origem")
    @CampoObrigatorio
    private String paisOrigem;
    
    @Column(name="aluno_com_deficiencia")
    @CampoObrigatorio
    private Integer alunoComDeficiencia;
    
    @Column(name="deficiencia_cegueira")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaCegueira;
    
    @Column(name="deficiencia_baixa_visao")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaBaixaVisao;
    
    @Column(name="deficiencia_surdez")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaSurdez;
    
    @Column(name="deficiencia_auditiva")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAuditiva;
    
    @Column(name="deficiencia_fisica")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaFisica;
    
    @Column(name="deficiencia_surdo_cegueira")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaSurdoCegueira;
    
    @Column(name="deficiencia_multipla")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaMultipla;
    
    @Column(name="deficiencia_intelectual")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaIntelectual;
    
    @Column(name="deficiencia_autismo")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAutismo;
    
    @Column(name="deficiencia_asperger")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAsperger;
    
    @Column(name="deficiencia_rett")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaRett;
    
    @Column(name="deficiencia_desintegrativo")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaDesintegrativo;
    
    @Column(name="deficiencia_altas_habilidades")
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAltasHabilidades;
    
    @OneToMany(mappedBy = "aluno",cascade = CascadeType.ALL)
    private List<AlunoVinculo> vinculos;

    @Transient
    private List<Prova> provas = new ArrayList<>();
    
    @Transient
    private Integer seq;
    
    public Aluno(){
        this.vinculos = new ArrayList<>();
        
    }

    public Aluno(Long ID,Integer linhaArquivo,Integer linhaArquivoAbsoluto ,Integer tipoRegistro, String codigoInep, String idIES, String nome, String cpf, String passaporte, Date dataNascimento, Integer sexo, Integer raca, String nomeMae, Integer nacionalidade, Integer ufNascimento, Integer cidadeNascimento, String paisOrigem, Integer alunoComDeficiencia, Integer deficienciaCegueira, Integer deficienciaBaixaVisao, Integer deficienciaSurdez, Integer deficienciaAuditiva, Integer deficienciaFisica, Integer deficienciaSurdoCegueira, Integer deficienciaMultipla, Integer deficienciaIntelectual, Integer deficienciaAutismo, Integer deficienciaAsperger, Integer deficienciaRett, Integer deficienciaDesintegrativo, Integer deficienciaAltasHabilidades, List<AlunoVinculo> vinculos) {
        this.ID = ID;
        this.linhaArquivo = linhaArquivo;
        this.linhaArquivoAbsoluta = linhaArquivoAbsoluto;
        this.tipoRegistro = tipoRegistro;
        this.codigoInep = codigoInep;
        this.idIES = idIES;
        this.nome = nome;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.raca = raca;
        this.nomeMae = nomeMae;
        this.nacionalidade = nacionalidade;
        this.ufNascimento = ufNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.paisOrigem = paisOrigem;
        this.alunoComDeficiencia = alunoComDeficiencia;
        this.deficienciaCegueira = deficienciaCegueira;
        this.deficienciaBaixaVisao = deficienciaBaixaVisao;
        this.deficienciaSurdez = deficienciaSurdez;
        this.deficienciaAuditiva = deficienciaAuditiva;
        this.deficienciaFisica = deficienciaFisica;
        this.deficienciaSurdoCegueira = deficienciaSurdoCegueira;
        this.deficienciaMultipla = deficienciaMultipla;
        this.deficienciaIntelectual = deficienciaIntelectual;
        this.deficienciaAutismo = deficienciaAutismo;
        this.deficienciaAsperger = deficienciaAsperger;
        this.deficienciaRett = deficienciaRett;
        this.deficienciaDesintegrativo = deficienciaDesintegrativo;
        this.deficienciaAltasHabilidades = deficienciaAltasHabilidades;
        this.vinculos = vinculos;
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

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getCodigoInep() {
        return codigoInep;
    }

    public void setCodigoInep(String codigoInep) {
        this.codigoInep = codigoInep;
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

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
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

    public Integer getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(Integer ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public Integer getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(Integer cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Integer getAlunoComDeficiencia() {
        return alunoComDeficiencia;
    }

    public void setAlunoComDeficiencia(Integer alunoComDeficiencia) {
        this.alunoComDeficiencia = alunoComDeficiencia;
    }

    public Integer getDeficienciaCegueira() {
        return deficienciaCegueira;
    }

    public void setDeficienciaCegueira(Integer deficienciaCegueira) {
        this.deficienciaCegueira = deficienciaCegueira;
    }

    public Integer getDeficienciaBaixaVisao() {
        return deficienciaBaixaVisao;
    }

    public void setDeficienciaBaixaVisao(Integer deficienciaBaixaVisao) {
        this.deficienciaBaixaVisao = deficienciaBaixaVisao;
    }

    public Integer getDeficienciaSurdez() {
        return deficienciaSurdez;
    }

    public void setDeficienciaSurdez(Integer deficienciaSurdez) {
        this.deficienciaSurdez = deficienciaSurdez;
    }

    public Integer getDeficienciaAuditiva() {
        return deficienciaAuditiva;
    }

    public void setDeficienciaAuditiva(Integer deficienciaAuditiva) {
        this.deficienciaAuditiva = deficienciaAuditiva;
    }

    public Integer getDeficienciaFisica() {
        return deficienciaFisica;
    }

    public void setDeficienciaFisica(Integer deficienciaFisica) {
        this.deficienciaFisica = deficienciaFisica;
    }

    public Integer getDeficienciaSurdoCegueira() {
        return deficienciaSurdoCegueira;
    }

    public void setDeficienciaSurdoCegueira(Integer deficienciaSurdoCegueira) {
        this.deficienciaSurdoCegueira = deficienciaSurdoCegueira;
    }

    public Integer getDeficienciaMultipla() {
        return deficienciaMultipla;
    }

    public void setDeficienciaMultipla(Integer deficienciaMultipla) {
        this.deficienciaMultipla = deficienciaMultipla;
    }

    public Integer getDeficienciaIntelectual() {
        return deficienciaIntelectual;
    }

    public void setDeficienciaIntelectual(Integer deficienciaIntelectual) {
        this.deficienciaIntelectual = deficienciaIntelectual;
    }

    public Integer getDeficienciaAutismo() {
        return deficienciaAutismo;
    }

    public void setDeficienciaAutismo(Integer deficienciaAutismo) {
        this.deficienciaAutismo = deficienciaAutismo;
    }

    public Integer getDeficienciaAsperger() {
        return deficienciaAsperger;
    }

    public void setDeficienciaAsperger(Integer deficienciaAsperger) {
        this.deficienciaAsperger = deficienciaAsperger;
    }

    public Integer getDeficienciaRett() {
        return deficienciaRett;
    }

    public void setDeficienciaRett(Integer deficienciaRett) {
        this.deficienciaRett = deficienciaRett;
    }

    public Integer getDeficienciaDesintegrativo() {
        return deficienciaDesintegrativo;
    }

    public void setDeficienciaDesintegrativo(Integer deficienciaDesintegrativo) {
        this.deficienciaDesintegrativo = deficienciaDesintegrativo;
    }

    public Integer getDeficienciaAltasHabilidades() {
        return deficienciaAltasHabilidades;
    }

    public void setDeficienciaAltasHabilidades(Integer deficienciaAltasHabilidades) {
        this.deficienciaAltasHabilidades = deficienciaAltasHabilidades;
    }

    public List<AlunoVinculo> getVinculos() {
        return vinculos;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    
    
    public void setVinculos(List<AlunoVinculo> vinculos) {
        this.vinculos = vinculos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ID);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
   
   

    @Override
    public int compareTo(Aluno o) {
        if (this.getLinhaArquivo()> o.getLinhaArquivo()){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");
        
        
        out.append(tiraNulo(this.getTipoRegistro())).append("|");
        out.append(tiraNulo(this.getCodigoInep())).append("|");
        out.append(tiraNulo(this.getIdIES())).append("|");
        out.append(tiraNulo(this.getNome())).append("|");
        out.append(tiraNulo(this.getCpf())).append("|");
        out.append(tiraNulo(this.getPassaporte())).append("|");
        

        
        String dataNascimentoTmp = formatador.format(this.getDataNascimento());
       
        out.append(tiraNulo(dataNascimentoTmp)).append("|");
        out.append(tiraNulo(this.getSexo())).append("|");
        out.append(tiraNulo(this.getRaca())).append("|");
        out.append(tiraNulo(this.getNomeMae())).append("|");
        out.append(tiraNulo(this.getNacionalidade())).append("|");
        out.append(tiraNulo(this.getUfNascimento())).append("|");
        out.append(tiraNulo(this.getCidadeNascimento())).append("|");
        out.append(tiraNulo(this.getPaisOrigem())).append("|");
        out.append(tiraNulo(this.getAlunoComDeficiencia())).append("|");
        out.append(tiraNulo(this.getDeficienciaCegueira())).append("|");
        out.append(tiraNulo(this.getDeficienciaBaixaVisao())).append("|");
        out.append(tiraNulo(this.getDeficienciaSurdez())).append("|");
        out.append(tiraNulo(this.getDeficienciaAuditiva())).append("|");
        out.append(tiraNulo(this.getDeficienciaFisica())).append("|");
        out.append(tiraNulo(this.getDeficienciaSurdoCegueira())).append("|");
        out.append(tiraNulo(this.getDeficienciaMultipla())).append("|");
        out.append(tiraNulo(this.getDeficienciaIntelectual())).append("|");
        out.append(tiraNulo(this.getDeficienciaAutismo())).append("|");
        out.append(tiraNulo(this.getDeficienciaAsperger())).append("|");
        out.append(tiraNulo(this.getDeficienciaRett())).append("|");
        out.append(tiraNulo(this.getDeficienciaDesintegrativo())).append("|");
        out.append(tiraNulo(this.getDeficienciaAltasHabilidades()));
        
        out.append("\n");
        for (AlunoVinculo alunoVinculo : vinculos) {
            out.append(alunoVinculo).append("\n");
            provas.add(new Prova(cpf, alunoVinculo.getCodigoCurso(), alunoVinculo.getSemestreReferencia(), alunoVinculo.getId(),this.seq));
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
