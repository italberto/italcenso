/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ital.censo.file.domain;

/**
 *
 * @author italberto
 */
public abstract class Validable {
    protected abstract boolean checkContent();
    protected abstract boolean checkFill();
    protected abstract boolean checkDependence();
}
