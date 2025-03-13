/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.bd.Utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Key;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Fecha: 13/03/2024
 * @author Jhon Zuluaga
 * Objetivo: permite consultas y transacciones en la tabla key
 * 
 */
public class BDKey extends DBConnection {
    
    public void insert(Key key)
    {
        try {
             connect();
             String sql = "insert into key (name, room, count, observation) values(?,?,?,?)";
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, key.getName());
             preparedStatement.setString(2, key.getRoom());
             preparedStatement.setInt(3, 0);
             preparedStatement.setString(4, key.getObservation());
             preparedStatement.executeUpdate();
             preparedStatement.close();
             
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al insertar llave." + e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public void update(Key key)
    {
        try {
            connect();
            String sql = "UPDATE key SET name = ? WHERE id = ? AND room = ? AND count = ? AND observation = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setInt(2, key.getId());
            preparedStatement.setString(2, key.getRoom());
            
            preparedStatement.setString(4, key.getObservation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al actualizar llave" + e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    
}
