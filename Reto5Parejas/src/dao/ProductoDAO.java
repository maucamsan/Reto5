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
import model.ProductoModel;
import utils.ConnectionDB;

/**
 *
 * @author lenovo
 */
public class ProductoDAO {
    
    // Inicialización de tipo connection para posteriormente asignarle el valor de una instancia  de la calse ConnectionDB
    private Connection connection = null;
    
    
//    public ArrayList<ProductoModel> getProductosByProveedor(int prov_codigo)
//    {
//        ArrayList<ProductoModel> productos = new ArrayList();
//        try
//        {
//            if(connection == null)
//                connection = ConnectionDB.getConnection();
//            
//            String sql = "SELECT prod_codigo, prod_nombre, prod_valor, prod_cantidad, prod_material 
//            
//            
//        }
//        catch(SQLException ex)
//        {
//            
//        }
//    }
    
    public ArrayList<ProductoModel> getProducto(int prodCodigo) // Consulta a través de prod_codigo
    {
         ArrayList<ProductoModel> productos = new ArrayList();
        try
        {
            if(connection==null)
                connection = ConnectionDB.getConnection();
            String sql = "SELECT prod_codigo, prod_nombre, prod_valor, prod_cantidad, prod_material FROM producto WHERE prod_codigo = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, prodCodigo);
            
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                ProductoModel producto = new ProductoModel(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5));
                productos.add(producto);
            }
            
            
        }
        catch(SQLException ex)
        {
             System.out.println("El producto  no pudo ser consultado");
           
        }
        return productos;
    }
    
    public void addProduct(ProductoModel producto) // Añadir producto
    {
     try
     {
         if(connection == null)
             connection = ConnectionDB.getConnection();
         
         String sql = "INSERT INTO producto(prod_codigo, prod_nombre, prod_valor, prod_cantidad, prod_material) VALUES(?,?,?,?,?)";
         
         // Alista en la DB todo lo necesario para la creacion de un query
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
    
    public void updateProduct(ProductoModel producto) // Actualizar producto
    {
        try
        {
             if(connection == null)
                connection = ConnectionDB.getConnection();
             
             String sql = "UPDATE producto SET prod_nombre=?, prod_valor=?, prod_cantidad=?, prod_material=? WHERE prod_codigo=?";
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1, producto.getProdNombre());
             statement.setInt(2, producto.getProdValor());
             statement.setInt(3, producto.getProdCantidad());
             statement.setString(4, producto.getProdMaterial());
             statement.setInt(5, producto.getProdCodigo());
             
             int rowsUpdated = statement.executeUpdate();
             if(rowsUpdated > 0)
                 System.out.println("El producto ha sido actualizado");
        }
        catch(SQLException ex)
        {
            System.out.println("El producto no pudo ser actualizado");
        }
    }
    
    public void deleteProduct(int prodCodigo) // Eliminar Producto
    {
        try
        {
            if(connection == null)
                connection = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM producto WHERE prod_codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, prodCodigo);
            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0)
            {
                System.out.println("Producto eliminado correctamente");
            }
        }
        catch(SQLException ex)
        {
            System.out.println("El producto no pudo ser eliminado");
        }
    }
    
}
