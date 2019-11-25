/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Abraham
 */
public class Citas {
    private int idcita;
    private int idpac;
    private String nompac;
    private String ap1pac;
    private String ap2pac;
    private int iddoc;
    private String nombdoc;
    private String ap1doc;
    private String ap2doc;
    private String fecha;
    private String hora;
    private String depto;

    public Citas(int idcita, int idpac, String nompac, String ap1pac, String ap2pac, int iddoc, String nombdoc, String ap1doc, String ap2doc, String fecha, String hora, String depto) {
        this.idcita = idcita;
        this.idpac = idpac;
        this.nompac = nompac;
        this.ap1pac = ap1pac;
        this.ap2pac = ap2pac;
        this.iddoc = iddoc;
        this.nombdoc = nombdoc;
        this.ap1doc = ap1doc;
        this.ap2doc = ap2doc;
        this.fecha = fecha;
        this.hora = hora;
        this.depto = depto;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public int getIdpac() {
        return idpac;
    }

    public void setIdpac(int idpac) {
        this.idpac = idpac;
    }

    public String getNompac() {
        return nompac;
    }

    public void setNompac(String nompac) {
        this.nompac = nompac;
    }

    public String getAp1pac() {
        return ap1pac;
    }

    public void setAp1pac(String ap1pac) {
        this.ap1pac = ap1pac;
    }

    public String getAp2pac() {
        return ap2pac;
    }

    public void setAp2pac(String ap2pac) {
        this.ap2pac = ap2pac;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public String getNombdoc() {
        return nombdoc;
    }

    public void setNombdoc(String nombdoc) {
        this.nombdoc = nombdoc;
    }

    public String getAp1doc() {
        return ap1doc;
    }

    public void setAp1doc(String ap1doc) {
        this.ap1doc = ap1doc;
    }

    public String getAp2doc() {
        return ap2doc;
    }

    public void setAp2doc(String ap2doc) {
        this.ap2doc = ap2doc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }
    
    
}
