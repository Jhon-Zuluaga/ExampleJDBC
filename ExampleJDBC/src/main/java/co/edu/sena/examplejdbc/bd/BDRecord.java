/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import co.edu.sena.examplejdbc.bd.Utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * * Fecha: 20/03/2025
 *
 * @author Jhon Zuluaga Objetivo: Representa la tabla record
 */
public class BDRecord extends DBConnection {

    public void insert(Record record) {
        try {
            connect();
            String sql = "INSERT INTO record (date_record, start_time, end_time, employee_id, key_id, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDate_record());
            preparedStatement.setString(2, record.getStart_time());
            preparedStatement.setString(3, record.getEnd_time());
            preparedStatement.setLong(4,  record.getEmployeeId().getDocument());
            preparedStatement.setInt(5,  record.getKey().getId());
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al insertar llave  " + e.getMessage());
        }finally{
            disconnect();
        }

    }

    public void update(Record record) {
        try {
            int pos = 0;
            connect();
            String sql = "INSERT INTO record VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(++pos, record.getId());
            stmt.setString(++pos, record.getDate_record());
            stmt.setString(++pos, record.getStart_time());
            stmt.setString(++pos, record.getEnd_time());
            stmt.setLong(++pos, record.getEmployeeId().getDocument()); // FK: Llave foránea
            stmt.setInt(++pos, record.getKey().getId()); // FK: Llave foránea
            stmt.setString(++pos, record.getStatus());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al insertar registro..." + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void delete(int id) {
        try {
            connect();
            String sql = "DELETE FROM record WHERE id= ?";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(pos, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al eliminar grabación" + e.getMessage());

        } finally {
            disconnect();
        }
    }

    public List<Record> findAll() {
        List<Record> results = new ArrayList<>();
        BDEmployee dbet = new BDEmployee();
        BDKey bdkey = new BDKey();
        try {
            connect();
            String sql = "Select * from `record`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                record.setStatus(resultSet.getString("status"));
                // FK
                Employee employee = dbet.findById(resultSet.getInt("type_id"));
                record.setEmployeeId(employee);
                results.add(record);
                
                //FK
                Key key = bdkey.findById(resultSet.getInt("id"));
                record.setKey(key);
                results.add(record);
            }
            resultSet.close();

        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al encontrar grabación" + e.getMessage());
        } finally {
            disconnect();
        }
        return results;
    }

    public Record findById(int id) {
        Record record = null;
        BDEmployee dbet = new BDEmployee();
        BDKey bdkey = new BDKey();

        try {
            connect();
            String sql = "SELECT * FROM `record` WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(id, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            // . next para recorrer todos los resultados
            if (resultSet.next()) {
                record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                record.setStatus(resultSet.getString("status"));

                // FK
                Employee employee = dbet.findById(resultSet.getInt("type_id"));
                record.setEmployeeId(employee);

                Key key = bdkey.findById(resultSet.getInt("id"));
                record.setKey(key);

            }
            resultSet.close();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al consultar tipo de grabación" + e.getMessage());
        } finally {
            disconnect();
        }
        return record;
    }
}
