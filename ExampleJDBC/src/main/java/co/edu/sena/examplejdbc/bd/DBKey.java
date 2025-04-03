/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.bd.Utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Key;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *Fecha: 13/03/2024
 * @author Jhon Zuluaga
 * Objetivo: permite consultas y transacciones en la tabla key
 * 
 */
public class DBKey extends DBConnection {
    
    public void insert(Key key)
    {
        try {
             connect();
             String sql = "insert into `key` (name, id, room, count, observation) values(?,?,?,?,?)";
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
              
           preparedStatement.setString(1, key.getName());
           preparedStatement.setInt(2, key.getId());
           preparedStatement.setString(3, key.getRoom());
           preparedStatement.setInt(4, key.getCount());
           preparedStatement.setString(5, key.getObservation());
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
            String sql = "UPDATE `key` SET name = ?, room = ?, count = ?, observation = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setString(2, key.getRoom());
            preparedStatement.setInt(3, key.getCount());
            preparedStatement.setString(4 , key.getObservation());
            preparedStatement.setInt(5, key.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al actualizar llave" + e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public void delete(int id)
    {
        try {
                connect();
                String sql = "delete from `key` where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                        
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al eliminar " + e.getMessage() );
            
        }
        finally{
            disconnect();
        }
    }
    
    public List<Key> findAll()
    {
        List<Key> results = new ArrayList<>();
        try {
            connect();
            String sql = "Select * from `key`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Key key = new Key();
                key.setId(resultSet.getInt("id"));
                key.setName(resultSet.getString("name"));
                key.setRoom(resultSet.getString("room"));
                key.setCount(resultSet.getInt("count"));
                key.setObservation(resultSet.getString("observation"));
                results.add(key);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al consultar tabla keys" + e.getMessage());
        }
        finally{
            disconnect();
        }
        return results;
    }
    
    public Key findById(int id){
        Key key = null;
        try {
                connect();
                String sql = "select * from `key` where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if(resultSet.next())
                {
                    key = new Key();
                    key.setId(resultSet.getInt("id"));
                    key.setName(resultSet.getString("name"));
                    key.setRoom(resultSet.getString("room"));
                    key.setCount(resultSet.getInt("count"));
                    key.setObservation(resultSet.getString("observation"));
                }
                resultSet.close();
                preparedStatement.close();
                
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al consultar key.." + e.getMessage());
        }
        finally
        {
            disconnect();
        }
        return key;
    }
    
    

    
    
    
}
