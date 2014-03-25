/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.italcenso.validators;

import com.ital.censo.file.domain.Aluno;
import com.ital.censo.file.domain.AlunoVinculo;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoDependente;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoObrigatorio;
import com.ital.censo.vadidator.annotations.parsers.ParserValoresPossiveis;
import com.ital.censo.vadidator.validators.Validador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author italberto
 */
public class TesteValidacaoAluno {

    public TesteValidacaoAluno() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    //@Test
    public void testeValidarAluno() {

        Aluno a = new Aluno();

        a.setTipoRegistro(41);
        a.setCodigoInep(null);
        a.setIdIES("99H2015478");
        a.setNome("Teste de nome de pessoa");
        a.setCpf("98357891349");
        a.setPassaporte(null);
        a.setDataNascimento("22021985");
        a.setSexo(1);
        a.setRaca(1);
        a.setNomeMae(null);
        a.setNacionalidade(1);
        a.setUfNascimento(null);
        a.setCidadeNascimento(null);
        a.setPaisOrigem("BRA");
        a.setAlunoComDeficiencia(0);
        a.setDeficienciaCegueira(null);
        a.setDeficienciaBaixaVisao(null);
        a.setDeficienciaSurdez(null);
        a.setDeficienciaAuditiva(null);
        a.setDeficienciaFisica(null);
        a.setDeficienciaSurdoCegueira(null);
        a.setDeficienciaMultipla(null);
        a.setDeficienciaIntelectual(null);
        a.setDeficienciaAutismo(null);
        a.setDeficienciaAsperger(null);
        a.setDeficienciaRett(null);
        a.setDeficienciaDesintegrativo(null);
        a.setDeficienciaAltasHabilidades(null);

        //preenchimento padrão
        boolean result = Validador.validar(a, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(true, result);

        //preenchimento com campo dependente faltando
        a.setAlunoComDeficiencia(1);

        result = Validador.validar(a, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());

        assertEquals(false, result);

        //preenchimento com campo dependente ok
        a.setAlunoComDeficiencia(1);
        a.setDeficienciaCegueira(1);
        a.setDeficienciaBaixaVisao(1);
        a.setDeficienciaSurdez(1);
        a.setDeficienciaAuditiva(1);
        a.setDeficienciaFisica(1);
        a.setDeficienciaSurdoCegueira(1);
        a.setDeficienciaMultipla(1);
        a.setDeficienciaIntelectual(1);
        a.setDeficienciaAutismo(1);
        a.setDeficienciaAsperger(1);
        a.setDeficienciaRett(1);
        a.setDeficienciaDesintegrativo(1);
        a.setDeficienciaAltasHabilidades(1);

        result = Validador.validar(a, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());

        assertEquals(true, result);

        //preenchimento com campo valores de campos dependetes errados
        a.setAlunoComDeficiencia(1);
        a.setDeficienciaCegueira(0);
        a.setDeficienciaBaixaVisao(0);
        a.setDeficienciaSurdez(0);
        a.setDeficienciaAuditiva(0);
        a.setDeficienciaFisica(0);
        a.setDeficienciaSurdoCegueira(0);
        a.setDeficienciaMultipla(0);
        a.setDeficienciaIntelectual(90);
        a.setDeficienciaAutismo(0);
        a.setDeficienciaAsperger(0);
        a.setDeficienciaRett(0);
        a.setDeficienciaDesintegrativo(0);
        a.setDeficienciaAltasHabilidades(0);

        result = Validador.validar(a, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());

        assertEquals(false, result);

        //preenchimento com campo obrigatorio errado
        a.setAlunoComDeficiencia(0);
        a.setDeficienciaCegueira(null);
        a.setDeficienciaBaixaVisao(null);
        a.setDeficienciaSurdez(null);
        a.setDeficienciaAuditiva(null);
        a.setDeficienciaFisica(null);
        a.setDeficienciaSurdoCegueira(null);
        a.setDeficienciaMultipla(null);
        a.setDeficienciaIntelectual(null);
        a.setDeficienciaAutismo(null);
        a.setDeficienciaAsperger(null);
        a.setDeficienciaRett(null);
        a.setDeficienciaDesintegrativo(null);
        a.setDeficienciaAltasHabilidades(null);

        a.setCpf(null);

        result = Validador.validar(a, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());

        assertEquals(false, result);
    }

    @Test
    public void testeValidacaoVinculoAluno() {
        AlunoVinculo av = new AlunoVinculo();

        av.setTipoRegistro(42);
        av.setSemestreReferencia(1);
        av.setCodigoCurso(123456);
        av.setCodigoPoloEad(null);
        av.setTurno(1);
        av.setSituacaoVinculo(3);
        av.setCursoOrigem(null);
        av.setSemestreConclusao(null);
        av.setAlunoParfor(null);
        av.setDataIngressoCurso("22021985");
        av.setTipoEscolaEnsinoMedio(1);
        av.setFormaIngressoVestibular(1);
        av.setFormaIngressoEnem(0);
        av.setFormaIngressoSeriada(0);
        av.setFormaIngressoOutraSelecao(0);
        av.setFormaIngressoPECG(0);
        av.setFormaIngressoEXOfficio(0);
        av.setFormaIngressoJudicial(0);
        av.setFormaIngressoOutra(0);
        av.setMobilidadeAcademica(null);
        av.setTipoMobilidadeAcademica(null);
        av.setIesDestino(null);
        av.setTipoMobilidadeAcademicaInternacional(null);
        av.setPaisDestino(null);
        av.setProgramaReservaVagas(0);
        av.setProgramaReservaEtnico(null);
        av.setProgramaReservaDeficiencia(null);
        av.setProgramaReservaEscolaPublica(null);
        av.setProgramaReservaSocial(null);
        av.setProgramaReservaOutros(null);
        av.setFinanciamentoEstudantil(0);
        av.setFinanciamentoFIES(null);
        av.setFinanciamentoEstadual(null);
        av.setFinanciamentoMunicipal(null);
        av.setFinanciamentoIES(null);
        av.setFinanciamentoEntidadesExternas(null);
        av.setFinanciamentoProUniIntegralNR(null);
        av.setFinanciamentoProUniParcialNR(null);
        av.setFinanciamentoEntidadesExternasNR(null);
        av.setFinanciamentoEstadualNR(null);
        av.setFinanciamentoIesNR(null);
        av.setFinanciamentoMunicipalNR(null);
        av.setApoioSocial(0);
        av.setTipoApoioSocialAlimentacao(null);
        av.setTipoApoioSocialMoradia(null);
        av.setTipoApoioSocialTransporte(null);
        av.setTipoApoioSocialMaterialDidatico(null);
        av.setTipoApoioSocialBolsaTrabalho(null);
        av.setTipoApoioSocialBolsaPermanencia(null);
        av.setAtividadeExtracurricular(0);
        av.setAtividadeExtracurricularPesquisa(null);
        av.setBolsaPesquisa(null);
        av.setAtividadeExtensao(null);
        av.setBolsaExtensao(null);
        av.setAtividadeMonitoria(null);
        av.setBolsaMonitoria(null);
        av.setAtividadeEstagioObrigatorio(null);
        av.setBolsaEstagioObrigatorio(null);

        boolean result = Validador.validar(av, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());

        assertEquals(true, result);
    }
}
