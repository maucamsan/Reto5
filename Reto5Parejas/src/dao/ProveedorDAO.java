/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ProveedorModel;
import utils.ConnectionDB;

/**
 *
 * @author lenovo
 */
public class ProveedorDAO {
    
    private Connection connection = null;
    
    private ArrayList<ProveedorModel> getProveedor() // ADVANCED READ
    {
        ArrayList<ProveedorModel> proveedores = new ArrayList();
        
        
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "SELECT proveedor.prov_codigo, prov_nombre, prov_direccion, prov_telefono, prov_pais, prov_ciudad, producto.prod_nombre, producto.prod_codigo"
                    + "FROM proveedor"
                    + "JOIN ofrece ON proveedor.prov_codigo = ofrece.prov_codigo"
                    + "JOIN producto ON producto.prod_codigo=ofrece.prod_codigo";
            
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next())
            {
                ProveedorModel proveedor = new ProveedorModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6), result.getString(7), result.getInt(8));
                proveedores.add(proveedor);
            }
            
            
        }
        catch(SQLException ex)
        {
            System.out.println("No se realizó la consulta con éxito");
        }
        return proveedores;
        
    }
    
    
    public void insertProveedor(ProveedorModel proveedor) // CREATE
    {
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO  proveedor(prov_codigo, prov_nombre, prov_direccion, prov_telefono, prov_pais, prov_ciudad) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, proveedor.getProvCod());
            statement.setString(2, proveedor.getProvNombre());
            statement.setString(3, proveedor.getProvDireccion());
            statement.setInt(4, proveedor.getTelefono());
            statement.setString(5, proveedor.getProvPais());
            statement.setString(6, proveedor.getProvCiudad());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
            {
                System.out.println("Proveedor añadido con éxito");
            }
            
            
        }
        catch(SQLException ex)
        {
            System.out.println("Proveedor no ha podido ser añadido con éxito");
        }
    }
    
    public void updateProveedor(ProveedorModel proveedor) // UPDATE
    {
        try
        {
            if(connection == null)
            connection = ConnectionDB.getConnection();
        
        String sql = "UPDATE proveefor SET prov_codigo=?, prov_nombre=?, prov_direccion=?, prov_telefono=?, prov_pais=?, prov_ciudad=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, proveedor.getProvCod());
        statement.setString(2, proveedor.getProvNombre());
        statement.setString(3, proveedor.getProvDireccion());
        statement.setInt(4, proveedor.getTelefono());
        statement.setString(5, proveedor.getProvPais());
        statement.setString(6, proveedor.getProvCiudad());
        
        int rowsUpdated = statement.executeUpdate();
        if(rowsUpdated > 0)
        {
            System.out.println("Registro actualizado correctamente");
        }
        
        }
        catch(SQLException ex)
        {
            System.out.println("Registro no pudo ser actualizado correctamente");
        }
        
    }
    
    public void deleteProveedor(int provCod) // DELETE
    {
         try
        {
            if(connection == null)
            connection = ConnectionDB.getConnection();
        
        String sql = "DELETE FROM proveedor WHERE prov_cod = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, provCod);
        
        
        int rowsUpdated = statement.executeUpdate();
        if(rowsUpdated > 0)
        {
            System.out.println("Elimincación realixada con éxito");
        }
        
        }
        catch(SQLException ex)
        {
            System.out.println("No se pudo eliminar el proveedor");
        }
    }
    
    
}
