/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.facade;

import com.ital.censo.persistence.dao.AlunoDAO;
import com.ital.censo.persistence.domain.Aluno;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeAluno extends Facade<Aluno>{

    public FacadeAluno() {
        super(new AlunoDAO());
    }

    @Override
    public List<Aluno> findAll() {
        return ((AlunoDAO)dao).findAll();
    }
    
    
    @Override
    public Aluno findById(Long id) {
        return ((AlunoDAO)dao).findById(id);
    }

    @Override
    public void save(Aluno obj) {
        ((AlunoDAO)dao).save(obj);
    }

    @Override
    public void create(Aluno obj) {
        ((AlunoDAO)dao).create(obj);
    }

    @Override
    public void delete(Aluno obj) {
        ((AlunoDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((AlunoDAO)dao).closeSession();
    }

    
    
    
}
