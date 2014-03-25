/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.principal;

import com.ital.censo.persistence.domain.Docente;
import com.ital.censo.persistence.facade.FacadeDocente;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoDependente;
import com.ital.censo.vadidator.annotations.parsers.ParserCampoObrigatorio;
import com.ital.censo.vadidator.annotations.parsers.ParserValoresPossiveis;
import com.ital.censo.vadidator.validators.Validador;
import java.util.List;

/**
 *
 * @author italberto
 */
public class ValidacaoDocentes {

    public static void main(String args[]) {
        FacadeDocente f = new FacadeDocente();

        List<Docente> docentes = f.findAll();

        for (Docente docente : docentes) {
            boolean resultado = Validador.validar(docente, new ParserCampoDependente(), new ParserCampoObrigatorio(), new ParserValoresPossiveis());
            if (!resultado) {
                System.out.println("O registro " + docente.getId() + " não passou pela validação.");
                System.out.println("------------------------------------------");
                System.out.println("");
            }

        }

        f.closeSession();
    }
}
