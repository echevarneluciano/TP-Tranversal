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
        String sql="INSERT INTO cursada (idAlumno,idMateria,nota) VALUES (?,?,?)";       
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getAlumno().getId_alumno());
            ps.setInt(2, c.getMateria().getId_materia());
            ps.setFloat(3, c.getNota());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                c.setId_cursada(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Inscripcion exitosa");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }  
    }
    public void borrarCursadaDeUnaMateria(int idA, int idM){
        String sql="DELETE FROM cursada WHERE idAlumno = ? AND idMateria = ?";     
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
    public void actualizarNotaCursada(int idA ,int idM, float nota){
        String sql="UPDATE cursada SET nota = ? WHERE idAlumno = ? AND idMateria = ?";     
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, nota);
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
        String sql="SELECT a.idAlumno, a.nombre, a.apellido, a.legajo, a.fechaNac, a.activo FROM cursada AS c, alumno as a WHERE c.idAlumno=a.idAlumno and c.idAlumno=?";
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
        String sql="SELECT m.idMateria, m.nombre, m.anio, m.activo FROM cursada AS c, materia as m WHERE m.idMateria=c.idMateria and m.idMateria=?;";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m.setAnio(rs.getInt("anio"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("activo"));
                m.setId_materia(rs.getInt("idMateria"));
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
                Alumno a = buscarAlumno(rs.getInt("idAlumno"));
                Materia m = buscarMateria(rs.getInt("idMateria"));
                c.setAlumno(a);
                c.setMateria(m);
                c.setNota(rs.getInt("nota"));
                c.setId_cursada(rs.getInt("idCursada"));
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
        String sql="SELECT * FROM cursada WHERE idAlumno=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                c = new Cursada();
                Alumno a = buscarAlumno(rs.getInt("idAlumno"));
                Materia m = buscarMateria(rs.getInt("idMateria"));
                c.setAlumno(a);
                c.setMateria(m);
                c.setNota(rs.getFloat("nota"));
                c.setId_cursada(rs.getInt("idCursada"));
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
        String sql= ("SELECT m.idMateria, m.nombre, m.anio, m.activo FROM cursada AS c, materia as m WHERE c.idMateria = m.idMateria AND idAlumno=?");
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("activo"));
                lm.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion en metodo obtenerMateriasCursadas.");
        }
        return lm;
    }
    public List <Materia> obtenerMateriasNOCursadas(int id){
        ArrayList <Materia> lm = new ArrayList<>();
        Materia m;
        String sql= ("SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria from cursada WHERE idAlumno=?)");
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("activo"));
                lm.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion en metodo obtenerMateriasNoCursadas");
        }
        return lm;
    }
    public List <Alumno> buscarAlumnoPorMateriaCursada(int id){
        Alumno a;
        ArrayList <Alumno> la = new ArrayList<>();
        String sql="SELECT a.idAlumno, a.nombre, a.apellido, a.legajo, a.fechaNac, a.activo FROM cursada AS c, alumno as a WHERE c.idAlumno=a.idAlumno and c.idMateria=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                a=new Alumno();
                a.setLegajo(rs.getInt("legajo"));
                a.setEstado(rs.getBoolean("activo"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                a.setId_alumno(rs.getInt("idAlumno"));
                la.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion metodo buscar alumno por materia cursada");
        }
        return la;
    } 
    public float buscarNotaCursada(int idA ,int idM){
       int resul=0; 
       String sql="SELECT `nota` FROM `cursada` WHERE idAlumno=? and idMateria=?";     
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idA);
            ps.setInt(2, idM);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
            resul=rs.getInt("nota");}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    return resul;
    }
}
