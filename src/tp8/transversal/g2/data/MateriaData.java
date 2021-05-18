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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tp8.transversal.g2.clases.*;

/**
 *
 * @author luciano.echevarne
 */
public class MateriaData {
    
    private Connection con;
    
    public MateriaData(Conexion conn){
        try {
            this.con =  conn.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }
    }
    
    public void ingresarMateria(Materia ma){
        String sql="INSERT INTO materia (nombre,anio,activo) VALUES (?,?,?)";       
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ma.getNombre());
            ps.setInt(2, ma.getAnio());
            ps.setBoolean(3, ma.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
            ma.setId_materia(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    public void modificarEstado (int id){
        String sql="UPDATE `materia` SET `activo`=? WHERE `idMateria`=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Materia m = this.buscarMateria(id);
            ps.setBoolean(1,!m.isEstado());
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    public void actualizarMateria (Materia ma){
        String sql="UPDATE `materia` SET `nombre`=?,`anio`=? WHERE `idMateria`=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ma.getNombre());
            ps.setInt(2,ma.getAnio());
            ps.setInt(3,ma.getId_materia());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
    }
    
    public Materia buscarMateria(int id){
        Materia mat=new Materia();
        String sql="SELECT * FROM `materia` WHERE `idMateria`=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                mat.setNombre(rs.getString("nombre"));
                mat.setId_materia(rs.getInt("idMateria"));
                mat.setEstado(rs.getBoolean("activo"));
                mat.setAnio(rs.getInt("anio"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return mat;
    }
    public List<Materia> obtenerMaterias(){
        Materia mat;
        ArrayList<Materia> materias=new ArrayList<>();
        String sql="SELECT * FROM materia";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                mat=new Materia();
                mat.setNombre(rs.getString("nombre"));
                mat.setId_materia(rs.getInt("idMateria"));
                mat.setEstado(rs.getBoolean("activo"));
                mat.setAnio(rs.getInt("anio"));
                materias.add(mat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion.");
        }
        return materias;
    }
}