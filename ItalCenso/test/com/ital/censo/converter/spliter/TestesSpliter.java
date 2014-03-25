package com.ital.censo.converter.spliter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author italberto
 */
public class TestesSpliter {
    
    public TestesSpliter() {
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
    public void testarDelimitedSpliter(){
        Spliter s = new DelimitedSpliter("\\|");
        
        String teste = "Italberto|Figueira|Dantas";
        
        assertArrayEquals(new String[]{"Italberto","Figueira","Dantas"}, s.split(teste));
        
    }
}
