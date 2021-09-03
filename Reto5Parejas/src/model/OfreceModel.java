/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
public class OfreceModel {

    private int provCodigo;
    private int prodCodigo;
    
    public OfreceModel(int provCodigo, int prodCodigo)
    {
        this.provCodigo = provCodigo;
        this.prodCodigo = prodCodigo;
    }
    
    
    /**
     * @return the provCodigo
     */
    public int getProvCodigo() {
        return provCodigo;
    }

    /**
     * @return the prodCodigo
     */
    public int getProdCodigo() {
        return prodCodigo;
    }
    
}
