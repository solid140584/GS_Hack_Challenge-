package com.alphateam.gshackchallenge.IO.Request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegistroRequest implements Serializable {
    @SerializedName("PrimerNombre")
    private String PrimerNombre;

    @SerializedName("SegundoNombre")
    private String SegundoNombre;

    @SerializedName("apPaterno")
    private String apPaterno;

    @SerializedName("apMaterno")
    private String apMaterno;

    @SerializedName("idGenero")
    private int idGenero;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("contraseña")
    private String contraseña;

    @SerializedName("usiario")
    private String usuario;

    @SerializedName("mail")
    private String mail;

    @SerializedName("ciudad")
    private String ciudad;

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
