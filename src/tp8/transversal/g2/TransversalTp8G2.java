/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tp8.transversal.g2.clases.Alumno;
import tp8.transversal.g2.clases.Conexion;
import tp8.transversal.g2.clases.Materia;
import tp8.transversal.g2.data.AlumnoData;
import tp8.transversal.g2.data.MateriaData;

/**
 *
 * @author luciano.echevarne
 */
public class TransversalTp8G2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion con = null;
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"error de driver");
        }
        
//        LocalDate dat=LocalDate.of(1987, 6, 27);
//        Alumno aL=new Alumno ("Luciano","Echevarne",dat,152383,true);
//        AlumnoData aD=new AlumnoData (con);
//        aD.ingresoAlumno(aL);
        Materia ma=new Materia("fisica",2, true);
        MateriaData maDat=new MateriaData(con);
        maDat.ingresoMateria(ma);
        System.out.println(ma.getId_materia());
        List<Materia> lista=maDat.obtenerMaterias();
        for(Materia m:lista){
            System.out.println(m.getNombre());
            System.out.println(m.getId_materia());
        }
    }
    
}
