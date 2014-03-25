/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.vadidator.annotations.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.ital.censo.vadidator.annotations.CampoObrigatorio;
import com.ital.censo.vadidator.exceptions.*;
import com.ital.censo.vadidator.util.StrUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italberto
 */
public class ParserCampoObrigatorio extends Parser{

    @Override
    public void parse(Object objeto) throws ErroDeAnotacaoException,
                                            ValorInvalidoException,
                                            ValorExcedenteException,
                                            PreencimentoDeCampoException,
                                            CampoObrigatorioExecption{
        
        Field[] fields = objeto.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(CampoObrigatorio.class)){
                
                String metodoGet = "get" + StrUtils.capitalizeString(field.getName());
                
                
                Method metodo = null;
                String valorMetodoObrigatorio = null;
                
                try {
                    metodo = objeto.getClass().getDeclaredMethod(metodoGet, null);
                } catch (NoSuchMethodException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (SecurityException ex) {
                    throw new ErroDeAnotacaoException();
                }
                
                
                try {                
                    if (metodo.invoke(objeto, null)!=null){
                        valorMetodoObrigatorio = metodo.invoke(objeto, null).toString();
                    }else{
                        valorMetodoObrigatorio = "";
                    }
                } catch (IllegalAccessException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (IllegalArgumentException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (InvocationTargetException ex) {
                    throw new ErroDeAnotacaoException();
                }
                
                
                
                if (valorMetodoObrigatorio.isEmpty()){
                    throw new CampoObrigatorioExecption(field.getName());
                }
            }
        }
        
    }
}
