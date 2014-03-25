/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.principal;

import com.ital.censo.file.domain.File;
import com.ital.censo.file.domain.NormalFile;
import com.ital.censo.file.elements.Elemento;
import com.ital.censo.file.elements.ElementoComposto;
import com.ital.censo.file.readers.MasterDetailReader;
import com.ital.censo.file.readers.Reader;
import com.ital.censo.persistence.domain.Aluno;
import com.ital.censo.persistence.domain.AlunoVinculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author italberto
 */
public class ImporterAluno extends Importer<Aluno> {

    
    private static Integer numAbsolutoLinhas = 0;

    public ImporterAluno(String delimitadorMaster, String delimitadorDetalhe) {
        super(delimitadorMaster, delimitadorDetalhe);
    }
   

    @Override
    public List<Aluno> executar(String caminhoArquivo) {
        File entrada = new NormalFile(caminhoArquivo);

        Reader r = new MasterDetailReader(super.getDelimitadorMaster(), super.getDelimitadorDetalhe());

        List<ElementoComposto> elementos = r.getElements(entrada);

        List<Aluno> alunos = new ArrayList<>();

        for (int i=0;i<elementos.size()-1;i++){
            alunos.add(copiarElementosParaObjetoAluno(i+1,elementos.get(i)));
        }
        
        return alunos;
    }

    private Aluno copiarElementosParaObjetoAluno(Integer numLinha, ElementoComposto el) {
        Aluno retorno = null;

        List<String> master = desmembrarLinhas(el.getConteudo());

        retorno = montarMaster(numLinha,master);
        
        numAbsolutoLinhas += 1;
        
        List<AlunoVinculo> vinculos = copiarElementosParaObjetoVinculo(el.getElementos());
        
        for (AlunoVinculo alunoVinculo : vinculos) {
            alunoVinculo.setAluno(retorno);
        }
        
        retorno.setVinculos(vinculos);
        
        return retorno;

    }

    private List<AlunoVinculo> copiarElementosParaObjetoVinculo(List<Elemento> elementos) {
        List<AlunoVinculo> retorno = new ArrayList<>();

        for (Elemento elemento : elementos) {
            List<String> linha = desmembrarLinhas(elemento.getConteudo());

            retorno.add(montarAlunoVinculo(linha));
            
            numAbsolutoLinhas += 1;
        }

        return retorno;
    }

    private Aluno montarMaster(Integer numLinha,List<String> e) {
        Aluno r = new Aluno();

        r.setLinhaArquivo(numLinha);
        
        r.setLinhaArquivoAbsoluta(numAbsolutoLinhas+1);
        
        try {
            if (e.get(0) != null && !e.get(0).equals("")) {
                r.setTipoRegistro(new Integer(e.get(0)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        r.setCodigoInep(e.get(1));
        r.setIdIES(e.get(2));
        r.setNome(e.get(3));
        r.setCpf(e.get(4));
        r.setPassaporte(e.get(5));

        try {
            if (e.get(6) != null && !e.get(6).equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                Date data = sdf.parse(e.get(6));

                r.setDataNascimento(data);
                
                
            }
        } catch (IndexOutOfBoundsException index) {

        } catch (ParseException ex){
            
        }

        try {
            if (e.get(7) != null && !e.get(7).equals("")) {
                r.setSexo(new Integer(e.get(7)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(8) != null && !e.get(8).equals("")) {
                r.setRaca(new Integer(e.get(8)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        r.setNomeMae(e.get(9));

        try {
            if (e.get(10) != null && !e.get(10).equals("")) {
                r.setNacionalidade(new Integer(e.get(10)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(11) != null && !e.get(11).equals("")) {
                r.setUfNascimento(new Integer(e.get(11)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(12) != null && !e.get(12).equals("")) {
                r.setCidadeNascimento(new Integer(e.get(12)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        r.setPaisOrigem(e.get(13));

        try {
            if (e.get(14) != null && !e.get(14).equals("")) {
                r.setAlunoComDeficiencia(new Integer(e.get(14)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(15) != null && !e.get(15).equals("")) {
                r.setDeficienciaCegueira(new Integer(e.get(15)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(16) != null && !e.get(16).equals("")) {
                r.setDeficienciaBaixaVisao(new Integer(e.get(16)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(17) != null && !e.get(17).equals("")) {
                r.setDeficienciaSurdez(new Integer(e.get(17)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(18) != null && !e.get(18).equals("")) {
                r.setDeficienciaAuditiva(new Integer(e.get(18)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(19) != null && !e.get(19).equals("")) {
                r.setDeficienciaFisica(new Integer(e.get(19)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(20) != null && !e.get(20).equals("")) {
                r.setDeficienciaSurdoCegueira(new Integer(e.get(20)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(21) != null && !e.get(21).equals("")) {
                r.setDeficienciaMultipla(new Integer(e.get(21)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(22) != null && !e.get(22).equals("")) {
                r.setDeficienciaIntelectual(new Integer(e.get(22)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(23) != null && !e.get(23).equals("")) {
                r.setDeficienciaAutismo(new Integer(e.get(23)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(24) != null && !e.get(24).equals("")) {
                r.setDeficienciaAsperger(new Integer(e.get(24)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(25) != null && !e.get(25).equals("")) {
                r.setDeficienciaRett(new Integer(e.get(25)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(26) != null && !e.get(26).equals("")) {
                r.setDeficienciaDesintegrativo(new Integer(e.get(26)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(27) != null && !e.get(27).equals("")) {
                r.setDeficienciaAltasHabilidades(new Integer(e.get(27)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        return r;

    }

    private AlunoVinculo montarAlunoVinculo(List<String> e) {
        AlunoVinculo r = new AlunoVinculo();

        try {
            if (e.get(0) != null && !e.get(0).equals("")) {
                r.setTipoRegistro(new Integer(e.get(0)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(1) != null && !e.get(1).equals("")) {
                r.setSemestreReferencia(new Integer(e.get(1)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(2) != null && !e.get(2).equals("")) {
                r.setCodigoCurso(new Integer(e.get(2)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(3) != null && !e.get(3).equals("")) {
                r.setCodigoPoloEad(new Integer(e.get(3)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(4) != null && !e.get(4).equals("")) {
                r.setTurno(new Integer(e.get(4)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(5) != null && !e.get(5).equals("")) {
                r.setSituacaoVinculo(new Integer(e.get(5)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(6) != null && !e.get(6).equals("")) {
                r.setCursoOrigem(new Integer(e.get(6)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(7) != null && !e.get(7).equals("")) {
                r.setSemestreConclusao(new Integer(e.get(7)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(8) != null && !e.get(8).equals("")) {
                r.setAlunoParfor(new Integer(e.get(8)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(9) != null && !e.get(9).equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                Date data = sdf.parse(e.get(9));

                r.setDataIngressoCurso(data);
            }
        } catch (IndexOutOfBoundsException index) {

        } catch (ParseException ex){
            
        }

        try {
            if (e.get(10) != null && !e.get(10).equals("")) {
                r.setTipoEscolaEnsinoMedio(new Integer(e.get(10)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(11) != null && !e.get(11).equals("")) {
                r.setFormaIngressoVestibular(new Integer(e.get(11)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(12) != null && !e.get(12).equals("")) {
                r.setFormaIngressoEnem(new Integer(e.get(12)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(13) != null && !e.get(13).equals("")) {
                r.setFormaIngressoSeriada(new Integer(e.get(13)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(14) != null && !e.get(14).equals("")) {
                r.setFormaIngressoOutraSelecao(new Integer(e.get(14)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(15) != null && !e.get(15).equals("")) {
                r.setFormaIngressoPECG(new Integer(e.get(15)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(16) != null && !e.get(16).equals("")) {
                r.setFormaIngressoEXOfficio(new Integer(e.get(16)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(17) != null && !e.get(17).equals("")) {
                r.setFormaIngressoJudicial(new Integer(e.get(17)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(18) != null && !e.get(18).equals("")) {
                r.setFormaIngressoOutra(new Integer(e.get(18)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(19) != null && !e.get(19).equals("")) {
                r.setMobilidadeAcademica(new Integer(e.get(19)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(20) != null && !e.get(20).equals("")) {
                r.setTipoMobilidadeAcademica(new Integer(e.get(20)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(21) != null && !e.get(21).equals("")) {
                r.setIesDestino(new Integer(e.get(21)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(22) != null && !e.get(22).equals("")) {
                r.setTipoMobilidadeAcademicaInternacional(new Integer(e.get(22)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(23) != null && !e.get(23).equals("")) {
                r.setPaisDestino(e.get(23));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(24) != null && !e.get(24).equals("")) {
                r.setProgramaReservaVagas(new Integer(e.get(24)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(25) != null && !e.get(25).equals("")) {
                r.setProgramaReservaEtnico(new Integer(e.get(25)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(26) != null && !e.get(26).equals("")) {
                r.setProgramaReservaDeficiencia(new Integer(e.get(26)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(27) != null && !e.get(27).equals("")) {
                r.setProgramaReservaEscolaPublica(new Integer(e.get(27)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(28) != null && !e.get(28).equals("")) {
                r.setProgramaReservaSocial(new Integer(e.get(28)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(29) != null && !e.get(29).equals("")) {
                r.setProgramaReservaOutros(new Integer(e.get(29)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(30) != null && !e.get(30).equals("")) {
                r.setFinanciamentoEstudantil(new Integer(e.get(30)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(31) != null && !e.get(31).equals("")) {
                r.setFinanciamentoFIES(new Integer(e.get(31)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(32) != null && !e.get(32).equals("")) {
                r.setFinanciamentoEstadual(new Integer(e.get(32)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(33) != null && !e.get(33).equals("")) {
                r.setFinanciamentoMunicipal(new Integer(e.get(33)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(34) != null && !e.get(34).equals("")) {
                r.setFinanciamentoIES(new Integer(e.get(34)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(35) != null && !e.get(35).equals("")) {
                r.setFinanciamentoEntidadesExternas(new Integer(e.get(35)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(36) != null && !e.get(36).equals("")) {
                r.setFinanciamentoProUniIntegralNR(new Integer(e.get(36)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(37) != null && !e.get(37).equals("")) {
                r.setFinanciamentoProUniParcialNR(new Integer(e.get(37)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(38) != null && !e.get(38).equals("")) {
                r.setFinanciamentoEntidadesExternas(new Integer(e.get(38)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(39) != null && !e.get(39).equals("")) {
                r.setFinanciamentoEstadualNR(new Integer(e.get(39)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(40) != null && !e.get(40).equals("")) {
                r.setFinanciamentoIesNR(new Integer(e.get(40)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(41) != null && !e.get(41).equals("")) {
                r.setFinanciamentoMunicipalNR(new Integer(e.get(41)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(42) != null && !e.get(42).equals("")) {
                r.setApoioSocial(new Integer(e.get(42)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(43) != null && !e.get(43).equals("")) {
                r.setTipoApoioSocialAlimentacao(new Integer(e.get(43)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(44) != null && !e.get(44).equals("")) {
                r.setTipoApoioSocialMoradia(new Integer(e.get(44)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(45) != null && !e.get(45).equals("")) {
                r.setTipoApoioSocialTransporte(new Integer(e.get(45)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(46) != null && !e.get(46).equals("")) {
                r.setTipoApoioSocialMaterialDidatico(new Integer(e.get(46)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(47) != null && !e.get(47).equals("")) {
                r.setTipoApoioSocialBolsaTrabalho(new Integer(e.get(47)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(48) != null && !e.get(48).equals("")) {
                r.setTipoApoioSocialBolsaPermanencia(new Integer(e.get(48)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(49) != null && !e.get(49).equals("")) {
                r.setAtividadeExtracurricular(new Integer(e.get(49)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(50) != null && !e.get(50).equals("")) {
                r.setAtividadeExtracurricularPesquisa(new Integer(e.get(50)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(51) != null && !e.get(51).equals("")) {
                r.setBolsaPesquisa(new Integer(e.get(51)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(52) != null && !e.get(52).equals("")) {
                r.setAtividadeExtensao(new Integer(e.get(52)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(53) != null && !e.get(53).equals("")) {
                r.setBolsaExtensao(new Integer(e.get(53)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(54) != null && !e.get(54).equals("")) {
                r.setAtividadeMonitoria(new Integer(e.get(54)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(55) != null && !e.get(55).equals("")) {
                r.setBolsaMonitoria(new Integer(e.get(55)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(56) != null && !e.get(56).equals("")) {
                r.setAtividadeEstagioObrigatorio(new Integer(e.get(56)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(57) != null && !e.get(57).equals("")) {
                r.setBolsaEstagioObrigatorio(new Integer(e.get(57)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        return r;

    }

    

}
