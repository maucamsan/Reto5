/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ProductoModel;
import utils.ConnectionDB;

/**
 *
 * @author lenovo
 */
public class ProductoDAO {
    
    // Inicialización de tipo connection para posteriormente asignarle el valor de una instancia  de la calse ConnectionDB
    private Connection connection = null;
    
    public ArrayList<ProductoModel> obtenerProductos()
    {
        return null;
    }
    
    
    public void addProduct(ProductoModel producto)
    {
     try
     {
         if(connection == null)
             connection = ConnectionDB.getConnection();
         
         String sql = "INSERT INTO producto(prod_codigo, prod_nombre, prod_valor, prod_cantidad, prod_material) VALUES(?,?,?,?,?)";
         
         // aliata en la DB todo lo necesario para la creacion de un query
         PreparedStatement statement = connection.prepareStatement(sql);
         
         // Inyeción de datos
         
         statement.setInt(1, producto.getProdCodigo());
         statement.setString(2, producto.getProdNombre());
         statement.setInt(3, producto.getProdCantidad());
         statement.setString(4, producto.getProdMaterial());
         
         // Ejecución de query
         int rowsInserted = statement.executeUpdate();
         
         if(rowsInserted > 0)
         {
             System.out.println("El nuevo producto "+producto.getProdNombre()+" ha sido añdido");
         }
         else
         {
             System.out.println("El producto "+producto.getProdNombre()+" no pudo ser añadido");
         }
     }
     catch(SQLException ex)
     {
         ex.printStackTrace();
     }
     
    }
    
    public void updateProduct(ProductoModel producto)
    {
        
    }
    
    public void deleteProduct(int proCodigo)
    {
        
    }
    
}
