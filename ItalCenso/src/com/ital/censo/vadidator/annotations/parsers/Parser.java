/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.vadidator.annotations.parsers;

import com.ital.censo.vadidator.exceptions.CampoObrigatorioExecption;
import com.ital.censo.vadidator.exceptions.ErroDeAnotacaoException;
import com.ital.censo.vadidator.exceptions.PreencimentoDeCampoException;
import com.ital.censo.vadidator.exceptions.ValorExcedenteException;
import com.ital.censo.vadidator.exceptions.ValorInvalidoException;

/**
 *
 * @author italberto
 */
public abstract class Parser {
    public abstract void parse(Object objeto) throws ErroDeAnotacaoException,
                                                     ValorInvalidoException,
                                                     ValorExcedenteException,
                                                     PreencimentoDeCampoException,
                                                     CampoObrigatorioExecption;
}
