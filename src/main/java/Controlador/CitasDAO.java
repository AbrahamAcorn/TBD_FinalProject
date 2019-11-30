/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Citas;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class CitasDAO {
      private String sql="";
      Metodos c=new Metodos();
       public boolean generaCita(Citas c){
        boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO Cita (`Paciente`, `Doctor`, `Fecha`, `hora`, "
                        + "`Consultorio`, `dept`) VALUES (?,?,?,?,?,?)")) {
                pstm.setInt(1,c.getPaciente());
                pstm.setInt(2, c.getDoctor());
                pstm.setDate(3, java.sql.Date.valueOf(c.getFecha()));
                pstm.setString(4,c.getHora());
                pstm.setInt(5,c.getConsul());
                pstm.setInt(6, c.getDept());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
     public boolean ModificaPaciente(Citas c){
          boolean actualizado;
          String sql = "UPDATE Consulta SET " +
                  " paciente = ?, " +
                  " doctor = ?, " +
                  " fecha = ?, " +
                  " hora = ?, " +
                  " consultorio = ?, " +
                  " dept = ? "+
                  "WHERE paciente = ?;";// and doctor= ?;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,c.getPaciente());
                pstm.setInt(2, c.getDoctor());
                pstm.setDate(3, java.sql.Date.valueOf(c.getFecha()));
                pstm.setString(4,c.getHora());
                pstm.setInt(5,c.getConsul());
                pstm.setInt(6, c.getDept());
                pstm.setInt(7,c.getPaciente());
               // pstm.setInt(8,c.getDoctor());
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
     
      public boolean Elimina(String filtro, String clave,String table){
        sql = "DELETE FROM"+table+" WHERE "+filtro+" = "+clave+";";
           boolean eliminado;
	        try {
	            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
	            //preparedStatement.execute();
	            preparedStatement.executeUpdate();
	            eliminado = true;
	            preparedStatement.close();
	        }catch (SQLException e){
	            e.printStackTrace();
	            eliminado = false;
	        }
	        return eliminado;
    }
      
       public Citas buscaCita(String filtro, String clave){
        Citas c = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM Cita WHERE "+filtro+" = "+clave+";";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            rs.last();
                c = new Citas();
                c.setPaciente(rs.getInt(1));
                c.setDoctor(rs.getInt(2));
                c.setFecha(String.valueOf(rs.getDate(3)));
                c.setHora(rs.getString(4));
                c.setConsul(rs.getInt(5));
                c.setDept(rs.getInt(6));
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        
        return c;
    }
}
