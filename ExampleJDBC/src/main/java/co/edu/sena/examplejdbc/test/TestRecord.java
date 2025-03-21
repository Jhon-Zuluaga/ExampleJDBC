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
import java.util.List;

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
        //dBRecord.insert(record);

        //ACTUALIZAR
        record = dBRecord.findById(1);
        record.setEnd_time("13:00:00");
        //dBRecord.update(record);

        //Encontrar todos
        List<Record> records = dBRecord.findAll();
        for (Record e : records) {
            System.out.println("id: " + e.getId()
                    + " / Fecha Registro: " + e.getDate_record()
                    + " / Hora inicio: " + e.getStart_time()
                    + " / Hora final: " + e.getEnd_time()
                    + " / Id Empleado: " + e.getEmployeeId().getDocument()
                    + " / Id Llave: " + e.getKey().getId()
                    + " / Estado: " + e.getStatus());
        }

        System.out.println("*******************");

        //Encontrar por id
        Record record2 = dBRecord.findById(8);
        System.out.println("id: " + record2.getId()
                + " / Fecha Registro: " + record2.getDate_record()
                + " / Hora inicio: " + record2.getStart_time()
                + " / Hora final: " + record2.getEnd_time()
                + " / Id Empleado: " + record2.getEmployeeId().getDocument()
                + " / Id Llave: " + record2.getKey().getId()
                + " / Estado: " + record2.getStatus());

    }

}
