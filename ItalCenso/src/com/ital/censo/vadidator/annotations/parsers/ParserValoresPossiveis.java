/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.vadidator.annotations.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.ital.censo.vadidator.annotations.ValoresPossiveis;
import com.ital.censo.vadidator.exceptions.CampoObrigatorioExecption;
import com.ital.censo.vadidator.exceptions.ErroDeAnotacaoException;
import com.ital.censo.vadidator.exceptions.PreencimentoDeCampoException;
import com.ital.censo.vadidator.exceptions.ValorExcedenteException;
import com.ital.censo.vadidator.exceptions.ValorInvalidoException;
import com.ital.censo.vadidator.util.StrUtils;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author italberto
 */
public class ParserValoresPossiveis extends Parser {

    @Override
    public void parse(Object objeto) throws ErroDeAnotacaoException,
                                            ValorInvalidoException,
                                            ValorExcedenteException,
                                            PreencimentoDeCampoException,
                                            CampoObrigatorioExecption {

        Field[] fields = objeto.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ValoresPossiveis.class)) {
                String[] valores = field.getAnnotation(ValoresPossiveis.class).valores();

                String metodoGet = "get" + StrUtils.capitalizeString(field.getName());

                Method metodo = null;
                try {
                    metodo = objeto.getClass().getDeclaredMethod(metodoGet, null);
                } catch (NoSuchMethodException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (SecurityException ex) {
                    throw new ErroDeAnotacaoException();
                }

                String valorCampo = null;

                try {

                    if (metodo.invoke(objeto, null) != null) {
                        valorCampo = metodo.invoke(objeto, null).toString();
                    } else {
                        valorCampo = "";
                    }

                } catch (IllegalAccessException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (IllegalArgumentException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (InvocationTargetException ex) {
                    throw new ErroDeAnotacaoException();
                }

                boolean resultado = false;

                for (String valor : valores) {
                    if (valor.equals(valorCampo)) {
                        resultado = true;
                    }
                }

                if (!resultado) {
                    throw new ValorInvalidoException(field.getName(),valores.toString());
                }
            }
        }
    }
}
