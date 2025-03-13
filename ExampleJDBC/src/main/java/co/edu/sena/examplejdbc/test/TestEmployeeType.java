/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 *Fecha: 13/03/2024
 * @author Jhon Zuluaga
 * Objetivo: probar consultas/transacciones en tabla employee_type
 */
public class TestEmployeeType {
    public static void main(String[] args) {
        DBEmployeeType dbEmployeeType = new DBEmployeeType();
        
        // Insertar
        EmployeeType employeeType = new EmployeeType(6, "SUBDIRECTOR");
        //dbEmployeeType.insert(employeeType);
        
        //Actualizar
        //employeeType.setId(5);
        //employeeType.setDescript("COORDINADOR");
        //dbEmployeeType.update(employeeType);
        
        //Eliminar
        //dbEmployeeType.delete(5);
        
        //Consultar todos
        //List<EmployeeType> ListEmployeeType = dbEmployeeType.findAll();
          //for (EmployeeType e : ListEmployeeType) {
              //System.out.println("id: " + e.getId() + " descript: "+ e.getDescript());
              
          // Consultar por id
          EmployeeType employeeType2 = dbEmployeeType.findById(3);
          if(employeeType2 != null)
          {
              System.out.println("id: " + employeeType2.getId() + " descript: "+ employeeType2.getDescript());
          }
          else{
              System.out.println("No existe el employeetipe con ese id!");
          }
         
          
        }
    }
    

