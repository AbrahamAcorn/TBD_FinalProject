/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class PacienteDAO {
    
    private String sql="";
    Metodos c=new Metodos();

    public PacienteDAO() {}
    
    public boolean agregaPaciente(Paciente p){
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
    
     public boolean ModificaPaciente(Paciente p){
          boolean actualizado;
          String sql = "UPDATE Paciente SET" +
                  " Nombre = ? , " +
                  " PrimAp = ? , " +
                  " SegAp = ? , " +
                  " Colonia = ? , " +
                  " Calle = ? , " +
                  " num = ? , " +
                  " Telefono = ? , " +
                  " Estado = ? , " +
                  " Habitacion = ? , " +
                  " Genero = ?  " +
                  " WHERE idPaciente = ? ; ";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setString( 1, p.getNombre());
              pstm.setString(2,p.getPrimAp());
              pstm.setString(3, p.getSegAp());
              pstm.setString(4,p.getColonia());
              pstm.setString(5, p.getCalle());
              pstm.setInt(6, p.getNum());
              pstm.setString(7, p.getTelefono());
              pstm.setString(8, p.getEstado());
              pstm.setInt(9, p.getHabitacion());
              pstm.setString(10,p.getGenero());
              pstm.setInt(11, p.getIdPaciente());
              pstm.executeUpdate();
              pstm.execute();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
              System.out.println("(¬_¬) / me lleva la verga version 2");
          }
          return actualizado;
    }
     
      public boolean Elimina(String filtro, String clave,String table){
        sql = "DELETE FROM "+table+" WHERE "+filtro+" = '"+clave+"';";
           boolean eliminado;
	        try {
	            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
	            //preparedStatement.execute();
	            preparedStatement.executeUpdate(sql);
                                preparedStatement.execute(sql);
	            eliminado = true;
	            preparedStatement.close();

	        }catch (SQLException e){
	            e.printStackTrace();
	            eliminado = false;
	        }

	        return eliminado;
        
    }
      
       public Paciente buscaPaciente(String columna, String clave){
        Paciente p = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM PACIENTE WHERE "+columna+" = '"+clave+"';";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            rs.last();
                p = new Paciente();
                p.setIdPaciente(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrimAp(rs.getString(3));
                p.setSegAp(rs.getString(4));
                p.setColonia(rs.getString(5));
                p.setCalle(rs.getString(6));
                p.setNum(rs.getInt(7));
                p.setTelefono(rs.getString(8));
                p.setEstado(rs.getString(9));
                p.setHabitacion(rs.getInt(10));
                p.setGenero(rs.getString(11));
                preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        
        return p;
    }
        public boolean CitaPaciente(int id){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " Estado = 'Citado' " +
                  " WHERE idPaciente = ? ;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
        
        public boolean QuitaCita(int id){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " Estado = 'De Alta' " +
                  " WHERE idPaciente = ? ;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
     
        public boolean DarAlta(int id){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " Estado = 'De Alta' " +
                  " WHERE idPaciente = ? ;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.executeUpdate();
              pstm.execute();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
        public static void main(String args[]) {
            PacienteDAO p = new PacienteDAO();
            
            Paciente n = new Paciente(1, "Juan", "perez", "Almaza", "tias", "abuelo", 24, "123-345-3456", "De Alta", 0, "Mujer");
            System.out.println(p.ModificaPaciente(n));
            //int idPaciente, String Nombre, String PrimAp, String SegAp, String Colonia, String Calle, int num, String telefono, String Estado, int habitacion, String genero
        }
}
