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
public class VendidoModel {

    
     private int provCodigo;
    private int venNroFactura;
    
    public VendidoModel(int provCodigo, int venNroFactura)
    {
        this.provCodigo = provCodigo;
        this.venNroFactura = venNroFactura;
    }
    /**
     * @return the provCodigo
     */
    public int getProvCodigo() {
        return provCodigo;
    }

    /**
     * @return the venNroFactura
     */
    public int getVenNroFactura() {
        return venNroFactura;
    }
    
   
    
}
