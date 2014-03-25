/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.facade;

import com.ital.censo.persistence.dao.AlunoDAO;
import com.ital.censo.persistence.dao.DocenteDAO;
import com.ital.censo.persistence.domain.Docente;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeDocente extends Facade<Docente>{

    public FacadeDocente() {
        super(new DocenteDAO());
    }

    @Override
    public List<Docente> findAll() {
        return ((DocenteDAO)dao).findAll();
    }

    @Override
    public Docente findById(Long id) {
        return ((DocenteDAO)dao).findById(id);
    }

    @Override
    public void save(Docente obj) {
        ((DocenteDAO)dao).save(obj);
    }

    @Override
    public void create(Docente obj) {
        ((DocenteDAO)dao).create(obj);
    }

    @Override
    public void delete(Docente obj) {
        ((DocenteDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((DocenteDAO)dao).closeSession();
    }

    
    
    
}
