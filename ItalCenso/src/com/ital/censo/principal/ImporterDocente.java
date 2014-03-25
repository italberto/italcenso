/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.principal;

import com.ital.censo.file.domain.File;
import com.ital.censo.file.domain.NormalFile;
import com.ital.censo.file.elements.ElementoComposto;
import com.ital.censo.file.readers.MasterDetailReader;
import com.ital.censo.file.readers.Reader;
import com.ital.censo.persistence.domain.Docente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italberto
 */
class ImporterDocente extends Importer<Docente> {

    private static Integer numAbsolutoLinhas = 0;

    public ImporterDocente(String delimitadorMaster, String delimitadorDetalhe) {
        super(delimitadorMaster, delimitadorDetalhe);
    }

    @Override
    public List<Docente> executar(String caminhoArquivo) {
        File entrada = new NormalFile(caminhoArquivo);

        Reader r = new MasterDetailReader(super.getDelimitadorMaster(), super.getDelimitadorDetalhe());

        List<ElementoComposto> elementos = r.getElements(entrada);

        List<Docente> docentes = new ArrayList<>();

        for (int i = 0; i < elementos.size() - 1; i++) {
            Docente tmp = copiarElementosParaObjetoDocente(i + 1, elementos.get(i));
            if (tmp != null) {
                docentes.add(tmp);
            }
        }

        return docentes;
    }

    private Docente copiarElementosParaObjetoDocente(Integer numLinha, ElementoComposto el) {
        Docente retorno = null;

        List<String> master = desmembrarLinhas(el.getConteudo());
        
        try {
            retorno = montarMaster(numLinha, master);
        } catch (Exception ex) {
            Logger.getLogger(ImporterDocente.class.getName()).log(Level.SEVERE, null, ex);
        }

        numAbsolutoLinhas += 1;

        return retorno;

    }

    private Docente montarMaster(Integer numLinha, List<String> e) throws Exception{
        Docente r = new Docente();

        r.setLinhaArquivo(numLinha);

        r.setLinhaArquivoAbsoluta(numAbsolutoLinhas + 1);

        r.setTipoRegistro(31);

        r.setIdIES(e.get(1));

        r.setNome(e.get(2));

        r.setCpf(e.get(3));

        r.setDocumentoEstrangeiro(e.get(4));

        try {
            if (e.get(5) != null && !e.get(5).equals("")) { //data nascimento
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                Date data = sdf.parse(e.get(5));

                r.setDataNascimento(data);
            }
        } catch (IndexOutOfBoundsException index) {

        } catch (ParseException ex) {

        }

        try {
            if (e.get(6) != null && !e.get(6).equals("")) { //sexo
                r.setSexo(new Integer(e.get(6)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(7) != null && !e.get(7).equals("")) { //raca
                r.setRaca(new Integer(e.get(7)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        r.setNomeMae(e.get(8));

        try {
            if (e.get(9) != null && !e.get(9).equals("")) { //nacionalidade
                r.setNacionalidade(new Integer(e.get(9)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        r.setPaisOrigem(e.get(10));

        try {
            if (e.get(11) != null && !e.get(11).equals("")) { //uf nascimento
                r.setNacionalidade(new Integer(e.get(11)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(12) != null && !e.get(12).equals("")) {
                r.setMunicipioNascimento(new Integer(e.get(12)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(13) != null && !e.get(13).equals("")) {
                r.setPossuiDeficiencia(new Integer(e.get(13)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(14) != null && !e.get(14).equals("")) {
                r.setTipoDeficienciaCegueira(new Integer(e.get(14)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(15) != null && !e.get(15).equals("")) {
                r.setTipoDeficienciaBaixaVisao(new Integer(e.get(15)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(16) != null && !e.get(16).equals("")) {
                r.setTipoDeficienciaSurdez(new Integer(e.get(16)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(17) != null && !e.get(17).equals("")) {
                r.setTipoDeficienciaAuditiva(new Integer(e.get(17)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(18) != null && !e.get(18).equals("")) {
                r.setTipoDeficienciaFisica(new Integer(e.get(18)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(19) != null && !e.get(19).equals("")) {
                r.setTipoDeficienciaSurdocegueira(new Integer(e.get(19)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(20) != null && !e.get(20).equals("")) {
                r.setTipoDeficienciaMultipla(new Integer(e.get(20)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(21) != null && !e.get(21).equals("")) {
                r.setTipoDeficienciaIntelectual(new Integer(e.get(21)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(22) != null && !e.get(21).equals("")) {
                r.setEscolaridade(new Integer(e.get(22)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(23) != null && !e.get(23).equals("")) {
                r.setPosGraduacao(new Integer(e.get(23)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(24) != null && !e.get(24).equals("")) {
                r.setSituacaoIES(new Integer(e.get(24)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(25) != null && !e.get(25).equals("")) {
                r.setDocenteExercicioFimAno(new Integer(e.get(25)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(26) != null && !e.get(26).equals("")) {
                r.setRegimeTrabalho(new Integer(e.get(26)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(27) != null && !e.get(27).equals("")) {
                r.setDocenteSubstituto(new Integer(e.get(27)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(28) != null && !e.get(28).equals("")) {
                r.setDocenteVisitante(new Integer(e.get(28)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(29) != null && !e.get(29).equals("")) {
                r.setTipoVinculoDocenteVisitante(new Integer(e.get(29)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(30) != null && !e.get(30).equals("")) {
                r.setAtuacaoSequencial(new Integer(e.get(30)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(31) != null && !e.get(31).equals("")) {
                r.setAtuacaoPresencial(new Integer(e.get(31)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(32) != null && !e.get(32).equals("")) {
                r.setAtuacaoEAD(new Integer(e.get(32)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(33) != null && !e.get(33).equals("")) {
                r.setAtuacaoStrictoPresencial(new Integer(e.get(33)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(34) != null && !e.get(34).equals("")) {
                r.setAtuacaoStrictoEAD(new Integer(e.get(34)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(35) != null && !e.get(35).equals("")) {
                r.setAtuacaoPesquisa(new Integer(e.get(35)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(36) != null && !e.get(36).equals("")) {
                r.setAtuacaoExtensao(new Integer(e.get(36)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(37) != null && !e.get(37).equals("")) {
                r.setAtuacaoGestao(new Integer(e.get(37)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        try {
            if (e.get(38) != null && !e.get(38).equals("")) {
                r.setBolsaPesquisa(new Integer(e.get(38)));
            }
        } catch (IndexOutOfBoundsException index) {

        }

        return r;

    }

}
