/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.principal;

import com.ital.censo.file.domain.File;
import com.ital.censo.file.domain.NormalFile;
import com.ital.censo.file.elements.Elemento;
import com.ital.censo.file.writers.SimpleWriter;
import com.ital.censo.file.writers.Writer;
import com.ital.censo.persistence.domain.Aluno;
import com.ital.censo.persistence.domain.Docente;
import com.ital.censo.persistence.domain.Prova;
import com.ital.censo.persistence.facade.FacadeAluno;
import com.ital.censo.persistence.facade.FacadeDocente;
import com.ital.censo.persistence.facade.FacadeProva;
import static com.ital.censo.principal.GerarArquivoDocente.mudaNomes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italberto
 */
public class GerarArquivoAluno {

    public static void mains(String args[]) {
        FacadeAluno f = new FacadeAluno();
        FacadeProva fp = new FacadeProva();
        
        List<Aluno> alunos = f.findAll();

        List<Elemento> elementos = new ArrayList<>();

        Elemento x = new Elemento();

        x.setConteudo("40|005|4\n");

        elementos.add(x);

        List<Prova> provas = new ArrayList<Prova>();
        
        Integer count = 1;
        Integer seq  = 1;
        
        for (Aluno aluno : alunos) {
            Elemento tmp = new Elemento();

            aluno.setSeq(seq);
            tmp.setConteudo(aluno.toString());
            
            
            provas.addAll(aluno.getProvas());
            
            elementos.add(tmp);
            if (count % 300==0){
                criarArquivos(elementos,seq);
                seq++;
                elementos = new ArrayList<>();
                elementos.add(x);
            }
            
            count++;
        }
     

        
        
        f.closeSession();
        
        fp.createXXX(provas);
    }
    
    public static void main(String args[]) {
        FacadeAluno f = new FacadeAluno();
        
        
        List<Aluno> alunos = f.findAll();

        List<Elemento> elementos = new ArrayList<>();

        Elemento x = new Elemento();

        x.setConteudo("40|005|4\n");

        elementos.add(x);

        
        for (Aluno aluno : alunos) {
            Elemento elemento = new Elemento();
            
            elemento.setConteudo(aluno.toString());
            
            elementos.add(elemento);
        }
        
        File saida = new NormalFile("/home/italberto/tmp/envios/aluno001.txt");
        
        
        Writer w = new SimpleWriter();
        
        w.putElements(elementos, saida);
        
        
        f.closeSession();
        
        
    }

    private static void criarArquivos(List<Elemento> linhas,Integer seq) {
        File saida = new NormalFile("/home/italberto/tmp/envios/00"+seq+".txt");
        
        
        Writer w = new SimpleWriter();
        
        w.putElements(linhas, saida);
    }
}
