/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;
import com.ital.censo.persistence.domain.Aluno;
import com.ital.censo.persistence.factory.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author italberto
 */
public class AlunoDAO extends DAO<Aluno>{

    private EntityManager em;
    
    public AlunoDAO() {
        super(Aluno.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

//    @Override
//    public List<Aluno> findAll() {
//        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
//        List<Aluno> alunos = em.createQuery("FROM Aluno").getResultList();
//        return alunos;
//    }

    
    @Override
    public List<Aluno> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Aluno> alunos = new HashSet<>();
        
        //alunos.addAll(em.createQuery("FROM Aluno a join fetch a.vinculos v WHERE v.situacaoVinculo is not null AND v.enviado  = false and v.reenviar = true").getResultList());
        //alunos.addAll(em.createQuery("FROM Aluno a join fetch a.vinculos v WHERE v.situacaoVinculo is not null AND v.enviado = true").getResultList());
        alunos.addAll(em.createQuery("FROM Aluno a join fetch a.vinculos v WHERE v.reenviar = true").getResultList());
        
        List<Aluno> retorno = new ArrayList();
        
        for (Aluno aluno : alunos) {
            retorno.add(aluno);
        }
        
        return retorno;
    }
    
    @Override
    public Aluno findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Aluno retorno = em.find(Aluno.class, id);
        return retorno;
    }

    @Override
    public void save(Aluno obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);   
    }

    @Override
    public void create(Aluno obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public void delete(Aluno obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.remove(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public  void closeSession(){
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }
    
    
}
