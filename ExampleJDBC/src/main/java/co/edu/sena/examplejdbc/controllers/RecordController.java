/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class RecordController implements IRecordController {

    private DBRecord bdr = new DBRecord();

    @Override
    public void insert(Record record) throws Exception {
        if ("".equals(record.getDate_record())) {
            throw new Exception("La fecha de grabación es obligatorio");
        }
        if ("".equals(record.getStart_time())) {
            throw new Exception("El inicio de grabación es obligatorio");
        }
        //FK
        if (record.getEmployeeId() == null) {
            throw new Exception("El id de empleado es obligatorio");
        }
        if (record.getKey() == null) {
            throw new Exception("La id de llave es obligatoria");
        }
        if ("".equals(record.getStatus())) {
            throw new Exception("El status es obligatorio");
        }
        //La PK no es autoincremental, se debe validar existencia de la grabación
        Record recordExists = bdr.findById(record.getId());
        if (recordExists != null) {
            throw new Exception("Ya existe una grabación con ese documento");
        }
        
        bdr.insert(record);

    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El empleado es nulo");
        }
        if(record.getId() == 0){
            throw new Exception("El id no puede ser 0");
        }
        if ("".equals(record.getDate_record())) {
            throw new Exception("La fecha de grabación es obligatorio");
        }
        if ("".equals(record.getStart_time())) {
            throw new Exception("El inicio de grabación es obligatorio");
        }
        if (record.getEmployeeId() == null) {
            throw new Exception("El id de empleado es obligatorio");
        }
        if (record.getKey() == null) {
            throw new Exception("La id de llave es obligatoria");
        }
        Record recordExists = bdr.findById(record.getId());
        if (recordExists != null) {
            throw new Exception("Ya existe una grabación con ese id");
        }
        if("".equals(record.getStatus())){
            throw new Exception("El status es obligatorio");
        }
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        Record recordExists = bdr.findById(id);
        if (recordExists == null) {
            throw new Exception("No existe un registro con ese id");
        }
        bdr.delete(id);

    }

    @Override
    public List<Record> findAll() throws Exception {
        return bdr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id no puede ser 0");
        }
        return bdr.findById(id);
    }

}
