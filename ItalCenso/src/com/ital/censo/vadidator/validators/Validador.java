/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.vadidator.validators;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.ital.censo.vadidator.annotations.parsers.Parser;
import com.ital.censo.vadidator.exceptions.CampoObrigatorioExecption;
import com.ital.censo.vadidator.exceptions.ErroDeAnotacaoException;
import com.ital.censo.vadidator.exceptions.PreencimentoDeCampoException;
import com.ital.censo.vadidator.exceptions.ValorExcedenteException;
import com.ital.censo.vadidator.exceptions.ValorInvalidoException;

/**
 *
 * @author italberto
 */
public class Validador {

    public static boolean validar(Object objeto, Parser... parsers) {
        for (Parser parser : parsers) {
            try {            
                parser.parse(objeto);
            } catch (ErroDeAnotacaoException ex) {
                System.out.println(ex.getMessage());
                return false;
            } catch (ValorInvalidoException ex) {
                System.out.println(ex.getMessage());
                return false;
            } catch (ValorExcedenteException ex) {
                System.out.println(ex.getMessage());
                return false;
            } catch (PreencimentoDeCampoException ex) {
                System.out.println(ex.getMessage());
                return false;
            } catch (CampoObrigatorioExecption ex) {
                System.out.println(ex.getMessage());
                return false;
            } catch (Exception ex){
                System.out.println(ex.getMessage());
                return false;
            }
            
        }

        return true;
    }
}
