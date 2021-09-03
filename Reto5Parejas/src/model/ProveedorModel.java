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
public class ProveedorModel {

    
    private int provCod;
    private String provNombre;
    private String provDireccion;
    private int telefono;
    private String provPais;
    private String provCiudad;
    
    /**
     * Constructor Básico del modelo del proveedor
     * @param provCod
     * @param provNombre
     * @param provDireccion
     * @param telefono
     * @param provPais
     * @param provCiudad 
     */
    
    public ProveedorModel(int provCod, String provNombre, String provDireccion, int telefono, String provPais, String provCiudad)
    {
        this.provCod = provCod;
        this.provNombre = provNombre;
        this.provDireccion = provDireccion;
        this.telefono = telefono;
        this.provPais = provPais;
        this.provCiudad = provCiudad;
    }
    /**
     * @return the provCod
     */
    public int getProvCod() {
        return provCod;
    }

    /**
     * @param provCod the provCod to set
     */
    public void setProvCod(int provCod) {
        this.provCod = provCod;
    }

    /**
     * @return the provNombre
     */
    public String getProvNombre() {
        return provNombre;
    }

    /**
     * @param provNombre the provNombre to set
     */
    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    /**
     * @return the provDireccion
     */
    public String getProvDireccion() {
        return provDireccion;
    }

    /**
     * @param provDireccion the provDireccion to set
     */
    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the provPais
     */
    public String getProvPais() {
        return provPais;
    }

    /**
     * @param provPais the provPais to set
     */
    public void setProvPais(String provPais) {
        this.provPais = provPais;
    }

    /**
     * @return the provCiudad
     */
    public String getProvCiudad() {
        return provCiudad;
    }

    /**
     * @param provCiudad the provCiudad to set
     */
    public void setProvCiudad(String provCiudad) {
        this.provCiudad = provCiudad;
    }
    
    
    
}
