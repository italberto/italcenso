/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.italcenso.validators;

import com.ital.censo.file.domain.Docente;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoDependente;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoObrigatorio;
import com.ital.censo.vadidator.annotations.parsers.ParserValoresPossiveis;
import com.ital.censo.vadidator.validators.Validador;
import java.util.Date;
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
public class TesteValidacaoDocente {

    public TesteValidacaoDocente() {
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
    @Test
    public void testaValidacaoDocente() {
        Docente d = new Docente();
        
        d.setTipoRegistro(31);
        d.setIdIES(null);
        d.setNome("Italberto Figueira Dantas");
        d.setCpf("98357891349");
        d.setDocumentoEstrangeiro(null);
        d.setDataNascimento(new Date());
        d.setSexo(0);
        d.setRaca(1);
        d.setNomeMae("Balbina Figueira Dantas");
        d.setNacionalidade(1);
        d.setPaisOrigem("BRA");
        d.setUfNascimento(null);
        d.setMunicipioNascimento(null);
        d.setPossuiDeficiencia(0);
        d.setTipoDeficienciaCegueira(null);
        d.setTipoDeficienciaBaixaVisao(null);
        d.setTipoDeficienciaSurdez(null);
        d.setTipoDeficienciaAuditiva(null);
        d.setTipoDeficienciaFisica(null);
        d.setTipoDeficienciaSurdocegueira(null);
        d.setTipoDeficienciaMultipla(null);
        d.setTipoDeficienciaIntelectual(null);
        d.setEscolaridade(2);
        d.setPosGraduacao(3);
        d.setSituacaoIES(1);
        d.setDocenteExercicioFimAno(1);
        d.setRegimeTrabalho(1);
        d.setDocenteSubstituto(0);
        d.setDocenteVisitante(0);
        d.setTipoVinculoDocenteVisitante(null);
        d.setAtuacaoSequencial(0);
        d.setAtuacaoPresencial(0);
        d.setAtuacaoEAD(0);
        d.setAtuacaoStrictoPresencial(0);
        d.setAtuacaoStrictoEAD(0);
        d.setAtuacaoPesquisa(0);
        d.setAtuacaoExtensao(0);
        d.setAtuacaoGestao(0);
        d.setBolsaPesquisa(null);
        
        //preenchimento padrão
        boolean result = Validador.validar(d, new ParserCampoDependente(),new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(true,result);
        
        
        //preenchimento com campo obrigatório faltando
        d.setTipoRegistro(null);
        
        result = Validador.validar(d, new ParserCampoDependente(),new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(false, result);
        
        //preenchimento com campo dependente faltando
        d.setTipoRegistro(31);
        d.setPossuiDeficiencia(1);
        
        result = Validador.validar(d, new ParserCampoDependente(),new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(false, result);
        
        //preenchimento com campo dependente correto
        d.setPossuiDeficiencia(1);
        d.setTipoDeficienciaCegueira(1);
        d.setTipoDeficienciaBaixaVisao(0);
        d.setTipoDeficienciaSurdez(0);
        d.setTipoDeficienciaAuditiva(0);
        d.setTipoDeficienciaFisica(0);
        d.setTipoDeficienciaSurdocegueira(0);
        d.setTipoDeficienciaMultipla(0);
        d.setTipoDeficienciaIntelectual(0);
        
        result = Validador.validar(d, new ParserCampoDependente(),new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(true, result);
        
        
        //preenchimento com valores possiveis errados
        d.setPossuiDeficiencia(0);
        d.setTipoDeficienciaCegueira(null);
        d.setTipoDeficienciaBaixaVisao(null);
        d.setTipoDeficienciaSurdez(null);
        d.setTipoDeficienciaAuditiva(null);
        d.setTipoDeficienciaFisica(null);
        d.setTipoDeficienciaSurdocegueira(null);
        d.setTipoDeficienciaMultipla(null);
        d.setTipoDeficienciaIntelectual(null);
        
        d.setTipoRegistro(32);
        
        result = Validador.validar(d, new ParserCampoDependente(),new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(false, result);
        
        //preenchimento com valores possiveis corretos
        d.setTipoRegistro(31);
        
        result = Validador.validar(d, new ParserCampoDependente(),new ParserCampoObrigatorio(), new ParserValoresPossiveis());
        
        assertEquals(true, result);
        
    }
    
   
}
