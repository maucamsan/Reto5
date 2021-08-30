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


public class ProductoModel {

    
    private int prodCodigo;
    private String prodNombre;
    private int prodCantidad;
    private String prodMaterial;
    
    private String proveedor;
    
    
    /**
     * Constructos para manejo interno de la tabla
     * @param prodCodigo
     * @param prodNombre
     * @param prodCantidad
     * @param prodMaterial 
     */

    public ProductoModel(int prodCodigo, String prodNombre, int prodCantidad, String prodMaterial) {
        this.prodCodigo     = prodCodigo;
        this.prodNombre     = prodNombre;
        this.prodCantidad   = prodCantidad;
        this.prodMaterial   = prodMaterial;
    }
    
    /**
     * Constructor para mostrar datos a usuario
     * @param prodCodigo
     * @param prodNombre
     * @param prodCantidad
     * @param prodMaterial
     * @param proveedor 
     */
    
    public ProductoModel(int prodCodigo, String prodNombre, int prodCantidad, String prodMaterial, String proveedor)
    {
         this.prodCodigo     = prodCodigo;
        this.prodNombre     = prodNombre;
        this.prodCantidad   = prodCantidad;
        this.prodMaterial   = prodMaterial;
        this.proveedor      = proveedor;
    }
    
    /**
     * @return the prodCodigo
     */
    public int getProdCodigo() {
        return prodCodigo;
    }

    /**
     * @return the prodNombre
     */
    public String getProdNombre() {
        return prodNombre;
    }

    /**
     * @return the prodCantidad
     */
    public int getProdCantidad() {
        return prodCantidad;
    }

    /**
     * @param prodCantidad the prodCantidad to set
     */
    public void setProdCantidad(int prodCantidad) {
        this.prodCantidad = prodCantidad;
    }

    /**
     * @return the prodMaterial
     */
    public String getProdMaterial() {
        return prodMaterial;
    }

    /**
     * @param prodMaterial the prodMaterial to set
     */
    public void setProdMaterial(String prodMaterial) {
        this.prodMaterial = prodMaterial;
    }
    
}
