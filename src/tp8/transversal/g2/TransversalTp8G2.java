/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2;

import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import tp8.transversal.g2.clases.*;
import tp8.transversal.g2.data.*;

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
        Conexion con=null;
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"error de driver");
        }
        AlumnoData ad=new AlumnoData(con);
        MateriaData md=new MateriaData(con);
        CursadaData cd=new CursadaData(con);
//        Alumno al2=ad.buscarAlumno(17);
//        Materia ma2=md.buscarMateria(3);
//        Cursada cu2=new Cursada(al2,ma2,9);
//        cd.guardarCursada(cu2);
//        cd.borrarCursadaDeUnaMateria(17, 3);
//         cd.actualizarNotaCursada(17, 3, -4);
//         Alumno pr=cd.buscarAlumno(17);
//         System.out.println(pr.getApellido());
//          Materia mpr=cd.buscarMateria(16);
//          System.out.println(mpr.getNombre());
           


//        LocalDate dat=LocalDate.of(1987, 6, 27);
//        Alumno aL=new Alumno ("Luciano","Echevarne",dat,152383,true);
//        AlumnoData aD=new AlumnoData (con);
//        aD.ingresarAlumno(aL);
//        Materia ma=new Materia("fisica",2, true);
//        MateriaData maDat=new MateriaData(con);
//        maDat.ingresarMateria(ma);
//        System.out.println(ma.getId_materia());
//        List<Materia> lista=maDat.obtenerMaterias();
//        for(Materia m:lista){
//            System.out.println(m.getNombre());
//            System.out.println(m.getId_materia());
//        }
//          Materia ma=new Materia("quimica",1, true);
//          MateriaData maDat=new MateriaData(con);
//          maDat.ingresarMateria(ma);
//          LocalDate dat=LocalDate.of(1992, 4, 28);
//          Alumno aL=new Alumno ("Franco","Echevarne",dat,152384,true);
//          AlumnoData aD=new AlumnoData (con);
//          aD.ingresarAlumno(aL);
//          Materia ma2=new Materia("quimica organica",4, true);
//          MateriaData maDat2=new MateriaData(con);
//          maDat2.ingresarMateria(ma2);
//          LocalDate dat2=LocalDate.of(1992, 4, 28);
//          Alumno aL2=new Alumno ("Rodrigo","Gonzalez",dat2,152394,true);
//          AlumnoData aD2=new AlumnoData (con);
//          aD2.ingresarAlumno(aL2);
    }
    
}
