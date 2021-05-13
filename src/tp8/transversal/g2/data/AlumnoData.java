/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tp8.transversal.g2.clases.Alumno;
import tp8.transversal.g2.clases.Conexion;

/**
 *
 * @author luciano.echevarne
 */
public class AlumnoData {
    private Connection con;
    
    public AlumnoData(Conexion conn){
        try {
            this.con =  conn.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion");
        }
    }
    public void ingresoAlumno(Alumno al){
        String sql="INSERT INTO alumno (legajo,activo,apellido,nombre,fechaNac) VALUES (?,?,?,?,?)";       
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, al.getLegajo());
            ps.setBoolean(2, al.isActivo());
            ps.setString(3, al.getApellido());
            ps.setString(4, al.getNombre());
            ps.setDate(5, Date.valueOf(al.getFechaNac()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
            al.setId_alumno(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
