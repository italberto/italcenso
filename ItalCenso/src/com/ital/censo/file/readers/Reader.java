/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.readers;

import com.ital.censo.file.domain.File;
import java.util.List;

/**
 *
 * @author italberto
 */
public interface Reader<T> {    
    public abstract List<T> getElements(File file);
}
