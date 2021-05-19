/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import tp8.transversal.g2.clases.Conexion;
import tp8.transversal.g2.clases.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CursadaData {
    
    private Connection con; 
    
    public CursadaData(Conexion conn){
        try {
            this.con =  conn.getConexion();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    
    public void guardarCursada(Cursada c){
        Cursada cur = new Cursada();
        String sql="INSERT INTO cursada (idAlumno,idMateria,nota) VALUES (?,?,?)";       
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cur.getAlumno().getId_alumno());
            ps.setInt(2, cur.getMateria().getId_materia());
            ps.setInt(3, cur.getNota());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                cur.setId_cursada(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }  
    }
    public void borrarCursadaDeUnaMateria(int idA, int idM){
        String sql="DELETE FROM cursada WHERE id_Alumno = ? AND id_materia = ?";     
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idA);
            ps.setInt(2, idM);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    public void actualizarNotaCursada(int idA ,int idM, int nota){
        String sql="UPDATE cursada SET calificacion = ? WHERE id_Alumno = ? AND id_Materia = ?";     
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,nota);
            ps.setInt(2, idA);
            ps.setInt(3, idM);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    
    public Alumno buscarAlumno(int id){
        Alumno a = new Alumno(); 
        String sql="SELECT a.id_Alumno, a.nombre, a.apellido, a.legajo, a.fecNac, a.estado FROM cursada AS c, alumno as a WHERE c.id_Alumno=?;";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                a.setLegajo(rs.getInt("legajo"));
                a.setEstado(rs.getBoolean("activo"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setId_alumno(rs.getInt("idAlumno"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion metodo buscar alumno");
        }
        return a;
    }
    public Materia buscarMateria(int id){
        Materia m = new Materia(); 
        String sql="SELECT a.id_Alumno, a.nombre, a.apellido, a.legajo, a.fecNac, a.estado FROM cursada AS c, alumno as a WHERE c.id_Alumno=?;";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m.setAnio(rs.getInt("anio"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                m.setId_materia(rs.getInt("id_Materia"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return m;
    }
    
    public List <Cursada> obtenerCursadas(){
        ArrayList <Cursada> lc = new ArrayList<>();
        Cursada c;
        String sql="SELECT * FROM cursada";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                c = new Cursada();
                Alumno a = buscarAlumno(rs.getInt("id_Alumno"));
                Materia m = buscarMateria(rs.getInt("id_Materia"));
                c.setAlumno(a);
                c.setMateria(m);
                c.setNota(rs.getInt("nota"));
                c.setId_cursada(rs.getInt("id_cursada"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return lc;
    
    }
    public List <Cursada> obtenerCursadasxAlumno(int id){
        ArrayList <Cursada> lc = new ArrayList<>();
        Cursada c;
        String sql="SELECT * FROM cursada WHERE id_Alumno=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                c = new Cursada();
                Alumno a = buscarAlumno(rs.getInt("id_Alumno"));
                Materia m = buscarMateria(rs.getInt("id_Materia"));
                c.setAlumno(a);
                c.setMateria(m);
                c.setNota(rs.getInt("nota"));
                c.setId_cursada(rs.getInt("id_cursada"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return lc;
        
        /*  SELECT m.id_Materia, m.nombre, m.anio, m.estado
            FROM cursada AS c, materia as m
            WHERE c.id_Materia = c.id_Materia
            AND id_Alumno=?;
        */
    }
    
    public List <Materia> obtenerMateriasCursadas(int id){
        ArrayList <Materia> lm = new ArrayList<>();
        Materia m;
        String sql= ("SELECT m.id_Materia, m.nombre, m.anio, m.estado\n" +
                    "FROM cursada AS c, materia as m\n" +
                    "WHERE c.id_Materia = c.id_Materia\n" +
                    "AND id_Alumno=?;");
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("id_Materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                lm.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return lm;
    }
    public List <Materia> obtenerMateriasNOCursadas(int id){
        ArrayList <Materia> lm = new ArrayList<>();
        Materia m;
        String sql= ("SELECT *\n"+
                    "FROM materia\n"+ 
                    "WHERE id_Materias NOT IN (SELECT cursada\n"+
                                                "WHERE id_alumno=?);");
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("id_Materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                lm.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return lm;
    }
    
    

}
