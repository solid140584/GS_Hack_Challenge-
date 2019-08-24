package com.alphateam.gshackchallenge.IO.Room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.alphateam.gshackchallenge.IO.Room.Entity.Medidor;

import java.util.List;


/**
 * Created by ISC Jesús Romero Mtz on 13/10/2019
 */
@Dao
public interface MedidorDao {
     //TODO alta
    @Insert
    void insertAll(Medidor... users);

    //TODO para hacer consulta por medidor.
    @Query("SELECT * FROM medidor where numero_medidor LIKE  :medidor")
    Medidor findByMedidor(String medidor);

    //TODO actualizar
    @Query(("UPDATE medidor SET calle = :calle, numero = :numero, interior = :interior,entre_calles = :entreCalles, colonia=:colonia, fecha=:fecha, lecturas = :lecturas where numero_medidor = :medidor"))
    void updateByMedidor(String medidor, String calle, String numero, String interior, String entreCalles, String colonia, int lecturas, String fecha);

    //TODO elimina el medidor seleccionado.
    @Query("DELETE FROM medidor where numero_medidor LIKE :medidor")
    void deleteMedidor(String medidor);

    @Query("SELECT * FROM medidor")
    List<Medidor> getAll();

}