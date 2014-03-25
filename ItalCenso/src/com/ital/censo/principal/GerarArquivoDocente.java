/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.principal;

import com.ital.censo.file.domain.File;
import com.ital.censo.file.domain.NormalFile;
import com.ital.censo.file.elements.Elemento;
import com.ital.censo.file.writers.SimpleWriter;
import com.ital.censo.file.writers.Writer;
import com.ital.censo.persistence.domain.Docente;
import com.ital.censo.persistence.facade.FacadeDocente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author italberto
 */
public class GerarArquivoDocente {

    public static void main(String args[]) {
        FacadeDocente f = new FacadeDocente();
        
        
        List<Docente> docentes = f.findAll();

        List<Elemento> elementos = new ArrayList<>();

        Elemento x = new Elemento();

        x.setConteudo("30|005|3\n");

        elementos.add(x);

        
        for (Docente docente : docentes) {
            Elemento elemento = new Elemento();
            
            docente.setNome(mudaNomes(docente.getNome()));
            
            elemento.setConteudo(docente.toString());
            
            elementos.add(elemento);
        }
        
        File saida = new NormalFile("/home/italberto/tmp/envios/docentes.txt");
        
        
        Writer w = new SimpleWriter();
        
        w.putElements(elementos, saida);
        
        
        f.closeSession();
        
        
    }

   
    public static String mudaNomes(String nome){
        HashMap<String,String> nomes = new HashMap<String,String>();
        
        nomes.put("ODINEA MARIA AMORIM BATISTA", "ODINEIA MARIA AMORIM BATISTA");
        nomes.put("MYCHELANGELA DE ASSIS BRITO", "MICHELANGELA DE ASSIS BRITO");
        nomes.put("SYLVIA TERESA PEREIRA CLARK","SILVIA TERESA PEREIRA CLARCK");
        nomes.put("EDMILSA SANTANA DE ARAUJO","EDMILZA SANTANA DE ARAUJO");
        nomes.put("SUYANNE FREIRE DE MACEDO","SUYANE FREIRE DE MACEDO");
        nomes.put("NIVIA CECILIA KRUTA DE ARAUJO","NIVEA CECILIA KRUTA DE ARAUJO");
        nomes.put("JEREMIAS DA SILVA LEAO","JERIMIAS DA SILVA LEAO");
        nomes.put("CHRISTIANNE MARIA TINOCO VERAS","CHRISTIANE MARIA TINOCO VERAS");
        
        if (nomes.containsKey(nome.toUpperCase())){
            return nomes.get(nome.toUpperCase());
        }
        
        
        return nome;
    } 
    
}
