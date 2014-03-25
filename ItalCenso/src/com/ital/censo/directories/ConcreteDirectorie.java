/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.directories;

import com.ital.censo.directories.exceptions.CantDeleteException;
import com.ital.censo.directories.exceptions.FileExistsException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italberto
 */
public class ConcreteDirectorie extends Directorie {

    public ConcreteDirectorie(String path) {
        super(path);
    }

    @Override
    public List<String> listFiles() {
        List<String> retorno = new ArrayList<>();

        File diretorio = new File(super.getPath());
        File fList[] = diretorio.listFiles();

        for (File file : fList) {
            retorno.add(file.getName());
        }


        return retorno;
    }

    @Override
    public boolean existFile(String fileName) {
        
        File arquivo = new File(getFullName(fileName));

        if (!arquivo.exists()) {
            return true;
        }

        return false;
    }

    @Override
    public String createSubdirectory(String dirName) throws FileExistsException {
        File diretorio = new File(super.getPath().concat(dirName));

        if (!diretorio.mkdir()){
            throw new FileExistsException();
        }else{
            diretorio.setWritable(true);
        }
     
        return diretorio.getAbsolutePath();
        
    }

    @Override
    public void deleteSubdirectory(String dirName) throws CantDeleteException {
        File diretorio = new File(getFullName(dirName));
        
        if (!diretorio.delete()){
            throw new CantDeleteException();
        }
        
        
    }

    private String getFullName(String name){
        return super.getPath().concat(name);
    }
    
}
