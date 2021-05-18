/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2.clases;

import java.time.LocalDate;

/**
 *
 * @author luciano.echevarne
 */
public class Alumno {
    
    private int idAlumno=-1;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private int legajo;
    private boolean activo;

    public Alumno() {
    }
    public Alumno(int id_alumno, String nombre, LocalDate fechaNac, int legajo, boolean estado) {
        this.idAlumno = id_alumno;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.activo = estado;
    }
    public Alumno(String nombre, String apellido, LocalDate fechaNac, int legajo, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.legajo = legajo;
        this.activo = estado;
    }

    public int getId_alumno() {
        return idAlumno;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public int getLegajo() {
        return legajo;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEstado(boolean estado) {
        this.activo = estado;
    }
    public void setId_alumno(int id_alumno) {
        this.idAlumno = id_alumno;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
