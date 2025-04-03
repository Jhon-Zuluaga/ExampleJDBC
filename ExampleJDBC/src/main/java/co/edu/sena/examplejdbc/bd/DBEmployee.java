/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import co.edu.sena.examplejdbc.bd.Utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 20/03/2025
 *
 * @author Jhon Zuluaga Objetivo: permite consultas y transacciones en la tabla
 * employee
 *
 */
public class DBEmployee extends DBConnection {

    public void insert(Employee employee) {
        try {
            connect();
            String sql = "INSERT INTO `employee`  VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getDocument());
            preparedStatement.setString(2, employee.getFullname());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setInt(5, employee.getEmployeeType().getId()); // llave FK
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al insertar tipo de empleado! " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void update(Employee employee) {
       try {
            connect();
            String sql = "UPDATE employee SET fullname= ?, direccion= ?, telefono= ?, type_id= ? WHERE document= ?";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(++pos, employee.getFullname());
            preparedStatement.setString(++pos, employee.getAddress());
            preparedStatement.setString(++pos, employee.getPhone());
            preparedStatement.setInt(++pos, employee.getEmployeeType().getId()); // FK: Llave foranea
            preparedStatement.setLong(++pos, employee.getDocument());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al actualizar tipo de empleado..."
                    + e.getMessage());
        } finally {
            disconnect();
        }

    }

   public void delete(long document) {
        try {
            connect();
            String sql = "DELETE FROM employee WHERE document= ?";
            int pos = 0;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(++pos, document);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al eliminar tipo de empleado..." + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<Employee> findAll() {
        List<Employee> results = new ArrayList<>();
        DBEmployeeType dbet = new DBEmployeeType();
        try {
            connect();
            String sql = "select * from employee";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setDocument(resultSet.getLong("document"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setAddress(resultSet.getString("direccion"));
                employee.setPhone(resultSet.getString("telefono"));
                // FK
                EmployeeType employeeType = dbet.findById(resultSet.getInt("type_id"));
                employee.setEmployeeType(employeeType);
                results.add(employee);
            }
            resultSet.close();

        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al encontrar user" + e.getMessage()) ;
        } finally {
            disconnect();
        }
        return results;
    }

    public Employee findById(long document) {
        Employee employee = null;
        DBEmployeeType dbet = new DBEmployeeType();

        try {
            connect();
            String sql = "SELECT * FROM employee WHERE document = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, document);
            ResultSet resultSet = preparedStatement.executeQuery();

            // .next para recorrer todos los resultados
            if (resultSet.next()) {
                employee = new Employee();
                employee.setDocument(resultSet.getLong("document"));
                employee.setFullname(resultSet.getString("fullname"));
                employee.setAddress(resultSet.getString("direccion"));
                employee.setPhone(resultSet.getString("telefono"));

                //FK
                EmployeeType employeeType = dbet.findById(resultSet.getInt("type_id"));
                employee.setEmployeeType(employeeType);
            }
            resultSet.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error al consultar tipo de empleados "
                    + e.getMessage());
        } finally {
            disconnect();
        }
        return employee;
    }

}
