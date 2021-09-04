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
    
    public void getvendido(int prodCodigo)
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
    
}
