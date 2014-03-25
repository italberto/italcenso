/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.persistence.facade;

import com.ital.censo.persistence.domain.Aluno;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.ital.censo.principal.Principal;
import java.util.List;

/**
 *
 * @author italberto
 */
public class TesteFachadaAluno {
    
    public TesteFachadaAluno() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testeFachadaAluno(){
        FacadeAluno f = new FacadeAluno();

        List<Aluno> alunos = f.findAll();
                
        assertEquals(0, alunos.size());
        
        Principal.importarAluno();
        
        assertEquals(29561, alunos.size());
    }
}
