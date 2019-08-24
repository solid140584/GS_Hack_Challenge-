package com.alphateam.gshackchallenge.IO.Room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by ISC Jesús Romero Mtz on 23/08/2019
 */

@Entity(tableName = "medidor")
public class Medidor  implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "numero_medidor")
    private String numeroMedidor;

    @ColumnInfo(name = "calle")
    private String calle;

    @ColumnInfo(name = "numero")
    private String numero;

      @ColumnInfo(name = "interior")
    private String interior;

      @ColumnInfo(name = "entre_calles")
    private String entreCalles;

      @ColumnInfo(name = "colonia")
    private String colonia;

      @ColumnInfo(name = "lecturas")
    private int lecturas;

      @ColumnInfo(name = "fecha")
    private String fecha;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getEntreCalles() {
        return entreCalles;
    }

    public void setEntreCalles(String entreCalles) {
        this.entreCalles = entreCalles;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getLecturas() {
        return lecturas;
    }

    public void setLecturas(int lecturas) {
        this.lecturas = lecturas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}