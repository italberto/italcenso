/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ital.censo.directories;

import com.ital.censo.directories.exceptions.CantDeleteException;
import com.ital.censo.directories.exceptions.FileExistsException;
import java.util.List;

/**
 *
 * @author italberto
 */
public abstract class Directorie {
    
    private String path;
    
    public Directorie(String path){
        this.path = path;
    }

   
    public abstract List<String> listFiles();
    public abstract boolean existFile(String fileName);
    public abstract String createSubdirectory(String dirName) throws FileExistsException;
    public abstract void deleteSubdirectory(String dirName) throws CantDeleteException;
    
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    

    
    
     

}
