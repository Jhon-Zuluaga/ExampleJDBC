/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Jhon Zuluaga
 * Objetivo: implementar interface para controlar el modelo key
 */
public class KeyController implements IKeyController {

    private DBKey dbk = new DBKey();

    @Override

    public void insert(Key key) throws Exception {
        if ("".equals(key.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(key.getRoom())) {
            throw new Exception("Room es obligatorio");
        }
        if (key.getCount() == 0) {
            throw new Exception("La cantidad es obligatoria");
        }
        dbk.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave  es nula");
        }
         if(key.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(key.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(key.getRoom())) {
            throw new Exception("Room es obligatorio");
        }
        
        if(key.getCount() < 1)
        {
            throw new Exception("La cantidad de llaves es incorrecta, debe ser minimo 1");
        }
        Key keyExists = dbk.findById(key.getId());
        if(keyExists == null)
        {
            throw new Exception("No existen llaves");
        }
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        //consultar si la key existe en la bd
        Key keyExists = dbk.findById(id);
        if (keyExists == null) {
            throw new Exception("El tipo de llave no existe");
        }
        dbk.delete(id);
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return dbk.findById(id);
    }
}
