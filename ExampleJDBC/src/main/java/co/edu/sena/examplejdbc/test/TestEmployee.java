/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 *
 * Fecha: 20/03/2025
 *
 * @author Jhon Zuluaga Objetivo: Probar consultas/transacciones en tabla
 * employee
 */
public class TestEmployee {

    public static void main(String[] args) {
        DBEmployee dBE = new DBEmployee();
        DBEmployeeType dBEmployeeType = new DBEmployeeType();
        // insertar
        EmployeeType employeeType = dBEmployeeType.findById(1);
        Employee employee = new Employee(1116070669, "Esteban Colorado Vargas",
                "Calle 28a #33-47", "3185551301", employeeType);
        //dBE.insert(employee);

        //modificar
//        employee.setFullname("Elba reto");
//        employeeType = dBEmployeeType.findById(2);
//        employee.setEmployeeType(employeeType);
//        dBE.update(employee);

        //eliminar
        dBE.delete(1000000047);
        
        //consultar todos
//        List<Employee> employees = dBE.findAll();
//        for (Employee employee1 : employees) {
//            System.out.println("document: " + employee1.getDocument() + "fullname: " + employee1.getFullname() + 
//                                   "address: " + employee1.getAddress() + "phone: " + employee1.getPhone() + "type: " + employee1.getEmployeeType().getDescript());
            
        }
        
        // consultar por id
//         System.out.println("*****************");
//        Employee employee2 = dBE.findById(1000000047);
//        System.out.println("Document: " + employee2.getDocument() + 
//                                " / fullname: " + employee2.getFullname()+ 
//                                " / address: " + employee2.getAddress() + 
//                                " / phone: " + employee2.getPhone() + 
//                                "  type: " + employee2.getEmployeeType().getDescript());
    }

