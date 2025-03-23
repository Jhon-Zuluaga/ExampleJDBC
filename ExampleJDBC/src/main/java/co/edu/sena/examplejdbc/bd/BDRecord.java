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
            preparedStatement.setLong(4, record.getEmployeeId().getDocument());
            preparedStatement.setInt(5, record.getKey().getId());
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al insertar llave  " + e.getMessage());
        } finally {
            disconnect();
        }

    }

    public void update(Record record) {
        try {
            
            connect();
<<<<<<< Updated upstream
            String sql = "UPDATE record SET date_record= ?, start_time= ?, end_time= ?, employee_id= ?, key_id= ?, status= ? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(++pos, record.getDate_record());
            stmt.setString(++pos, record.getStart_time());
            stmt.setString(++pos, record.getEnd_time());
            stmt.setLong(++pos, record.getEmployeeId().getDocument());
            stmt.setInt(++pos, record.getKey().getId());
            stmt.setString(++pos, record.getStatus());
            stmt.setInt(++pos, record.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al actualizar usuario..." + e.getMessage());
=======
            String sql = "UPDATE `record` SET date_record=?, start_time=?, end_time=?, employee_id=?, key_id=?, status=? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, record.getId());
            stmt.setString(2, record.getDate_record());
            stmt.setString(3, record.getStart_time());
            stmt.setString(4, record.getEnd_time());
            stmt.setLong(5, record.getEmployeeId().getDocument()); // FK: Llave foránea
            stmt.setInt(6, record.getKey().getId()); // FK: Llave foránea
            stmt.setString(7, record.getStatus());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al actualizar registro..." + e.getMessage());
>>>>>>> Stashed changes
        } finally {
            disconnect();
        }
    }

    public void delete(int id) {
        try {
            connect();
            String sql = "DELETE FROM record WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
        BDEmployee dBEmployee = new BDEmployee();
        BDKey dBKey = new BDKey();
        try {
            connect();
            String sql = "SELECT * FROM record";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                // FK
                Employee employee = dBEmployee.findById(resultSet.getInt("employee_id"));
                record.setEmployeeId(employee);
                // FK
                Key key = dBKey.findById(resultSet.getInt("key_id"));
                record.setKey(key);
                results.add(record);
            }
            stmt.close();
            resultSet.close();

        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al consultar todos los registros: " + e.getMessage()); // 🔹 Mejora en el mensaje
        } finally {
            disconnect();
        }
        return results;
    }

    public Record findById(int id) {
        Record record = null;
        BDEmployee dBEmployee = new BDEmployee();
        BDKey dBKey = new BDKey();
        try {
            connect();
            String sql = "SELECT * FROM record WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setStart_time(resultSet.getString("start_time"));
                record.setEnd_time(resultSet.getString("end_time"));
                // FK
<<<<<<< Updated upstream
                BDEmployee dBEmployee1 = new BDEmployee();
                Employee employee = dBEmployee.findById(resultSet.getLong("employee_id"));
=======
                Employee employee = dbet.findById(resultSet.getInt("id"));
>>>>>>> Stashed changes
                record.setEmployeeId(employee);
                // FK
                Key key = dBKey.findById(resultSet.getInt("key_id"));
                record.setKey(key);
                record.setStatus(resultSet.getString("status"));
            }
            stmt.close();
            resultSet.close();

        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al consultar todos los registros: " + e.getMessage());
        } finally {
            disconnect();
        }
        return record;
    }

}
