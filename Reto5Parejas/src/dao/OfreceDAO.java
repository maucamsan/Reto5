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
import java.util.ArrayList;
import model.OfreceModel;
import utils.ConnectionDB;

/**
 *
 * @author lenovo
 */
public class OfreceDAO {
    private Connection connection = null;
    
    public void getOferta(int provCodigo) // READ
    {
        ArrayList<OfreceModel> ofertas = new ArrayList();
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "SELECT prod_codigo, proveedor.prov_nombre, producto.prod_nombre FROM ofrece"
                    + "JOIN proveedor ON proveedor.prov_nombre=ofrece.prov_nombre"
                    + "JOIN producto ON producto.prod_codigo=ofrece.prod_codigo"
                    + " WHERE ofrece.prov_cod =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, provCodigo);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next())
            {
                OfreceModel oferta = new OfreceModel(result.getInt(1), result.getInt(2));
                
                ofertas.add(oferta);
                
            }
            
            
        }
        catch(SQLException ex)
        {
            System.out.println("No se puede consultar la venta");
        }
    }
    
    
    public void insertOferta(OfreceModel oferta) // CREATE
    {
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO  ofrece(prov_codigo, prod_codigo) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, oferta.getProvCodigo());
            statement.setInt(2, oferta.getProdCodigo());
           
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
            {
                System.out.println("Oferta añadida con éxito");
            }
            
            
        }
        catch(SQLException ex)
        {
            System.out.println("Oferta no ha podido ser añadido con éxito");
        }
    }
    
    public void updateOferta(OfreceModel oferta) // UPDATE
    {
        try
        {
            if(connection == null)
            connection = ConnectionDB.getConnection();
        
        String sql = "UPDATE ofrece SET prov_codigo=?, prod_codigo=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, oferta.getProvCodigo());
        statement.setInt(2, oferta.getProvCodigo());
        
        
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
    
    public void deleteOferta(int provCod) // DELETE
    {
         try
        {
            if(connection == null)
            connection = ConnectionDB.getConnection();
        
        String sql = "DELETE FROM ofrece WHERE prov_codigo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, provCod);
        
        
        int rowsUpdated = statement.executeUpdate();
        if(rowsUpdated > 0)
        {
            System.out.println("Eliminación realizada con éxito");
        }
        
        }
        catch(SQLException ex)
        {
            System.out.println("No se pudo eliminar el registro");
        }
    }
}
