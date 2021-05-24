/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2.clases;

/**
 *
 * @author luciano.echevarne
 */
public class Materia {
    private int id_materia;
    private String nombre;
    private int anio;
    private Boolean estado;

    public Materia() {
    }
    public Materia(int id_materia, String nombre, int anio, Boolean estado) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }
    public Materia(String nombre, int anio, Boolean estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public int getId_materia() {
        return id_materia;
    }
    public String getNombre() {
        return nombre;
    }
    public int getAnio() {
        return anio;
    }
    
    public Boolean isEstado() {
        return estado;
    }
    
    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id_materia+" - "+ nombre;
    }
    
}
