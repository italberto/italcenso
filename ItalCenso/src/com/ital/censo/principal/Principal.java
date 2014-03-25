/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.principal;

import com.ital.censo.persistence.domain.Aluno;
import com.ital.censo.persistence.domain.Docente;
import com.ital.censo.persistence.facade.FacadeAluno;
import com.ital.censo.persistence.facade.FacadeDocente;
import java.util.List;

/**
 *
 * @author italberto
 */
public class Principal {
     public static void main(String args[]) {
        //importarAluno();
        //importarDocente();
        
    }

    public static void importarAluno() {
        Importer e = new ImporterAluno("^41\\|.*","^42\\|.*");
        //List<Aluno> alunos = e.executar("/home/italberto/tmp/alunos.txt");
        List<Aluno> alunos = e.executar("/home/italberto/tmp/reimportar.txt");
        
        FacadeAluno f = new FacadeAluno();

        System.out.println("Número total de registros: " + alunos.size());
        
        for (Aluno aluno : alunos) {
            f.create(aluno);
        }
                
        
    }
    
    public static void importarDocente(){
        Importer e = new ImporterDocente("^31\\|.*","^32\\|.*");
        List<Docente> docentes = e.executar("/home/italberto/tmp/docentes.txt");
        
        FacadeDocente f = new FacadeDocente();
        
        System.out.println("Número total de registros: " + docentes.size());
        
        for (Docente docente : docentes) {
            f.create(docente);
        }
    }
}
