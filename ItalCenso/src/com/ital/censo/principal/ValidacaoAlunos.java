/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.principal;

import com.ital.censo.persistence.domain.Aluno;
import com.ital.censo.persistence.facade.FacadeAluno;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoDependente;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoObrigatorio;
import com.ital.censo.vadidator.annotations.parsers.ParserValoresPossiveis;
import com.ital.censo.vadidator.validators.Validador;
import java.util.List;

/**
 *
 * @author italberto
 */
public class ValidacaoAlunos {
    public static void main(String args[]) {
        FacadeAluno f = new FacadeAluno();
        
        
        
        List<Aluno> alunos = f.findAll(); 
        
        for (Aluno aluno : alunos) {
            boolean resultado = Validador.validar(aluno, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());
            if (!resultado){
                System.out.println("O registro " + aluno.getID() + " não passou pela validação.");
                System.out.println("------------------------------------------");
                System.out.println("");
            }
            
        }
        
        f.closeSession();
    }
}
