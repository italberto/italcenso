/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.dao;

import com.ital.censo.persistence.domain.Docente;
import com.ital.censo.persistence.factory.EntityManagerFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italberto
 */
public class DocenteDAO extends DAO<Docente>{

     private EntityManager em;
    
    public DocenteDAO() {
        super(Docente.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Docente> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        List<Docente> docentes = em.createQuery("FROM Docente d where d.inconsistencia = false").getResultList();
        //EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
        return docentes;
    }

    @Override
    public Docente findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Docente retorno = em.find(Docente.class, id);
        //EntityManagerFactory.getCurrentInstance().closeEntityManager(em);       
        return retorno;
    }

    @Override
    public void save(Docente obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Docente obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public void delete(Docente obj) {
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
