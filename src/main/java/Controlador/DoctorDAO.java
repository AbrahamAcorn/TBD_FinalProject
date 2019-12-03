/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Doctor;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class DoctorDAO {
   private String sql="";
      Metodos c=new Metodos();
       public boolean agregaDoctor(Paciente p){
        boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO Paciente (`Nombre`, `PrimAp`, `SegAp`, `Colonia`, "
                        + "`Calle`, `num`, `Telefono`, `Estado`, `Habitacion`, `Genero`) VALUES (?,?,?,?,?,?,?,?,?,?)")) {
                pstm.setString( 1, p.getNombre());
                pstm.setString(2, p.getPrimAp());
                pstm.setString(3, p.getSegAp());
                pstm.setString(4, p.getColonia());
                pstm.setString(5, p.getColonia());
                pstm.setInt(6, p.getNum());
                pstm.setString(7, p.getTelefono());
                pstm.setString(8,p.getEstado());
                pstm.setInt(9, p.getHabitacion());
                pstm.setString(10, p.getGenero());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
     public boolean ModificaDoctor(Paciente p){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " idPaciente = ?, " +
                  " Nombre = ?, " +
                  " PrimAp = ?, " +
                  " SegAp = ?, " +
                  " Colonia= ?, " +
                  " Calle = ?, " +
                  " num = ?, " +
                  " Telefono = ?, " +
                  " Estado = ?, " +
                  " Habitacion = ?, " +
                  " Genero = ?, " +
                  "WHERE idPa  ciente = ?;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setString( 1, String.valueOf(p.getIdPaciente()));
              pstm.setString(2, p.getNombre());
              pstm.setString(3,p.getPrimAp());
              pstm.setString(4, p.getSegAp());
              pstm.setString(5,p.getColonia());
              pstm.setString(6, p.getCalle());
              pstm.setInt(7, p.getNum());
              pstm.setString(8, p.getTelefono());
              pstm.setInt(9, p.getHabitacion());
              pstm.setString(10,p.getGenero());
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
      
       public Doctor buscaDoctor(String filtro, String clave){
        Doctor d = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM doctor "+filtro+" = "+clave+";";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            rs.last();
                d = new Doctor();
         
                preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        
        return d;
    }  
}
