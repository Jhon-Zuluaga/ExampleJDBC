/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.BDKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 * Fecha: 13/03/2024
 *
 * @author Jhon Zuluaga Objetivo; probar consultas/transacciones en tabla key
 */
public class TestKey {

    public static void main(String[] args) {
        BDKey dbkey = new BDKey();

        //Insertar 
        Key key = new Key(5, "BICENTENARIO", "Sala12", 4, "Llavero solo");
        //dbkey.insert(key);

        //actualizar
        key.setId(4);
        key.setName("asdad");
        key.setRoom("si");
        key.setCount(3);
        key.setObservation("si");
        dbkey.update(key);

        //dbkey.delete(5);
        //Consultar todos
        //List<Key> ListKey = dbkey.findAll();
        //for (Key k : ListKey) {
        //System.out.println("id: " + k.getId() + " name: " + k.getName() + " room: " + k.getRoom() + " count: " + k.getCount() + " observation: " + k.getObservation());
        //Consultar por id
        Key key2 = dbkey.findById(5);
        if (key2 != null) {
            System.out.println("id: " + key2.getId() + " name: " + key2.getName() + " room: " + key2.getRoom() + " count: " + key2.getCount() + " observation: " + key2.getObservation());
        } else {
            System.out.println("No existe key con ese id");
        }

    }

}
