package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionBD {
    
    private static ConexionBD miConexion;
    private Connection conexion;
    private Statement stm;
    private ResultSet rs;
    public static ConexionBD getConexionBD() {
        if (miConexion == null) {
            miConexion = new ConexionBD();
        }
        return miConexion;
    }
    
    private ConexionBD() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Abraham\\hospital.db");
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos");
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean ejecutarInstruccion(String sql) {
		try {
                    new ConexionBD();
		stm=conexion.createStatement();
		int ejecucion;
		ejecucion=stm.executeUpdate(sql);
                if(ejecucion==1){
                    System.out.println("Si se ejecuto");
                }else{
                   System.out.println("no se ejecuto"); 
                }
		return ejecucion == 1?true:false;
		}catch (SQLException e) {
			System.out.println("No se pudo ejecutar la instruccion SQL");
		return false;
		}
		
	}//ejecutarInstruccion
    	public ResultSet ejecutarConsultaRegistros(String sql) {
		
		try {
			stm=conexion.createStatement();
			rs=stm.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("No se pudo ejecutar la consulta SQL");
			
		}
		
		return rs;
	}
        /*
        public static void main(String[] args) {
		ConexionBD c =new ConexionBD();
                //c.ejecutarConsultaRegistros("select*from paciente;");
                //System.out.println(c.ejecutarInstruccion("INSERT INTO Paciente (`idPaciente`, `Nombre`, `PrimAp`, `SegAp`, `Colonia`, `Calle`, `num`, `Telefono`, `Estado`, `Habitacion`, `Genero`) VALUES (9, 'Avelarda', 'Juarez', 'Tyson', 'Juanes', 'Forever', 34, '111-222-3344', 'Revision', 1, 'Mujer');"));
	}*/
}
