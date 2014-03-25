/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.facade;

import com.ital.censo.persistence.dao.AlunoDAO;
import com.ital.censo.persistence.dao.DAO;
import com.ital.censo.persistence.dao.ProvaDAO;
import com.ital.censo.persistence.domain.Prova;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeProva extends Facade<Prova>{

    public FacadeProva() {
        super(new ProvaDAO());
    }

    
    
    @Override
    public List<Prova> findAll() {
        return ((ProvaDAO)dao).findAll();
    }

    @Override
    public Prova findById(Long id) {
        return ((ProvaDAO)dao).findById(id);
    }

    @Override
    public void save(Prova obj) {
        ((ProvaDAO)dao).save(obj);
    }

    @Override
    public void create(Prova obj) {
       ((ProvaDAO)dao).create(obj);
    }

    @Override
    public void delete(Prova obj) {
        ((ProvaDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((ProvaDAO)dao).closeSession();
    }
    
    public void createXXX(List<Prova> provas){
        ((ProvaDAO)dao).createXXX(provas);
    }
    
}
