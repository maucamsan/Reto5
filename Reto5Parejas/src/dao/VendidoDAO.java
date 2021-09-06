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
import model.VendidoModel;
import utils.ConnectionDB;

/**
 *
 * @author lenovo
 */
public class VendidoDAO {
    private Connection connection = null;
    
    public void getVenta(int prodCodigo) // READ
    {
        ArrayList<VendidoModel> ventas = new ArrayList();
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "SELECT  prod_codigo, ven_nro_factura FROM vendido WHERE prod_codigo =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, prodCodigo);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next())
            {
                VendidoModel vendido = new VendidoModel(result.getInt(1), result.getInt(2));
                
                ventas.add(vendido);
                
            }
            
            
        }
        catch(SQLException ex)
        {
            System.out.println("No se puede consultar la venta");
        }
    }
    
    
    public void insertVenta(VendidoModel vendido) // CREATE
    {
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO  vendido(prod_codigo, ven_nro_factura) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, vendido.getProvCodigo());
            statement.setInt(2, vendido.getVenNroFactura());
           
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
            {
                System.out.println("Venta añadida con éxito");
            }
            
            
        }
        catch(SQLException ex)
        {
            System.out.println("Proveedor no ha podido ser añadido con éxito");
        }
    }
    
    public void updateVenta(VendidoModel vendido) // UPDATE
    {
        try
        {
            if(connection == null)
            connection = ConnectionDB.getConnection();
        
        String sql = "UPDATE vendido SET prod_codigo=?, ven_nro_factura=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, vendido.getProvCodigo());
        statement.setInt(2, vendido.getVenNroFactura());
        
        
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
    
    public void deleteVenta(int prodCod) // DELETE
    {
         try
        {
            if(connection == null)
            connection = ConnectionDB.getConnection();
        
        String sql = "DELETE FROM vendido WHERE prod_codigo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, prodCod);
        
        
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
