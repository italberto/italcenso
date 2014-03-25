/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.vadidator.annotations.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.ital.censo.vadidator.annotations.CampoDependente;
import com.ital.censo.vadidator.exceptions.*;
import com.ital.censo.vadidator.util.StrUtils;
import java.lang.reflect.InvocationTargetException;


/**
 *
 * @author italberto
 */
public class ParserCampoDependente extends Parser {

    @Override
    public void parse(Object objeto) throws ErroDeAnotacaoException,
                                            ValorInvalidoException,
                                            ValorExcedenteException,
                                            PreencimentoDeCampoException{
        
        Field[] fields = objeto.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(CampoDependente.class)) {
                CampoDependente campoDependente = field.getAnnotation(CampoDependente.class);

                String nomeCampoForte = "get" + StrUtils.capitalizeString(campoDependente.campoForte());
                String valorNecessario = campoDependente.valorForteNecessario();

                //TODO: completar a implementação desse método aqui. é muito importante.
                String[] valorObrigatorio = campoDependente.valorFracoObrigatorio();

                String nomeMetodoAnotado = "get" + StrUtils.capitalizeString(field.getName());

                Class noparams[] = {};

                Method metodoForte = null;
                Method metodoFraco = null;
                String valorCampoForte = "";
                String valorCampoFraco = "";

                try {
                    metodoForte = objeto.getClass().getDeclaredMethod(nomeCampoForte, noparams);
                    metodoFraco = objeto.getClass().getDeclaredMethod(nomeMetodoAnotado, noparams);
                } catch (NoSuchMethodException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (SecurityException ex) {
                    throw new ErroDeAnotacaoException();
                }
                
                
                try {
                    if (metodoForte.invoke(objeto, null)!=null){
                        valorCampoForte = metodoForte.invoke(objeto, null).toString();
                    }else{
                        valorCampoForte = "";
                    }
                    
                    if (metodoFraco.invoke(objeto, null)!=null){
                        valorCampoFraco = metodoFraco.invoke(objeto, null).toString();
                    }else {
                        valorCampoFraco = "";
                    }
                    
                    
                } catch (IllegalAccessException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (IllegalArgumentException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (InvocationTargetException ex) {
                    throw new ErroDeAnotacaoException();
                } catch (NullPointerException ex){
                    throw new ValorInvalidoException(field.getName(),valorCampoFraco);
                }

                
                if ((valorCampoForte != null)) {
                    if (!valorCampoForte.isEmpty() && valorCampoForte.equals(valorNecessario)) { //O campo forte precisa ser preenchido com um valor específico.
                        if (valorCampoFraco != null && !valorCampoFraco.isEmpty()) {
                            
                            boolean result = (valorCampoFraco.isEmpty());//caso o campo esteja em branco, quer dizer que qualquer valor é aceitavel, exceto nulo
                            
                            for (String valor:valorObrigatorio){
                                if (valor.equals(valorCampoFraco)){
                                    result = true;
                                }
                            }
                            
                            if (!result){
                                throw new ValorInvalidoException(field.getName(),valorCampoForte);
                            }
                            
                        } else {
                            throw new PreencimentoDeCampoException(field.getName());
                        }
                    } else if (valorNecessario.equals("")){ //o campo forte só precisa ser preenchido com um valor diferente de vazio.
                        if (valorCampoFraco != null) {
                            
                            boolean result = (valorCampoFraco.isEmpty());//caso o campo esteja em branco, quer dizer que qualquer valor é aceitavel, exceto nulo
                            
                            for (String valor:valorObrigatorio){
                                if (valor.equals(valorCampoFraco)){
                                    result = true;
                                }
                            }
                            
                            if (!result){
                                throw new ValorInvalidoException(field.getName(),valorCampoFraco);
                            }
                            
                            
                        } else {
                            throw new PreencimentoDeCampoException(field.getName());
                        }
                    } else {
                        if (valorCampoFraco != null && !valorCampoFraco.isEmpty()) {
                            //Caso o campo seja preenchido mesmo o valor do campo forte não sendo o necessário
                            //dá erro.
                            throw new ValorExcedenteException(field.getName(), 
                                                              campoDependente.campoForte(), 
                                                              campoDependente.valorForteNecessario());
                        }
                    }
                }else{
                    
                }

            }
        }

    }

}
