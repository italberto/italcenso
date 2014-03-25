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
import java.util.List;
import java.util.Objects;

/**
 *
 * @author italberto
 */
public class Aluno{

    @CampoObrigatorio
    @ValoresPossiveis(valores = {"41"})
    private Integer tipoRegistro;
    
    private Integer codigoInep;
    
    @CampoObrigatorio
    private String idIES;
    
    @CampoObrigatorio
    private String nome;
    
    @CampoObrigatorio
    private String cpf;
    
    @CampoDependente(campoForte = "nacionalidade", valorForteNecessario = "3")
    private String passaporte;
    
    @CampoObrigatorio
    private String dataNascimento;
    
    @CampoObrigatorio
    private Integer sexo;
    
    @CampoObrigatorio
    private Integer raca;
    
    private String nomeMae;
    
    @CampoObrigatorio
    private Integer nacionalidade;
    
    private Integer ufNascimento;
    
    @CampoDependente(campoForte = "ufNascimento", valorForteNecessario = "")
    private Integer cidadeNascimento;
    
    @CampoDependente(campoForte = "nacionalidade",valorForteNecessario = "1",valorFracoObrigatorio = {"BRA"})
    private String paisOrigem;
    
    @CampoObrigatorio
    private Integer alunoComDeficiencia;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaCegueira;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaBaixaVisao;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaSurdez;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAuditiva;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaFisica;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaSurdoCegueira;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaMultipla;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaIntelectual;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAutismo;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAsperger;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaRett;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaDesintegrativo;
    
    @CampoDependente(campoForte = "alunoComDeficiencia", valorForteNecessario = "1", valorFracoObrigatorio = {"0","1"})
    private Integer deficienciaAltasHabilidades;

    private List<AlunoVinculo> vinculos;

    public Aluno() {
        this.vinculos = new ArrayList<>();
    }

    public Aluno(Integer tipoRegistro, Integer codigoInep, String idIES, String nome, String cpf, String passaporte, String dataNascimento, Integer sexo, Integer raca, String nomeMae, Integer nacionalidade, Integer ufNascimento, Integer cidadeNascimento, String paisOrigem, Integer alunoComDeficiencia, Integer deficienciaCegueira, Integer deficienciaBaixaVisao, Integer deficienciaSurdez, Integer deficienciaAuditiva, Integer deficienciaFisica, Integer deficienciaSurdoCegueira, Integer deficienciaMultipla, Integer deficienciaIntelectual, Integer deficienciaAutismo, Integer deficienciaAsperger, Integer deficienciaRett, Integer deficienciaDesintegrativo, Integer deficienciaAltasHabilidades) {
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
        
        this.vinculos = new ArrayList<>();
    }

    

    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Integer getCodigoInep() {
        return codigoInep;
    }

    public void setCodigoInep(Integer codigoInep) {
        this.codigoInep = codigoInep;
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

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

    public void setVinculos(List<AlunoVinculo> vinculos) {
        this.vinculos = vinculos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.tipoRegistro);
        hash = 41 * hash + Objects.hashCode(this.codigoInep);
        hash = 41 * hash + Objects.hashCode(this.idIES);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.passaporte);
        hash = 41 * hash + Objects.hashCode(this.dataNascimento);
        hash = 41 * hash + Objects.hashCode(this.sexo);
        hash = 41 * hash + Objects.hashCode(this.raca);
        hash = 41 * hash + Objects.hashCode(this.nomeMae);
        hash = 41 * hash + Objects.hashCode(this.nacionalidade);
        hash = 41 * hash + Objects.hashCode(this.ufNascimento);
        hash = 41 * hash + Objects.hashCode(this.cidadeNascimento);
        hash = 41 * hash + Objects.hashCode(this.paisOrigem);
        hash = 41 * hash + Objects.hashCode(this.alunoComDeficiencia);
        hash = 41 * hash + Objects.hashCode(this.deficienciaCegueira);
        hash = 41 * hash + Objects.hashCode(this.deficienciaBaixaVisao);
        hash = 41 * hash + Objects.hashCode(this.deficienciaSurdez);
        hash = 41 * hash + Objects.hashCode(this.deficienciaAuditiva);
        hash = 41 * hash + Objects.hashCode(this.deficienciaFisica);
        hash = 41 * hash + Objects.hashCode(this.deficienciaSurdoCegueira);
        hash = 41 * hash + Objects.hashCode(this.deficienciaMultipla);
        hash = 41 * hash + Objects.hashCode(this.deficienciaIntelectual);
        hash = 41 * hash + Objects.hashCode(this.deficienciaAutismo);
        hash = 41 * hash + Objects.hashCode(this.deficienciaAsperger);
        hash = 41 * hash + Objects.hashCode(this.deficienciaRett);
        hash = 41 * hash + Objects.hashCode(this.deficienciaDesintegrativo);
        hash = 41 * hash + Objects.hashCode(this.deficienciaAltasHabilidades);
        hash = 41 * hash + Objects.hashCode(this.vinculos);
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
        if (!Objects.equals(this.tipoRegistro, other.tipoRegistro)) {
            return false;
        }
        if (!Objects.equals(this.codigoInep, other.codigoInep)) {
            return false;
        }
        if (!Objects.equals(this.idIES, other.idIES)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.passaporte, other.passaporte)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        if (!Objects.equals(this.ufNascimento, other.ufNascimento)) {
            return false;
        }
        if (!Objects.equals(this.cidadeNascimento, other.cidadeNascimento)) {
            return false;
        }
        if (!Objects.equals(this.paisOrigem, other.paisOrigem)) {
            return false;
        }
        if (!Objects.equals(this.alunoComDeficiencia, other.alunoComDeficiencia)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaCegueira, other.deficienciaCegueira)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaBaixaVisao, other.deficienciaBaixaVisao)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaSurdez, other.deficienciaSurdez)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaAuditiva, other.deficienciaAuditiva)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaFisica, other.deficienciaFisica)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaSurdoCegueira, other.deficienciaSurdoCegueira)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaMultipla, other.deficienciaMultipla)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaIntelectual, other.deficienciaIntelectual)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaAutismo, other.deficienciaAutismo)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaAsperger, other.deficienciaAsperger)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaRett, other.deficienciaRett)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaDesintegrativo, other.deficienciaDesintegrativo)) {
            return false;
        }
        if (!Objects.equals(this.deficienciaAltasHabilidades, other.deficienciaAltasHabilidades)) {
            return false;
        }
        if (!Objects.equals(this.vinculos, other.vinculos)) {
            return false;
        }
        return true;
    }

}
