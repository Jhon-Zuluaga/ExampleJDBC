/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDEmployee;
import co.edu.sena.examplejdbc.bd.BDKey;
import co.edu.sena.examplejdbc.bd.BDRecord;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;

/**
 *
 * @author Aprendiz
 */
public class TestRecord {
    public static void main(String[] args) {
        BDRecord dBRecord = new BDRecord();
        BDEmployee dBEmployee = new BDEmployee();
        BDKey dBKey = new BDKey();
        Employee employee = dBEmployee.findById(1115);
        Key key = dBKey.findById(1);
        
        // INSERTAR
        Record record = new Record(9, "2025-01-26", "10:00:00", null, employee, key, "PENDIENTE");
        dBRecord.insert(record);
        
        //ACTUALIZAR
    }
}


   

